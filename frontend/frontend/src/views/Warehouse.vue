<template>
  <div class="page">
    <h2>🏬 仓储管理</h2>

    <table class="table">
      <thead>
        <tr>
          <th>仓库名称</th>
          <th>商品名称</th>
          <th>库存数量</th>
          <th>预警阈值</th>
        </tr>
      </thead>
      <tbody>
        <tr
          v-for="item in stocks"
          :key="item.id"
          :class="{ warning: item.quantity < item.threshold }"
        >
          <td>{{ item.warehouse }}</td>
          <td>{{ item.product }}</td>
          <td>{{ item.quantity }}</td>
          <td>{{ item.threshold }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'

const stocks = ref([
  {
    id: 1,
    warehouse: '上海仓库',
    product: '电子产品',
    quantity: 120,
    threshold: 50
  },
  {
    id: 2,
    warehouse: '北京仓库',
    product: '食品',
    quantity: 30,
    threshold: 60
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
.warning {
  background-color: #fff3f3;
  color: #d93026;
}
</style>
