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
      },
      updateuser(){
        this.$router.push({ path: '/updateuser'})
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

