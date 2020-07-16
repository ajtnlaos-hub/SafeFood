import Vue from 'vue'
import VueRouter from 'vue-router';
import main from '../components/pages/main'
import QnAMain from '../components/pages/QnA/QnA'
import notice from '../components/pages/Notice/notice'
import QnAList from '../components/pages/QnA/qnaList'
import QnANew from '../components/pages/QnA/newQnA'
import login from '../components/pages/User/login.vue'
import myQnA from '../components/pages/QnA/myQnA.vue'
import noticeDetail from '../components/pages/Notice/noticeDetail.vue';
import registUser from '../components/pages/User/registUser.vue';
import updateUser from '../components/pages/User/updateUser.vue';
import updateNotice from '../components/pages/Notice/updateNotice.vue';
import newNotice from '../components/pages/Notice/newNotice.vue';
import QnADetail from '../components/pages/QnA/QnAdetail'
import QnAUpdate from '../components/pages/QnA/QnAupdate'
import ProductMain from '../components/pages/Product/productMain'
import foodDetail from '../components/pages/Product/productDetail'
import BestFood from '../components/pages/BestFood/BestFood'
import MyFood from '../components/pages/MyFoodInfo/MyFood'
import MsgBox from '../components/pages/MyMessage/MailBox'
import MsgList from '../components/pages/MyMessage/MsgList'
import MsgNew from '../components/pages/MyMessage/MyNewMessage'
import MsgDetail from "../components/pages/MyMessage/MyMessageDetail";
import MsgMyHistory from '../components/pages/MyMessage/MySentHistory'
//import MyMapMain from '../components/pages/MyMap/MyMapMain'

import shoppingListMain from '../components/pages/ShoppingList/shoppingListMain.vue'
import shoppingHistory from '../components/pages/ShoppingList/shoppingHistory.vue'
import historyDetail from '../components/pages/ShoppingList/historyDetail.vue'
Vue.use(VueRouter)
const router = new VueRouter({
    routes:[
        {
            name: 'historyDetail',
            path: '/historyDetail/:id/:date',
            component: historyDetail,
            props: true
        },
        {
            name: 'shoppingHistory',
            path: '/shoppingHistory/:id',
            component: shoppingHistory,
            props: true
        },
        {
            name:"MsgBox",
            path:"/MsgBox",
            component:MsgBox,
            children:[
                {
                    path:"",
                    component:MsgList
                },
                {
                    path:"MsgNew",
                    component:MsgNew
                },
                {
                    path:"MsgDetail",
                    component:MsgDetail
                },
                {
                    path:"MsgMyHistory",
                    component:MsgMyHistory
                }
            ]
        },
        {
            name: "shoppingListMain",
            path: "/shoppingListMain/:id",
            component: shoppingListMain,
            props: true
        },
        {
            name:"MyFood",
            path:"/MyFood",
            component:MyFood
        },
        {
            name:"BestFood",
            path:"/BestFood",
            component:BestFood
        },
        {
            name: "newNotice",
            path: "/newNotice",
            component: newNotice
        },
        {
            name: "updateNotice",
            path: "/updateNotice/:noticeNum",
            component: updateNotice,
            props: true
        },
        {
            name: "updateUser",
            path: "/updateUser/:id",
            component: updateUser,
            props: true
        },
        {
            name: "registUser",
            path: "/registUser",
            component: registUser,
        },
        {
            name: "noticeDetail",
            path: "/noticeDetail/:noticeNum",
            component: noticeDetail,
            props: true
        },
        {
            name: "login",
            path: "/login",
            component: login
        },
        {
            name:"main",
            path:"/",
            component: main
        },
        {
            name:"QnAList",
            path:"/QnAMain",
            component:QnAMain,
            children:[
                {
                    path:"",
                    component:QnAList
                },
                {
                    path: 'myQnA',
                    component: myQnA  
                },
                {
                    path: 'QnAList',
                component:QnAList
                },
                {
                    path: 'QnANew',
                component: QnANew
                },
                {
                    path: '/QnADetail/:qnaNum',
                    props:true,
                component: QnADetail
                },
                {
                    path: '/QnAUpdate/:qnaNum',
                    props:true,
                component: QnAUpdate
                }
            ]
        },
        {
            name:"notice",
            path:"/notice",
            component:notice
        },
        {
            name:"ProductMain",
            path:"/ProductMain",
            component:ProductMain,
            props:true
        },
        {
            name:"foodDetail",
            path:"/foodDetail/:code",
            component:foodDetail,
            props:true
        },
        // {
        //     name:"MyMapMain",
        //     path:"/MyMapMain",
        //     component:MyMapMain
        // }
    ]
})
export default router