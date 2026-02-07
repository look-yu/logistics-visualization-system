<template>
  <div class="transport-list">
    <h2>运输任务管理</h2>
    
    <!-- 筛选栏 -->
    <div class="filter-bar">
      <el-select 
        v-model="statusFilter" 
        placeholder="请选择运输状态" 
        style="width: 200px; margin-right: 10px;"
      >
        <el-option label="全部" value="-1"></el-option>
        <el-option label="未开始" value="0"></el-option>
        <el-option label="运输中" value="1"></el-option>
        <el-option label="已完成" value="2"></el-option>
      </el-select>
      <el-input 
        v-model="orderNoFilter" 
        placeholder="请输入订单号" 
        style="width: 200px; margin-right: 10px;"
      ></el-input>
      <el-button type="primary" @click="loadTaskList">查询</el-button>
    </div>
    
    <!-- 运输任务表格 -->
    <el-table 
      :data="taskList" 
      border 
      stripe
      style="width: 100%; margin-top: 20px;"
    >
      <el-table-column prop="id" label="ID" width="80"></el-table-column>
      <el-table-column prop="orderNo" label="关联订单号" width="180"></el-table-column>
      <el-table-column prop="transportType" label="运输方式" width="100">
        <template #default="scope">
          {{ getTransportTypeText(scope.row.transportType) }}
        </template>
      </el-table-column>
      <el-table-column prop="transportNo" label="运输单号" width="180"></el-table-column>
      <el-table-column prop="startAddress" label="出发地" width="150"></el-table-column>
      <el-table-column prop="endAddress" label="目的地" width="150"></el-table-column>
      <el-table-column prop="status" label="状态" width="100">
        <template #default="scope">
          <el-tag :type="getStatusTagType(scope.row.status)">
            {{ getStatusText(scope.row.status) }}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="createTime" label="创建时间" width="180">
        <template #default="scope">
          {{ formatDate(scope.row.createTime) }}
        </template>
      </el-table-column>
      <el-table-column prop="expectArriveTime" label="预计到达时间" width="180">
        <template #default="scope">
          {{ formatDate(scope.row.expectArriveTime) }}
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { getTaskList, getTaskByStatus, getTaskByOrderNo } from '@/api/transport'

// 响应式数据
const statusFilter = ref(-1) // 状态筛选：-1=全部，0=未开始，1=运输中，2=已完成
const orderNoFilter = ref('') // 订单号筛选
const taskList = ref<any[]>([]) // 运输任务列表

// 格式化日期
const formatDate = (dateStr: string) => {
  if (!dateStr) return ''
  return new Date(dateStr).toLocaleString()
}

// 获取运输方式文本
const getTransportTypeText = (type: number) => {
  switch (type) {
    case 0: return '快递'
    case 1: return '物流'
    case 2: return '空运'
    default: return '其他'
  }
}

// 获取状态文本
const getStatusText = (status: number) => {
  switch (status) {
    case 0: return '未开始'
    case 1: return '运输中'
    case 2: return '已完成'
    default: return '未知'
  }
}

// 获取状态标签类型
const getStatusTagType = (status: number) => {
  switch (status) {
    case 0: return 'info'     // 灰色
    case 1: return 'primary'  // 蓝色
    case 2: return 'success'  // 绿色
    default: return 'info'
  }
}

// 加载运输任务列表
const loadTaskList = async () => {
  try {
    let data: any[] = []
    // 优先按订单号筛选
    if (orderNoFilter.value) {
      data = await getTaskByOrderNo(orderNoFilter.value)
    } else if (statusFilter.value === -1) {
      // 查询全部任务
      data = await getTaskList()
    } else {
      // 按状态筛选
      data = await getTaskByStatus(statusFilter.value)
    }
    taskList.value = data
  } catch (error) {
    console.error('加载运输任务失败：', error)
  }
}

// 页面挂载时加载数据
onMounted(() => {
  loadTaskList()
})
</script>

<style scoped>
.transport-list {
  background: #fff;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 2px 12px rgba(0,0,0,0.1);
}

.filter-bar {
  margin-bottom: 10px;
}
</style>