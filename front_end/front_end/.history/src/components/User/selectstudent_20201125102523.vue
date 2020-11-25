<template>
  <div class="hello">
    <div>
        <el-button round  @click="selectAll" >查询全部信息</el-button>
        <el-button round  @click.native="selectnumVisible=true" >学生信息查询</el-button>
        <el-button round  @click.native="selectclassVisible=true">班级查询</el-button>
        <el-button round  @click.native="selectgendVisible=true">院系查询</el-button>
        <el-input v-model="search1" placeholder="请输入内容"  style="width:30%;padding-left:400px"  @blur="validateCounts"></el-input>
        
      <el-divider></el-divider>
    </div>
    <el-container>  
 
   <div>
    <el-table border class="el-table-column" :data="stuData.slice((currentPage-1)*pageSize,currentPage*pageSize)" :default-sort = "{prop: 'date', order: 'descending'}" style="width: 100%" @row-click="rowclick">
      <el-table-column align="center" header-align="center" prop="stuNum" label="序号" width="80%" sortable></el-table-column>
      <el-table-column align="center" header-align="center" prop="stuID" label="学号"  width="170%" sortable></el-table-column>
      <el-table-column align="center" header-align="center" prop="stuName" label="学生姓名"  width="160%"></el-table-column>
      <el-table-column align="center" header-align="center" prop="stuBirth" label="出生年月日"  width="160%"></el-table-column>
      <el-table-column align="center" header-align="center" prop="stuSex" label="性别"  width="110%"></el-table-column>
      <el-table-column align="center" header-align="center" prop="stuTel" label="手机号码"  width="160%"></el-table-column>
      <el-table-column align="center" header-align="center" prop="stuClass" label="班级"  width="160%" sortable></el-table-column>
      <el-table-column align="center" header-align="center" prop="stuDep" label="系部"  width="160%" sortable></el-table-column>
      <el-table-column align="center" header-align="center" prop="" label="操作"  width="180%">
        <template slot="header" slot-scope="scope">
        <el-input
          v-model="search"
          size="mini"
          placeholder="输入关键字搜索"/>
      </template>
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

    <el-dialog title="选择院系" :visible.sync="selectgendVisible" width="30%">
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
        <el-form-item label="班级" >
            <el-input v-model="selectclassForm.selectclass"></el-input>
           </el-form-item>
       <el-form-item>
          <el-button type="primary" @click="selectclassSubmit">查询</el-button>
      </el-form-item>
      </el-form>
  </el-dialog>

  <el-dialog title="输入学号" :visible.sync="selectnumVisible" width="30%">
      <el-form :inline="true" :model="selectnumForm" class="selectnumForm_demo">
        <el-form-item label="学号" >
            <el-input v-model="selectnumForm.selectnum"></el-input>
           </el-form-item>
       <el-form-item>
          <el-button type="primary" @click="selectnumSubmit">查询</el-button>
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
        rowID:'',
        search:'',
        search1:'',
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
        selectgendVisible:false,
        selectclassVisible:false,
        selectnumVisible:false,
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
      selectgendForm:{
        selectgendacademy:"",
      },
      selectclassForm:{
        selectclass:"",
      },
      selectnumForm:{
        selectnum:"",
       
      },
      
      
      };
    },


    methods: {
      validateCounts(){},

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

//获取一行的学号
      rowclick(row){
        this.rowID=row.stuID
        console.log("rowclick:"+row.stuID)
        return row.stuID
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
        handleCurrentChange: function(val) {
            this.currentPage = val;
        },

        selectAll(){
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


         selectgendSubmit(){
          console.log(this.selectgendForm.selectgendacademy)
          axios({
            method:"post",
            url:"/api/SelectByStuDep",
            data:{
              stuDep:this.selectgendForm.selectgendacademy,
            }
          }).then(response=>{
            console.log(response.data)
            alert("查询成功")
            this.selectgendVisible=false
              let body = response.data;
                console.log(typeof (body));
                this.stuData=[]
                this.stuData=body
                console.log(JSON.stringify(body))        
          })
        },

        selectclassSubmit(){
            console.log(this.selectclassForm.selectclass)
          axios({
            method:"post",
            url:"/api/SelectByStuClass",
            data:{
              stuClass:this.selectclassForm.selectclass,
            }
          }).then(response=>{
            console.log(response.data)
            alert("查询成功")
            this.selectclassVisible=false
              let body = response.data;
                console.log(typeof (body));
                this.stuData=[]
                this.stuData=body
                console.log(JSON.stringify(body))        
          })
        },

       selectnumSubmit(){
          console.log(this.selectnumForm.selectnum)
          axios({
            method:"post",
            url:"/api/getMessagesById",
            data:{
              stuID:this.selectnumForm.selectnum,
            }
          }).then(response=>{
            console.log(response.data)
            alert("查询成功")
            this.selectnumVisible=false
              let body = response.data;
                console.log(typeof (body));
                this.stuData=body
                console.log(JSON.stringify(body))        
          })  
       },
    },
    //获取表格数据
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

