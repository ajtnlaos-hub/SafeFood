<template>
  <div class="container-fluid">
    <table class="table table-bordered">
      <tbody>
        <tr>
          <td class="info">글번호</td>
          <td>{{qna.questionNum}}</td>
          <td class="info">작성자</td>
          <td>{{qna.writer}}</td>
        </tr>
        <tr>
          <td class="info">제목</td>
          <td>{{qna.title}}</td>
          <td class="info">작성일시</td>
          <td>{{qna.writtenDate}}</td>
        </tr>
      </tbody>
    </table>
    <div align="left" style="margin-left:50px; margin-top:30px;">{{qna.contents}}</div>
    <div v-if="isLogin && (qna.writer==loginUser.id || loginUser.admin)" align="right" style="margin-top:50px;">
      <button style="width:200px;" type="button" class="btn btn-info" id="modifyNoticeBtn" @click="editPost()">수정</button>
      <button style="width:200px; margin-left:20px;" type="button" class="btn btn-danger" id="deleteBtn" @click="deletePost()">삭제</button>
    </div>
    
    <div style="margin-top:30px;" class="form-inline">
      <textarea @keydown.enter="addReply" v-model="newReply.contents" style="width:700px;" class="form-control"></textarea>
      <button @click="addReply" style="height:50px; margin-left:10px;" class="btn btn-primary">댓글 등록</button>
    </div>

    <!-- reply content -->
    <div style="margin-top:30px; margin-left:10px;"><p v-if="replies.length>0" style="font-size:1.2em">댓글</p>
      <div style="margin-top:10px; background: whitesmoke; padding:10px;" v-for="reply in replies" :key="reply.answerNum">
        <div>
          <span style="font-size:1.1em">{{reply.writer}}</span>
          <span class="fr">{{reply.writtenDate}}</span>
        </div>
        <div style="margin-top:10px;">{{reply.contents}}</div>
        <div align="right" v-if="isLogin && (reply.writer==loginUser.id || loginUser.admin)">
          <a style="margin-left:10px;" href="#" @click="deleteReply(reply.answerNum)">삭제</a>
        </div>
      </div>
    </div>
    <div style="width:800px;"></div>
  </div>
</template>

<script>
import ajax from "../../../js/http-commons";
import router from "../../../js/router";
export default {
  props: ["qnaNum"],
  data() {
    return {
      qna: {},
      replies: [],
      newReply: {contents: ""},
      isLoading: false
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
    this.isLoading = true;
    ajax
      .get("/question/detail/" + this.qnaNum)
      .then(res => {
        this.qna = res.data;
      })
      .catch(e => {
        alert("error: " + e);
      });
    ajax
      .get("answer/answerForQuestion/" + this.qnaNum)
      .then(res => {
        this.replies = res.data;
      })
      .catch(e => {
        alert("ERROR IN REPLY : " + e);
      })
      .finally(() => {
        this.isLoading = false;
      });
  },
  methods: {
    editPost() {
      router.push({
        path: "/QnAUpdate/" + this.qnaNum
      });
    },
    deletePost() {
      ajax
        .delete("/question/delete/" + this.qnaNum)
        .then(() => {
          alert("삭제되었습니다.");
          router.push({
            path: "/QnAMain/QnAList"
          });
        })
        .catch(e => {
          alert(e);
        });
    },
    addReply() {
      if(this.newReply.contents=="") {
        alert("내용이 없습니다.");
        return;
      }
      this.newReply.writer = this.loginUser.id;
      this.newReply.questionNum = this.qnaNum;
      ajax
        .post("/answer/regist", this.newReply)
        .then(res => {
          if (res.data.state == "SUCCESS") {
            alert("댓글이 등록되었습니다.");
            this.newReply.contents=""
            router.push({
              path: "/QnADetail/" + this.qnaNum
            });
          } else {
            alert("댓글이 등록 실패");
          }
        })
        .catch(e => {
          alert("add reply: " + e);
        })
        .finally(() => {
          ajax
            .get("answer/answerForQuestion/" + this.qnaNum)
            .then(res => {
              this.replies = res.data;
            })
            .catch(e => {
              alert("ERROR IN REPLY : " + e);
            })
            .finally(() => {
              this.isLoading = false;
            });
        });
    },
    deleteReply(answerNum) {
      ajax
        .delete("/answer/delete/" + answerNum)
        .then(() => {
          router.push({
            path: "/QnADetail/" + this.qnaNum
          });
          alert("댓글이 삭제되었습니다.");
        })
        .catch(e => {
          alert(e);
        }).finally(() => {
          ajax
            .get("answer/answerForQuestion/" + this.qnaNum)
            .then(res => {
              this.replies = res.data;
            })
            .catch(e => {
              alert("ERROR IN REPLY : " + e);
            })
            .finally(() => {
              this.isLoading = false;
            });
        });
    }
  }
};
</script>

<style scoped>
.info {
  background: whitesmoke;
}
.fr {
  float: right;
}
</style>