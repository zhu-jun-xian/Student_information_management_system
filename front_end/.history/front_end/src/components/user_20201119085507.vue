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
          <el-menu-item index="1-1">学生信息统计</el-menu-item>
          <el-menu-item index="1-2" @click="selectuser">学生信息查询</el-menu-item>
        </el-menu-item-group>
      </el-submenu>

      <el-submenu index="2">
        <template slot="title"><i class="el-icon-menu"></i>信息修改</template>
        <el-menu-item-group>
          <el-menu-item index="2-1" @click.native="dialogVisible = true">修改用户信息</el-menu-item>
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
  <div :is="currentView"></div>
</el-container>
   </el-container>

<el-dialog title="修改用户信息" :visible.sync="dialogVisible" width="35%">
      <span>
        <el-form ref="form" :model="form" label-width="100px">
          <el-form-item label="登陆ID" >
            <el-input v-model="form.id" plain disabled></el-input>
          </el-form-item>
          <el-form-item label="姓名">
            <el-input v-model="form.name"></el-input>
          </el-form-item>
          
          <el-form-item label="手机"  >
            <el-input v-model="form.tel"></el-input>
          </el-form-item>
          <el-form-item label="修改密码">
            <el-input v-model="form.pass"></el-input>
          </el-form-item>
         <el-form-item label="确认密码">
            <el-input v-model="form.repass"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="onSubmit">确认</el-button>
            <el-button @click="dialogVisible = false">取消</el-button>
          </el-form-item>
        </el-form>
      </span>
      
    </el-dialog>
 




    
      
  </div> 
</template>

<script>
import selectuser from '@/components/User/selectuser'
 export default {
    components:{
   selectuser
  },
   data() {
      return {
        tabPosition: 'left',
        dialogVisible: false, //控制对话框的显示和隐藏
         dialog: false,
        form: {
        id: "",
        name: "",
        tel: "",
        pass: "",
        repass: "",
      },
      
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

      this.dialogVisible = false;
    },
    selectuser(){
      this.$router.push({ path: '/selectuser'})
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

