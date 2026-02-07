<template>
  <div class="dashboard">
    <h2>物流数据可视化看板</h2>
    
    <!-- 图表容器：一行展示3个图表 -->
    <div class="chart-grid">
      <!-- 订单状态分布饼图 -->
      <div class="chart-card">
        <h3>订单状态分布</h3>
        <div ref="orderStatusRef" class="chart" style="width: 100%; height: 250px;"></div>
      </div>
      
      <!-- 仓库库存统计柱状图 -->
      <div class="chart-card">
        <h3>仓库库存统计</h3>
        <div ref="warehouseStockRef" class="chart" style="width: 100%; height: 250px;"></div>
      </div>
      
      <!-- 运输任务状态饼图 -->
      <div class="chart-card">
        <h3>运输任务状态</h3>
        <div ref="transportStatusRef" class="chart" style="width: 100%; height: 250px;"></div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import * as echarts from 'echarts'
import { getHomeData } from '@/api/dashboard'

// 图表容器引用
const orderStatusRef = ref<HTMLDivElement>(null)
const warehouseStockRef = ref<HTMLDivElement>(null)
const transportStatusRef = ref<HTMLDivElement>(null)

// 初始化所有图表
const initCharts = async () => {
  try {
    // 1. 获取后端数据
    const data = await getHomeData()
    
    // 2. 初始化订单状态饼图
    const orderChart = echarts.init(orderStatusRef.value!)
    orderChart.setOption({
      tooltip: { trigger: 'item' },
      series: [
        {
          name: '订单数量',
          type: 'pie',
          radius: ['40%', '70%'],
          data: data.orderStatusData,
          label: {
            show: true,
            formatter: '{b}: {c} ({d}%)' // 显示标签：名称+数量+百分比
          }
        }
      ]
    })
    
    // 3. 初始化仓库库存柱状图
    const warehouseChart = echarts.init(warehouseStockRef.value!)
    warehouseChart.setOption({
      xAxis: {
        type: 'category',
        data: data.warehouseStockData.map((item: any) => item.warehouseName)
      },
      yAxis: { type: 'value' },
      tooltip: { trigger: 'axis' },
      series: [
        {
          name: '库存总量',
          type: 'bar',
          data: data.warehouseStockData.map((item: any) => item.totalStock)
        }
      ]
    })
    
    // 4. 初始化运输任务状态饼图
    const transportChart = echarts.init(transportStatusRef.value!)
    transportChart.setOption({
      tooltip: { trigger: 'item' },
      series: [
        {
          name: '任务数量',
          type: 'pie',
          radius: ['40%', '70%'],
          data: data.transportStatusData,
          label: {
            show: true,
            formatter: '{b}: {c} ({d}%)'
          }
        }
      ]
    })
    
    // 窗口大小变化时，重新调整图表尺寸
    window.addEventListener('resize', () => {
      orderChart.resize()
      warehouseChart.resize()
      transportChart.resize()
    })
    
  } catch (error) {
    console.error('图表初始化失败：', error)
  }
}

// 页面挂载时执行初始化
onMounted(() => {
  initCharts()
})
</script>

<style scoped>
.dashboard {
  padding: 10px;
}

/* 图表网格布局 */
.chart-grid {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 20px;
  margin-top: 20px;
}

/* 图表卡片样式 */
.chart-card {
  background: #fff;
  padding: 15px;
  border-radius: 8px;
  box-shadow: 0 2px 12px rgba(0,0,0,0.1);
}

.chart-card h3 {
  margin: 0 0 10px 0;
  font-size: 16px;
  color: #333;
}
</style>