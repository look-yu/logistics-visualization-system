<template>
  <div class="order-list">
    <h2>订单管理</h2>
    
    <!-- 筛选栏 -->
    <div class="filter-bar">
      <el-select 
        v-model="statusFilter" 
        placeholder="请选择订单状态" 
        style="width: 200px; margin-right: 10px;"
      >
        <el-option label="全部" value="-1"></el-option>
        <el-option label="待发货" value="0"></el-option>
        <el-option label="运输中" value="1"></el-option>
        <el-option label="已签收" value="2"></el-option>
      </el-select>
      <el-button type="primary" @click="loadOrderList">查询</el-button>
    </div>
    
    <!-- 订单表格 -->
    <el-table 
      :data="orderList" 
      border 
      stripe
      style="width: 100%; margin-top: 20px;"
    >
      <el-table-column prop="id" label="ID" width="80"></el-table-column>
      <el-table-column prop="orderNo" label="订单编号" width="180"></el-table-column>
      <el-table-column prop="status" label="状态" width="100">
        <template #default="scope">
          <el-tag :type="getStatusTagType(scope.row.status)">
            {{ getStatusText(scope.row.status) }}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="warehouseName" label="发货仓库" width="120"></el-table-column>
      <el-table-column prop="receiveAddress" label="收货地址" min-width="200"></el-table-column>
      <el-table-column prop="amount" label="金额" width="100">
        <template #default="scope">
          ¥{{ scope.row.amount.toFixed(2) }}
        </template>
      </el-table-column>
      <el-table-column prop="createTime" label="创建时间" width="180">
        <template #default="scope">
          {{ formatDate(scope.row.createTime) }}
        </template>
      </el-table-column>
      <el-table-column label="操作" width="200">
        <template #default="scope">
          <el-select 
            v-model="scope.row.newStatus" 
            placeholder="选择新状态" 
            style="width: 100px; margin-right: 5px;"
          >
            <el-option label="待发货" value="0"></el-option>
            <el-option label="运输中" value="1"></el-option>
            <el-option label="已签收" value="2"></el-option>
          </el-select>
          <el-button 
            type="primary" 
            size="small" 
            @click="handleUpdateStatus(scope.row.id, scope.row.newStatus)"
          >
            更新
          </el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { getOrderList, getOrderByStatus, updateOrderStatus } from '@/api/order'

// 响应式数据
const statusFilter = ref(-1) // 状态筛选：-1=全部，0=待发货，1=运输中，2=已签收
const orderList = ref<any[]>([]) // 订单列表

// 格式化日期（后端返回的时间戳/字符串转成易读格式）
const formatDate = (dateStr: string) => {
  if (!dateStr) return ''
  return new Date(dateStr).toLocaleString()
}

// 获取状态文本
const getStatusText = (status: number) => {
  switch (status) {
    case 0: return '待发货'
    case 1: return '运输中'
    case 2: return '已签收'
    default: return '未知'
  }
}

// 获取状态标签类型（ElementPlus标签样式）
const getStatusTagType = (status: number) => {
  switch (status) {
    case 0: return 'warning' // 黄色
    case 1: return 'primary' // 蓝色
    case 2: return 'success' // 绿色
    default: return 'info'    // 灰色
  }
}

// 加载订单列表
const loadOrderList = async () => {
  try {
    let data: any[] = []
    if (statusFilter.value === -1) {
      // 查询全部订单
      data = await getOrderList()
    } else {
      // 按状态查询
      data = await getOrderByStatus(statusFilter.value)
    }
    // 给每个订单添加newStatus默认值（用于更新）
    orderList.value = data.map(item => ({ ...item, newStatus: item.status }))
  } catch (error) {
    console.error('加载订单失败：', error)
  }
}

// 更新订单状态
const handleUpdateStatus = async (id: number, newStatus: number) => {
  try {
    await updateOrderStatus(id, newStatus)
    alert('订单状态更新成功！')
    // 重新加载列表
    loadOrderList()
  } catch (error) {
    console.error('更新订单状态失败：', error)
  }
}

// 页面挂载时加载数据
onMounted(() => {
  loadOrderList()
})
</script>

<style scoped>
.order-list {
  background: #fff;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 2px 12px rgba(0,0,0,0.1);
}

.filter-bar {
  margin-bottom: 10px;
}
</style>