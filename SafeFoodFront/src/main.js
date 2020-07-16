import Vue from 'vue'
import App from './App.vue'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import router from './js/router'
import store from './js/vuex'
import VueApexCharts from 'vue-apexcharts'
// import {Tabs, Tab} from 'vue-tabs-component'



Vue.use(BootstrapVue)
Vue.use(VueApexCharts)
Vue.component('apexchart',VueApexCharts)
// Vue.component('tabs',Tabs)
// Vue.component('tab',Tab)
Vue.config.productionTip = true

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')
