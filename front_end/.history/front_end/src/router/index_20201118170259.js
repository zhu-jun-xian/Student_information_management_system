import Vue from 'vue'
import VueRouter from "vue-router";
import login from '@/components/login'
import user from '@/components/user'
import sel from '@/components/User/selectuser'

Vue.use(VueRouter)

const routes = [
    
    
  { path: '/', component: login},
  { path: '/user', component: user },
  { path: '/selectuser', component: selectuser },

];

const router = new VueRouter({
  routes
});

export default router;