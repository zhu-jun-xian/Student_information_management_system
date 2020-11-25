<template>
    <el-table :data="tableData" border width="100%">
         <el-table-column :key="col.prop" :label="col.label" :prop="col.prop" v-for="col in cols">
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