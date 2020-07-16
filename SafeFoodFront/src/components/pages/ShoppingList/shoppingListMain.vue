<template>
  <div id="content" align="center" class="container">
    <b-jumbotron bg-variant="info" text-variant="primary" border-variant="dark" style="text-align: center" fluid container-fluid>
      <template v-slot:header>Shopping List</template>
      <template v-slot:lead>장바구니 입니다.</template>
      <hr class="my-4"/>
      <p>선택하신 상품의 수량에 따른 영양 섭취 정보를 확인해보세요.<br>
      저장을 눌러 상태를 반영하고 구매, 제거 버튼을 통해 구매여부를 결정하세요.
      </p>
    </b-jumbotron>
    <b-container class="bv-example-row">
      <b-row>
        <b-col cols="3" v-for="(product) in shoppingListFoods" :key="product.code" style="margin-bottom: 15px">
            <b-card>
                <img :src="require('@/assets/' + product.food.imgPath)" style="max-width: 90%;" class="mb-3" img-top/>
                <b-card-text>
                <strong>{{product.food.name}}</strong><br>
                <p>{{product.food.maker}}</p>
                <div class="form-inline">
                  <input type="number" v-model="product.quantity" min="1" style="width:45%; margin-left:5px; height:35px"/>
                  <button @click="update(product.id, product.code, product.quantity)" class="btn btn-success" style="width:45%; margin-left:10px; height:35px;">저장</button>
                </div>
                <div style="margin-top:5px;">
                  <button @click="purchase(product.id, product.code, product.quantity)" style="width:45%; height:35px;" class="btn btn-primary">구매</button>
                  <button @click="remove(product.id, product.code)" style="width:45%; margin-left:10px; height:35px;" class="btn btn-danger">제거</button>
                </div>
                </b-card-text>
            </b-card>
        </b-col>
      </b-row>
    </b-container>


    <div style="width:1500px;"></div>
  </div>
</template>

<script>
import axios from '../../../js/http-commons.js';
export default {
    props: ["id"],
    data(){
        return{
            shoppingListFoods:[],
            product : {},
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
      this.renew();
    },
    methods: {
      update(id, code, quantity) {
        axios.put("/food/updateShoppingList", {id, code, quantity})
        .then(res => {
          if(res.data.state=="SUCCESS") {
            alert("적용되었습니다.");
          } else {
            alert("저장 실패");
          }
        }).catch(e => {
          alert("적용 실패 : " + e);
        })
      },
    purchase(id, code, quantity) {
      this.product = {id, code, quantity};
      axios.post("/food/deleteShoppingList", this.product)
      .then(res => {
        if(res.data.state=="FAIL") {
          alert("처리 중 문제가 발생했습니다.");
        }
        this.renew();
      }).catch(e => {
        alert("처리 중 문제가 발생했습니다. : " + e);
        this.renew();
      });
      axios.post("/food/addShoppingHistory", this.product)
      .then(res=> {
        if(res.data.state=="SUCCESS") {
          alert("구매 완료 되었습니다.");
        } else {
          alert("구매 처리 중 문제가 발생했습니다.");
        }
      }).catch(e => {
        alert("구매 처리 중 문제가 발생했습니다. : " + e);
      });
      this.product = {};
    },
    remove(id, code) {
      this.product = {id, code};
      axios.post("/food/deleteShoppingList", this.product)
      .then(res => {
        if(res.data.state=="FAIL") {
          alert("처리 중 문제가 발생했습니다.");
        }
        this.renew();
      }).catch(e => {
        alert("처리 중 문제가 발생했습니다. : " + e);
        this.renew();
      });
      this.product = {};
    },
    renew() {
      axios.get("/food/showMyShoppingListFoods/" + this.id)
      .then(res => {
        if(res.data.length==0) {
          alert("장바구니에 담긴 상품이 없습니다.");
          this.shoppingListFoods = res.data;
          return;
        }
        this.shoppingListFoods = res.data;
      }).catch(e => {
        alert("조회 실패 : " + e);
      })
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