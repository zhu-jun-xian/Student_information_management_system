import Vue from 'vue'
import Router from 'vue-router'
import login from '@/components/login'

Vue.use(VueRouter)

const routes = [
    
    
  { path: '/login', component: login},
  { path: '/', component: login },

];

const router = new VueRouter({
  routes
});

export default router;