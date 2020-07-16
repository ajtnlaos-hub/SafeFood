<template>
  <b-container class="container">
    <b-row>
      <b-col>내가 먹은 음식을 분석해 드립니다.</b-col>
    </b-row>
    <b-row>
      <!-- 차트 -->
      <b-col>
        <div id="chart">
          <apexchart type="line" height="350" :options="chartOptions" :series="series" />
        </div>
      </b-col>
    </b-row>
      <!-- 검색 정보 -->
    <b-row>
      <b-col>

      </b-col>
    </b-row>
  </b-container>
</template>

<script>
export default {
  data() {
    return {
      series: [
        {
          name: "청소년(남)",
          type: "column",
          data: [2700, 470, 60, 80, 1500]
        },
        {
          name: "청소년(여)",
          type: "column",
          data: [2000, 350, 45, 66.7, 1500]
        },
        {
          name: "성인(남)",
          type: "line",
          data: [2600, 460, 55, 72, 1500]
        },
        {
          name: "성인(여)",
          type: "line",
          data: [2100, 370, 50, 58.3, 1500]
        }
      ],
      chartOptions: {
        dataLabels: {
          enabled: false
        },

        stroke: {
          width: [1, 1, 1,1]
        },
        
        xaxis: {
          categories: [
            "칼로리",
            "탄수화물",
            "단백질",
            "지방",
            "나트륨"
          ],
        },
        yaxis: [
          {
            axisTicks: {
              show: true
            },
            axisBorder: {
              show: true,
              color: "#008FFB"
            },
            labels: {
              style: {
                color: "#008FFB"
              }
            },
            title: {
              text: "청소년-남(섭취량)",
              style: {
                color: "#008FFB"
              }
            },
            tooltip: {
              enabled: true
            }
          },

          {
            seriesName: "청소년(남)",
            opposite: true,
            axisTicks: {
              show: true
            },
            axisBorder: {
              show: true,
              color: "#00E396"
            },
            labels: {
              style: {
                color: "#00E396"
              }
            },
            title: {
              text: "청소년-여(섭취량)",
              style: {
                color: "#00E396"
              }
            },
            tooltip: {
              enabled: true
            }
          },
          {
            seriesName: "청소년(여)",
            opposite: true,
            axisTicks: {
              show: true
            },
            axisBorder: {
              show: true,
              color: "#FEB019"
            },
            labels: {
              style: {
                color: "#FEB019"
              }
            },
            title: {
              text: "성인-남(섭취량)",
              style: {
                color: "#FEB019"
              }
            }
          },
          {
            seriesName: "성인(남)",
            opposite: true,
            axisTicks: {
              show: true
            },
            axisBorder: {
              show: true,
              color: "#FF4560"
            },
            labels: {
              style: {
                color: "#FF4560"
              }
            },
            title: {
              text: "성인-여(섭취량)",
              style: {
                color: "#FF4560"
              }
            }
          }
        ],
        tooltip: {
          fixed: {
            enabled: true,
            position: "topLeft", // topRight, topLeft, bottomRight, bottomLeft
            offsetY: 30,
            offsetX: 60
          }
        },
        legend: {
          horizontalAlign: "left",
          offsetX: 40
        }
      }
    };
  }
};
</script>

<style>
</style>