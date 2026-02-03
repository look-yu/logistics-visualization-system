
<template>
  <div ref="chartRef" style="height: 400px;"></div>
</template>

<script setup lang="ts">
import { onMounted, ref } from 'vue'
import * as echarts from 'echarts'
import { getWarehouseStockStats } from '@/api/dashboard'

const chartRef = ref<HTMLDivElement | null>(null)

onMounted(async () => {
  const chart = echarts.init(chartRef.value!)
  const res = await getWarehouseStockStats()

  chart.setOption({
    title: { text: '仓库库存情况' },
    xAxis: {
      type: 'category',
      data: res.data.map(item => item.warehouse_name)
    },
    yAxis: { type: 'value' },
    series: [{
      type: 'bar',
      data: res.data.map(item => item.stock_quantity)
    }]
  })
})
</script>
