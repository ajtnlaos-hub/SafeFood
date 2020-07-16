<template>
  <div class="container">
    <div class="row" style="margin-top:50px;">
      <div id="image" class="col-md-3">
        <img :src="require('@/assets/'+food.imgPath)" width="80%" />
      </div>
      <div class="col-md-8">
        <table id="info" class="table">
          <tr>
            <th>제품명</th>
            <td id="name">{{food.name}}</td>
          </tr>
          <tr>
            <th>제조사</th>
            <td id="maker">{{food.maker}}</td>
          </tr>
          <tr>
            <th>원재료</th>
            <td id="material">{{food.material}}</td>
          </tr>
          <tr>
            <th>알레르기 성분</th>
            <td id="allergy">
              <span v-for="allergy in food.allergyList" :key="allergy">
                {{allergy}}
              </span>
            </td>
          </tr>
        </table>
        <br />
      </div>
    </div>
    <div id="nut">
      <h4>영양 정보</h4>
      <div class="row">
        <div class="col-md-6" id="drawChart" style="width: 550px; height: 500px;">
          <apexchart type="bar" height="550" :options="chartOptions" :series="series" />
        </div>
        <div class="col-md-6" style="padding:30px 0 0 0;">
          <table id="nutr" class="table">
            <tr>
              <th>일회 제공량</th>
              <td id="wt">{{food.supportPerEat}}</td>
            </tr>
            <tr>
              <th>칼로리</th>
              <td id="cal">{{food.calory}}</td>
            </tr>
            <tr>
              <th>탄수화물</th>
              <td id="carbo">{{food.carbo}}</td>
            </tr>
            <tr>
              <th>단백질</th>
              <td id="prot">{{food.protein}}</td>
            </tr>
            <tr>
              <th>지방</th>
              <td id="fat">{{food.fat}}</td>
            </tr>
            <tr>
              <th>당류</th>
              <td id="sugar">{{food.sugar}}</td>
            </tr>
            <tr>
              <th>나트륨</th>
              <td id="na">{{food.natrium}}</td>
            </tr>
            <tr>
              <th>콜레스테롤</th>
              <td id="col">{{food.chole}}</td>
            </tr>
            <tr>
              <th>포화 지방산</th>
              <td id="acid">{{food.fattyacid}}</td>
            </tr>
            <tr>
              <th>트랜스지방</th>
              <td id="trans">{{food.transfat}}</td>
            </tr>
          </table>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ajax from "../../../js/http-commons";
var colors = [
  "#008FFB",
  "#00E396",
  "#FEB019",
  "#FF4560",
  "#775DD0",
  "#546E7A",
  "#26a69a",
  "#D10CE8",
  "#575CE8"
];
export default {
  props: ["code"],
  data() {
    return {
      food: {},
      isLoading: false,
      // Chart Data
      series: [
        {data:[0,0,0,0,0,0,0,0,0]},
      ],
      chartOptions: {
        chart: {
          height: 550,
          type: "bar",
          events: {}
        },
        colors: colors,
        plotOptions: {
          bar: {
            columnWidth: "45%",
            distributed: true
          }
        },
        dataLabels: {
          enabled: false
        },

        xaxis: {
          categories: [
            "칼로리",
            "탄수화물",
            "단백질",
            "지방",
            "당류",
            "나트륨",
            "콜레스테롤",
            "포화지방산",
            "트랜스지방"
          ],
          labels: {
            style: {
              colors: colors,
              fontSize: "14px"
            }
          }
        }
      }
    };
  },
  mounted() {
    ajax.get("/food/detail/" + this.code)
      .then(res => {
        this.food = res.data;
         this.series = [
           {data: [this.food.calory,
                        this.food.carbo,
                        this.food.protein,
                        this.food.fat,
                        this.food.sugar,
                        this.food.natrium,
                        this.food.chole,
                        this.food.fattyacid,
                        this.food.transfat]
           }];
      })
      .catch(e => {
        alert("DETAIL PAGE ERROR: " + e);
      })
  }
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap");
#subTitle {
  font-family: "Do Hyeon", sans-serif;
  font-size: 70px;
}
.container {
  margin-bottom: 10px;
}
#info th {
  text-align: center;
  width: 100px;
}
#nutr th {
  text-align: center;
  width: 200px;
}
#nut {
  margin-top: 50px;
}
</style>