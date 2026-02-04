<template>
  <div class="page">
    <h2>📦 订单管理</h2>

    <table class="table">
      <thead>
        <tr>
          <th>订单号</th>
          <th>客户名称</th>
          <th>起点</th>
          <th>终点</th>
          <th>状态</th>
          <th>创建时间</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="order in orders" :key="order.id">
          <td>{{ order.orderNo }}</td>
          <td>{{ order.customer }}</td>
          <td>{{ order.origin }}</td>
          <td>{{ order.destination }}</td>
          <td>{{ order.status }}</td>
          <td>{{ order.time }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'

const orders = ref([
  {
    id: 1,
    orderNo: 'ORD-001',
    customer: '客户A',
    origin: '北京',
    destination: '上海',
    status: '运输中',
    time: '2026-02-04'
  },
  {
    id: 2,
    orderNo: 'ORD-002',
    customer: '客户B',
    origin: '广州',
    destination: '深圳',
    status: '已完成',
    time: '2026-02-03'
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
