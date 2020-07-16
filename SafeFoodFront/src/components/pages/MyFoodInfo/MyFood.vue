<template>
  <div class="container">
    <b-jumbotron
      fluid
      container-fluid
      bg-variant="info"
      text-variant="primary"
      border-variant="dark"
      style="text-align: center"
    >
      <template v-slot:header>My Food Information</template>
      <template v-slot:lead>What I ate, What I gonna eat,</template>
      <hr class="my-4" />
      <p>맛있으면 0칼로리!</p>
    </b-jumbotron>
    <div style="width:1500px;"></div>
    <div >
      <b-tabs content-class="mt-3" justified>
        <b-tab title="이미 먹은 음식들은?" active>
          <div>
            <already-eat></already-eat>
          </div>
        </b-tab>
        <b-tab title="내가 먹을 음식들은?">
          <gonna-eat></gonna-eat>
        </b-tab>
        <b-tab title="맛있으면 0칼로리!!!" disabled>
          <p>disabled tab!</p>
        </b-tab>
      </b-tabs>
    </div>
    <div style="width:1500px;"></div>
  </div>
</template>

<script>
import AlreadyEat from '../MyFoodInfo/AlreadyAte'
import GonnaEat from '../MyFoodInfo/GonnaEat'

export default {
  components:{
    AlreadyEat,
    GonnaEat
  }


};
</script>

<style>
</style>