
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import LaundryHistoryManager from "./components/listers/LaundryHistoryCards"
import LaundryHistoryDetail from "./components/listers/LaundryHistoryDetail"

import LaundryStatusView from "./components/LaundryStatusView"
import LaundryStatusViewDetail from "./components/LaundryStatusViewDetail"
import PaymentHistoryManager from "./components/listers/PaymentHistoryCards"
import PaymentHistoryDetail from "./components/listers/PaymentHistoryDetail"

import LaundryHistoryManager from "./components/listers/LaundryHistoryCards"
import LaundryHistoryDetail from "./components/listers/LaundryHistoryDetail"



export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/laundryHistories',
                name: 'LaundryHistoryManager',
                component: LaundryHistoryManager
            },
            {
                path: '/laundryHistories/:id',
                name: 'LaundryHistoryDetail',
                component: LaundryHistoryDetail
            },

            {
                path: '/laundryStatuses',
                name: 'LaundryStatusView',
                component: LaundryStatusView
            },
            {
                path: '/laundryStatuses/:id',
                name: 'LaundryStatusViewDetail',
                component: LaundryStatusViewDetail
            },
            {
                path: '/paymentHistories',
                name: 'PaymentHistoryManager',
                component: PaymentHistoryManager
            },
            {
                path: '/paymentHistories/:id',
                name: 'PaymentHistoryDetail',
                component: PaymentHistoryDetail
            },

            {
                path: '/laundryHistories',
                name: 'LaundryHistoryManager',
                component: LaundryHistoryManager
            },
            {
                path: '/laundryHistories/:id',
                name: 'LaundryHistoryDetail',
                component: LaundryHistoryDetail
            },




    ]
})
