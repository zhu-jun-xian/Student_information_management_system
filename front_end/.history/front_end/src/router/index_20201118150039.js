import Vue from 'vue'
import VueRouter from "vue-router";
import login from '@/components/login'

Vue.use(VueRouter)

const routes = [
    
    
  { path: '/', component: login},
  { path: '/', component: login },

];

const router = new VueRouter({
  routes
});

export default router;