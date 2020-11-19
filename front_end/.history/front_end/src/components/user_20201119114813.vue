<template>
  <div class="hello">
    <el-container>
    <el-header style="text-align: right; font-size: 12px">
      <el-dropdown>
        <i class="el-icon-setting" style="margin-right: 15px"></i>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item>退出</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
      <span id="user_name">王小虎</span>
    </el-header>

    <el-container style="height:700px; border: 1px solid #eee">
  <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
    <el-menu :default-openeds="['1', '3']">
      <el-submenu index="1">
        <template slot="title"><i class="el-icon-message"></i>信息查询</template>
        <el-menu-item-group>
          <el-menu-item index="1-1" @click.native="statisticsVisible = true">学生信息统计</el-menu-item>
          <el-menu-item index="1-2" @click.native="dialogVisible = true">学生信息查询</el-menu-item>
        </el-menu-item-group>
      </el-submenu>

      <el-submenu index="2">
        <template slot="title"><i class="el-icon-menu"></i>信息修改</template>
        <el-menu-item-group>
          <el-menu-item index="2-1" @click.native="UpdateVisible = true">修改用户信息</el-menu-item>
          <el-menu-item index="2-2" @click.native="addVisible = true">新增用户信息</el-menu-item>
          <el-menu-item index="2-3">删除学生信息</el-menu-item>
        </el-menu-item-group>
      </el-submenu>

      <el-submenu index="3">
        <template slot="title"><i class="el-icon-setting"></i>设置</template>
        <el-menu-item-group>
          <el-menu-item index="3-1">修改密码</el-menu-item>
          <el-menu-item index="3-2">退出登陆</el-menu-item>
        </el-menu-item-group>  
      </el-submenu>
    </el-menu>
  </el-aside>
  
</el-container>
   </el-container>

<el-dialog title="修改用户信息" :visible.sync="UpdateVisible" width="35%">
      <span>
        <el-form ref="Updateform" :model="Updateform" label-width="100px">
          <el-form-item label="登陆ID" prop="id">
            <el-input v-model="Updateform.id" plain disabled></el-input>
          </el-form-item>
          <el-form-item label="姓名" prop="name">
            <el-input v-model="Updateform.name"></el-input>
          </el-form-item>
          
          <el-form-item label="手机" prop="tel" >
            <el-input v-model="Updateform.tel"></el-input>
          </el-form-item>
          <el-form-item label="修改密码" prop="pass">
            <el-input v-model="Updateform.pass"></el-input>
          </el-form-item>
         <el-form-item label="确认密码" prop="repass">
            <el-input v-model="Updateform.repass"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="onSubmit">确认</el-button>
            <el-button @click="resetForm('Updateform')">清空</el-button>
          </el-form-item>
        </el-form>
      </span> 
    </el-dialog> 

    <el-dialog title="学生信息查询" :visible.sync="dialogVisible" width="35%">
      <span>
        <el-form :model="selectForm" :rules="dialogrules" ref="selectForm" label-width="100px" class="selectForm">
          <el-form-item label="学生姓名" prop="stuname">
          <el-input v-model="selectForm.stuname"></el-input>
       </el-form-item>
        <el-form-item label="学号" prop="stunum">
          <el-input v-model="selectForm.stunum"></el-input>
       </el-form-item>
        <el-form-item label="班级" prop="stuclass">
          <el-input v-model="selectForm.stuclass"></el-input>
       </el-form-item>
       <el-form-item label="性别" prop="sex">
          <el-select v-model="selectForm.sex" placeholder="请选择">
            <el-option label="女" value="boy"></el-option>
            <el-option label="男" value="girl"></el-option>
          </el-select>
       </el-form-item>
       <el-form-item label="系部" prop="academy">
          <el-select v-model="selectForm.academy" placeholder="请选择">
            <el-option label="智能制造学部" value="intelligent"></el-option>
            <el-option label="土木工程学院" value="building"></el-option>
            <el-option label="经济管理学院" value="economics"></el-option>
            <el-option label="外国语学院" value="foreign"></el-option>
            <el-option label="艺术设计学院" value="arting"></el-option>
          </el-select>
       </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="submitForm('selectForm')">查询</el-button>
    <el-button @click="resetForm('selectForm')">清空</el-button>
  </el-form-item>
 </el-form>
      </span> 
    </el-dialog>  

    <el-dialog title="学生信息统计" :visible.sync="statisticsVisible" width="35%">
      <span>
        <el-form :model="statisticsForm" :rules="statisticsrules" ref="statisticsForm" label-width="100px" class="statisticsForm">
          
       <el-form-item label="统计规则" prop="irule">
          <el-select v-model="statisticsForm.irule" placeholder="请选择">
            <el-option label="院系" value="iacademy"></el-option>
            <el-option label="班级" value="isex" ></el-option>
          </el-select>
       </el-form-item>
       <el-form-item  prop="imassage"  style="width: 61%;">
          <el-input v-model="statisticsForm.imassage"></el-input>
       </el-form-item>
  <el-form-item >
    <el-button type="primary" @click="submitForm('statisticsForm')">查询</el-button>
    <el-button @click="resetForm('statisticsForm')">清空</el-button>
  </el-form-item>
 </el-form>
      </span> 
    </el-dialog> 

     <el-dialog title="学生信息录入" :visible.sync="addVisible" width="35%">
      <span>
        <el-form :model="addForm" :rules="addrules" ref="addForm" label-width="100px" class="addForm">
          <el-form-item label="学生姓名" prop="stuname">
          <el-input v-model="selectForm.stuname"></el-input>
       </el-form-item>
        <el-form-item label="学号" prop="stunum">
          <el-input v-model="selectForm.stunum"></el-input>
       </el-form-item>
        <el-form-item label="班级" prop="stuclass">
          <el-input v-model="selectForm.stuclass"></el-input>
       </el-form-item>
       <el-form-item label="性别" prop="sex">
          <el-select v-model="selectForm.sex" placeholder="请选择">
            <el-option label="女" value="boy"></el-option>
            <el-option label="男" value="girl"></el-option>
          </el-select>
       </el-form-item>
       <el-form-item label="系部" prop="academy">
          <el-select v-model="selectForm.academy" placeholder="请选择">
            <el-option label="智能制造学部" value="intelligent"></el-option>
            <el-option label="土木工程学院" value="building"></el-option>
            <el-option label="经济管理学院" value="economics"></el-option>
            <el-option label="外国语学院" value="foreign"></el-option>
            <el-option label="艺术设计学院" value="arting"></el-option>
          </el-select>
       </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="submitForm('selectForm')">查询</el-button>
    <el-button @click="resetForm('selectForm')">清空</el-button>
  </el-form-item>
 </el-form>
      </span> 
    </el-dialog>
  </div> 
</template>

<script>

 export default {
   
   data() {
      return {
        tabPosition: 'left',
        dialogVisible: false, //控制对话框的显示和隐藏
        UpdateVisible: false, //控制对话框的显示和隐藏
        statisticsVisible:false,
        dialog: false,
        addVisible:false,
        Updateform: {
        id: "",
        name: "",
        tel: "",
        pass: "",
        repass: "",
      },
      selectForm: {
          stuname: '',
          stunum:'',
          stuclass:'',
          sex: '',
          academy:''
        },
        statisticsForm: {
          irule: '',
          imassage: '',
          
        },
        addForm:{
          msg: "学生信息录入",
          studentname: "",
          studentnumber: "",
          gender: "",
          tel: "",
          time:"",
          classnumber: "",
      department: "",
      dialogImageUrl: "",
        },
        dialogrules: {
          stuname: [
            { required: true, message: '请输入学生姓名', trigger: 'blur' },
            { min: 2, max: 30, message: '姓名不符合规范', trigger: 'blur' }
          ],
          stunum: [
            { required: true, message: '请输入学号', trigger: 'blur' },
            { min: 10, max: 10, message: '学号不符合规范', trigger: 'blur' }
          ],
          stuclass: [
            { required: true, message: '请输入班级', trigger: 'blur' },
            { min: 6, max: 6, message: '班级不符合规范', trigger: 'blur' }
          ],
          sex: [
            { required: true, message: '请选择', trigger: 'change' }
          ],
          academy: [
            { required: true, message: '请选择', trigger: 'change' }
          ],  
        },
        statisticsrules: {
         irule: [
            { required: true, message: '请选择', trigger: 'change' }
          ],
         imassage: [
            { required: true, message: '请输入', trigger: 'blur' },
            { min: 2, max: 12, message: '不符合规范', trigger: 'blur' }
          ],
        }
      
      
      };
    },
    methods: {
     
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      },
       // 将表单数据添加到表格中去
    onSubmit() {
      //console.log(this.table)
      this.table.push(this.form);

      this.UpdateVisible = false;
    },
    // selectuser(){
    //   this.$router.push({ path: '/user/selectuser'})
    // },
    resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    

    }
  }
 
    

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
.el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }
  
  .el-aside {
    color: #333;
  }
</style>

