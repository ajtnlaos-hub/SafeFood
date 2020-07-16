<template>
  <div class="container">
    <b-jumbotron fluid container-fluid style="text-align: center" bg-variant="info" text-variant="primary" border-variant="dark">
      <template v-slot:header>
        <strong>Notice Detail</strong>
      </template>
      <template v-slot:lead>
        공지사항 상세 페이지 입니다.
      </template>
      <hr class="my-4" />
      <p>등록된 공지사항을 꼼꼼하게 읽어보세요.</p>
    </b-jumbotron>
    <table class="table table-bordered" style="margin-top:30px;">
      <tr>
        <td class="info">글번호</td>
        <td>{{notice.noticeNum}}</td>
        <td class="info">작성자</td>
        <td>{{notice.writer}}</td>
      </tr>
      <tr>
        <td class="info">제목</td>
        <td>{{notice.title}}</td>
        <td class="info">작성일시</td>
        <td>{{notice.writtenDate}}</td>
      </tr>
    </table>
    <div align="left" style="margin-left:50px; margin-top:30px;">{{notice.contents}}</div>
    <div v-if="isLogin && loginUser.admin" align="right" style="margin-top:30px;">
      <a href="#" @click="updateNotice">수정</a>
      <a href="#" @click="deleteNotice" style="margin-left:20px; margin-right:30px;">삭제</a>
    </div>
    <div style="width:1500px;"></div>
  </div>
</template>

<script>
import axios from "../../../js/http-commons.js";
export default {
  props: ["noticeNum"],
  data() {
    return {
      notice: {}
    };
  },
  computed: {
    loginUser() {
      return this.$store.state.loginUser;
    },
    isLogin() {
      return this.$store.state.isLogin;
    }
  },
  mounted() {
    axios
      .get("/notice/detail/" + this.noticeNum)
      .then(res => {
        this.notice = res.data;
      })
      .catch(e => {
        alert(e);
      });
  },
  methods: {
    updateNotice() {
      this.$router.push({
        path: "/updateNotice/"+ this.notice.noticeNum
      })
    },
    deleteNotice() {
      axios.delete("/notice/delete/"+this.notice.noticeNum)
      .then(res => {
        if(res.data.state=="SUCCESS") {
          alert("삭제되었습니다.");
          this.$router.push({
            path: "/notice"
          });
        } else {
          alert("삭제 실패");
        }
      }).catch(e => {
        alert("삭제 대실패 : " + e);
      })
    }
  },
};
</script>

<style>
.info {
  background: whitesmoke;
}
</style>