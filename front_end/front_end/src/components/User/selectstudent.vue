<template>
   <div class="hello">
    <el-container>
      <!-- <router-link to="/selectstudent"></router-link> -->
   <el-table :data="selecttableData" style="width: 100%">
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
      <template slot="header">
        <el-input
          v-model="search"
          size="mini"
          placeholder="输入关键字搜索"/>
      </template>
      <template slot-scope="scope">
        <el-button
          size="mini"
          @click="handleEdit(scope.$index, scope.row)">Edit</el-button>
          
        <el-button
          size="mini"
          type="danger"
          @click.native.prevent="deleteRow(scope.$index, selecttableData)">Delete</el-button>
      </template>
    </el-table-column>
  </el-table>


    </el-container>
   </div>
</template>

<script>
   export default {
    data() {
      return {
        search: '',
        selecttableData: [{
          id: '1',
          stunum: '3217005359',
          stuname:'张小虎',
          stubirth:'2020-09-11',
          stusex:'男',
          stutel:'13456782225',
          stuclass: '170806',
          stugend:'智能制造学部'
        },
        {
          id: '1',
          stunum: '3217005359',
          stuname:'李四',
          stubirth:'2020-09-11',
          stusex:'男',
          stutel:'13456782225',
          stuclass: '170806',
          stugend:'智能制造学部'
        },]
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
      }
    }
  }
</script>


<style scoped>

</style>
     