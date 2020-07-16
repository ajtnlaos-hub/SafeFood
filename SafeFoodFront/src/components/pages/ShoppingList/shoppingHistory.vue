<template>
  <div id="content" align="center" class="container">
    <b-jumbotron bg-variant="info" text-variant="primary" border-variant="dark" style="text-align: center" fluid container-fluid>
      <template v-slot:header><strong>Shopping History</strong></template>
      <template v-slot:lead>구매내역 입니다.</template>
      <hr class="my-4"/>
      <p>구매하신 내용을 확인하고, 해당일의 영양 정보를 확인해보세요.</p>
    </b-jumbotron>
    <div>고객님은 총 {{dateOnly.length}}건의 구매 이력이 있습니다.</div>
    <p>아래 버튼을 눌러 상세 구매 내역을 확인해보세요.</p>
    <div v-for="history in dateOnly" :key="history.date">
        <a href="#" @click="historyDetail(history.date)">{{history.date}}</a>
    </div>
    <div style="width:1500px;"></div>
  </div>
</template>

<script>
import axios from '../../../js/http-commons.js';
export default {
    props: ["id"],
    data() {
        return {
            dateOnly: []
        }
    },
    mounted() {
        axios.get("/food/showShoppingDate/" + this.id)
        .then(res => {
            this.dateOnly=res.data;
            if(res.data.length==0) {
                alert("구매 내역이 없습니다.");
            }
            console.log(this.dateOnly);
        }).catch(e => {
            alert("조회 중 오류 발생 : " + e);
        })
    },
    methods: {
        historyDetail(clickedDate) {
            console.log(clickedDate);
            console.log(this.id);
            this.$router.push({
                path: "/historyDetail/" + this.id + "/" + clickedDate
            });
        }
    },
}
</script>

<style>

</style>