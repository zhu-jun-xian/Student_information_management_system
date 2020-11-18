<template>
<div>
<h1>{{msg}}</h1>
<hr>
<div class="inputStyle" id="register"> 
<p class="p1">登录ID :
<el-input  type="text"   v-model="ID" maxlength="30" show-word-limit :disabled="true" ></el-input></p><!--修改信息时，登录ID不可修改-->
<p class="p1"><span style="color:red" v-if="username.length==0">*</span>姓名 :
<el-input  type="text"   v-model="username" maxlength="10" show-word-limit></el-input></p>
<p class="p1"><span style="color:red" v-if="tel.length==0">*</span>手机号码 :
<el-input  type="text"   v-model="tel" maxlength="11" minlength="11" show-word-limit></el-input></p>
<p class="p1"><span style="color:red" v-if="password.length==0">*</span>输入密码 :
<el-input  type="password" v-model="password" maxlength="30" minlength="8"></el-input></p>
<p class="p1"><span style="color:red" v-if="password1.length==0">*</span>确认密码 :
<el-input  type="password" v-model="password1" maxlength="30" minlength="8"></el-input></p>
<el-button class="button"  type="primary" round>确认</el-button>
</div>
</div>
</template>

<script>
//修改信息
export default {
  data() {
    return {
      msg: "修改信息",
      ID: '',
      username: '',
      tel: '',
      password: '',
      password1: '',
      
    };
  },
methods: {
  
},
   mounted(){
    document.querySelector('body').setAttribute('style','background-color: #e5ffee')
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