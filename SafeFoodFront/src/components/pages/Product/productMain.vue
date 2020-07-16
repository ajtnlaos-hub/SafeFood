<template>
  <div id="content" align="center" class="container">
    <b-jumbotron
      bg-variant="info"
      text-variant="primary"
      border-variant="dark"
      style="text-align: center"
      fluid container-fluid>
      <template v-slot:header>Information</template>
      <template v-slot:lead>식품 목록입니다.</template>
      <hr class="my-4"/>
      <p>상세 정보 버튼을 눌러 상세 정보를 확인하고<br>
      관심있는 상품을 장바구니에 담아보세요.</p>
    </b-jumbotron>
    <div id="searchForm" class="form-group form-inline container">
      <select v-model="searchCondition" class="form-control">
        <option value="1">상품명</option>
        <option value="2">제조사</option>
        <option value="3">원재료</option>
        <option value="4">알레르기 성분</option>
      </select>
      <input v-model="searchText" @keydown.enter="doSearch" type="text" style="width:300px; margin-left:20px;" class="form-control">
      <button @click="doSearch" class="btn btn-primary" style="width:100px; margin-left:20px;">검색</button>
    </div>
    <b-container class="bv-example-row">
      <b-row>
        <b-col cols="3" v-for="(product) in products" :key="product.code" style="margin-bottom: 15px">
            <b-card>
            <img :src="require('@/assets/' + product.imgPath)" style="max-width: 90%;" class="mb-3" img-top/>
            <b-card-text>
              <strong>{{product.name}}</strong><br>
              <p>{{product.maker}}</p>
            </b-card-text>
            <a href="#" @click="moveToDetail(product.code)" variant="primary">상세 정보</a><br><hr>
            <b-button @click="shoppingList(product.code)" variant="info">장바구니에 담기</b-button>
            </b-card>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import axios from '../../../js/http-commons'
import router from '../../../js/router'
export default {
    data(){
        return{
            products:[],
            searchCondition: 1,
            searchText: ""
        };
    },
    computed: {
      isLogin() {
        return this.$store.state.isLogin;
      },
      loginUser() {
        return this.$store.state.loginUser;
      }
    },
    mounted() {
        axios.get("/food/main")
        .then(res=>{
            this.products = res.data;
        }).catch(e=>{
            alert("data Loadgin err : " + e);
        });
    },methods: {
        moveToDetail(code){
            router.push({
                path:"/foodDetail/"+code
            });
        },
        shoppingList(code) {
          console.log(code);
          if(this.isLogin) {
            let shoppingList = {
              id: this.loginUser.id,
              code,
              quantity: 0
            };
            axios.post("/food/addShoppingList", shoppingList)
            .then(res=> {
              if(res.data.state=="SUCCESS") {
                alert("선택한 상품을 장바구니에 담았습니다.");
              } else {
                alert("장바구니에 동일한 상품이 있습니다.");
              }
            }).catch(e => {
              alert("장바구니 담기 실패 : " + e);
            })
          } else {
            alert("로그인이 필요한 기능입니다.");
            this.$router.push({
              path: "/login"
            });
          }
        },


        doSearch() {
          if(this.searchText=="") {
            alert("검색어를 입력하세요.");
            return;
          }
          if(this.searchCondition==1) {
            axios.get("/food/searchByTitle/" + this.searchText)
            .then(res => {
              if(res.data.length==0) {
                alert("검색 정보에 맞는 상품이 존재하지 않습니다.");
                return;
              } else {
                this.products = res.data;
              }
            }).catch(e => {
              alert("정보 조회 실패 : " + e);
            })
          } else if(this.searchCondition==2) {
            axios.get("/food/searchByMaker/" + this.searchText)
            .then(res => {
              if(res.data.length==0) {
                alert("검색 정보에 맞는 상품이 존재하지 않습니다.");
                return;
              } else {
                this.products = res.data;
              }
            }).catch(e => {
              alert("정보 조회 실패 : " + e);
            })

          } else if(this.searchCondition==3) {
            axios.get("/food/searchByMaterial/" + this.searchText)
            .then(res => {
              if(res.data.length==0) {
                alert("검색 정보에 맞는 상품이 존재하지 않습니다.");
                return;
              } else {
                this.products = res.data;
              }
            }).catch(e => {
              alert("정보 조회 실패 : " + e);
            })
          } else if(this.searchCondition==4) {
            axios.get("/food/searchByAllergyIngredient/" + this.searchText)
            .then(res => {
              if(res.data.length==0) {
                alert("검색 정보에 맞는 상품이 존재하지 않습니다.");
                return;
              } else {
                this.products = res.data;
              }
            }).catch(e => {
              alert("정보 조회 실패 : " + e);
            })
          }
        }
    },

};
</script>

<style sc>
#content{
  align-content: center;
}
#searchForm {
  margin-left: 500px;
}
</style>