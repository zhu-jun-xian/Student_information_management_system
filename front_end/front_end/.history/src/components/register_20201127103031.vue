<template>
  <div>
    <div class="box">
      <h2>Register</h2>
      注册表单
      <form>
        <div class="inputbox">
          <input type="number" v-model="ID" maxlength="30" show-word-limit />
          <label>ID</label>
        </div>
        <div class="inputbox">
          <input type="text" v-model="username" maxlength="30" show-word-limit />
          <label>Username</label>
        </div>
        <div class="inputbox">
          <input type="number" v-model="tel" maxlength="30" show-word-limit />
          <label>Telephone</label>
        </div>
        <div class="inputbox">
          <input type="password" v-model="password" maxlength="30" />
          <label>Password</label>
        </div>
        <div class="inputbox">
          <input type="password" v-model="password1" maxlength="30" show-word-limit />
          <label>Confirm Password</label>
        </div>
        <el-button class="button" @click="registerUser" type="primary" round icon="el-icon-check">Register</el-button>
        <el-button class="button buttonclass" @click="returnTologin" type="primary" round icon="el-icon-back">Login</el-button>
      </form>
    </div>
    <vue-particles color="#dedede" :particleOpacity="0.7" :particlesNumber="80" shapeType="star" :particleSize="4" linesColor="#FFFFFF" :linesWidth="2" :lineLinked="true" :lineOpacity="0.4" :linesDistance="150" :moveSpeed="4" :hoverEffect="true" hoverMode="grab" :clickEffect="true" clickMode="push"> </vue-particles>
  </div>
</template>

<script>
// 注册界面
export default {
  data() {
    return {
      msg: "账号注册",
      ID: "",
      username: "",
      tel: "",
      password: "",
      password1: "",
    };
  },
  methods: {
    returnTologin() {
      this.$router.push({ path: "/" });
    },
    registerUser() {
      var reg = new RegExp("(?=.*[A-Z])(?=.*[a-z])(?=.*[^a-zA-Z0-9]).{8,30}");
      if ((this.ID.length === 0 || this.username.length === 0 || this.tel.length === 0 || this.password.length === 0 || this, this.password1.length == 0)) {
        this.$message({
          message: "错误:存在空输入框，注册失败",
          center: true,
          offset: 50,
          type: "warning",
        });
      } else if (this.username.length <= 0 || this.username.length > 30) {
        this.$message({
          message: "错误:用户名应该要符合1位到30位",
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
      } else if (this.tel.length < 10 || this.tel.length > 30) {
        this.$message({
          message: "错误:用户电话应该要符合11位到30位数字",
          center: true,
          offset: 50,
          type: "warning",
        });
      } else if (!reg.test(this.password)) {
        this.$message({
          message: "错误:密码应由大小写字母+特殊字符组合,长度控制在8-30",
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
      } else if (!reg.test(this.password1)) {
        this.$message({
          message: "错误:字母+数字组合,至少包含一个字母和数字,长度控制在8-30",
          center: true,
          offset: 50,
          type: "warning",
        });
      } else if (this.password1.length < 8 || this.password1.length > 30) {
        this.$message({
          message: "错误:密码应该要符合8位到30位",
          center: true,
          offset: 50,
          type: "warning",
        });
      } else if (this.password === this.password1) {
        axios({
          method: "post",
          url: "/api/register",
          data: {
            id: this.ID,
            name: this.username,
            tel: this.tel,
            password: this.password,
          },
        })
          .then((response) => {
            let body = response.data;
            switch (body) {
              case "success":
                console.log(body);
                this.$message({
                  message: "恭喜你，注册成功，进入登录界面",
                  type: "success",
                  center: true,
                  offset: 50,
                });
                this.$router.push({ path: "/", query: { username: this.ID } });
                break;
              case "fault":
                console.log(body);
                this.$message({
                  message: "错误:用户ID重复",
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
      } else {
        this.$message({
          message: "错误:两次密码不一致",
          center: true,
          offset: 50,
          type: "warning",
        });
      }
    },
  },
  mounted() {
    // document.querySelector('body').setAttribute('style','background-color:rgb(102, 255, 102)')
  }, //设置页面背景色
};
</script>

<style scoped>
.button {
  width: 140px;
  margin-left: 30%;
}
.inputStyle {
  width: 450px;
  height: 200px;
  margin-top: 9%;
  margin-left: 35%;
}
#particles-js {
  background-color: black;
  position: fixed;
  z-index: -999;
  width: 100%;
  height: 100%;
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
  /* outline用于绘制元素周围的线
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
}
.box .inputbox input:focus ~ label,
.box .inputbox input:valid ~ label {
  position: absolute;
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
  /*cursor: pointer;
  光标呈现为指示链接的指针（一只手）
  border-radius: 10px;*/
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
