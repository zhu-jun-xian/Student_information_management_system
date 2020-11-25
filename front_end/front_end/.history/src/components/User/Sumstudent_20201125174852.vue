<template>
   <el-table ref="multipleTable" :data="rolelist" border stripe tooltip-effect="dark" :height='tableHeight' v-loading="loading"
		 element-loading-text="拼命加载中">
		       <el-table-column :label="item.propName" :property="item.prop" :width='item.width' v-for="item in rolelisttop" :key="item.prop" align="center">
		             <template slot-scope="scope">
		                   <span>{{scope.row[scope.column.property]}}</span>
		             </template>
		         </el-table-column>
		 </el-table>
</template>

<script>
export default {
		name: "timedtasks",
		data() {
			return {
				loading:false,//表格加载
				rolelisttop: [{prop: 'name', propName: '角色名称'},
								{prop: 'name', propName: '锁定状态'},
								{prop: 'intro', propName: '备注'},
								{prop: 'mtime', propName: '添加时间'}],//表格头部
				// 表格数据										 
				rolelist: [{name:'超级管理员',islock:'锁定',intro:'无备注',mtime:'2020-9-15'}],
				tableHeight:'',//表格高度
            };
        },
			mounted() {
				setTimeout(() => {
					this.tableHeight = $('.moduleManagement').height() - $('.el-card').outerHeight() - $('.moduleManagement_btntop').outerHeight() -
						$('.moduleManagement_btn').outerHeight();
				}, 100)
			},
			watch: {
				tableHeight() {
					this.tableHeight = $('.moduleManagement').height() - $('.el-card').outerHeight() - $('.moduleManagement_btntop').outerHeight() -
						$('.moduleManagement_btn').outerHeight()
				}
			},
		};
</script>

<style scoped>


</style>