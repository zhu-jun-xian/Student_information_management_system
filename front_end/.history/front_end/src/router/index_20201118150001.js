import Vue from 'vue'
import Router from 'vue-router'
import login from '@/components/login'

Vue.use(VueRouter)

const routes = [
    
    
  { path: '/HelloWorld', component: HelloWorld1},
  { path: '/', component: login },

];

const router = new VueRouter({
  routes
});

export default router;