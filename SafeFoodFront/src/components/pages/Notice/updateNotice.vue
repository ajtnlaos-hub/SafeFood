<template>
  <div class="container">
    <b-jumbotron fluid container-fluid style="text-align: center" bg-variant="info" text-variant="primary" border-variant="dark">
      <template v-slot:header>
        <strong>Update Notice</strong>
      </template>
      <template v-slot:lead>
        공지사항 수정 페이지입니다.
      </template>
      <hr class="my-4" />
      <p>수정 즉시 반영됩니다.</p>
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
        <td><input type="text" v-model="notice.title" style="width:350px;"></td>
        <td class="info">작성일시</td>
        <td>{{notice.writtenDate}}</td>
      </tr>
    </table>
    <div align="left" style="margin-left:50px; margin-top:30px;">
        <textarea v-model="notice.contents" class="form-control" style="width:960px; height:300px;"></textarea>
    </div>
    <div style="margin-top:50px;">
        <button @click="doUpdate" class="btn btn-primary" style="width:300px;">수정</button>
    </div>
  </div>
</template>

<script>
import axios from '../../../js/http-commons.js';
export default {
    props: ["noticeNum"],
    data() {
        return {
            notice: {}
        }
    },
    mounted() {
        axios.get("/notice/detail/" + this.noticeNum)
        .then(res => {
            this.notice = res.data;
        }).catch(() => {
            alert("정보 조회 실패");
        })
    },
    methods: {
        doUpdate() {
            axios.put("/notice/update", this.notice)
            .then(res=> {
                if(res.data.state=="SUCCESS") {
                    alert("공지사항을 수정하였습니다.");
                    this.$router.push("/noticeDetail/" + this.notice.noticeNum);
                } else {
                    alert("수정 실패!");
                }
            }).catch(e => {
                alert("수정 대실패 : " + e)
            })
        }
    },
}
</script>

<style scoped>
.info {
  background: whitesmoke;
}
</style>