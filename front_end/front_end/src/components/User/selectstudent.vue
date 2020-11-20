<template>
   <div class="hello">
    <el-container>
      <!-- <router-link to="/selectstudent"></router-link> -->
   <el-table :data="selecttableData.filter(data => !search || data.stuname.toLowerCase().includes(search.toLowerCase())) " style="width: 100%">
    <el-table-column label="序号"  width="50px">
      <template slot-scope="scope">
        <span >{{ scope.row.id }}</span>
      </template>
    </el-table-column>
     <el-table-column label="学号"  width="150px">
      <template slot-scope="scope">
        <span >{{ scope.row.stunum }}</span>
      </template>
    </el-table-column>
     <el-table-column label="学生姓名"  width="100px">
      <template slot-scope="scope">
        <span >{{ scope.row.stuname }}</span>
      </template>
    </el-table-column>
     <el-table-column label="出生日期"  width="150px">
      <template slot-scope="scope">
        <span >{{ scope.row.stubirth }}</span>
      </template>
    </el-table-column>
     <el-table-column label="性别"  width="100px">
      <template slot-scope="scope">
        <span >{{ scope.row.stusex }}</span>
      </template>
    </el-table-column>
    <el-table-column label="手机号码"  width="150px">
      <template slot-scope="scope">
        <span >{{ scope.row.stutel }}</span>
      </template>
    </el-table-column>
    <el-table-column label="班级"  width="150px">
      <template slot-scope="scope">
        <span >{{ scope.row.stuclass }}</span>
      </template>
    </el-table-column>
    <el-table-column label="系部"  width="150px">
      <template slot-scope="scope">
        <span >{{ scope.row.stugend }}</span>
      </template>
    </el-table-column>
    <el-table-column
      align="right">
       <template slot="header" slot-scope="scope">
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

   </div>
</template>

<script>
   export default {
    data() {
      return {
        
        UpdateVisible:false,
        selecttableData: [{
          id: '1',
          stunum: '1111111111',
          stuname:'1111',
          stubirth:'11111111',
          stusex:'11',
          stutel:'11111111111',
          stuclass: '111111',
          stugend:'1111'
        }],
         Updateform: {
        id: "",
        name: "",
        tel: "",
        pass: "",
        repass: "",
      },
          search: '',

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
    }
  }
</script>


<style scoped>

</style>
     