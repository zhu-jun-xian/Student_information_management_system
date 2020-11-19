《ele
     <el-dialog title="学生信息录入" :visible.sync="addVisible" width="70%">
      <span>
        <el-form :model="addForm" :rules="addrules" ref="addForm" label-width="100px" class="addForm">
          <el-row><span>基本信息</span></el-row><hr />
          <el-form-item label="学生姓名" prop="addstudentname">
          <el-input v-model="addForm.addstudentname"></el-input>
       </el-form-item>
        <el-form-item label="学号" prop="addstudentnumber">
          <el-input v-model="addForm.addstudentnumber"></el-input>
       </el-form-item>
       <el-form-item label="出生日期" prop="addtime">
         <el-col :span="11">
            <el-date-picker type="date" placeholder="选择日期" v-model="addForm.addtime" style="width: 100%;"></el-date-picker>
         </el-col>
       </el-form-item>
       <el-form-item label="性别" prop="addsex">
          <el-select v-model="addForm.addsex" placeholder="请选择">
            <el-option label="女" value="boy"></el-option>
            <el-option label="男" value="girl"></el-option>
          </el-select>
       </el-form-item>
        <el-form-item label="电话" prop="addtel">
          <el-input v-model="addForm.addtel"></el-input>
       </el-form-item>
       <el-form-item label="系统录入时间" prop="addsystemtime">
          <el-input disabled="false" v-model="time" placeholder="系统自动生成" style="width:100%"
          ></el-input>
       </el-form-item>
       <el-form-item label="系部" prop="adddepartment">
          <el-select v-model="addForm.adddepartment" placeholder="请选择">
            <el-option label="智能制造学部" value="intelligent"></el-option>
            <el-option label="土木工程学院" value="building"></el-option>
            <el-option label="经济管理学院" value="economics"></el-option>
            <el-option label="外国语学院" value="foreign"></el-option>
            <el-option label="艺术设计学院" value="arting"></el-option>
          </el-select>
       </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="submitForm('selectForm')">查询</el-button>
    <el-button @click="resetForm('addForm')">清空</el-button>
  </el-form-item>
 </el-form>
      </span> 
    </el-dialog>