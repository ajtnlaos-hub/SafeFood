<template>
  <div class="container">
    <table class="table table-hover table-condensed" id="list-table" style="margin-top:20px; width:800px;">
      <thead>
        <tr>
          <th class="col-sd-1">글번호</th>
          <th class="col-sd-7" >제목</th>
          <th class="col-sd-2">작성자</th>
          <th class="col-sd-3">작성일시</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(post) in posts" :key="post.qnaNum" @click="detail(post.questionNum)">
          <td class="col-sd-1">{{post.questionNum}}</td>
          <td class="col-sd-7">{{post.title}}</td>
          <td class="col-sd-2">{{post.writer}}</td>
          <td class="col-sd-3">{{post.writtenDate}}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import ajax from "../../../js/http-commons";
import router from "../../../js/router";
export default {
  data() {
    return {
      posts: []
    };
  },
  computed: {
    rows() {
      return this.posts.length;
    },
    loginUser() {
        return this.$store.state.loginUser;
    }
  },
  mounted() {
    ajax.get("/question/selectMyQnA/" + this.loginUser.id)
      .then(res => {
        this.posts = res.data;
      })
      .catch(e => {
        alert(e + " qna error");
      })
  },
  methods: {
    detail(num) {
      router.push({
        path: "/QnADetail/" + num
      });
    }
  }
};
</script>

<style scoped>
</style>