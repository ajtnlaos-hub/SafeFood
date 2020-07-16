<template>
  <div class="container">
      <b-jumbotron fluid container-fluid style="text-align: center" bg-variant="info" text-variant="primary" border-variant="dark">
      <template v-slot:header>
        <strong>Popular products</strong>
      </template>
      <template v-slot:lead>
        <p>가장 많은 사람들의 선택을 받은 상품들입니다.</p>
      </template>
      <hr class="my-4" />
      <p>건강한 삶을 위한 먹거리 프로젝트, 당신의 Pick은?</p>
    </b-jumbotron>
    <!-- rank design -->
    <div style="width: 1100px;">
      <!-- <img :src="request('https://cdn2.iconfinder.com/data/icons/seo-line-8/64/Keyword_ranking_graph_colom-512.png')"> -->

        <b-row>
          <b-col style="text-align:center">What's is the <span id="rankTitle"> Best 5</span></b-col>
        </b-row>
        <b-row>
          <b-col cols=1 style="text-align:center;">
            <img :src="require('@/assets/'+foodList[0].imgPath)" width="90%" />
          </b-col>
          <b-col cols=3 style="text-align:left">
            {{foodList[0].name}}
          </b-col>
        </b-row>
        <b-row>
          <b-col cols=1 style="text-align:center;">
            <img :src="require('@/assets/'+foodList[1].imgPath)" width="90%" />
          </b-col>
          <b-col cols=3 style="text-align:left">
            {{foodList[1].name}}
          </b-col>
        </b-row>
        <b-row>
          <b-col cols=1 style="text-align:center;">
            <img :src="require('@/assets/'+foodList[2].imgPath)" width="90%" />
          </b-col>
          <b-col cols=3 style="text-align:left">
            {{foodList[2].name}}
          </b-col>
        </b-row>
        <b-row>
          <b-col cols=1 style="text-align:center;">
            <img :src="require('@/assets/'+foodList[3].imgPath)" width="90%" />
          </b-col>
          <b-col cols=3 style="text-align:left">
            {{foodList[3].name}}
          </b-col>
        </b-row>
        <b-row>
          <b-col cols=1 style="text-align:center;">
            <img :src="require('@/assets/'+foodList[4].imgPath)" width="90%" />
          </b-col>
          <b-col cols=3 style="text-align:left">
            {{foodList[4].name}}
          </b-col>
        </b-row>
      
    </div>
 

  </div>
</template>

<script>
import axios from '../../../js/http-commons.js';
export default {
    data() {
        return {
            isLoading:false,
            foodList:[]
        }
    },
    mounted() {
        this.isLoading=true;
        axios.get('/food/top20Foods')
        .then(res=>{
            this.foodList = res.data;
        })
        .catch(e=>{
            alert("Best 5 Page Error: " + e)
        })
        .finally(()=>{
            this.isLoading = false;
        })
    },

}
</script>

<style>

</style>