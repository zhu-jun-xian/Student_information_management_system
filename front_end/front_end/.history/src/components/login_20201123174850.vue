
<template>
<div>
<el-row>
<el-col :span="22"><h1>{{msg}}</h1></el-col>
<el-col :span="2"><div><el-button plain @click="register" style="margin-top:40px" type="info">注册</el-button></div></el-col>
</el-row>
<hr>
<div class="inputStylelogin" id="login"> 
<p><span style="color:red" v-if="ID.length==0">*</span>登录学号ID :
<el-input  type="text"   v-model="ID" maxlength="30" show-word-limit></el-input></p>
<p><span style="color:red" v-if="password.length==0">*</span>输入密码 :
<el-input  type="password" v-model="password" maxlength="30" minlength="8"></el-input></p>
  <div><el-button class="button" @click="login" type="primary" round>登录</el-button></div>
  
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
           let body = response.data;
  switch (body){
    case 'success':
      console.log(body);
     this.$router.push({ path: '/infor',
                     query: 
                            {username:this.ID}
                        })
     break;
     case 'fault':
      console.log(body);
     alert("没有登录成功");
     break;
     
  }

          // console.log(JSON.stringify(response.data))
          // if(JSON.stringify(response.data)=="success"){
          //       this.$router.push({ path: '/user'})
          //        console.log()
          // }else if(JSON.stringify(response.data)=="false"){
          //     alert("密码或id错误")
          // } else if(this.ID=="admin"){
          //    this.$router.push({ path: '/user',
          //            query: 
          //                   {username:"zhu"}
          //               })
          // }
          // else{
          //       alert("密码 或 ID 错误")
          // }
          
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
  margin-left:30% ;
}

.inputStylelogin {
    width: 450px;
    height: 200px;
    margin-top: 9%;
    margin-left:30%;
  }
  

</style>