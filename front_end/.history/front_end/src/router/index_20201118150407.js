import Vue from 'vue'
import VueRouter from "vue-router";
import login from '@/components/login'
import HelloWorld from '@/components/HelloWorld'
import login from '@/components/login'
import login from '@/components/login'
Vue.use(VueRouter)

const routes = [
    
    
  { path: '/', component: login},
  { path: '/Hello', component: login },

];

const router = new VueRouter({
  routes
});

export default router;