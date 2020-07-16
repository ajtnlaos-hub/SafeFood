<template>
  <div align="center" class="container">
    <b-jumbotron
      fluid
      container-fluid
      style="text-align: center"
      bg-variant="info"
      text-variant="primary"
      border-variant="dark"
    >
      <template v-slot:header>
        <strong>Sign-in</strong>
      </template>
      <template v-slot:lead>
        <p>회원가입 페이지 입니다.</p>
      </template>
      <hr class="my-4" />
      <p>회원가입하여 저희가 제공하는 모든 서비스를 무료로 이용하세요.<br>
      보유하신 알러지가 있다면 체크해두시는 것을 추천드립니다.</p>
    </b-jumbotron>
    <!-- 새 폼 -->
    <div class="d-flex justify-content-center h-100">
      <div class="card">
        <div class="card-header">
          <h3>Sign Up</h3>
          <!-- <div class="d-flex justify-content-end social_icon">
					<span><i class="fab fa-facebook-square"></i></span>
					<span><i class="fab fa-google-plus-square"></i></span>
					<span><i class="fab fa-twitter-square"></i></span>
          </div>-->
        </div>
        <div class="card-body">
          <form>
            <div class="input-group form-group">
              <div class="input-group-prepend">
                <span class="input-group-text">
                  <i class="fas fa-user"></i>
                </span>
              </div>
              <input
                style="width:300px;"
                v-model="user.id"
                id="inputId"
                type="text"
                placeholder="  ID"
              />
            </div>
            <div class="input-group form-group">
              <div class="input-group-prepend">
                <span class="input-group-text">
                  <i class="fas fa-key"></i>
                </span>
              </div>
              <input
                style="width:300px;"
                v-model="user.password"
                id="inputPassword"
                type="password"
                placeholder="  PASSWORD"
              />
            </div>
            <div class="input-group form-group">
              <div class="input-group-prepend">
                <span class="input-group-text">
                  <i class="fas fa-user"></i>
                </span>
              </div>
              <input
                style="width:300px;"
                v-model="user.name"
                id="inputName"
                type="text"
                placeholder="  NAME"
              />
            </div>
             <div class="input-group form-group">
              <div class="input-group-prepend">
                <span class="input-group-text">
                  <i class="fas fa-envelope"></i>
                </span>
              </div>
              <input
                style="width:300px;"
                v-model="user.email"
                id="inputEmail"
                type="text"
                placeholder="  ex)abcdef@ssafy.com"
              />
            </div>
             <div class="input-group form-group">
              <div class="input-group-prepend">
                <span class="input-group-text">
                  <i class="fas fa-phone"></i>
                </span>
              </div>
              <input
                style="width:300px;"
                v-model="user.phone"
                id="inputPhone"
                type="text"
                placeholder="  ex)010-0000-0000"
              />
            </div>

            <!-- <div style="width:1024px;"></div> -->
            <div style="width:330px; margin-top:20px;">
              <b-form-group label="알레르기 성분" style="text-align:left;">
                <b-form-checkbox-group
                style="border:1px solid;text-align:center;"
                  id="checkbox-group-1"
                  v-model="allergyList"
                  :options="options"
                  name="allergy"
                ></b-form-checkbox-group>
              </b-form-group>
            </div>
            <div style="margin-top:30px;">
              <button @click="doRegist" class="btn btn-primary" style="width:300px;">Submit</button>
            </div>
          </form>
        </div>
       </div>
    </div>
    <div style="width:1500px;"></div>
  </div>
</template>

<script>
import axios from "../../../js/http-commons";
export default {
  data() {
    return {
      user: {},
      allergyList: [],
      options: [
        { text: "대두", value: "대두" },
        { text: "땅콩", value: "땅콩" },
        { text: "게", value: "게" },
        { text: "새우", value: "새우" },
        { text: "참치", value: "참치" },
        { text: "연어", value: "연어" },
        { text: "쑥", value: "쑥" },
        { text: "소고기", value: "소고기" },
        { text: "닭고기", value: "닭고기" },
        { text: "돼지고기", value: "돼지고기" },
        { text: "복숭아", value: "복숭아" },
        { text: "민들레", value: "민들레" },
        { text: "계란흰자", value: "계란흰자" }
      ]
    };
  },
  methods: {
    doRegist() {
      this.user.allergyList = this.allergyList;
      axios
        .post("/user/regist", this.user)
        .then(res => {
          if (res.data.state == "SUCCESS") {
            alert("회원 가입 되었습니다.");
            this.$router.push({
              path: "/"
            });
          } else {
            alert("회원 가입 실패");
          }
        })
        .catch(e => {
          alert("회원 가입 실패 : " + e);
        });
    }
  }
};
</script>

<style scoped>
input[type="checkbox"] {
  margin-left: 40px;
}
.form-group {
  margin-top: 20px;
}
.container {
  align-content: center;
}

.card {
  height: 700px;
  margin-top: auto;
  margin-bottom: auto;
  width: 400px;
  background-color: rgb(255, 255, 255) !important;
}

.social_icon span {
  font-size: 60px;
  margin-left: 10px;
  color: #ffc312;
}

.social_icon span:hover {
  color: white;
  cursor: pointer;
}

.card-header h3 {
  color: black;
}

.social_icon {
  position: absolute;
  right: 20px;
  top: -45px;
}

.input-group-prepend span {
  width: 50px;
  background-color: #b0d853;
  color: black;
  border: 0 !important;
}

input:focus {
  outline: 0 0 0 0 !important;
  box-shadow: 0 0 0 0 !important;
}

.remember {
  color: white;
}

.remember input {
  width: 20px;
  height: 20px;
  margin-left: 15px;
  margin-right: 5px;
}

.login_btn {
  color: black;
  background-color: #ffc312;
  width: 100px;
}

.login_btn:hover {
  color: black;
  background-color: white;
}

.links {
  color: white;
}

.links a {
  margin-left: 4px;
}
</style>