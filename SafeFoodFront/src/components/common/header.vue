<template>
  <div id="appNavBar" class="container-fluid">
    <!-- <div id="titleTop">Safe Food</div> -->
    <b-navbar toggleable="lg" type="dark" variant="dark">
      <b-navbar-brand href="/">Safe Food</b-navbar-brand>
      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
          <b-nav-item router-link to="/notice">공지사항</b-nav-item>
          <b-nav-item router-link to="/ProductMain">음식정보</b-nav-item>
          <b-nav-item router-link to="/MyFood">섭취정보</b-nav-item>
          <b-nav-item router-link to="/BestFood">Most Pick</b-nav-item>
          <b-nav-item router-link to="/MyFood">섭취정보</b-nav-item>
          <b-nav-item router-link @click="myShoppingList">장바구니</b-nav-item>
          <b-nav-item router-link @click="myShoppingHistory">구매내역</b-nav-item>
          <b-nav-item router-link to="/QnAMain"> Q & A  </b-nav-item>
        </b-navbar-nav>

        <!-- Right aligned nav items -->
        <b-navbar-nav class="ml-auto">
          <b-nav-item v-if="!isLogin" router-link to="/registUser">회원가입</b-nav-item>
          <b-nav-item v-if="!isLogin" router-link to="/login">로그인</b-nav-item>

          <b-nav-item v-if="isLogin"  router-link to="/MsgBox">          
            <span class="far fa-envelope"></span>
          </b-nav-item>
          <b-nav-item v-if="isLogin" @click="update(loginUser.id)">{{loginUser.name}}님 반갑습니다.</b-nav-item>
          <b-nav-item v-if="isLogin" @click="logout">로그아웃</b-nav-item>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
    <!-- common imege-->
  </div>
</template>

<script>
import router from "../../js/router";
export default {
  name: "appNavBar",
  router: router,
  components: {},
  computed: {
    loginUser() {
      console.log(this.$store.state.loginUser);
      return this.$store.state.loginUser;
    },
    isLogin() {
      return this.$store.state.isLogin;
    }
  },
  methods: {
    logout() {
      this.$store.state.loginUser={};
      this.$store.state.isLogin=false;
      console.log(this.$store.state.loginUser);
      console.log(this.$store.state.isLogin);
      router.push({
        path: "/"
      });
      alert("로그아웃 되었습니다.");
    },
    update(id) {
      this.$router.push({
        path: "/updateUser/"+id
      });
    },
    myShoppingList() {
      if(this.isLogin) {
        this.$router.push({
          path: "/shoppingListMain/" + this.loginUser.id
        })
      } else {
        alert("먼저 로그인 해주세요.");
        this.$router.push({
          path: "/login"
        })
      }
    },
    myShoppingHistory() {
      if(this.isLogin) {
        this.$router.push({
          path: "/shoppingHistory/" + this.loginUser.id
        })
      } else {
        alert("먼저 로그인 해주세요.");
        this.$router.push({
          path: "/login"
        })
      }
    }
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css?family=Righteous&display=swap");
@import url("https://fonts.googleapis.com/css?family=Monoton&display=swap");
#titleTop {
  /* font-family: 'Righteous', cursive; */
  font-family: "Monoton", cursive;
  font-size: 450%;
}
</style>