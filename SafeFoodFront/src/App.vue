<template>
  <div id="app">
    <b-row class="justify-content-md-center">
      <div id="header">
        <v-header></v-header>
        <router-view></router-view>
        <div id="footer" style="margin-top:50px;"><v-bottom></v-bottom></div>
      </div>
    </b-row>
  </div>
</template>

<script>
import router from "./js/router";
import vHeader from "./components/common/header";
import vBottom from "./components/common/bottom";
export default {
  name: "app",
  router,
  components: {
    vHeader,
    vBottom
  }
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
#footer {
  margin-top: 20px;
  background: #f0f0f0;
  padding: 5px 15px 10px 15px;
}
.jumbotron {
  /* width: 1024px; */
  height: 400px;
  background: white;
  background-image: url(https://images.unsplash.com/photo-1543352634-a1c51d9f1fa7?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80);
  background-repeat: no-repeat;
  background-position: center;
  background-size: cover;
  padding-top: 120px;
  margin-top: 10px;
}

</style>
