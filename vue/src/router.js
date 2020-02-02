import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from './components/Login.vue'
import Home from './components/Home.vue'
import Dashboard from './components/Dashboard.vue'
import Member from './components/Member.vue'

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        redirect: '/login',
    },
    {
        path: '/login',
        name: 'Login',
        component: Login
    },
    {
        path: '/home',
        name: 'Home',
        component: Home,
        redirect: '/home/dashboard',
        children: [
            {
                path: 'dashboard',
                component: Dashboard
            },
            {
                path: 'member',
                component: Member
            }
        ]
    }
]

export default new VueRouter({
    // mode: 'history',
    routes
})