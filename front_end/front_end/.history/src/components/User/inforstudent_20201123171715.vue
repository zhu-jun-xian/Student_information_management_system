<template>
     <el-container>
     </el-container>
      <div>
     <el-table  border class="el-table-column" :data="stuData.slice((currentPage-1)*pageSize,currentPage*pageSize)" style="width: 100%" @row-click="rowclick">
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
          @click.native.prevent="deleteRow(scope.$index, selecttableData)">Delete</el-button></el-table-column>
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
 this.$router.push({ path:'/inforstudent'}) 
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


<style scoped>

</style>
     