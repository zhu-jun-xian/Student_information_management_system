<template>
    <el-table :data="tableData" border
                  width="100%">
          <el-table-column
            :key="col.prop"
            :label="col.label"
            :prop="col.prop"
            v-for="col in cols">
          </el-table-column>
          <el-table-column
            label="操作"
            prop="option">
            <template slot-scope="scope">
              <el-button @click="edit(scope.row)" size="mini" type="info">
                <i class="el-icon-edit"></i>
                编辑
              </el-button>
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