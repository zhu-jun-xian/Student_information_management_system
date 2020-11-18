<template>
<div>
<h1>{{msg}}</h1>
<hr>
<el-row>
  <el-col :span="1"><div class="grid-content"></div></el-col>
  <el-col :span="5"><span>学生姓名</span><div class="grid-content bg-purple"><el-input v-model="studentname" placeholder="张三"></el-input>
  </div></el-col>
  <el-col :span="3"><div class="grid-content"></div></el-col>
  <el-col :span="5"><span>学号</span><div class="grid-content "><el-input v-model="studentnumber" placeholder="311700xxxx"></el-input></div></el-col>
  <el-col :span="3"><div class="grid-content"></div></el-col>
  <el-col :span="4"><span>出生年月日</span><div class="grid-content"><el-date-picker v-model="value1" type="date" placeholder="选择日期" style="width:300px" >
  </el-date-picker></div></el-col>
</el-row>

<el-row><span></span></el-row>

<el-row>
  <el-col :span="1"><div class="grid-content"></div></el-col>
  <el-col :span="5"><span>性别</span><div class="grid-content bg-purple">   <el-select style="width:300px" v-model="gender" placeholder="请选择">
  <el-option v-for="item in options" :key="item.value" :label="item.label":value="item.value"  ></el-option></el-select></div></el-col>
  <el-col :span="3"><div class="grid-content"></div></el-col>
  <el-col :span="5"><span>手机号码</span><div class="grid-content "><el-input v-model="tel" placeholder="137xxxx2222"></el-input></div></el-col>
  <el-col :span="3"><div class="grid-content"></div></el-col>
  <el-col :span="4"><span>班级</span><div class="grid-content "><el-input v-model="classnumber" placeholder="17xxxx" style="width:300px"></el-input></div></el-col>
</el-row>

<el-row><span></span></el-row>
   
<el-row>
  <el-col :span="1"><div class="grid-content"></div></el-col>
  <el-col :span="5"><span></span><div class="grid-content"></div></el-col>
  <el-col :span="3"><div class="grid-content"></div></el-col>
  <el-col :span="5"><span>系部</span><div class="grid-content "><el-input v-model="department" placeholder="智能制造学部"></el-input></div></el-col>
  <el-col :span="3"><div class="grid-content"></div></el-col>
  <el-col :span="4"><span>班级</span><div class="grid-content "><el-input v-model="classnumber" placeholder="17xxxx" style="width:300px"></el-input></div></el-col>
</el-row>

<el-row><span></span></el-row>

</div>
</template>

<script>
//修改信息
export default {
  data() {
    return {
      
      msg: "基本信息",
      studentname: '',
      studentnumber: '',
      gender: '',
      tel: '',
      classnumber:'',
      department:'',
      
      pickerOptions: {
          disabledDate(time) {
            return time.getTime() > Date.now();
          },      
      },
      value1: '',
          options: [{
          value: '选项1',
          label: '男'
        }, {
          value: '选项2',
          label: '女'
        }],
      value:'',
    };
  },
methods: {
  
},
   mounted(){
    document.querySelector('body').setAttribute('style','background-color: #e5ffee')
    },  //设置页面背景色
  };
</script>

<style scoped>
  .el-row {
    margin-bottom: 20px;
    &:last-child {
      margin-bottom: 0;
    }
  }
  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
    background: #99a9bf;
  }
  .bg-purple {
    background: #d3dce6;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }
</style>