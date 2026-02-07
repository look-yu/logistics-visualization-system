<template>
  <div class="warehouse-list">
    <h2>仓库库存管理</h2>
    
    <!-- 操作按钮 -->
    <div class="btn-bar">
      <el-button type="primary" @click="loadStockList">刷新库存</el-button>
      <el-button type="warning" @click="loadWarnStockList">查看库存预警</el-button>
    </div>
    
    <!-- 库存表格 -->
    <el-table 
      :data="stockList" 
      border 
      stripe
      style="width: 100%; margin-top: 20px;"
    >
      <el-table-column prop="id" label="ID" width="80"></el-table-column>
      <el-table-column prop="warehouseName" label="仓库名称" width="120"></el-table-column>
      <el-table-column prop="goodsName" label="商品名称" width="150"></el-table-column>
      <el-table-column prop="goodsCode" label="商品编码" width="150"></el-table-column>
      <el-table-column prop="stockNum" label="库存数量" width="100">
        <template #default="scope">
          <el-tag :type="scope.row.stockNum <= scope.row.warnNum ? 'danger' : 'success'">
            {{ scope.row.stockNum }}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="warnNum" label="预警值" width="100"></el-table-column>
      <el-table-column prop="updateTime" label="最后更新时间" width="180"></el-table-column>
    </el-table>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { getStockList, getWarnStockList } from '@/api/warehouse'

// 响应式数据
const stockList = ref<any[]>([]) // 库存列表

// 加载全部库存
const loadStockList = async () => {
  try {
    const data = await getStockList()
    stockList.value = data
  } catch (error) {
    console.error('加载库存失败：', error)
  }
}

// 加载库存预警商品
const loadWarnStockList = async () => {
  try {
    const data = await getWarnStockList()
    stockList.value = data
    alert(`共查询到 ${data.length} 个库存预警商品！`)
  } catch (error) {
    console.error('加载预警库存失败：', error)
  }
}

// 页面挂载时加载数据
onMounted(() => {
  loadStockList()
})
</script>

<style scoped>
.warehouse-list {
  background: #fff;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 2px 12px rgba(0,0,0,0.1);
}

.btn-bar {
  margin-bottom: 10px;
}
</style>