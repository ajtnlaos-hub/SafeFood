<template>
  <nav id="bar" style="text-align:center">
    <div class="list-group">
      <a href="#" class="list-group-item disabled" style="background-color:lightgray;">
        <strong>Q & A</strong>
      </a>
      <router-link class="list-group-item" to="/QnAMain/QnAList">Q & A 목록</router-link>
      <a class="list-group-item" href="#" @click="newQnA">Q & A 작성</a>
      <a class="list-group-item" href="#" @click="myQnA">My Q & A</a>
    </div>
  </nav>
</template>

<script>
export default {
  data() {
    return {
      state: 0
    };
  },
  computed: {
    isLogin() {
      return this.$store.state.isLogin;
    }
  },
  methods: {
    newQnA() {
      if(this.isLogin) {
        this.$router.push("/QnAMain/QnANew");
      } else {
        alert("먼저 로그인 해주세요.")
        this.$router.push({
          path: "/login"
        });
      }
    },
    myQnA() {
      if(this.isLogin) {
        this.$router.push("/QnAMain/myQnA/");
      } else {
        alert("먼저 로그인 해주세요.")
        this.$router.push({
          path: "/login"
        });
      }
    }
  },
};
</script>

<style scoped>
nav {
  /* border-radius: 25px; */
  border-radius: 15px 50px 30px 5px;
  margin-right: 10px;
  margin-left: 10px;
  /* border: 1px solid; */
}
</style>