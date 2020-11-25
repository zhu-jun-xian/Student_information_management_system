<template>
  <div class="hello">
    <div>
      <!-- <el-button round @click="sumstudent">合计</el-button> -->
      <el-button round @click="selectAll">全部信息</el-button>
      <el-button round @click.native="selectnumVisible = true">学生查询</el-button>
      <el-button round @click.native="selectclassVisible = true">班级查询</el-button>
      <el-button round @click.native="selectgendVisible = true">院系查询</el-button>
      <el-button round @click.native="selectfuzzyVisible = true">模糊查询</el-button>
      <el-input v-model="search1" placeholder="请输入" style="width: 30%; padding-left: 300px" @keydown.enter.native="validateCounts"> </el-input>
      <el-divider></el-divider>
    </div>
    <el-container>
      <div>
        <el-table border class="el-table-column" :data="stuData.slice((currentPage - 1) * pageSize, currentPage * pageSize)" :default-sort="{ prop: 'date', order: 'descending' }" style="width: 100%" @row-click="rowclick">
          <!-- <el-table-column align="center" header-align="center" prop="stuNum" label="序号" width="80%" sortable>
          </el-table-column> -->
          <el-table-column align="center" header-align="center" prop="stuID" label="学号" width="170%" sortable> </el-table-column>
          <el-table-column align="center" header-align="center" prop="stuName" label="学生姓名" width="160%"> </el-table-column>
          <el-table-column align="center" header-align="center" prop="stuBirth" label="出生年月日" width="160%"> </el-table-column>
          <el-table-column align="center" header-align="center" prop="stuSex" label="性别" width="110%"></el-table-column>
          <el-table-column align="center" header-align="center" prop="stuTel" label="手机号码" width="160%"> </el-table-column>
          <el-table-column align="center" header-align="center" prop="stuClass" label="班级" width="160%" sortable> </el-table-column>
          <el-table-column align="center" header-align="center" prop="stuDep" label="系部" width="160%" sortable> </el-table-column>
          <el-table-column align="center" header-align="center" label="操作" width="180%">
            <el-button size="mini" type="primary" icon="el-icon-edit" circle @click.native="UpdateVisible = true"></el-button>

            <el-button size="mini" type="danger" icon="el-icon-delete" circle @click.native.prevent="deleteRow()"></el-button>
          </el-table-column>
        </el-table>
        <div class="block" style="margin-top: 15px">
          <el-pagination align="center" @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage" :page-sizes="[5, 10, 20, 50]" :page-size="pageSize" layout="total, sizes, prev, pager, next, jumper" :total="stuData.length"> </el-pagination>
        </div>
      </div>
    </el-container>

    <el-dialog title="修改学生信息" :visible.sync="UpdateVisible" width="35%">
      <el-form ref="Updateform" :model="Updateform" label-width="100px">
        <el-form-item label="学号">             
          <el-input v-model="rowID" plain disabled></el-input>          
         </el-form-item>
        <el-form-item label="学生姓名" prop="name">
          <el-input v-model="Updateform.name"></el-input>
        </el-form-item>

        <el-form-item label="出生年月" prop="time">            
           <el-input v-model="Updateform.time" placeholder="20200501"></el-input> 
        </el-form-item>
          <el-form-item label="性别" prop="sex">
              <el-select v-model="Updateform.sex" placeholder="请选择" style="width: 100%">              
            <el-option label="男" value="男"></el-option>              
            <el-option label="女" value="女"></el-option>            
          </el-select>           
        </el-form-item>
        <el-form-item label="手机号码" prop="tel">
          <el-input v-model="Updateform.tel"></el-input>
        </el-form-item>
        <el-form-item label="班级" prop="classnumber">
          <el-input v-model="Updateform.classnumber"></el-input>
        </el-form-item>
        <el-form-item label="系部" prop="department">
          <el-select v-model="Updateform.department" placeholder="请选择" style="width: 100%">
                <el-option label="智能制造学部" value="智能制造学部"></el-option>           
            <el-option label="土木工程学院" value="土木工程学院"></el-option>            
             <el-option label="经济管理学院" value="经济管理学院"></el-option>             
            <el-option label="外国语学院" value="外国语学院"></el-option>
                <el-option label="艺术设计学院" value="艺术设计学院"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="updateusermessage">确认</el-button>
          <el-button @click="resetForm('Updateform')">清空</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

    <el-dialog title="选择院系" :visible.sync="selectgendVisible" width="20%">
      <el-form :inline="true" :model="selectgendForm" class="selectgendForm_demo">
        <el-form-item label="系部：" prop="selectgendacademy">
          <el-select v-model="selectgendForm.selectgendacademy" placeholder="请选择">
            <el-option label="智能制造学部" value="智能制造学部"></el-option>
            <el-option label="土木工程学院" value="土木工程学院"></el-option>
            <el-option label="经济管理学院" value="经济管理学院"></el-option>
            <el-option label="外国语学院" value="外国语学院"></el-option>
            <el-option label="艺术设计学院" value="艺术设计学院"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="selectgendSubmit">查询</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

    <el-dialog title="输入班级" :visible.sync="selectclassVisible" width="30%">
      <el-form :inline="true" :model="selectclassForm" class="selectclassForm_demo">
        <el-form-item label="班级">
          <el-input v-model="selectclassForm.selectclass"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="selectclassSubmit">查询</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

    <el-dialog title="输入学号" :visible.sync="selectnumVisible" width="30%">
      <el-form :inline="true" :model="selectnumForm" class="selectnumForm_demo">
        <el-form-item label="学号">
          <el-input v-model="selectnumForm.selectnum"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="selectnumSubmit">查询</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

    <el-dialog title="模糊查询" :visible.sync="selectfuzzyVisible" width="40%">
      <el-form ref="selectfuzzyForm" :inline="true" :model="selectfuzzyForm" class="selectfuzzyForm_demo">
        <el-form-item label="姓名" prop="fuzzyname">
          <el-input v-model="selectfuzzyForm.fuzzyname"></el-input>
        </el-form-item>
        <el-form-item label="学号" prop="fuzzynum">
          <el-input v-model="selectfuzzyForm.fuzzynum"></el-input>
        </el-form-item>
        <el-form-item label="班级" prop="fuzzynclass">
          <el-input v-model="selectfuzzyForm.fuzzyclass"></el-input>
        </el-form-item>
          <el-form-item label="性别" prop="fuzzysex">
            <el-select v-model="selectfuzzyForm.fuzzysex" placeholder="请选择" style="width: 100%">     
            <el-option label="男" value="男"></el-option>     
            <el-option label="女" value="女"></el-option> </el-select>
        </el-form-item>
        <el-form-item label="系部：" prop="fuzzyacademy">
          <el-select v-model="selectfuzzyForm.fuzzyacademy" placeholder="请选择">
            <el-option label="智能制造学部" value="智能制造学部"></el-option>
            <el-option label="土木工程学院" value="土木工程学院"></el-option>
            <el-option label="经济管理学院" value="经济管理学院"></el-option>
            <el-option label="外国语学院" value="外国语学院"></el-option>
            <el-option label="艺术设计学院" value="艺术设计学院"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="selectfuzzySubmit">查询</el-button>
          <el-button @click="resetForm('selectfuzzyForm')">清空</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
// import selectstudent from '@/components/User/selectstudent'
export default {
  data() {
    return {
      rowID: "",
      search: "",
      search1: "",
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
      tabPosition: "left",
      // dialogVisible: false,
      UpdateVisible: false, //控制对话框的显示和隐藏
      selectgendVisible: false,
      selectclassVisible: false,
      selectnumVisible: false,
      selectfuzzyVisible: false,
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
      selectgendForm: {
        selectgendacademy: "",
      },
      selectclassForm: {
        selectclass: "",
      },
      selectnumForm: {
        selectnum: "",
      },
      selectfuzzyForm: {
        fuzzynum: "",
        fuzzyname: "",
        fuzzyclass: "",
        fuzzysex: "",
        fuzzyacademy: "",
      },
    };
  },

  methods: {
    sumstudent() {
      this.$router.push({
        path: "/Sumstudent",
      });
    },
    //基于表单的模糊搜索
    selectfuzzySubmit(){
      console.log("查询中...");
      axios({
        method:"post",
        url:"/api/",
        data:{
          stuName:this.selectfuzzyForm.fuzzyname,
          stuNum:this.selectfuzzyForm.fuzzynum,
          stuClass:this.selectfuzzyForm.fuzzyclass,
          stuSex:this.selectfuzzyForm.fuzzysex,
          stuDep:this.selectfuzzyForm.fuzzyacademy
        fuzzysex: "",
        fuzzyacademy: "",
        }
      })
    },

    //模糊搜索，基于搜索框
    validateCounts() {
      console.log("搜索内容...", this.search1);
      axios({
        method: "post",
        url: "/api/SelectByStuAll",
        data: {
          stuID: this.search1,
          stuName: this.search1,
          stuSex: this.search1,
          stuTel: this.search1,
          stuBirth: this.search1,
          stuClass: this.search1,
          stuDep: this.search1,
        },
      }).then((response) => {
        console.log(response.data);
        this.currentPage = 1;
        let body = response.data;
        this.stuData = [];
        this.stuData = body;
        console.log(JSON.stringify(body));
      });
    },

    updateusermessage() {
      let stuid = this.rowID;
      console.log("updateusermessage:" + stuid);
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
              alert("修改成功");
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
    deleteRow() {
      let stuid = this.rowID;
      console.log("deleteRow:" + stuid);
      axios({
        method: "post",
        url: "/api/deleteMessagesById",
        data: {
          stuID: stuid,
        },
      })
        .then((response) => {
          if (response.data == "ok") {
            this.$message({
              type: "success",
              message: "删除成功!",
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
    },

    //获取一行的学号
    rowclick(row) {
      this.rowID = row.stuID;
      console.log("rowclick:" + row.stuID);
      return row.stuID;
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
      console.log(`每页 ${val} 条`);
      this.currentPage = 1;
      this.pageSize = val;
    },
    handleCurrentChange: function (val) {
      this.currentPage = val;
    },

    selectAll() {
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

    selectgendSubmit() {
      console.log("院系...", this.selectgendForm.selectgendacademy);
      axios({
        method: "post",
        url: "/api/SelectByStuDep",
        data: {
          stuDep: this.selectgendForm.selectgendacademy,
        },
      }).then((response) => {
        this.selectgendVisible = false;
        let body = response.data;
        this.stuData = [];
        this.stuData = body;
      });
    },

    selectclassSubmit() {
      console.log("班级...", this.selectclassForm.selectclass);
      axios({
        method: "post",
        url: "/api/SelectByStuClass",
        data: {
          stuClass: this.selectclassForm.selectclass,
        },
      }).then((response) => {
        this.selectclassVisible = false;
        let body = response.data;
        this.stuData = [];
        this.stuData = body;
      });
    },

    //按照学号查询
    selectnumSubmit() {
      //
      console.log("学号...", this.selectnumForm.selectnum);
      axios({
        method: "post",
        url: "/api/getMessagesById",
        data: {
          stuID: this.selectnumForm.selectnum,
        },
      }).then((response) => {
        this.selectnumVisible = false;
        let body = response.data;
        this.stuData = [body];
      });
    },
  },
  //获取表格数据
  created() {
    var name = this.$route.query.username;
    console.log(name);
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
.el-select .el-input {
  width: 100px;
}
.input-with-select .el-input-group__prepend {
  background-color: #fff;
}
</style>
