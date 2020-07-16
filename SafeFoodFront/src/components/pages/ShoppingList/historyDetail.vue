<template>
  <div id="content" align="center" class="container">
    <b-jumbotron bg-variant="info" text-variant="primary" border-variant="dark" style="text-align: center" fluid container-fluid>
      <template v-slot:header><strong>Shopping History</strong></template>
      <template v-slot:lead>상세 내역 입니다.</template>
      <hr class="my-4"/>
      <p>구매하신 내용을 확인하세요<br>문의 사항은 QnA 게시판을 활용해주세요.</p>
    </b-jumbotron>
    <b-container class="bv-example-row">
      <b-row>
        <b-col cols="3" v-for="(product) in histories" :key="product.date" style="margin-bottom: 15px">
            <b-card>
                <img :src="require('@/assets/' + product.food.imgPath)" style="max-width: 90%;" class="mb-3" img-top/>
                <b-card-text>
                <strong>{{product.food.name}}</strong><br>
                <div>{{product.food.maker}}</div>
                <p>구매 수량 : {{product.quantity}}<br>{{product.date}}</p>
                <div style="margin-top:5px;">
                </div>
                </b-card-text>
            </b-card>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import axios from '../../../js/http-commons.js';
export default {
    props: ["id", "date"],
    data() {
        return {
            histories: []
        }
    },
    mounted() {
        let transfer = {id:this.id, date:this.date}
        axios.post("/food/showHistoryDetail", transfer)
        .then(res => {
            this.histories = res.data;
            console.log(res);
        }).catch(e => {
            alert("조회 중 오류가 발생했습니다. : " + e);
        })
    },
}
</script>

<style>

</style>