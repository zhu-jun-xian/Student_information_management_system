import Vue from 'vue'
import VueRouter from "vue-router";
import login from '@/components/login'
import user from '@/components/user'
import updateuser from '@/components/User/updateuser'

Vue.use(VueRouter)

const routes = [
    
    
  { path: '/', component: login},
  { path: '/user', component: user },
  { path: '/user', component: user },

];

const router = new VueRouter({
  routes
});

export default router;