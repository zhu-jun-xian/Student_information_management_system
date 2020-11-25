<template>
   <el-table ref="multipleTable" :data="rolelist" border stripe tooltip-effect="dark" :height='tableHeight' v-loading="loading"
		 element-loading-text="拼命加载中">
			<el-table-column type="index" label="序号" width="70" align="center"></el-table-column>
		       <el-table-column :label="item.propName" :property="item.prop" :width='item.width' v-for="item in rolelisttop" :key="item.prop" align="center">
		             <template slot-scope="scope">
		                   <span>{{scope.row[scope.column.property]}}</span>
		             </template>
		         </el-table-column>
				<el-table-column label="操作" align="center" width="300" fixed="right">
					<template slot-scope="scope">
						<el-button size="mini" type="warning" icon="el-icon-edit" @click="modifytiming(scope.row)" min-width="70">修改</el-button>
						<el-button size="mini" type="danger" icon="el-icon-delete" @click="deletetiming(scope.row)" min-width="70">删除</el-button>
					</template>
				</el-table-column>
		 </el-table>
</template>

<script>

export default {
  data(){
    return {
    
    }
  },
  methods:{

  },

}
</script>

<style scoped>


</style>