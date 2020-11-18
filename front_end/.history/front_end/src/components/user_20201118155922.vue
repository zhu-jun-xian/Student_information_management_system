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
          <el-menu-item index="1-2">学生信息查询</el-menu-item>
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
</el-container>
   </el-container>

<!-- <el-dialog title="提示" :visible.sync="dialogVisible" width="50%">
      <span>
        <el-form ref="form" :model="form" label-width="100px">
          <el-form-item label="年份">
            <el-input v-model="form.year"></el-input>
          </el-form-item>
          <el-form-item label="物品名称">
            <el-input v-model="form.name"></el-input>
          </el-form-item>
          <el-form-item label="物品性质">
            <el-select v-model="form.type" placeholder="请选择物品性质">
              <el-option label="家用电器" value="家用电器"></el-option>
              <el-option label="衣物" value="衣物"></el-option>
              <el-option label="鞋子" value="鞋子"></el-option>
              <el-option label="家具" value="家具"></el-option>
              <el-option label="书籍" value="书籍"></el-option>
              <el-option label="衣物" value="衣物"></el-option>
              <el-option label="零食" value="零食"></el-option>
              <el-option label="珠宝" value="珠宝"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="成本（万）">
            <el-input v-model="form.cost"></el-input>
          </el-form-item>
          <el-form-item label="率润（万）">
            <el-input v-model="form.rate"></el-input>
          </el-form-item>
          <el-form-item label="物品质量等级">
            <el-radio-group v-model="form.quality">
              <el-radio label="一级"></el-radio>
              <el-radio label="二级"></el-radio>
              <el-radio label="三级"></el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="主要出售地区">
            <el-checkbox-group v-model="form.region">
              <el-checkbox label="北京" name="type"></el-checkbox>
              <el-checkbox label="上海" name="type"></el-checkbox>
              <el-checkbox label="深圳" name="type"></el-checkbox>
              <el-checkbox label="广州" name="type"></el-checkbox>
            </el-checkbox-group>
          </el-form-item>
          <el-form-item label="备注">
            <el-input type="textarea" v-model="form.text"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="onSubmit">立即创建</el-button>
            <el-button>取消</el-button>
          </el-form-item>
        </el-form>
      </span>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogVisible = false"
          >确 定</el-button
        >
      </span>
    </el-dialog> -->
 




    
      
  </div> 
</template>

<script>
 export default {
   data() {
      return {
        tabPosition: 'left',
        dialogVisible: false, //控制对话框的显示和隐藏
         dialog: false,
      };
    },
    methods: {
     
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      }
//       updateuser(){
//         this.$router.push({ path: '/updateuser'})
// }
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

