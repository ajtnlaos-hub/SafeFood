import VueX from 'vuex'
import Vue from 'vue'

Vue.use(VueX)
const store = new VueX.Store({
    state:{
        mod:0,
        loginUser: {},
        isLogin: false
    },
    mutations:{
        function (state) {
            console.log(state)
        }
    },

})
export default store;