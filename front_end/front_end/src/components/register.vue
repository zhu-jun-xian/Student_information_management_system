<template>
<div>
<el-row>
<el-col :span="22"><h1>{{msg}}</h1></el-col>
<el-col :span="2"><div><el-button plain @click="returnTologin" style="margin-top:40px" type="info" >返回登录</el-button></div></el-col>
</el-row>
<hr>
<div class="inputStyle" id="register"> 
<p class="p1"><span style="color:red" v-if="ID.length==0">*</span>登录ID :
<el-input  type="text"   v-model="ID" maxlength="30" show-word-limit></el-input></p>
<p class="p1"><span style="color:red" v-if="username.length==0">*</span>姓名 :
<el-input  type="text"   v-model="username" maxlength="10" show-word-limit></el-input></p>
<p class="p1"><span style="color:red" v-if="tel.length==0">*</span>手机号码 :
<el-input  type="text"   v-model="tel" maxlength="11" minlength="11" show-word-limit></el-input></p>
<p class="p1"><span style="color:red" v-if="password.length==0">*</span>输入密码 :
<el-input  type="password" v-model="password" maxlength="30" minlength="8"></el-input></p>
<p class="p1"><span style="color:red" v-if="password1.length==0">*</span>确认密码 :
<el-input  type="password" v-model="password1" maxlength="30" minlength="8"></el-input></p>
<el-button class="button"  type="primary" round>注册</el-button>
</div>
</div>
</template>

<script>
// 注册界面
export default {
  data() {
    return {
      msg: "账号注册",
      ID: '',
      username: '',
      tel: '',
      password: '',
      password1: '',
      
    };
  },
methods: {
  returnTologin(){
  this.$router.push({ path: '/'})
},
},
   mounted(){
    // document.querySelector('body').setAttribute('style','background-color:rgb(102, 255, 102)')
    },  //设置页面背景色
  };
</script>

<style scoped>
.button{
  width: 140px;
  margin-left:30% ;
}
.inputStyle {
    width: 450px;
    height: 200px;
    margin-top: 9%;
    margin-left:30%;
  }

</style>