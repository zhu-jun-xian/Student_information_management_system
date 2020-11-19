
<template>
<div>
<h1>{{msg}}</h1>
<hr>
<div class="inputStylelogin" id="login"> 
<p><span style="color:red" v-if="ID.length==0">*</span>登录ID :
<el-input  type="text"   v-model="ID" maxlength="30" show-word-limit></el-input></p>
<p><span style="color:red" v-if="password.length==0">*</span>输入密码 :
<el-input  type="password" v-model="password" maxlength="30" minlength="8"></el-input></p>
<el-row>
  <el-col :span="4"><div><el-button class="button" @click="login" type="primary" round>登录</el-button></div></el-col>
  <el-col :span="4"><div><el-button class="button1" @click="register" type="primary" round>注册</el-button></div></el-col>
</el-row>


</div>
</div>
</template>
<script>
// 登录界面
import axios from 'axios'
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
register(){
  this.$router.push({ path: '/register'})
},
  login(){
        axios({
          method:"post",
          url:"/api/login",
          data:{
            id:this.ID,
            password:this.password
          }
        }).then(response=>{
          console.log(JSON.stringify(response.data)=="success")
          if(JSON.stringify(response.data)=="success"){
                this.$router.push({ path: '/user'})
          }else if(JSON.stringify(response.data)=="false"){
              alert("密码或id错误")
          }
          
        }).catch(err=>{
          
          console.log("...err...",err)
        });
        // this.$router.push({ path: '/user'})
}
}
}
</script>

<style scoped>
.button{
  width: 140px;
  margin-left:70% ;
}
.button1{
  width: 140px;
  margin-left:170px ;
}
.inputStylelogin {
    width: 450px;
    height: 200px;
    margin-top: 9%;
    margin-left:30%;
  }
  

</style>