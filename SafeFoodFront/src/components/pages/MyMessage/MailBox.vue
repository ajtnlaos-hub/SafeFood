<template>
  <div class="container">
    <b-jumbotron fluid container-fluid bg-variant="info" text-variant="success" border-variant="dark" style="text-align: center">
      <template v-slot:header>Message Box</template>
       <template v-slot:lead>
        Message Box
      </template>
      <hr class="my-4" />
      <p>건강한 삶을 위한 먹거리 프로젝트</p>
    </b-jumbotron>
    <div class="container">
      <table>
        <tr>
          <td id="fl" valign="top" style="width:200px;">
            <left-nav></left-nav>
            </td>
          <td style="width:100"><router-view></router-view></td>
        </tr>
      </table>
    </div>
    <div style="width:1140px;"></div>
  </div>
</template>


<script>
import leftNav from "./leftNav";
export default {
  components: {
    leftNav
  }
};
</script>

<style scoped>
  #fl {
    float:left;
  }
</style>