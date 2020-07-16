<template>
  <div class="container">
    <b-jumbotron fluid container-fluid style="text-align: center" bg-variant="info" text-variant="primary" border-variant="dark">
      <template v-slot:header>
        <strong>New Notice</strong>
      </template>
      <template v-slot:lead>
        새로운 공지를 입력해주세요.
      </template>
      <hr class="my-4" />
      <p>공지사항은 모든 사용자에게 공개됩니다.</p>
    </b-jumbotron>
    <div style="margin-top:20px;">
      <label for="noticeTitle">제목</label><br/>
      <input v-model="notice.title" style="width:900px" id="noticeTitle" type="text" placeholder="  title"/>
    </div>
    <div style="margin-top:20px;">
      <label for="contents">내용</label><br/>
      <textarea v-model="notice.contents" style="width:900px; height:300px"
      id="contents" placeholder="  Write contents here"></textarea>
    </div>
    <div style="margin-top:50px;">
      <button @click="insertNotice" class="btn btn-primary" style="width:300px;">등록</button>
    </div>
  </div>
</template>

<script>
import axios from '../../../js/http-commons.js';
export default {
  data() {
    return {
      notice: {}
    };
  },
  computed: {
      loginUser() {
          return this.$store.state.loginUser;
      }
  },
  methods: {
    insertNotice() {
        this.notice.writer = this.loginUser.id;
        axios.post("/notice/regist", this.notice)
        .then(res => {
            if(res.data.state=='SUCCESS') {
                alert("공지사항을 등록했습니다.")
                this.$router.push({
                    path: "/notice"
                })
            } else {
                alert("공지사항 등록 실패");
            }
        }).catch(e => {
            alert("공지사항 등록 대실패 : " + e);
        })
    }
  }
};
</script>

<style>
</style>