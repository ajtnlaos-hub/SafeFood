<template>
  <div class="container" align="center">
    <form>
      <div class="form-group">
        <label for="titleText">제목</label>
        <input v-model="qna.title" id="titleText" class="form-control" type="text" />
      </div>
      <div class="from-group">
        <label for="contents">내용</label>
        <textarea v-model="qna.contents" id="contents" class="form-control" rows="5" cols="1000"></textarea>
      </div>
      <div align="center">
        <button style="width:300px; margin-top:30px;" type="button" class="btn btn-primary" @click="regist">등록</button>
      </div>
    </form>
  </div>
</template>

<script>
import ajax from "../../../js/http-commons";
import router from "../../../js/router"
export default {
  data() {
    return {
      qna: {}
    };
  },
  computed: {
    loginUser() {
      return this.$store.state.loginUser;
    }
  },
  methods: {
    regist() {
      this.qna.writer = this.loginUser.id;
      ajax
        .post("/question/regist", this.qna)
        .then(res => {
          if (res.data.state == "SUCCESS") {
            alert("QnA 등록 성공");
            router.push({
              path:"/QnAMain"
              });
          } else {
            alert("QnA 등록 실패");
          }
        })
        .catch(e => {
          alert("QnA 등록 실패 : " + e);
        });
    }
  }
};
</script>

<style scoped>
</style>