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
   </el-container>

 
  <!-- <el-tabs :tab-position="tabPosition" style="height: 700px;">
    <el-tab-pane label="用户注册">用户注册</el-tab-pane>
    <el-tab-pane label="配置管理">配置管理</el-tab-pane>
    <el-tab-pane label="角色管理">角色管理</el-tab-pane>
    <el-tab-pane label="个人信息">个人信息</el-tab-pane>
    <el-tab-pane label="修改密码">修改密码</el-tab-pane>
  </el-tabs> -->

<el-container style="height:700px; border: 1px solid #eee">
  <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
    <el-menu :default-openeds="['1', '3']">
      <el-submenu index="1">
        <template slot="title"><i class="el-icon-message"></i>信息查询</template>
        <el-menu-item-group>
          
          <el-menu-item index="1-1">学生信息统计</el-menu-item>
          <el-menu-item index="1-2">学生信息查询</el-menu-item>

        </el-menu-item-group>
      </el-submenu>
      <el-submenu index="2">
        <template slot="title"><i class="el-icon-menu"></i>信息修改</template>
        <el-menu-item-group>
          <el-menu-item index="2-1">修改用户信息</el-menu-item>
          <el-menu-item index="2-2">新增用户信息</el-menu-item>
          <el-menu-item index="2-1">删除学生信息</el-menu-item>
        </el-menu-item-group>
      </el-submenu>

      <el-submenu index="3">
        <template slot="title"><i class="el-icon-setting"></i>设置</template>
        <el-menu-item-group>
          <el-menu-item index="3-2">修改密码</el-menu-item>
          <el-menu-item index="3-2">退出登陆</el-menu-item>
        </el-menu-item-group>  
      </el-submenu>
    </el-menu>
  </el-aside>

  <el-table
    :data="tableData"
    stripe
    style="width: 100%">
    <el-table-column
      prop="date"
      label="日期"
      width="180">
    </el-table-column>
    <el-table-column
      prop="name"
      label="姓名"
      width="180">
    </el-table-column>
    <el-table-column
      prop="address"
      label="地址">
    </el-table-column>
  </el-table>
  
</el-container>



    
      
  </div> 
</template>

<script>
 export default {
   data() {
      return {
        tabPosition: 'left'
      };
    },
    methods: {
     
      handleClose(key, keyPath) {
        console.log(key, keyPath);
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

