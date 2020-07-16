<template>
  <div align="center" class="container">
    <b-jumbotron fluid container-fluid style="text-align: center" bg-variant="info" text-variant="primary" border-variant="dark">
      <template v-slot:header>
        <strong>Update Information</strong>
      </template>
      <template v-slot:lead>
        <p>회원 정보 수정 페이지입니다.</p>
      </template>
      <hr class="my-4" />
      <p>변경된 사항이 있다면 반영해주세요.</p>
    </b-jumbotron>
    <div class="form-group">
      <label for="inputId">아이디</label>
      <br>
      <input readonly="true" v-model="user.id" id="inputId" type="text" placeholder="  ID" />
    </div>
    <div class="form-group">
      <label for="inputPassword">비밀번호</label>
      <br>
      <input v-model="user.password" id="inputPassword" type="password" placeholder="  PASSWORD" />
    </div>
    <div class="form-group">
      <label for="inputName">이름</label>
      <br>
      <input v-model="user.name" id="inputName" type="text" placeholder="  NAME" />
    </div>
    <div class="form-group">
      <label for="inputEmail">이메일</label>
      <br>
      <input v-model="user.email" id="inputEmail" type="text" placeholder="  ex)abcdef@ssafy.com" />
    </div>
    <div class="form-group">
      <label for="inputPhone">연락처</label>
      <br>
      <input v-model="user.phone" id="inputPhone" type="text" placeholder="  ex)010-0000-0000" />
    </div>

    <div style="width:330px;">
      <b-form-group label="알레르기 성분">
        <b-form-checkbox-group id="checkbox-group-1" v-model="allergyList" :options="options" name="allergy">
        </b-form-checkbox-group>
      </b-form-group>
    </div>
    <br />
    <div style="margin-top:30px;">
      <button @click="doUpdate" class="btn btn-primary" style="width:300px;">수정</button>
    </div>
    <div style="margin-top:30px;">
      <button @click="doDelete" class="btn btn-danger" style="width:300px;">회원탈퇴</button>
    </div>
    <div style="width:1500px"></div>
  </div>
</template>

<script>
import axios from "../../../js/http-commons";
export default {
  props: ["id"],
  data() {
    return {
      user: {},
      allergyList: [],
      options: [
            {text:'대두', value:'대두'},
            {text:'땅콩', value:'땅콩'},
            {text:'게', value:'게'},
            {text:'새우', value:'새우'},
            {text:'참치', value:'참치'},
            {text:'연어', value:'연어'},
            {text:'쑥', value:'쑥'},
            {text:'소고기', value:'소고기'},
            {text:'닭고기', value:'닭고기'},
            {text:'돼지고기', value:'돼지고기'},
            {text:'복숭아', value:'복숭아'},
            {text:'민들레', value:'민들레'},
            {text:'계란흰자', value:'계란흰자'},
        ]
    };
  },
  methods: {
    doUpdate() {
        this.user.allergyList = this.allergyList;
      axios
        .put("/user/update", this.user)
        .then(res => {
          if (res.data.state == "SUCCESS") {
            alert("수정 완료 되었습니다.");
            this.$router.push({
              path: "/"
            });
          } else {
            alert("회원 정보 수정 실패");
          }
        })
        .catch(e => {
          alert("회원 정보 수정 실패 : " + e);
        });
    },
    doDelete() {
        axios.delete("/user/delete/"+this.user.id)
        .then(res => {
            if(res.data.state=="SUCCESS") {
                this.$store.state.loginUser = {};
                this.$store.state.isLogin = false;
                alert("회원 탈퇴 되었습니다.");
                this.$router.push({
                    path: "/"
                });
            } else {
                alert("회원 탈퇴 실패");
            }
        }).catch(e => {
            alert("회원 탈퇴 실패 : " + e);
        })
    }
  },
  mounted() {
    axios.get("/user/selectUserById/" + this.id)
      .then(res => {
        this.user = res.data;
        this.allergyList = res.data.allergyList;
      })
      .catch(e => {
        alert(e);
      });
  }
};
</script>

<style scoped>
input {
  width: 300px;
}
.form-group {
  margin-top: 20px;
}
</style>