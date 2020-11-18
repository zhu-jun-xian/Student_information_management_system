import Vue from 'vue'
import VueRouter from "vue-router";
import login from '@/components/login'
import user from '@/components/HelloWorld'

Vue.use(VueRouter)

const routes = [
    
    
  { path: '/', component: login},
  { path: '/HelloWorld', component: HelloWorld },

];

const router = new VueRouter({
  routes
});

export default router;