<template>
   <div class="hello">
      <div>
       <el-row>
        <el-button round>学生信息查询</el-button>
        <el-button round @click.native="selectclassVisible=true">班级查询</el-button>
        <el-button round @click.native="selectgendVisible=true">院系查询</el-button> <el-divider></el-divider>
      </el-row> 
      </div>
    <el-container>
      <!-- <router-link to="/selectstudent"></router-link> -->
    <div>
   <el-table :data="selectDatas.slice((currentPage-1)*pageSize,currentPage*pageSize)"  :default-sort = "{prop: 'date', order: 'descending'}" style="width: 100%">
    <el-table-column label="序号"  width="100px" sortable prop="id">
      <template slot-scope="scope" >
        <span >{{ scope.row.id }}</span>
      </template>
    </el-table-column>
     <el-table-column label="学号"  width="150px" prop="stunum" sortable>
      <template slot-scope="scope">
        <span >{{ scope.row.stunum }}</span>
      </template>
    </el-table-column>
     <el-table-column label="学生姓名"  width="100px" prop="stuname" >
      <template slot-scope="scope">
        <span >{{ scope.row.stuname }}</span>
      </template>
    </el-table-column>
     <el-table-column label="出生日期"  width="150px" prop="stubirth" sortable>
      <template slot-scope="scope">
        <span >{{ scope.row.stubirth }}</span>
      </template>
    </el-table-column>
     <el-table-column label="性别"  width="100px" prop="stusex" sortable>
      <template slot-scope="scope">
        <span >{{ scope.row.stusex }}</span>
      </template>
    </el-table-column>
    <el-table-column label="手机号码"  width="150px" prop="stutel">
      <template slot-scope="scope"></template>
        <span >{{ scope.row.stutel }}</span>
      </template>
    </el-table-column>
    <el-table-column label="班级"  width="150px" prop="stuclass" sortable>
      <template slot-scope="scope">
        <span >{{ scope.row.stuclass }}</span>
      </template>
    </el-table-column>
    <el-table-column label="系部"  width="150px" prop="stugend" sortable>
      <template slot-scope="scope">
        <span >{{ scope.row.stugend }}</span>
      </template>
    </el-table-column>
    <el-table-column
      align="right" prop="id">
       <template slot="header" >
        <el-input
          v-model="search"
          size="mini"
          placeholder="输入关键字搜索"/>
      </template>
      <template slot-scope="scope">
        <el-button
          size="mini"
          @click.native="UpdateVisible = true">Edit</el-button>
          
        <el-button
          size="mini"
          type="danger"
          @click.native.prevent="deleteRow(scope.$index, selecttableData)">Delete</el-button>
      </template>
    </el-table-column>
  </el-table>
       
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

    </div>
    </el-container>


    <el-dialog title="修改用户信息" :visible.sync="UpdateVisible" width="35%">
      <span>
        <el-form ref="Updateform" :model="Updateform" label-width="100px">
          <el-form-item label="学号" prop="studentnumber">
            <el-input v-model="Updateform.studentnumber" plain disabled></el-input>
          </el-form-item>
          <el-form-item label="学生姓名" prop="name">
            <el-input v-model="Updateform.name"></el-input>
          </el-form-item>
          
          <el-form-item label="出生年月" prop="time" >
            <el-date-picker type="date" placeholder="选择日期" v-model="Updateform.time" style="width: 100%;"></el-date-picker>
          </el-form-item>
          <el-form-item label="性别" prop="sex">
            <el-input v-model="Updateform.sex"></el-input>
          </el-form-item>
         <el-form-item label="手机号码" prop="tel">
            <el-input v-model="Updateform.repass"></el-input>
          </el-form-item>
           <el-form-item label="班级" prop="classnumber">
            <el-input v-model="Updateform.classnumber"></el-input>
          </el-form-item>
          <el-form-item label="系部" prop="department">
            <el-input v-model="Updateform.department"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="onSubmit">确认</el-button>
            <el-button @click="resetForm('Updateform')">清空</el-button>
          </el-form-item>
        </el-form>
      </span> 
    </el-dialog> 

    <el-dialog title="选择院系" :visible.sync="selectgendVisible" width="30%">
      <el-form :inline="true" :model="selectgendForm" class="selectgendForm_demo">
        <el-form-item label="系部：" prop="selectgendacademy">
          <el-select v-model="selectgendForm.selectgendacademy" placeholder="请选择">
            <el-option label="智能制造学部" value="intelligent"></el-option>
            <el-option label="土木工程学院" value="building"></el-option>
            <el-option label="经济管理学院" value="economics"></el-option>
            <el-option label="外国语学院" value="foreign"></el-option>
            <el-option label="艺术设计学院" value="arting"></el-option>
          </el-select>
       </el-form-item>
       <el-form-item>
          <el-button type="primary" @click="selectgendSubmit(this.selectgendacademy)">查询</el-button>
      </el-form-item>
</el-form>
</el-dialog>

    <el-dialog title="输入班级" :visible.sync="selectclassVisible" width="30%">
      <el-form :inline="true" :model="selectclassForm" class="selectgendForm_demo">
        <el-form-item label="班级：" prop="selectgendacademy">
          <el-input v-model="selectclassForm.selectclass"></el-input>
       </el-form-item>
       <el-form-item>
          <el-button type="primary" @click="selectclassSubmit(this.selectclass)">查询</el-button>
      </el-form-item>
</el-form>
</el-dialog>

   </div>
</template>

<script>
   export default {
    data() {
      return {
        
        UpdateVisible:false,
        selectgendVisible:false,
        selectclassVisible:false,
        selectDatas: [{
            id: '',
            stunum: '',
            stuname: '',
            stubrith:'',
            stusex:'',
            stutel:'',
            stuclass:'',
            stugend:'',
          }],
        currentPage:1,
        pageSize:10,
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
      search: '',

      selectgendForm:{
        selectgendacademy:'',
        
      },
       selectclassForm:{
        selectclass:'',
        
      }

      }
    },
    methods: {
      handleEdit(index, row) {
        console.log(index, row);
      },
      handleDelete(index, row) {
        row.splice(index, 1);
        console.log(index, row);
      },
      deleteRow(index, rows) {
        rows.splice(index, 1);
      },   
       // 将表单数据添加到表格中去
    onSubmit() {
      //console.log(this.table)
      this.table.push(this.form);

      this.UpdateVisible = false;
    },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      selectgendSubmit(index){
        this.selectgendVisible = false;
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
         this.selectDatas=body
          console.log(JSON.stringify(body))
        }).catch(err=>{
          
          console.log("...err...",err)
        });
    },
    computed : { 
     selecttableDatas(){
        if(this.search) {
          return this.selecttableData.filter(item =>{
            return Object.keys(item).some(key => {    //1，2
              return String(item[key]).toLowerCase().indexOf(this.search) > -1    //3
            })
          }
          )
        }else return this.selecttableData    //4
     }
    }
  }
  
</script>


<style scoped>

</style>
     