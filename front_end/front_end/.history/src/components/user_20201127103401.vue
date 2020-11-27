<template>
  <div class="hello">
    <el-container>
      <el-header>
        <span id="systemname" >学生信息管理系统</span>
        <el-button-group>
            <el-button type="primary"  class="downclass"><a href="/api/MessagesExcelDownloads" download="学生信息汇总表.docx">导出学生信息</a></el-button>
            <el-button type="primary"  class="downclass" v-if="admin"><a href="/apiUserExcelDownloads" download="用户信息汇总表.docx">导出用户信息</a></el-button>
          </el-button-group>
        <span id="user_name" >欢迎您！！！{{ username }}</span>
        <!-- <el-button @click="selectuser1">查询</el-button> -->
        <el-button type="primary" icon="el-icon-delete" @click="exit">退出</el-button>
        
        
      </el-header>
          
      <el-container style="height: 700px; border: 1px solid #eee">
        <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
          <el-menu :default-openeds="['1', '2', '3']">
            <el-submenu index="1">
              <template slot="title"><i class="el-icon-message"></i>信息查询</template>
<el-menu-item-group>
    <el-menu-item index="1-0" @click="selectrouteruser">学生信息总表</el-menu-item>
    <el-menu-item index="1-1" @click.native="statisticsVisible = true">学生信息统计</el-menu-item>
    <!-- <el-menu-item index="1-2" @click.native="dialogVisible = true">学生信息查询</el-menu-item> -->
    <el-menu-item index="1-2" @click="selectuser1">学生信息查询</el-menu-item>
</el-menu-item-group>
</el-submenu>

<el-submenu index="2">
    <template slot="title"><i class="el-icon-menu"></i>信息修改</template>
    <el-menu-item-group>
        <el-menu-item index="2-1" @click.native="addVisible = true">新增学生信息</el-menu-item>
        <!-- <el-menu-item index="2-3">删除学生信息</el-menu-item> -->
    </el-menu-item-group>
</el-submenu>

<el-submenu index="3">
    <template slot="title"><i class="el-icon-setting"></i>设置</template>
    <el-menu-item-group>
        <el-menu-item index="3-1" @click.native="userVisible = true">修改用户信息</el-menu-item>
        <el-menu-item index="3-2" @click.native="passwordVisible = true">修改密码</el-menu-item>
        <el-menu-item index="3-3" @click="exituser">注销账户</el-menu-item>
    </el-menu-item-group>
</el-submenu>
</el-menu>
</el-aside>

<el-main>
    <router-view> </router-view>
</el-main>
</el-container>
</el-container>
<!-- 修改用户信息 -->
<el-dialog title="修改用户信息" :visible.sync="userVisible" width="35%" @open="updateuseropen" @close="updateuserclose">
    <span>
      <el-form ref="passwordform" :model="passwordform" label-width="100px">
        <el-form-item label="登陆ID" prop="id">
          <el-input type="number" v-model="passwordform.id" plain disabled :placeholder="IDplaceholaer"></el-input>
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input v-model="passwordform.name" :placeholder="nameplaceholaer" ></el-input>
        </el-form-item>

        <el-form-item label="手机" prop="tel">
          <el-input type="number" v-model="passwordform.tel" :placeholder="telplaceholaer"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="updateuseronSubmit">确认</el-button>
          <el-button @click="resetForm('passwordform')">清空</el-button>
        </el-form-item>
      </el-form>
    </span>
</el-dialog>
<!-- 修改用户登录密码 -->
<el-dialog title="修改登录密码" :visible.sync="passwordVisible" width="35%" @open="updatepasswordopen">
    <span>
        <el-form ref="passwordform" :model="passwordform" label-width="100px">
          <el-form-item label="登陆ID" prop="id">
            <el-input v-model="passwordform.id" plain disabled :placeholder="IDplaceholaer"></el-input>
          </el-form-item>
          <el-form-item label="姓名" prop="name">
            <el-input v-model="passwordform.name" disabled :placeholder="nameplaceholaer"></el-input>
          </el-form-item>

          <el-form-item label="手机" prop="tel">
            <el-input type="number" v-model="passwordform.tel" disabled :placeholder="telplaceholaer"></el-input>
          </el-form-item>
          <el-form-item   label="修改密码" prop="pass">
            <el-input v-model="passwordform.pass"></el-input>
          </el-form-item>
          <el-form-item  label="确认密码" prop="repass">
            <el-input v-model="passwordform.repass"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="updatepassonSubmit">确认</el-button>
            <el-button @click="resetForm('passwordform')">清空</el-button>
          </el-form-item>
        </el-form>
      </span>
</el-dialog>
<!-- 根据学院+班级+性别进行人数统计并统计全校人数 -->
<el-dialog :visible.sync="statisticsVisible" width="90.1%" @open="sumdialogopen">
    <el-tag class="eltagclass">人数统计</el-tag>
    <el-table :data="sumtableData" border style="width: 100%">
        <el-table-column align="center" prop="artdesign" label="艺术设计学院" width="100"> </el-table-column>
        <el-table-column align="center" prop="foreign" label="外国语学院" width="100"> </el-table-column>
        <el-table-column align="center" prop="tumu" label="土木工程学院" width="100"> </el-table-column>
        <el-table-column align="center" prop="economic" label="经济管理学院" width="100"> </el-table-column>
        <el-table-column align="center" prop="intell" label="智能制造学部" width="100"> </el-table-column>
        <el-table-column align="center" prop="IBM1" label="IBM1班" width="100"> </el-table-column>
        <el-table-column align="center" prop="IBM2" label="IBM2班" width="100"> </el-table-column>
        <el-table-column align="center" prop="IBM3" label="IBM3班" width="100"> </el-table-column>
        <el-table-column align="center" prop="IBM5" label="IBM5班" width="100"> </el-table-column>
        <el-table-column align="center" prop="IBM6" label="IBM6班" width="100"> </el-table-column>
        <el-table-column align="center" prop="IBM7" label="IBM7班" width="100"> </el-table-column>
        <el-table-column align="center" prop="girls" label="男" width="100"> </el-table-column>
        <el-table-column align="center" prop="boys" label="女" width="100"> </el-table-column>
        <el-table-column align="center" prop="allSchoolstu" label="全校统计" width="100"> </el-table-column>
    </el-table>
    <div>
        <div id="main" style="width: 550px;height:400px;display: inline-block;"></div>
        <!--  柱形图容器 -->
        <div id="main1" style="width: 500px;height:400px;display: inline-block;"></div>
        <!--  饼状图容器 -->
        <div id="main2" style="width: 300px;height:400px;display: inline-block;"></div>
    </div>

</el-dialog>

<el-dialog title="学生信息录入" :visible.sync="addVisible" width="50%">
    <span>
        <el-form :model="addForm" ref="addForm" label-width="100px" class="addForm">
          <el-form-item label="学生姓名" prop="addstudentname">
            <el-input v-model="addForm.addstudentname" style="width: 60%"></el-input>
          </el-form-item>
          <el-form-item label="学号" prop="addstudentnumber">
            <el-input type="number" v-model="addForm.addstudentnumber" style="width: 60%"></el-input>
          </el-form-item>
          <el-form-item label="班级" prop="addclassnumber">
            <!-- <el-input v-model="addForm.addclassnumber" style="width: 60%"></el-input> -->
             <el-select v-model="addForm.addclassnumber" placeholder="请选择">
                              <el-option label="IBM1班" value="IBM1班"></el-option>
                              <el-option label="IBM2班" value="IBM2班"></el-option>
                              <el-option label="IBM3班" value="IBM3班"></el-option>
                              <el-option label="IBM4班" value="IBM4班"></el-option>
                              <el-option label="IBM5班" value="IBM5班"></el-option>
                              <el-option label="IBM6班" value="IBM6班"></el-option>
                              <el-option label="IBM7班" value="IBM7班"></el-option>
            </el-select>
            </el-form-item>
            </el-form-item>
            <el-form-item label="出生年月" prop="addtime" >  
            <el-date-picker type="date" v-model="addForm.addtime " placeholder="选择日期"  style="width: 60%;" value-format="yyyyMMdd"></el-date-picker>
            
          </el-form-item>
          <el-form-item label="性别" prop="addsex">
            <el-select v-model="addForm.addsex" placeholder="请选择">
              <el-option label="女" value="女"></el-option>
              <el-option label="男" value="男"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="电话" prop="addtel">
            <el-input type="number" v-model="addForm.addtel" style="width: 60%"></el-input>
          </el-form-item>
          <el-form-item label="系统录入时间">
            <el-input disabled v-model="addsystemtime" placeholder="系统自动生成" style="width: 50%"></el-input>
          </el-form-item>
          <el-form-item label="系部" prop="adddepartment">
            <el-select v-model="addForm.adddepartment" placeholder="请选择">
              <el-option label="智能制造学部" value="智能制造学部"></el-option>
              <el-option label="土木工程学院" value="土木工程学院"></el-option>
              <el-option label="经济管理学院" value="经济管理学院"></el-option>
              <el-option label="外国语学院" value="外国语学院"></el-option>
              <el-option label="艺术设计学院" value="艺术设计学院"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="添加照片">
            <el-upload class="upload-demo" action="https://jsonplaceholder.typicode.com/posts/" list-type="picture" limit:1>
              <el-button size="small" type="primary">点击上传</el-button>
              <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
            </el-upload>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="addstusubmitForm">信息录入</el-button>
            <el-button @click="resetForm('addForm')">清空</el-button>
          </el-form-item>
        </el-form>
      </span>
</el-dialog>
</div>
</template>

<script>
    // import selectstudent from '@/components/User/selectstudent'
    export default {
        data() {
            return {
                admin: '',
                IDplaceholaer: '',
                nameplaceholaer: '张三',
                telplaceholaer: '13440213456',
                userVisible: false,
                addsystemtime: '',
                ifimg: true,
                tabPosition: "left",
                // dialogVisible: false,
                passwordVisible: false, //控制对话框的显示和隐藏
                statisticsVisible: false,
                dialog: false,
                addVisible: false,
                imageUrl: "",
                passwordform: {
                    id: "",
                    name: "",
                    tel: "",
                    pass: "",
                    repass: "",
                },
                sumtableData: [{
                    artdesign: '0',
                    foreign: '0',
                    tumu: '0',
                    economic: "0",
                    intell: '0',
                    girls: "0",
                    boys: "0",
                    IBM1: '0',
                    IBM2: '0',
                    IBM3: '0',
                    IBM4: '0',
                    IBM5: '0',
                    IBM6: '0',
                    IBM7: '0',
                    allSchoolstu: '0'
                }, ],
                statisticsForm: {
                    irule: "",
                    imassage: "",
                },
                addForm: {
                    msg: "学生信息录入",
                    addstudentname: "",
                    addstudentnumber: "",
                    addtime: "",
                    addsex: "",
                    addtel: "",
                    addclassnumber: "",
                    addsystemtime: "",
                    adddepartment: "",
                    adddialogImageUrl: "",
                },

                dialogrules: {
                    stuname: [{
                        required: true,
                        message: "请输入学生姓名",
                        trigger: "blur",
                    }, {
                        min: 2,
                        max: 30,
                        message: "姓名不符合规范",
                        trigger: "blur",
                    }, ],
                    stunum: [{
                        required: true,
                        message: "请输入学号",
                        trigger: "blur",
                    }, {
                        min: 10,
                        max: 10,
                        message: "学号不符合规范",
                        trigger: "blur",
                    }, ],
                    stuclass: [{
                        required: true,
                        message: "请输入班级",
                        trigger: "blur",
                    }, {
                        min: 6,
                        max: 6,
                        message: "班级不符合规范",
                        trigger: "blur",
                    }, ],
                    sex: [{
                        required: true,
                        message: "请选择",
                        trigger: "change",
                    }, ],
                    academy: [{
                        required: true,
                        message: "请选择",
                        trigger: "change",
                    }, ],
                },
                statisticsrules: {
                    irule: [{
                        required: true,
                        message: "请选择",
                        trigger: "change",
                    }, ],
                    imassage: [{
                        required: true,
                        message: "请输入",
                        trigger: "blur",
                    }, {
                        min: 2,
                        max: 12,
                        message: "不符合规范",
                        trigger: "blur",
                    }, ],
                },
            };
        },
        methods: {

            sumdialogopen() {
                axios({
                        method: "get",
                        url: "/api/CountStuInfo1",
                    })
                    .then((response) => {
                        let body = response.data;
                        // console.log(JSON.stringify(body))
                        let sumallSchoolstu = parseInt(body[13].totalSex) + parseInt(body[12].totalSex)
                        this.sumtableData = [{
                            artdesign: body[11].totalDep,
                            foreign: body[8].totalDep,
                            tumu: body[7].totalDep,
                            economic: body[10].totalDep,
                            intell: body[9].totalDep,
                            boys: body[13].totalSex,
                            girls: body[12].totalSex,
                            IBM1: body[0].totalClass,
                            IBM2: body[1].totalClass,
                            IBM3: body[2].totalClass,
                            IBM4: body[3].totalClass,
                            IBM5: body[4].totalClass,
                            IBM6: body[5].totalClass,
                            IBM7: body[6].totalClass,

                            allSchoolstu: sumallSchoolstu
                        }, ];
                        console.log(JSON.stringify(body))
                        var myChart = this.$echarts.init(document.getElementById('main'));
                        // 指定图表的配置项和数据
                        var option = {
                            title: {
                                text: '各班人数柱状图'
                            },
                            tooltip: {},
                            legend: {
                                data: ['人数']
                            },
                            xAxis: {
                                data: ["IBM1班", "IBM2班", "IBM3班", "IBM4班", "IBM5班", "IBM6班", "IBM7班"]
                            },
                            yAxis: {},
                            series: [{
                                name: '人数',
                                type: 'bar',
                                data: [body[0].totalClass, body[1].totalClass, body[2].totalClass, body[3].totalClass, body[4].totalClass, body[5].totalClass, body[6].totalClass]
                            }]
                        };
                        // 使用刚指定的配置项和数据显示图表。
                        myChart.setOption(option);
                        var myChart = this.$echarts.init(document.getElementById('main1'));
                        myChart.setOption({
                            series: [{
                                name: '系部人数饼状图',
                                type: 'pie', // 设置图表类型为饼图
                                radius: '55%', // 饼图的半径，外半径为可视区尺寸（容器高宽中较小一项）的 55% 长度。
                                data: [ // 数据数组，name 为数据项名称，value 为数据项值
                                    {
                                        value: body[9].totalDep,
                                        name: '智能制造学部'
                                    }, {
                                        value: body[11].totalDep,
                                        name: '艺术设计学院'
                                    }, {
                                        value: body[10].totalDep,
                                        name: '经济管理学院'
                                    }, {
                                        value: body[7].totalDep,
                                        name: '土木工程学院'
                                    }, {
                                        value: body[8].totalDep,
                                        name: '外国语学院'
                                    }
                                ]
                            }]
                        })
                        var myChart = this.$echarts.init(document.getElementById('main2'));
                        var option1 = {
                            title: {
                                text: '男女人数'
                            },
                            tooltip: {},
                            legend: {
                                data: ['人数']
                            },
                            xAxis: {
                                data: ["男", "女", ]
                            },
                            yAxis: {},
                            series: [{
                                name: '人数',
                                type: 'bar',
                                data: [body[13].totalSex, body[12].totalSex]
                            }]
                        };
                        // 使用刚指定的配置项和数据显示图表。
                        myChart.setOption(option1);



                    })
                    .catch((err) => {
                        console.log("...err...", err);
                    });
            },
            updateuserclose() {
                let id = this.$route.query.id;
                axios({
                        method: "post",
                        url: "/api/getUserById1",
                        data: {
                            id: id,
                        },
                    })
                    .then((response) => {
                        let body = response.data;
                        this.username = body.name


                    })
                    .catch((err) => {
                        console.log("...err...", err);
                    });
            },

            //添加学生信息
            addstusubmitForm() {
                if (this.addForm.addstudentnumber.length == 0 || this.addForm.addstudentname.length == 0 || this.addForm.addtime.length == 0 ||
                    this.addForm.addsex.length == 0 || this.addForm.addtel.length == 0 || this.addForm.addclassnumber.length == 0 ||
                    this.addForm.adddepartment.length == 0) {
                    this.$message({
                        message: "错误:存在空输入框，添加失败",
                        center: true,
                        offset: 50,
                        type: "warning",
                    });
                } else if (this.addForm.addstudentnumber.length > 30) {
                    this.$message({
                        message: "错误:学号大于30位，添加失败",
                        center: true,
                        offset: 50,
                        type: "warning",
                    });
                } else if (this.addForm.addstudentname.length > 30) {
                    this.$message({
                        message: "错误:学生姓名大于30位，添加失败",
                        center: true,
                        offset: 50,
                        type: "warning",
                    });
                } else {
                    axios({
                            method: "post",
                            url: "/api/addMessages",
                            data: {
                                stuID: this.addForm.addstudentnumber,
                                stuName: this.addForm.addstudentname,
                                stuBirth: this.addForm.addtime,
                                stuSex: this.addForm.addsex,
                                stuTel: this.addForm.addtel,
                                stuClass: this.addForm.addclassnumber,
                                stuDep: this.addForm.adddepartment,
                                stuAddTimed: this.addsystemtime,
                                stuImgUrl: this.addForm.adddialogImageUrl,
                            },
                        })
                        .then((response) => {
                            switch (response.data) {
                                case "ok":
                                    this.$message({
                                        type: 'success',
                                        message: '新增学生信息成功!',
                                        duration: 1000
                                    });
                                    this.addVisible = false;
                                    axios({
                                            method: "get",
                                            url: "/api/findAll",
                                        })
                                        .then((response) => {
                                            let body = response.data;
                                            this.stuData = body;
                                        })
                                        .catch((err) => {
                                            console.log("...err...", err);
                                        });
                            }


                        })
                        .catch((err) => {
                            console.log("...err...", err);
                        });

                    location.reload();

                }
            },

            selectrouteruser() {
                this.$router.push({
                    path: "/inforstudent",
                });
            },

            handleClose(key, keyPath) {
                console.log(key, keyPath);
            },
            updateuseronSubmit() {
                let id = this.$route.query.id;
                axios({
                        method: "post",
                        url: "/api/getUserById1",
                        data: {
                            id: id,
                        },
                    })
                    .then((response) => {
                        let body = response.data;
                        this.passwordform.id = body.id
                        this.nameplaceholaer = body.name
                        this.telplaceholaer = body.tel

                    })
                    .catch((err) => {
                        console.log("...err...", err);
                    });
                if (this.passwordform.name.length == 0 && this.passwordform.tel.length == 0) {
                    this.$message({
                        message: "错误:空输入，不能修改",
                        center: true,
                        offset: 50,
                        type: "warning",
                    });
                } else if (this.passwordform.name.length == 0) {
                    axios({
                            method: "post",
                            url: "/api/updateUserTableByID",
                            data: {
                                id: id,
                                name: this.nameplaceholaer,
                                tel: this.passwordform.tel
                            },
                        })
                        .then((response) => {
                            let body = response.data;
                            switch (body) {
                                case "success":
                                    this.$message({
                                        type: 'success',
                                        message: '修改用户信息成功!',

                                    });
                                    break
                            }
                            this.userVisible = false
                            this.$router.push({
                                path: "/",
                            });
                        })
                        .catch((err) => {
                            console.log("...err...", err);
                        });
                } else if (this.passwordform.tel.length == 0) {
                    axios({
                            method: "post",
                            url: "/api/updateUserTableByID",
                            data: {
                                id: id,
                                name: this.passwordform.name,
                                tel: this.telplaceholaer
                            },
                        })
                        .then((response) => {
                            let body = response.data;
                            switch (body) {
                                case "success":
                                    this.$message({
                                        type: 'success',
                                        message: '修改用户信息成功!',

                                    });
                                    break
                            }
                            this.userVisible = false
                            this.$router.push({
                                path: "/",
                            });
                        })
                        .catch((err) => {
                            console.log("...err...", err);
                        });
                } else {
                    axios({
                            method: "post",
                            url: "/api/updateUserTableByID",
                            data: {
                                id: id,
                                name: this.passwordform.name,
                                tel: this.passwordform.tel
                            },
                        })
                        .then((response) => {
                            let body = response.data;
                            switch (body) {
                                case "success":
                                    this.$message({
                                        type: 'success',
                                        message: '修改用户信息成功!',

                                    });
                                    break
                            }
                            this.userVisible = false
                            this.$router.push({
                                path: "/",
                            });
                        })
                        .catch((err) => {
                            console.log("...err...", err);
                        });
                }

            },
            updateuseropen() {
                let id = this.$route.query.id;
                axios({
                        method: "post",
                        url: "/api/getUserById1",
                        data: {
                            id: id,
                        },
                    })
                    .then((response) => {
                        let body = response.data;
                        this.passwordform.id = body.id
                        this.nameplaceholaer = body.name
                        this.telplaceholaer = body.tel
                        this.IDplaceholaer = body.id


                    })
                    .catch((err) => {
                        console.log("...err...", err);
                    });
            },
            updatepasswordopen() {

                let id = this.$route.query.id;
                axios({
                        method: "post",
                        url: "/api/getUserById1",
                        data: {
                            id: id,
                        },
                    })
                    .then((response) => {
                        let body = response.data;
                        (this.passwordform.id = body.id), (this.passwordform.name = body.name), (this.passwordform.tel = body.tel);
                        this.nameplaceholaer = body.name
                        this.telplaceholaer = body.tel
                        this.IDplaceholaer = body.id
                    })
                    .catch((err) => {
                        console.log("...err...", err);
                    });
            },
            // 将表单数据添加到表格中去
            updatepassonSubmit() {
                var reg = new RegExp("(?=.*[A-Z])(?=.*[a-z])(?=.*[^a-zA-Z0-9]).{8,30}");
                if (!reg.test(this.passwordform.pass) || !reg.test(this.passwordform.repass)) {
                    this.$message({
                        message: "错误:密码应由大小写字母+特殊字符组合,长度控制在8-30",
                        center: true,
                        offset: 50,
                        type: "warning",
                    });
                } else if (this.passwordform.pass === this.passwordform.repass) {
                    axios({
                            method: "post",
                            url: "/api/updateUserPassword",
                            data: {
                                id: this.passwordform.id,
                                password: this.passwordform.pass,

                            },
                        })
                        .then((response) => {
                            this.$message({
                                message: "恭喜你，密码修改成功，请重新登录",
                                type: "success",
                                center: true,
                                offset: 50,
                            });
                            this.$router.push({
                                path: "/",
                            });
                        })
                        .catch((err) => {
                            console.log("...err...", err);
                        });
                } else {
                    this.$message({
                        message: "错误:两次密码不一致",
                        center: true,
                        offset: 50,
                        type: "warning",
                    });
                }
                this.UpdateVisible = false;
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
            handlePictureCardPreview(file) {
                this.dialogImageUrl = file.url;
                this.dialogVisible = true;
            },

            handleRemove(file) {
                this.ifimg = false;
                file.url = "";
                this.dialogImageUrl = file.url;
            },
            exituser() {
                this.$confirm('此操作将注销该账户, 是否继续?', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    let id = this.$route.query.id;
                    axios({
                            method: "post",
                            url: "/api/deleteUser",
                            data: {
                                id: id,
                            },
                        })
                        .then((response) => {
                            let body = response.data;
                            switch (body) {
                                case "success":
                                    this.$message({
                                        type: 'success',
                                        message: '注销成功!',
                                        duration: 1000
                                    });
                                    this.$router.push({
                                        path: "/",
                                    });
                                    break

                            }
                        })
                        .catch((err) => {
                            console.log("...err...", err);
                        });

                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除注销'
                    });

                });
            },
            exit() {
                this.$router.push({
                    path: "/",
                });
            },
            selectuser1() {
                this.$router.push({
                    path: "/selectstudent",
                });

                // this.dialogVisible= false;
            },
            //分页
            handleSizeChange(val) {
                this.currentPage = 1;
                this.pageSize = val;
            },
            handleCurrentChange: function(val) {
                this.currentPage = val;
            },
        },
        created() {
            var name = this.$route.query.username;
            this.username = name;
            if (this.username == "admin") {
                this.admin = true
            } else {
                this.admin = false
            }
            axios({
                    method: "get",
                    url: "/api/findAll",
                })
                .then((response) => {
                    let body = response.data;
                    this.stuData = body;
                })
                .catch((err) => {
                    console.log("...err...", err);
                });
        },

        mounted() {
            var name = this.$route.query.username;
            this.username = name;

            if (this.username == "admin") {
                this.admin = true
            } else {
                this.admin = false
            }
            var d = new Date();
            let mon = d.getMonth() + 1;
            this.addsystemtime = d.getFullYear() + "-" + mon + "-" + d.getDate() + "  " + d.getHours() + ":" + d.getMinutes();
        }, //设置页面背景色
    };
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
    .el-header {
        background-color: #b3c0d1;
        color: #333;
        line-height: 60px;
    }
    
    .el-aside {
        color: #333;
    }
    
    .avatar-uploader .el-upload {
        border: 1px dashed #d9d9d9;
        border-radius: 6px;
        cursor: pointer;
        position: relative;
        overflow: hidden;
    }
    
    .avatar-uploader .el-upload:hover {
        border-color: #409eff;
    }
    
    .avatar-uploader-icon {
        font-size: 28px;
        color: #8c939d;
        width: 178px;
        height: 178px;
        line-height: 178px;
        text-align: center;
    }
    
    .avatar {
        width: 178px;
        height: 178px;
        display: block;
    }
    
    #systemname {
        font-size: 30px;
        color: white;
        text-shadow: 5px 5px 5px cyan;
    }
    
    input::-webkit-outer-spin-button,
    input::-webkit-inner-spin-button {
        -webkit-appearance: none;
    }
    
    input[type="number"] {
        -moz-appearance: textfield;
    }
    
    #user_name {
        font-size: 20px;
        margin-left: 45%;
    }
    
    .downclass {
        margin-left: 50px;
    }
    
    .eltagclass {
        margin-bottom: 10px;
        font-size: 20px;
    }
</style>
</style>