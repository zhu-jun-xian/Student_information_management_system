<template>
  <div class="hello">
    <el-container>
  <!-- //学生信息总表，登陆之后展示在首界面 -->
      <div>  
        <el-table border class="el-table-column" :data="stuData.slice((currentPage - 1) * pageSize, currentPage * pageSize)" style="width: 100%">
          <!-- <el-table-column align="center" header-align="center" prop="stuNum" label="序号" width="80%"></el-table-column> -->
          <el-table-column align="center" header-align="center" prop="stuID" label="学号" width="170%"></el-table-column>
          <el-table-column align="center" header-align="center" prop="stuName" label="学生姓名" width="160%"></el-table-column>
          <el-table-column align="center" header-align="center" prop="stuBirth" label="出生年月日" width="160%"></el-table-column>
          <el-table-column align="center" header-align="center" prop="stuSex" label="性别" width="110%"></el-table-column>
          <el-table-column align="center" header-align="center" prop="stuTel" label="手机号码" width="160%"></el-table-column>
          <el-table-column align="center" header-align="center" prop="stuClass" label="班级" width="160%"></el-table-column>
          <el-table-column align="center" header-align="center" prop="stuDep" label="系部" width="160%"></el-table-column>
          <el-table-column align="center" header-align="center" prop="" label="操作" width="180%">
            <template slot-scope="scope">
              <el-button size="mini" type="primary" icon="el-icon-edit" circle @click.native.prevent="handleEdit(scope.$index, stuData)"></el-button>
              <el-button size="mini" type="danger" icon="el-icon-delete" circle @click.native.prevent="deleteRow(scope.$index, stuData)"></el-button>
            </template>
          </el-table-column>
        </el-table>
        <div class="block" style="margin-top: 15px">
          <el-pagination align="center" @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage" :page-sizes="[5, 10, 20, 50]" :page-size="pageSize" layout="total, sizes, prev, pager, next, jumper" :total="stuData.length"> </el-pagination>
        </div>
      </div>
    </el-container>
<!-- 修改学生信息弹框 -->
    <el-dialog title="修改学生信息" :visible.sync="UpdateVisible" width="35%">
      <span>
        <el-form ref="Updateform" :model="Updateform" label-width="100px">
          <el-form-item label="学号" prop="studentnumber">              <el-input v-model="studentnumberplaceholder" plain disabled placeholder="studentnumberplaceholder"></el-input>            </el-form-item>
          <el-form-item label="学生姓名" prop="name">
            <el-input v-model="Updateform.name"></el-input>
          </el-form-item>

          <el-form-item type="number" label="出生年月" prop="time">         <el-date-picker type="date" v-model="Updateform.time" placeholder="选择日期" style="width: 60%" value-format="yyyyMMdd"></el-date-picker>       </el-form-item>
            <el-form-item label="性别" prop="sex">
            <el-select v-model="Updateform.sex" placeholder="请选择" style="width: 100%">              <el-option label="男" value="男"></el-option>               <el-option label="女" value="女"></el-option>            </el-select>           
          </el-form-item>
          <el-form-item label="手机号码" prop="tel">
            <el-input type="number" v-model="Updateform.tel"></el-input>
          </el-form-item>
          <el-form-item label="班级" prop="classnumber" type="number">
            <!-- <el-input v-model="Updateform.classnumber"></el-input> -->
            <el-select v-model="Updateform.classnumber" placeholder="请选择班别">
              <el-option label="IBM1班" value="IBM1班"></el-option>
              <el-option label="IBM2班" value="IBM2班"></el-option>
              <el-option label="IBM3班" value="IBM3班"></el-option>
              <el-option label="IBM4班" value="IBM4班"></el-option>
              <el-option label="IBM5班" value="IBM5班"></el-option>
              <el-option label="IBM6班" value="IBM6班"></el-option>
              <el-option label="IBM7班" value="IBM7班"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="系部" prop="department">
            <el-select v-model="Updateform.department" placeholder="请选择" style="width: 100%">
              <el-option label="智能制造学部" value="智能制造学部"></el-option>               <el-option label="土木工程学院" value="土木工程学院"></el-option>               <el-option label="经济管理学院" value="经济管理学院"></el-option>              
              <el-option label="外国语学院" value="外国语学院"></el-option>
              <el-option label="艺术设计学院" value="艺术设计学院"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="updateusermessage">确认</el-button>
            <el-button @click="resetForm('Updateform')">清空</el-button>
          </el-form-item>
        </el-form>
      </span>
    </el-dialog>
  </div>
</template>

<script>
// import selectstudent from '@/components/User/selectstudent'
export default {
  data() {
    return {
      indexcurr: "",
      rowstuid: "",
      studentnumberplaceholder: "",
      stuData: [
        {
          stuNum: "",
          stuID: "",
          stuName: "",
          stuBirth: "",
          stuSex: "",
          stuTel: "",
          stuClass: "",
          stuDep: "",
        },
      ],
      currentPage: 1,
      pageSize: 10,
      ifimg: true,
      stuData: [],
      tabPosition: "left",
      // dialogVisible: false,
      UpdateVisible: false, //控制对话框的显示和隐藏
      dialog: false,
      imageUrl: "",
      Updateform: {
        studentnumber: "",
        name: "",
        time: "",
        sex: "",
        tel: "",
        classnumber: "",
        department: "",
      },
    };
  },

  methods: {
    handleEdit(index, rows) {
      if (this.currentPage > 1) {
        this.indexcurr = (this.currentPage - 1) * this.pageSize + index;
      } else {
        this.indexcurr = index;
      }
      this.rowstuid = rows[this.indexcurr].stuID;
      axios({
        method: "post",
        url: "/api/getMessagesById",
        data: {
          stuID: this.rowstuid,
        },
      })
        .then((response) => {
          let body = response.data;
          this.studentnumberplaceholder = this.rowstuid;
          this.Updateform.studentnumber = this.rowstuid;
          (this.Updateform.name = body.stuName), (this.Updateform.time = body.stuBirth), (this.Updateform.sex = body.stuSex), (this.Updateform.tel = body.stuTel), (this.Updateform.classnumber = body.stuClass), (this.Updateform.department = body.stuDep);
        })
        .catch((err) => {
          console.log("猪...err...", err);
        });
      this.UpdateVisible = true;
    },

    updateusermessage() {
      let stuid = this.rowstuid;
      console.log("zhu" + stuid);
      if (this.Updateform.name.length == 0 || this.Updateform.time.length == 0 || this.Updateform.sex.length == 0 || this.Updateform.tel.length == 0 || this.Updateform.classnumber.length == 0 || this.Updateform.department.length == 0) {
        this.$message({
          message: "错误:存在空输入框，修改失败",
          center: true,
          offset: 50,
          type: "warning",
        });
      } else {
        axios({
          method: "post",
          url: "/api/updateMessagesById",
          data: {
            stuID: stuid,
            stuName: this.Updateform.name,
            stuBirth: this.Updateform.time,
            stuSex: this.Updateform.sex,
            stuTel: this.Updateform.tel,
            stuClass: this.Updateform.classnumber,
            stuDep: this.Updateform.department,
          },
        })
          .then((response) => {
            this.UpdateVisible = false;
            if (response.data == "ok") {
              this.$message({
                type: "success",
                message: "修改成功!",
                duration: 1000,
              });
              axios({
                method: "get",
                url: "/api/findAll",
              })
                .then((response) => {
                  let body = response.data;
                  this.stuData = body;
                })
                .catch((err) => {
                  console.log("...err...", err);
                });
            }
          })
          .catch((err) => {
            console.log("...err...", err);
          });
      }
    },
    //删除学生信息
    deleteRow(index, rows) {
      if (this.currentPage > 1) {
        this.indexcurr = (this.currentPage - 1) * this.pageSize + index;
      } else {
        this.indexcurr = index;
      }
      this.rowstuid1 = rows[this.indexcurr].stuID;
      this.$confirm("信息删除不可恢复,请确认是否删除学号为:" + rows[this.indexcurr].stuID + ",姓名为：" + rows[this.indexcurr].stuName + "的学生吗？, 是否继续?", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          axios({
            method: "post",
            url: "/api/deleteMessagesById",
            data: {
              stuID: this.rowstuid1,
            },
          })
            .then((response) => {
              if (response.data == "ok") {
                axios({
                  method: "get",
                  url: "/api/findAll",
                })
                  .then((response) => {
                    let body = response.data;
                    this.stuData = body;
                  })
                  .catch((err) => {
                    console.log("...err...", err);
                  });
                this.$message({
                  type: "success",
                  message: "删除成功!",
                  duration: 1000,
                });
                // location.reload();
              }
            })
            .catch((err) => {
              console.log("...err...", err);
            });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });
    },

    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },

    //清空表单
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },

    //分页
    handleSizeChange(val) {
      this.currentPage = 1;
      this.pageSize = val;
    },
    handleCurrentChange: function (val) {
      this.currentPage = val;
    },
  },
  //获取表格数据
  created() {
    var name = this.$route.query.username;
    this.username = name;
    axios({
      method: "get",
      url: "/api/findAll",
    })
      .then((response) => {
        let body = response.data;
        this.stuData = body;
      })
      .catch((err) => {
        console.log("...err...", err);
      });
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
.el-header {
  background-color: #b3c0d1;
  color: #333;
  line-height: 60px;
}

.el-aside {
  color: #333;
}

.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader .el-upload:hover {
  border-color: #409eff;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}
.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
}
input[type="number"] {
  -moz-appearance: textfield;
}
</style>
