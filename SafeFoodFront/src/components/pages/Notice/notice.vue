<template>
  <div class="container" align="center">
    <b-jumbotron fluid container-fluid style="text-align: center" bg-variant="info" text-variant="primary" border-variant="dark">
      <template v-slot:header>
        <strong>Notice</strong>
      </template>
      <template v-slot:lead>
        공지사항 게시판 입니다.
      </template>
      <hr class="my-4" />
      <p>원활한 사용을 위해 제공되는 공지를 잘 읽어주세요.<br>
      특정 공지를 찾으실 땐 우측 상단의 검색을 이용하세요.</p>
    </b-jumbotron>
		<div v-if="isLogin && loginUser.admin" align="right" style="margin-right:30px;"><router-link to="/newNotice">새 공지</router-link></div>
    <div class="form-group form-inline" style="margin-left:550px; margin-top:20px;">
      <select v-model="searchCondition" class="form-control">
        <option value="1">제목</option>
        <option value="2">작성자</option>
      </select>
      <input v-model="searchText" @keydown.enter="doSearch" type="text" id="searchText" class="form-control" style="width:300px; margin-left:10px;">
      <button @click="doSearch" class="btn btn-primary" style="width:100px; margin-left:10px;">검색</button>
    </div>
		<table class="table table-hover table-condensed" style="width:1024px; margin-top:20px;">
			<thead>
				<tr>
          <th class="col-sd-1">글번호</th>
          <th class="col-sd-7">제목</th>
          <th class="col-sd-2">작성자</th>
          <th class="col-sd-3">작성일시</th>
        </tr>
			</thead>
      <tbody>
        <tr @click="showDetail(notice.noticeNum)" v-for="notice in noticeList" :key="notice.noticeNum">
          <td>{{notice.noticeNum}}</td>
          <td>{{notice.title}}</td>
          <td>{{notice.writer}}</td>
          <td>{{notice.writtenDate}}</td>
        </tr>
      </tbody>
		</table>
    <div style="width:1500px"></div>
	</div>
</template>

<script>
import axios from '../../../js/http-commons.js';
export default {
  data() {
    return {
      noticeList: [],
      searchCondition: 1,
      searchText: ""
    }
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
    axios.get("/notice/main")
    .then(res => {
      this.noticeList=res.data;
    }).catch(e => {
      alert(e);
    })
  },
  methods: {
    showDetail(noticeNum) {
      this.$router.push({
        path: "/noticeDetail/" + noticeNum
      });
    },
    doSearch() {
      if(this.searchCondition==1) {
        if(this.searchText=="") {
          alert("검색어를 입력하세요.");
          return;
        }
        axios.get("/notice/searchNoticeByTitle/" + this.searchText)
        .then(res => {
          this.noticeList = res.data;
          if(this.noticeList.length==0) alert("검색 조건에 맞는 상품이 없습니다.");
        }).catch(e => {
          alert("조회 실패 : " + e);
        })
      } else {
        if(this.searchText=="") {
          alert("검색어를 입력하세요.");
          return;
        }
        axios.get("/notice/searchNoticeByWriter/" + this.searchText)
        .then(res => {
          this.noticeList = res.data;
          if(this.noticeList.length==0) alert("검색 조건에 맞는 상품이 없습니다.");
        }).catch(e => {
          alert("조회 실패 : " + e);
        })
      }
    }
  },
};
</script>

<style>
</style>