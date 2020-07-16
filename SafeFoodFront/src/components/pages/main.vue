<template>
  <div class="container">
    <b-jumbotron fluid container-fluid style="text-align: center" bg-variant="info" text-variant="primary" border-variant="dark">
      <template v-slot:header>
        <h1>WHAT WE <strong>PROVIDE</strong></h1>
      </template>
      <template v-slot:lead>
        Safe Food에 오신 것을 환영합니다.
      </template>
      <hr class="my-4" />
      <p>건강한 삶을 위한 먹거리 프로젝트</p>
      Safe Food는 고객들이 건강한 삶을 유지할 수 있도록<br>
      안심 먹거리를 선정하는 지침을 제공하고 있습니다.
    </b-jumbotron>
    <div style="width:1500px;"></div>
  </div>
</template>

<script>
export default {};
</script>

<style>
@import url("https://fonts.googleapis.com/css?family=Righteous&display=swap");
@import url("https://fonts.googleapis.com/css?family=Monoton&display=swap");
#titleTop {
  /* font-family: 'Righteous', cursive; */
  font-family: "Monoton", cursive;
  font-size: 450%;
}
</style>