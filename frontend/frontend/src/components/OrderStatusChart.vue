<template>
  <div ref="chartRef" style="height: 400px;"></div>
</template>

<script setup lang="ts">
import { onMounted, ref } from 'vue'
import * as echarts from 'echarts'
import { getOrderStatusStats } from '@/api/dashboard'

const chartRef = ref<HTMLDivElement | null>(null)

onMounted(async () => {
  const chart = echarts.init(chartRef.value!)
  const res = await getOrderStatusStats()

  chart.setOption({
    title: { text: '订单状态分布' },
    series: [{
      type: 'pie',
      data: res.data.map(item => ({
        name: item.order_status,   // ✅ 对应 order_info.order_status
        value: item.count          // ✅ COUNT(*)
      }))
    }]
  })
})
</script>
