import Vue from 'vue'
import VueRouter from "vue-router";
import login from '@/components/login'
import user from '@/components/user'
import selectstudent from '@/components/User/selectstudent'
import inforstudent from '@/components/User/inforstudent'
import Sumstudent from '@/components/User/Sumstudent'
import register from '@/components/register'
import { component } from 'vue/types/umd';


Vue.use(VueRouter)

const routes = [


    { path: '/', component: login },
    {
        path: '/user',
        component: user,
        children: [　　　
            {
               path: '/selectstudent',
               component: selectstudent　　 
             },
            {
              path: '/inforstudent', 　　　
              component: inforstudent　　 
            },
            {
                path:'/Sumstudent'
                component
            }
        　　]
    },
    { path: '/register', component: register },
    // { path: '/selectstudent', component: selectstudent },

];

const router = new VueRouter({
    routes,
    mode: "history"
});

export default router;