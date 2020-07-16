<template>
  <div class="container-fluid">
    <div id="search">
      <form class="form-inline">
        <div class="form-group">
          <select class="form-control" id="searchOption" v-model="searchOption">
            <option value selected disabled hidden>Choose here</option>
            <option value="1">제목</option>
            <option value="2">작성자</option>
          </select>
        </div>
        <div class="form-group">
          <input type="text" style="width:300px; margin-left:10px;" class="form-control" id="searchText" v-model="searchTxt" />
        </div>
        <input style="width:100px; margin-left:10px;" type="button" class="btn btn-primary" @click="search()" value="검색" />
      </form>
    </div>
    <table class="table table-hover table-condensed" id="list-table" style="margin-top:20px;">
      <thead>
        <tr>
          <th class="col-sd-1">글번호</th>
          <th class="col-sd-7">제목</th>
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
      searchOption: 1,
      searchTxt: "",
      posts: [],
      isLoading: false
    };
  },
  computed: {
    rows() {
      return this.posts.length;
    }
  },
  mounted() {
    this.isLoading = true;
    ajax.get("/question/main")
      .then(res => {
        this.posts = res.data;
      })
      .catch(e => {
        alert(e + " qna error");
      })
      .finally(() => {
        this.isLoading = false;
      });
  },
  methods: {
    detail(num) {
      router.push({
        path: "/QnADetail/" + num
      });
    },
    search() {
      this.isLoading = true;
      if(this.searchTxt=="") {
        alert("검색어를 입력하세요");
        return;
      }
      if (this.searchOption == 1) { // 제목
        ajax
          .get("/question/searchQuestionsByTitle/" + this.searchTxt)
          .then(res => {
            this.posts = res.data;
          })
          .catch(e => {
            alert(e);
          })
          .finally(() => {
            this.isLoading = false;
          });
      }else{
        ajax
          .get("/question/searchQuestionsByWriter/" + this.searchTxt)
          .then(res => {
            this.posts = res.data;
          })
          .catch(e => {
            alert(e);
          })
          .finally(() => {
            this.isLoading = false;
          });
      } 
    }
  }
};
</script>

<style>
#search {
  margin-bottom: 20px;
  float: right;
}
</style>