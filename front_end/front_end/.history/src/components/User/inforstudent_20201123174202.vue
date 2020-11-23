<template>
  <div class="hello">
    <el-container>  
 
   <div>
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
    </div>
  
</el-container>


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
        UpdateVisible: false, //控制对话框的显示和隐藏
        dialog: false,
         imageUrl: '',
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

     

 //删除学生信息     
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


      handleClose(key, keyPath) {
        console.log(key, keyPath);
      },


    resetForm(formName) {
        this.$refs[formName].resetFields();
      },

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

