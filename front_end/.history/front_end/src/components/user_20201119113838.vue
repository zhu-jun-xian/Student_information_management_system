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
          <el-menu-item index="2-2">新增用户信息</el-menu-item>
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

    <el-dialog :visible.sync="dialogFormVisible">
  <div>
    <h1 style="margin-left:40%">{{ msg }}</h1>
    <el-row><span>基本信息</span></el-row>
    <hr />
    <el-row>
      <el-col :span="1"><div class="grid-content"></div></el-col>
      <el-col :span="5"
        ><span>学生姓名</span>
        <div class="grid-content bg-purple">
          <el-input
            v-model="studentname"
            placeholder="张三"
            maxlength="30"
          ></el-input></div
      ></el-col>
      <el-col :span="3"><div class="grid-content"></div></el-col>
      <el-col :span="5"
        ><span>学号</span>
        <div class="grid-content ">
          <el-input
            v-model="studentnumber"
            placeholder="311700xxxx"
            maxlength="30"
            style="width:100%"
          ></el-input></div
      ></el-col>
      <el-col :span="3"><div class="grid-content"></div></el-col>
      <el-col :span="4"
        ><span>出生年月日</span>
        <div class="grid-content">
          <el-date-picker
            v-model="value1"
            type="date"
            placeholder="选择日期"
            style="width:100%"
          >
          </el-date-picker></div
      ></el-col>
    </el-row>

    <el-row><span></span></el-row>

    <el-row>
      <el-col :span="1"><div class="grid-content"></div></el-col>
      <el-col :span="5"
        ><span>性别</span>
        <div class="grid-content bg-purple">
          <el-select
            style="width:100%"
            clearable
            v-model="gender"
            placeholder="请选择"
          >
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            ></el-option
          ></el-select></div
      ></el-col>
      <el-col :span="3"><div class="grid-content"></div></el-col>
      <el-col :span="5"
        ><span>手机号码</span>
        <div class="grid-content ">
          <el-input v-model="tel" placeholder="137xxxx2222"></el-input></div
      ></el-col>
      <el-col :span="3"><div class="grid-content"></div></el-col>
      <el-col :span="4"
        ><span>班级</span>
        <div class="grid-content ">
          <el-input
            v-model="classnumber"
            placeholder="17xxxx"
            style="width:100%"
            maxlength="30"
          ></el-input></div
      ></el-col>
    </el-row>

    <el-row><span></span></el-row>

    <el-row>
     <el-col :span="1"><div class="grid-content"></div></el-col>
      <el-col :span="5"><span>信息录入时间</span>
      <div class="grid-content ">
      <el-input disabled="false"
            v-model="time"
            placeholder="系统自动生成"
            style="width:100%"
          ></el-input></div
      ></el-col>
      
      <el-col :span="3"><div class="grid-content"></div></el-col>
      <el-col :span="5"
        ><span>系部</span>
        <div class="grid-content bg-purple">
          <el-select
            style="width:100%"
            clearable
            v-model="department"
            placeholder="请选择"
          >
            <el-option
              v-for="item in options2"
              :key="item.value2"
              :label="item.label2"
              :value="item.value2"
            ></el-option
          ></el-select></div
      ></el-col>
      

    </el-row>
    <el-row><span></span></el-row>
    <el-row><span>学生照片</span></el-row>
    <hr />
    <el-upload  action="#" list-type="picture-card" :auto-upload="false"  >
      <i  slot="default" class="el-icon-plus" ></i>
      <div v-if="ifimg">
        <div  slot="file" slot-scope="{ file }">
        <img class="el-upload-list__item-thumbnail" :src="file.url" alt="" @load="onLoad"/>
        <span   class="el-upload-list__item-actions">
           <span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file)">
           <i class="el-icon-zoom-in"></i></span>
           <span class="el-upload-list__item-delete" @click="handleRemove(file)">
            <i class="el-icon-delete"></i></span>
        </span>
      </div>
      </div>
 
    </el-upload>
    <el-dialog :visible.sync="dialogVisible">
      <img  width="100%" :src="dialogImageUrl" alt="" id="imgUpLoad" />
    </el-dialog>
    <el-button class="submit" type="submit" round >提交</el-button>
  </div>
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
         dialogFormVisible: false,
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
         statisticsForm: {
          irule: '',
          imassage: '',
          
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

