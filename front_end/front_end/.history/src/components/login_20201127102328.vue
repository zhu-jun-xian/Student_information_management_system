<template>
  <div>
    <div class="box">
      <h2 class="titlestu">学生信息管理系统</h2>
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
          <el-link class="ellinkclass" type="danger" @click="forgetpass">忘记密码</el-link>
          <el-button class="button buttonclass" @click="register" type="primary" round icon="el-icon-right">Register</el-button>
        </div>
      </form>
    </div>

<!-- 修改登录密码功能 -->
    <el-dialog title="修改登录密码" :visible.sync="passwordVisible" width="35%">
      <span>
        <el-form ref="passwordform" :model="passwordform" label-width="100px">
          <el-form-item label="登陆ID" prop="id">
            <el-input v-model="passwordform.id" plain :disabled="iddisabled"></el-input>
          </el-form-item>
          <el-form-item label="姓名" prop="name">
            <el-input v-model="passwordform.name" :disabled="namedisabled"></el-input>
          </el-form-item>

          <el-form-item label="手机" prop="tel">
            <el-input type="number" v-model="passwordform.tel" :disabled="teldisabled"></el-input>
          </el-form-item>
          <el-form-item label="修改密码" prop="repass1" v-if="passif">
            <el-input v-model="passwordform.repass1" placeholder="大小写字母特殊字符"></el-input>
          </el-form-item>
          <el-form-item label="确认密码" prop="repass" v-if="repassif">
            <el-input v-model="passwordform.repass" placeholder="大小写字母特殊字符"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="success" v-if="checkpassonSubmitif" @click="checkpassonSubmit">检查</el-button>
            <el-button type="success" v-if="updatepassonSubmitif" @click="updatepassonSubmit1">修改</el-button>
            <el-button @click="resetForm('passwordform')">清空</el-button>
          </el-form-item>
        </el-form>
      </span>
    </el-dialog>
    <vue-particles color="#dedede" :particleOpacity="0.7" :particlesNumber="80" shapeType="star" :particleSize="4" linesColor="#FFFFFF" :linesWidth="2" :lineLinked="true" :lineOpacity="0.4" :linesDistance="150" :moveSpeed="4" :hoverEffect="true" hoverMode="grab" :clickEffect="true" clickMode="push"> </vue-particles>
  </div>
</template>
<script>
// 登录界面
import axios from "axios";
export default {
  data() {
    return {
      passwordform: {
        id: "",
        name: "",
        tel: "",
        repass1: "",
        repass: "",
      },
      checkpassonSubmitif: "true",
      updatepassonSubmitif: "false",
      passif: "false",
      repassif: "false",
      namedisabled: "false",
      iddisabled: "false",
      teldisabled: "false",

      passwordVisible: false,
      msg: "登录",
      ID: "",
      username: "",
      tel: "",
      password: "",
      password1: "",
    };
  },
  methods: {
    checkpassonSubmit() {
      axios({
        method: "post",
        url: "/api/getUserById1",
        data: {
          id: this.passwordform.id,
        },
      })
        .then((response) => {
          let body = response.data;
          console.log(body);
          this.username = body.name;
          if (this.passwordform.name === body.name && this.passwordform.tel === body.tel) {
            this.namedisabled = true;
            this.iddisabled = true;
            this.teldisabled = true;
            this.passif = true;
            this.repassif = true;
            this.checkpassonSubmitif = false;
            this.updatepassonSubmitif = true;
          } else {
            this.$message.error("错了哦，无法进行修改页面");
          }
        })
        .catch((err) => {
          console.log("...err...", err);
        });
    },

    //
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    forgetpass() {
      this.$confirm("此操作请先确认信息是否一致, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          this.checkpassonSubmitif = true;
          this.updatepassonSubmitif = false;
          this.passwordVisible = true;
          this.namedisabled = false;
          this.iddisabled = false;
          this.teldisabled = false;
          this.passif = false;
          this.repassif = false;
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });
    },
    // 将表单数据添加到表格中去
    updatepassonSubmit1() {
      console.log(this.passwordform.repass1);
      var reg = new RegExp("(?=.*[A-Z])(?=.*[a-z])(?=.*[^a-zA-Z0-9]).{8,30}");
      if (!reg.test(this.passwordform.repass1) || !reg.test(this.passwordform.repass)) {
        this.$message({
          message: "错误:密码应由大小写字母+特殊字符组合,长度控制在8-30",
          center: true,
          offset: 50,
          type: "warning",
        });
      } else if (this.passwordform.repass === 0 || this.passwordform.repass1 === 0) {
        this.$message({
          message: "错误:存在空输入框，修改失败",
          center: true,
          offset: 50,
          type: "warning",
        });
      } else if (this.passwordform.repass1.length === this.passwordform.repass.length) {
        axios({
          method: "post",
          url: "/api/updateUserPassword",
          data: {
            id: this.passwordform.id,
            password: this.passwordform.repass1,
          },
        })
          .then((response) => {
            this.$message({
              message: "恭喜你，密码修改成功，请重新登录",
              type: "success",
              center: true,
              offset: 50,
            });
            this.passwordVisible = false;
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
    register() {
      this.$router.push({ path: "/register" });
    },
    login() {
      var reg = new RegExp("(?=.*[A-Z])(?=.*[a-z])(?=.*[^a-zA-Z0-9]).{8,30}");
      if (this.ID.length === 0 || this.password.length == 0) {
        this.$message({
          message: "错误:密码和用户ID不能为空",
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
.ellinkclass {
  margin-left: 30px;
}
.titlestu{
  font-size: 40px;
  font-family: monospace;
}
</style>
