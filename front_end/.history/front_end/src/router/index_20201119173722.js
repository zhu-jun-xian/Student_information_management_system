import Vue from 'vue'
import VueRouter from "vue-router";
import login from '@/components/login'
import user from '@/components/user'
import selectstudent from '@/components/User/selectstudent'
import register from '@/components/register'


Vue.use(VueRouter)

const routes = [


    { path: '/', component: login },
    { path: '/user', component: user },
    { path: '/register', component: register },
    { path: '/selectstudentr', component: selectuser },

];

const router = new VueRouter({
    routes,
    mode: "history"
});

export default router;