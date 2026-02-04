<template>
  <div class="page">
    <h2>🚛 运输管理</h2>

    <table class="table">
      <thead>
        <tr>
          <th>订单号</th>
          <th>车辆编号</th>
          <th>司机</th>
          <th>运输状态</th>
          <th>开始时间</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="task in tasks" :key="task.id">
          <td>{{ task.orderNo }}</td>
          <td>{{ task.vehicle }}</td>
          <td>{{ task.driver }}</td>
          <td>{{ task.status }}</td>
          <td>{{ task.startTime }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'

const tasks = ref([
  {
    id: 1,
    orderNo: 'ORD-001',
    vehicle: '京A12345',
    driver: '张三',
    status: '运输中',
    startTime: '2026-02-04 09:00'
  },
  {
    id: 2,
    orderNo: 'ORD-002',
    vehicle: '粤B54321',
    driver: '李四',
    status: '已完成',
    startTime: '2026-02-03 14:00'
  }
])
</script>

<style scoped>
.page {
  padding: 20px;
}
.table {
  width: 100%;
  border-collapse: collapse;
}
th, td {
  border: 1px solid #ddd;
  padding: 8px;
}
th {
  background: #f5f5f5;
}
</style>
