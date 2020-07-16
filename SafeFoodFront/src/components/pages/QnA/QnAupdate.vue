<template>
  <div class="container-fluid">
    <table class="table">
      <thead>
        <tr>
          <th>#</th>
          <th>Title</th>
          <th>Writer</th>
          <th>Written date</th>
        </tr>
      </thead>
      <tbody>
        <tr v-if="(targetPost)" :key="targetPost.questionNum">
          <td>{{targetPost.questionNum}}</td>
          <td>
            <input type="text" v-model="targetPost.title" />
          </td>
          <td>{{targetPost.writer}}</td>
          <td>{{targetPost.writtenDate}}</td>
        </tr>
        <tr>
          <td colspan="4">
            <textarea v-model="targetPost.contents" id="contents" class="form-control" rows="5" cols="1000">
            </textarea>
            <br />
          </td>
        </tr>
      </tbody>
    </table>
    <div align="right">
      <button style="width:200px;" type="button"  class="btn btn-info"  id="modifyNoticeBtn"  @click="editPost()">수정</button>
      <button style="width:200px; margin-left:10px;" type="button" class="btn btn-danger" id="deleteBtn" @click="deletePost()">삭제</button>
    </div>
  </div>
</template>

<script>
import ajax from "../../../js/http-commons";
import router from "../../../js/router";
export default {
  props: ["qnaNum"],
  data() {
    return {
      targetPost: {},
      isLoading: false
    };
  },
  mounted() {
    this.isLoading = true;
    ajax
      .get("/question/detail/" + this.qnaNum)
      .then(res => {
        this.targetPost = res.data;
      })
      .catch(e => {
        alert("error: " + e);
      })
      .finally(() => {
        this.isLoading = false;
      });
  },
  methods: {
      editPost(){
          ajax.put("/question/update",this.targetPost)
          .then(res=>{

           if(res.data.state=='SUCCESS') {
            alert('수정 완료');
            router.push({
              path: "/QnADetail/" + this.qnaNum
            });
          } else {
            alert('수정 실패');
          }
        }).catch(e => {
          alert('수정 실패 : ' + e);
        })
      },
      deletePost(){
        
      }
  },
};
</script>

<style scoped>
tr {
  margin: 10px;
}
</style>