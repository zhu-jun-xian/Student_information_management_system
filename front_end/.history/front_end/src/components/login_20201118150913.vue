
<template>
<div>
<h1>{{msg}}</h1>
<hr>
<div class="inputStylelogin" id="login"> 
<p><span style="color:red" v-if="ID.length==0">*</span>登录ID :
<el-input  type="text"   v-model="ID" maxlength="30" show-word-limit></el-input></p>
<p><span style="color:red" v-if="password.length==0">*</span>输入密码 :
<el-input  type="password" v-model="password" maxlength="30" minlength="8"></el-input></p>
<el-button class="button" @click="enter" type="primary" round>登录</el-button>
</div>
</div>
</template>
<script>
// 登录界面
export default {
  data() {
    return {
      msg: "登录",
      ID: '',
      username: '',
      tel: '',
      password: '',
      password1: '',
      
    };
  },
methods: {
    //设置页面背景色
   mounted(){
    document.querySelector('body').setAttribute('style','background-color:rgb(153, 153, 255)')
    },
  enter(){
        this.$router.push({ path: '/HelloWorld'})
}
}
  
</script>

<style scoped>
.button{
  width: 140px;
  margin-left:30% ;
}
.inputStylelogin {
    width: 450px;
    height: 200px;
    margin-top: 9%;
    margin-left:30%;
  }

</style>