<template>
  <div id="content" align="center" class="container">
    <b-jumbotron fluid container-fluid bg-variant="info" text-variant="primary" border-variant="dark" style="text-align: center">
      <template v-slot:header>Q & A</template>
       <template v-slot:lead>
        Q & A 게시판입니다
      </template>
      <hr class="my-4" />
      <p>문의 사항을 남겨주세요.<br>최대한 빠른 시간 안에 응답하는 Safe Food가 되겠습니다.</p>
    </b-jumbotron>
    <div class="container">
      <table>
        <tr>
          <td id="fl" valign="top" style="width:200px;">
            <v-nav-bar></v-nav-bar>
            </td>
          <td><router-view></router-view></td>
        </tr>
      </table>
    </div>
    <div style="width:1500px;"></div>
  </div>
</template>

<script>
import vNavBar from "./leftNav";
export default {
  components: {
    vNavBar
  },
  mounted() {
    
  },
};
</script>

<style scoped>
  #fl {
    float:left;
  }
</style>