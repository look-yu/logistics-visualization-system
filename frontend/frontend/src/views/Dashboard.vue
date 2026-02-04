<template>
  <div class="dashboard">
    <!-- 顶部指标卡 -->
    <div class="stat-cards">
      <div class="card">
        <p class="label">订单总数</p>
        <p class="value">{{ stats.totalOrders }}</p>
      </div>
      <div class="card">
        <p class="label">运输中订单</p>
        <p class="value warning">{{ stats.inTransit }}</p>
      </div>
      <div class="card">
        <p class="label">仓库数量</p>
        <p class="value">{{ stats.warehouseCount }}</p>
      </div>
      <div class="card">
        <p class="label">库存预警</p>
        <p class="value danger">{{ stats.stockWarning }}</p>
      </div>
    </div>

    <!-- 图表区域 -->
    <div class="charts">
      <div class="chart" ref="orderChartRef"></div>
      <div class="chart" ref="warehouseChartRef"></div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { onMounted, ref } from 'vue'
import * as echarts from 'echarts'

/** ====== 顶部统计数据 ====== */
const stats = ref({
  totalOrders: 256,
  inTransit: 89,
  warehouseCount: 6,
  stockWarning: 3
})

/** ====== 图表 DOM ====== */
const orderChartRef = ref<HTMLDivElement | null>(null)
const warehouseChartRef = ref<HTMLDivElement | null>(null)

onMounted(() => {
  initOrderChart()
  initWarehouseChart()
})

/** ====== 订单状态分布 ====== */
function initOrderChart() {
  if (!orderChartRef.value) return
  const chart = echarts.init(orderChartRef.value)

  chart.setOption({
    title: { text: '订单状态分布', left: 'center' },
    tooltip: { trigger: 'item' },
    legend: { bottom: 0 },
    series: [
      {
        type: 'pie',
        radius: '55%',
        data: [
          { value: 120, name: '已完成' },
          { value: 89, name: '运输中' },
          { value: 47, name: '待发货' }
        ]
      }
    ]
  })
}

/** ====== 仓库库存情况 ====== */
function initWarehouseChart() {
  if (!warehouseChartRef.value) return
  const chart = echarts.init(warehouseChartRef.value)

  chart.setOption({
    title: { text: '仓库库存分布', left: 'center' },
    tooltip: {},
    xAxis: {
      type: 'category',
      data: ['北京仓', '上海仓', '广州仓', '深圳仓']
    },
    yAxis: { type: 'value' },
    series: [
      {
        type: 'bar',
        data: [320, 540, 210, 180]
      }
    ]
  })
}
</script>

<style scoped>
.dashboard {
  padding: 20px;
  background: #f5f7fa;
}

/* 顶部指标卡 */
.stat-cards {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 16px;
  margin-bottom: 20px;
}

.card {
  background: #fff;
  padding: 16px;
  border-radius: 6px;
}

.label {
  font-size: 14px;
  color: #666;
}

.value {
  font-size: 28px;
  font-weight: bold;
  margin-top: 8px;
}

.warning {
  color: #fa8c16;
}

.danger {
  color: #f5222d;
}

/* 图表 */
.charts {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 16px;
}

.chart {
  height: 360px;
  background: #fff;
  border-radius: 6px;
}
</style>
