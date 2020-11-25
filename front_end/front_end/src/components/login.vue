<template>
  <!--<div class="loginmain">
    <vue-particles color="#dedede" :particleOpacity="0.7" :particlesNumber="80" shapeType="star" :particleSize="4" linesColor="#FFFFFF" :linesWidth="2" :lineLinked="true" :lineOpacity="0.4" :linesDistance="150" :moveSpeed="3" :hoverEffect="true" hoverMode="grab" :clickEffect="true" clickMode="push"> </vue-particles>
    <div class="login">
      <el-row>
        <el-col :span="22">
          <div class="login-title">LOGIN</div>
        </el-col>
        <el-col :span="2"
          ><div>
            <el-button plain @click="register" style="margin-top: 40px" type="info">注册</el-button>
          </div></el-col
        >
      </el-row>
      <hr />
      <div class="inputStylelogin" id="login">
        <p>
          <span style="color: red" v-if="ID.length == 0">*</span>登录学号ID :
          <el-input type="text" v-model="ID" maxlength="30" show-word-limit></el-input>
        </p>
        <p>
          <span style="color: red" v-if="password.length == 0">*</span>输入密码 :
          <el-input type="password" v-model="password" maxlength="30" minlength="8"></el-input>
        </p>
        <div>
          <el-button class="button" @click="login" type="primary" round>登录</el-button>
        </div>
      </div>
    </div>
  </div>-->
  <div>
    <div class="box">
      <h2>Login</h2>
      <form>
        <div class="inputbox">
          <input type="number" v-model="ID" maxlength="30" show-word-limit name="" required="" />
          <label v-if="ID.length == 0">ID</label>
        </div>
        <div class="inputbox">
          <input type="password" v-model="password" maxlength="30" minlength="8" name=" " required="" />
          <label v-if="password.length == 0">Password</label>
        </div>
        <div>
          <el-button class="button" @click="login" type="primary" round icon="el-icon-check">Login</el-button>
          <el-button class="button buttonclass" @click="register" type="primary" round icon="el-icon-right">Register</el-button>
        </div>
      </form>
    </div>
    <vue-particles color="#dedede" :particleOpacity="0.7" :particlesNumber="80" shapeType="star" :particleSize="4" linesColor="#FFFFFF" :linesWidth="2" :lineLinked="true" :lineOpacity="0.4" :linesDistance="150" :moveSpeed="4" :hoverEffect="true" hoverMode="grab" :clickEffect="true" clickMode="push"> </vue-particles>
  </div>
</template>
<script>
// 登录界面
import axios from "axios";
export default {
  data() {
    return {
      msg: "登录",
      ID: "",
      username: "",
      tel: "",
      password: "",
      password1: "",
    };
  },
  methods: {
    register() {
      this.$router.push({ path: "/register" });
    },
    login() {
      if (this.ID.length === 0 || this.password.length == 0) {
        this.$message({
          message: "错误:密码和用户ID不能为空",
          center: true,
          offset: 50,
          type: "warning",
        });
      } else if (this.ID.length < 10 || this.ID.length > 30) {
        this.$message({
          message: "错误:用户ID应该要符合10位到30位",
          center: true,
          offset: 50,
          type: "warning",
        });
      } else if (this.password.length < 8 || this.password.length > 30) {
        this.$message({
          message: "错误:密码应该要符合8位到30位",
          center: true,
          offset: 50,
          type: "warning",
        });
      } else {
        axios({
          method: "post",
          url: "/api/login",
          data: {
            id: this.ID,
            password: this.password,
          },
        })
          .then((response) => {
            let body = response.data;
            switch (body) {
              case "success":
                console.log(body);
                axios({
                  method: "post",
                  url: "/api/getUserById1",
                  data: {
                    id: this.ID,
                  },
                })
                  .then((response) => {
                    let body = response.data;
                    this.$router.push({
                      path: "/inforstudent",
                      query: { username: body.name, id: this.ID },
                    });
                    this.$message({
                      message: "恭喜你，登录成功",
                      type: "success",
                      center: true,
                      offset: 50,
                    });
                  })
                  .catch((err) => {
                    console.log("...err...", err);
                  });

                break;
              case "fault":
                console.log(body);
                this.$message({
                  message: "错误:没有登录成功",
                  center: true,
                  offset: 50,
                  type: "warning",
                });
                break;
            }
          })
          .catch((err) => {
            console.log("...err...", err);
          });
      }
    },
  },
};
</script>

<style scoped>
.button {
  width: 140px;
  margin-left: 30%;
}
.loginmain {
  position: static;
}
.login {
  background-color: white;
  position: absolute;
  opacity: 90%;
  width: 1000px;
  height: 400px;
  top: 50%;
  margin-top: -10%;
  left: 23%;
}

#particles-js {
  background-color: black;
  position: fixed;
  z-index: -999;
  width: 100%;
  height: 100%;
}
.inputStylelogin {
  width: 450px;
  height: 200px;
  margin-top: 9%;
  margin-left: 25%;
}

.box {
  position: absolute;
  /*定位方式绝对定位absolute*/
  top: 50%;
  left: 50%;
  /*顶和高同时设置50%实现的是同时水平垂直居中效果*/
  transform: translate(-50%, -50%);
  /*实现块元素百分比下居中*/
  width: 450px;
  padding: 50px;
  background: rgba(0, 0, 0, 0.8);
  /*背景颜色为黑色，透明度为0.8*/
  box-sizing: border-box;
  /*box-sizing设置盒子模型的解析模式为怪异盒模型，
    将border和padding划归到width范围内*/
  box-shadow: 0px 15px 25px rgba(0, 0, 0, 0.5);
  /*边框阴影  水平阴影0 垂直阴影15px 模糊25px 颜色黑色透明度0.5*/
  border-radius: 15px;
  /*边框圆角，四个角均为15px*/
}
.box h2 {
  margin: 0 0 30px;
  padding: 0;
  color: #fff;
  text-align: center;
  /*文字居中*/
}
.box .inputbox {
  position: relative;
}
.box .inputbox input {
  width: 100%;
  padding: 10px 0;
  font-size: 16px;
  color: #fff;
  letter-spacing: 1px;
  /*字符间的间距1px*/
  margin-bottom: 30px;
  border: none;
  border-bottom: 1px solid #fff;
  outline: none;
  /*outline用于绘制元素周围的线
    outline：none在这里用途是将输入框的边框的线条使其消失*/
  background: transparent;
  /*背景颜色为透明*/
}
.box .inputbox label {
  /*<label> 标签为 input 元素定义标注（标记）*/
  position: absolute;
  top: 0px;
  left: 0px;
  padding: 10px 0;
  font-size: 16px;
  color: #fff;
  pointer-events: none;
  /*鼠标事件消失，比如说选中文字，光标定位，超链接下划线*/
  transition: 0.5s;
  /*过渡时间5s*/
}
.box .inputbox input:focus ~ label,
.box .inputbox input:valid ~ label {
  top: -30px;
  left: 0;
  color: #03a9f4;
  font-size: 14px;
}
.box input[type="submit"] {
  background: transparent;
  border: none;
  outline: none;
  font-size: 16px;
  color: #fff;
  background: #03a9f4;
  padding: 15px 20px;
  cursor: pointer;
  /*光标呈现为指示链接的指针（一只手）*/
  border-radius: 10px;
}
input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
}
input[type="number"] {
  -moz-appearance: textfield;
}
.buttonclass {
  margin-top: 50px;
}
</style>
