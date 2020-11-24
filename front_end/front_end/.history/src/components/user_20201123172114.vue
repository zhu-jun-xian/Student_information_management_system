<template>
  <div class="hello">
    <el-container>
    <el-header style="text-align: right; font-size: 12px">

      <span id="user_name" v-bind="username" style="font-size:20px">{{username}}</span>
      <!-- <el-button @click="selectuser1">查询</el-button> -->
       <el-button @click="exit">退出</el-button>
       
 </el-header>
      
    <el-container style="height:700px; border: 1px solid #eee">
  <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
    <el-menu :default-openeds="['1', '2','3']">
      <el-submenu index="1">
        <template slot="title"><i class="el-icon-message"></i>信息查询</template>
        <el-menu-item-group>
        <el-menu-item index="1-0" @click="selectrouteruser">学生信息</el-menu-item>
          <el-menu-item index="1-1" @click.native="statisticsVisible = true">学生信息统计</el-menu-item>
          <!-- <el-menu-item index="1-2" @click.native="dialogVisible = true">学生信息查询</el-menu-item> -->
          <el-menu-item index="1-2" @click="selectuser1">学生信息查询</el-menu-item>
        </el-menu-item-group>
      </el-submenu>

      <el-submenu index="2">
        <template slot="title"><i class="el-icon-menu"></i>信息修改</template>
        <el-menu-item-group>
          <!-- <el-menu-item index="2-1" @click.native="UpdateVisible = true">修改学生信息</el-menu-item> -->
          <el-menu-item index="2-2" @click.native="addVisible = true">新增学生信息</el-menu-item>
          <!-- <el-menu-item index="2-3">删除学生信息</el-menu-item> -->
        </el-menu-item-group>
      </el-submenu>

      <el-submenu index="3">
        <template slot="title"><i class="el-icon-setting"></i>设置</template>
        <el-menu-item-group>
          <el-menu-item index="3-1" @click.native="passwordVisible = true">修改密码</el-menu-item>
          <el-menu-item index="3-2" @click="exit">退出登陆</el-menu-item>
        </el-menu-item-group>  
      </el-submenu>
    </el-menu>
  </el-aside>

   <el-main>

    <router-view> </router-view>
   <!-- <div>
    <el-table border class="el-table-column" :data="stuData.slice((currentPage-1)*pageSize,currentPage*pageSize)" style="width: 100%" @row-click="rowclick">
      <el-table-column align="center" header-align="center" prop="stuNum" label="序号" width="80%"></el-table-column>
      <el-table-column align="center" header-align="center" prop="stuID" label="学号"  width="170%"></el-table-column>
      <el-table-column align="center" header-align="center" prop="stuName" label="学生姓名"  width="160%"></el-table-column>
      <el-table-column align="center" header-align="center" prop="stuBirth" label="出生年月日"  width="160%"></el-table-column>
      <el-table-column align="center" header-align="center" prop="stuSex" label="性别"  width="110%"></el-table-column>
      <el-table-column align="center" header-align="center" prop="stuTel" label="手机号码"  width="160%"></el-table-column>
      <el-table-column align="center" header-align="center" prop="stuClass" label="班级"  width="160%"></el-table-column>
      <el-table-column align="center" header-align="center" prop="stuDep" label="系部"  width="160%"></el-table-column>
      <el-table-column align="center" header-align="center" prop="" label="操作"  width="180%">
      <el-button
          size="mini"
          @click.native="UpdateVisible = true">Edit</el-button>
          
        <el-button
          size="mini"
          type="danger"
          @click.native.prevent="deleteRow()">Delete</el-button></el-table-column>
    </el-table> 
    <div class="block" style="margin-top:15px;">
            <el-pagination align='center' 
            @size-change="handleSizeChange" 
            @current-change="handleCurrentChange" 
            :current-page="currentPage" 
            :page-sizes="[5,10,20,50]" 
            :page-size="pageSize" 
            layout="total, sizes, prev, pager, next, jumper" 
            :total="stuData.length">
            </el-pagination>
        </div>
    </div> -->
    </el-main>
  
</el-container>
   </el-container>

<el-dialog title="修改登录密码" :visible.sync="passwordVisible" width="35%" @open="updatepasswordopen">
      <span>
        <el-form ref="passwordform" :model="passwordform" label-width="100px">
          <el-form-item label="登陆ID" prop="id">
            <el-input v-model="passwordform.id" plain disabled></el-input>
          </el-form-item>
          <el-form-item label="姓名" prop="name">
            <el-input v-model="passwordform.name" disabled></el-input>
          </el-form-item>
          
          <el-form-item label="手机" prop="tel" >
            <el-input v-model="passwordform.tel" disabled></el-input>
          </el-form-item>
          <el-form-item label="修改密码" prop="pass">
            <el-input v-model="passwordform.pass"></el-input>
          </el-form-item>
         <el-form-item label="确认密码" prop="repass">
            <el-input v-model="passwordform.repass"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="updatepassonSubmit">确认</el-button>
            <el-button @click="resetForm('passwordform')">清空</el-button>
          </el-form-item>
        </el-form>
      </span> 
    </el-dialog> 

<el-dialog title="修改学生信息" :visible.sync="UpdateVisible" width="35%">
      <span>
        <el-form ref="Updateform" :model="Updateform" label-width="100px">
          <el-form-item label="学号" prop="studentnumber">
            <el-input v-model="rowID" plain disabled></el-input>
          </el-form-item>
          <el-form-item label="学生姓名" prop="name">
            <el-input v-model="Updateform.name"></el-input>
          </el-form-item>
          
          <el-form-item label="出生年月" prop="time" >
                       <el-input v-model="Updateform.time" placeholder="20200501"></el-input>
          </el-form-item>
           <el-form-item label="性别" prop="sex">
          <el-select v-model="Updateform.sex" placeholder="请选择" style="width:100%" >
            <el-option label="男" value="男"></el-option>
            <el-option label="女" value="女"></el-option>
          </el-select>
          </el-form-item>
         <el-form-item label="手机号码" prop="tel">
            <el-input v-model="Updateform.tel"></el-input>
          </el-form-item>
           <el-form-item label="班级" prop="classnumber">
            <el-input v-model="Updateform.classnumber"></el-input>
          </el-form-item>
          <el-form-item label="系部" prop="department">
       <el-select v-model="Updateform.department" placeholder="请选择" style="width:100%" >
            <el-option label="智能制造学部" value="智能制造学部"></el-option>
            <el-option label="土木工程学院" value="土木工程学院"></el-option>
            <el-option label="经济管理学院" value="经济管理学院"></el-option>
            <el-option label="外国语学院" value="外国语学院"></el-option>
            <el-option label="艺术设计学院" value="艺术设计学院"></el-option>
       </el-select>
       </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="updateusermessage">确认</el-button>
            <el-button @click="resetForm('Updateform')">清空</el-button>
          </el-form-item>
        </el-form>
      </span> 
    </el-dialog> 
    <!-- <el-dialog title="学生信息查询" :visible.sync="dialogVisible" width="35%">
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
    <el-button type="primary" @click="selectuser1">查询</el-button>
    <el-button @click="resetForm('selectForm')">清空</el-button>
  </el-form-item>
 </el-form>
      </span> 
    </el-dialog>   -->

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
    <el-button type="primary" @click="submitForm('statisticsForm')">信息统计</el-button>
    <el-button @click="resetForm('statisticsForm')">清空</el-button>
  </el-form-item>
 </el-form>
      </span> 
    </el-dialog> 


     <el-dialog title="学生信息录入" :visible.sync="addVisible" width="50%">
      <span>
        <el-form :model="addForm"  ref="addForm" label-width="100px" class="addForm">
          <el-form-item label="学生姓名" prop="addstudentname">
          <el-input v-model="addForm.addstudentname" style="width: 60%;"></el-input>
       </el-form-item>
        <el-form-item label="学号" prop="addstudentnumber">
          <el-input v-model="addForm.addstudentnumber" style="width: 60%;"></el-input>
       </el-form-item>
        <el-form-item label="班级" prop="addclassnumber">
          <el-input v-model="addForm.addclassnumber" style="width:60%;"></el-input>
       </el-form-item>
       <el-form-item label="出生日期" prop="addtime">
         <el-col :span="11">
            <el-date-picker type="date" placeholder="选择日期" v-model="addForm.addtime" style="width: 100%;"></el-date-picker>
         </el-col>
       </el-form-item>
       <el-form-item label="性别" prop="addsex">
          <el-select v-model="addForm.addsex" placeholder="请选择">
            <el-option label="女" value="boy"></el-option>
            <el-option label="男" value="girl"></el-option>
          </el-select>
       </el-form-item>
        <el-form-item label="电话" prop="addtel">
          <el-input v-model="addForm.addtel" style="width: 60%;"></el-input>
       </el-form-item>
       <el-form-item label="系统录入时间" >
          <el-input disabled="false" v-model="addsystemtime" placeholder="系统自动生成" style="width:50%"></el-input>
       </el-form-item>
       <el-form-item label="系部" prop="adddepartment">
          <el-select v-model="addForm.adddepartment" placeholder="请选择">
            <el-option label="智能制造学部" value="intelligent"></el-option>
            <el-option label="土木工程学院" value="building"></el-option>
            <el-option label="经济管理学院" value="economics"></el-option>
            <el-option label="外国语学院" value="foreign"></el-option>
            <el-option label="艺术设计学院" value="arting"></el-option>
          </el-select>
       </el-form-item>
        <el-form-item label="添加照片" prop="adddialogImageUrl">
      <el-upload  action="#" v-model="adddialogImageUrl" list-type="picture-card" :auto-upload="false"  :limit=1 >
           <i  slot="default" class="el-icon-plus" ></i>
           <div v-if="ifimg">
          <div  slot="file" slot-scope="{ file }">
          <img class="el-upload-list__item-thumbnail" :src="file.url" alt="" @load="onLoad"/>
          <span   class="el-upload-list__item-actions">
           <!-- <span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file)">
           <i class="el-icon-zoom-in"></i></span> -->
           <span class="el-upload-list__item-delete" @click="handleRemove(file)">
            <i class="el-icon-delete"></i></span>
        </span>
      </div>
      </div>
 
    </el-upload>

       </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="addstusubmitForm">信息录入</el-button>
    <el-button @click="resetForm('addForm')">清空</el-button>
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
        rowID:'',
         stuData: [{
            stuNum: '',
            stuID: '',
            stuName: '',
            stuBirth:'',
            stuSex:'',
            stuTel:'',
            stuClass:'',
            stuDep:'',
          }],
          currentPage:1,
        pageSize:10,
        ifimg:true,
        stuData:[],
        tabPosition: 'left',
        // dialogVisible: false,
        passwordVisible: false,  //控制对话框的显示和隐藏
        UpdateVisible: false, //控制对话框的显示和隐藏
        statisticsVisible:false,
        dialog: false,
        addVisible:false,
         imageUrl: '',
        passwordform: {
        id: "",
        name: "",
        tel: "",
        pass: "",
        repass: "",
      },
      Updateform: {
        studentnumber: "",
        name: "",
        time: "",
        sex: "",
        tel: "",
        classnumber: "",
        department: "",
      },
      // selectForm: {
      //     stuname: '',
      //     stunum:'',
      //     stuclass:'',
      //     sex: '',
      //     academy:''
      //   },
        statisticsForm: {
          irule: '',
          imassage: '',
          
        },
        addForm:{
          msg: "学生信息录入",
          addstudentname: "",
          addstudentnumber: "",
          addtime:"",
          addsex: "",
          addtel: "",
          addclassnumber: "",
          addsystemtime:"",
          adddepartment: "",
          adddialogImageUrl: "",
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
      updateusermessage(){
         let stuid=this.rowID
         console.log("updateusermessage:"+stuid)
axios({
          method:"post",
          url:"/api/updateMessagesById",
          data:{
            stuID:stuid,
            stuName:this.Updateform.name,
            stuBirth:this.Updateform.time,
            stuSex:this.Updateform.sex,
            stuTel:this.Updateform.tel,
            stuClass:this.Updateform.classnumber,
            stuDep:this.Updateform.department,
          }
        }).then(response=>{
          console.log(response.data)
          this.UpdateVisible=false
          if(response.data=="ok"){
alert("修改成功")
 axios({
          method:"get",
          url:"/api/findAll",
        }).then(response=>{
          let body = response.data;
          
          console.log(typeof (body));
         this.stuData=body
          console.log(JSON.stringify(body))
        }).catch(err=>{
          console.log("...err...",err)
        });
          }
          
        }).catch(err=>{
          console.log("...err...",err)
        });
      },
      addstusubmitForm(){
         axios({
          method:"post",
          url:"/api/addMessages",
          
          data:{
            stuID:this.addForm.addstudentnumber,
            stuName:this.addForm.addstudentname,
            stuBirth:this.addForm.addtime,
            stuSex:this.addForm.addsex,
            stuTel:this.addtel,
            stuClass:this.addclassnumber,
            stuDep:this.adddepartment,
            stuAddTimed:addsystemtime,
            stuImgUrl:this.addForm.adddialogImageUrl
          }
        }).then(response=>{
 console.log("addstusubmitForm")
        }).catch(err=>{
          console.log("...err...",err)
        });
      },
      deleteRow(){
 let stuid=this.rowID
         console.log("deleteRow:"+stuid)
axios({
          method:"post",
          url:"/api/deleteMessagesById",
          data:{
            stuID:stuid
          }
        }).then(response=>{
          console.log(response.data)
          if(response.data=="ok"){
alert("删除成功")
 axios({
          method:"get",
          url:"/api/findAll",
        }).then(response=>{
          let body = response.data;
          
          console.log(typeof (body));
         this.stuData=body
          console.log(JSON.stringify(body))
        }).catch(err=>{
          console.log("...err...",err)
        });
          }
          
        }).catch(err=>{
          console.log("...err...",err)
        });
      },
      rowclick(row){
        this.rowID=row.stuID
        console.log("rowclick:"+row.stuID)
        return row.stuID
      },
     selectrouteruser(){
 this.$router.push({ path:'/infor'}) 
     },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      },
      updatepasswordopen(){
        console.log("updatepasswordopen")
        let id = this.$route.query.username;
        axios({
          method:"post",
          url:"/api/getUserById1",
          data:{
            id:id
          }
        }).then(response=>{
          let body = response.data;
          console.log(typeof (body));
         this.passwordform.id=body.id,
         this.passwordform.name=body.name,
         this.passwordform.tel=body.tel
          console.log(JSON.stringify(body))
        }).catch(err=>{
          console.log("...err...",err)
        });
      },
       // 将表单数据添加到表格中去
    updatepassonSubmit() {
      
if(this.passwordform.pass===this.passwordform.repass){
        axios({
          method:"post",
          url:"/api/updateUserPassword",
          data:{
            id:this.passwordform.id,
            password:this.passwordform.pass
          }
        }).then(response=>{
          alert("密码修改成功，请重新登录")
          this.$router.push({ path:'/'})
        }).catch(err=>{
          console.log("...err...",err)
        });
}else{
  alert("两次密码不一致")
}
      this.UpdateVisible = false;
    },
    resetForm(formName) {
        this.$refs[formName].resetFields();
      },
//设置页面背景色
    
    // handlePictureCardPreview(file) {
    //   this.dialogImageUrl = file.url;
    //   this.dialogVisible = true;
    // },

    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    },

    handleRemove(file){
        this.ifimg=false;
        file.url="";
       this.dialogImageUrl = file.url;
    },

  exit(){
      this.$router.push({ path:'/'})    
  },
  selectuser1(){
    this.$router.push({ path:'/selectstudent'});

    // this.dialogVisible= false;
     
  },
            //分页
        handleSizeChange(val) {
         console.log(`每页 ${val} 条`);
         this.currentPage = 1;
         this.pageSize = val;
        },
        handleCurrentChange: function(val) {
            this.currentPage = val;
        },
        // handleUserList() {
        //     this.$http.get('http://localhost:8080/user').then(res => {  //这是从本地请求的数据接口，
        //         this.stuData = res.body
        //     })
        // }
    },
    created(){
      var name = this.$route.query.username;
      console.log(name)
       this.username=name;
       console.log(this.username)
          axios({
          method:"get",
          url:"/api/findAll",
        }).then(response=>{
          let body = response.data;
          
          console.log(typeof (body));
         this.stuData=body
          console.log(JSON.stringify(body))
        }).catch(err=>{
          console.log("...err...",err)
        });
    },

        mounted() {
       console.log("mount")

        var d = new Date();
        let mon=d.getMonth()+1;
        this.addsystemtime=d.getFullYear()+"-"+mon+"-"+d.getDate()+"  "+d.getHours()+":"+d.getMinutes();
        //  document.querySelector("body").setAttribute("style", "background-color: #e5ffee");
  } ,//设置页面背景色
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

  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
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
</style>

