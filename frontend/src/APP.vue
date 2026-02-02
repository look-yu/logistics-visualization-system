<template>
  <div class="layout">
    <!-- 顶部栏 -->
    <header class="header">
      <div class="logo">🚚 物流管理系统</div>
      <div class="user">管理员</div>
    </header>

    <div class="body">
      <!-- 左侧菜单 -->
      <aside class="sidebar">
        <ul>
          <li class="active">📊 数据看板</li>
          <li>📦 订单管理</li>
          <li>🏬 仓储管理</li>
          <li>🚛 运输管理</li>
          <li>⚙ 系统设置</li>
        </ul>
      </aside>

      <!-- 主内容区 -->
      <main class="content">
        <h2>数据总览</h2>

        <div class="cards">
          <div class="card">
            <p class="title">今日订单</p>
            <p class="value">128</p>
          </div>

          <div class="card">
            <p class="title">在途车辆</p>
            <p class="value">23</p>
          </div>

          <div class="card">
            <p class="title">仓库库存</p>
            <p class="value">5,420</p>
          </div>

          <div class="card">
            <p class="title">异常订单</p>
            <p class="value warn">3</p>
          </div>
        </div>

        <div class="placeholder">
          📈 后续这里接入 ECharts 图表
        </div>
      </main>
    </div>
  </div>
</template>

<script setup lang="ts">
</script>

<style scoped>
.layout {
  height: 100vh;
  display: flex;
  flex-direction: column;
  font-family: "Segoe UI", Arial, sans-serif;
}

/* 顶部 */
.header {
  height: 56px;
  background: #1f2937;
  color: #fff;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 24px;
}

.logo {
  font-size: 18px;
  font-weight: bold;
}

.user {
  font-size: 14px;
}

/* 主体 */
.body {
  flex: 1;
  display: flex;
  background: #f5f7fa;
}

/* 侧边栏 */
.sidebar {
  width: 200px;
  background: #111827;
  color: #cbd5e1;
}

.sidebar ul {
  list-style: none;
  padding: 0;
  margin: 0;
}

.sidebar li {
  padding: 14px 20px;
  cursor: pointer;
}

.sidebar li.active,
.sidebar li:hover {
  background: #1f2937;
  color: #fff;
}

/* 内容区 */
.content {
  flex: 1;
  padding: 24px;
}

.cards {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 16px;
  margin: 20px 0;
}

.card {
  background: #fff;
  padding: 20px;
  border-radius: 6px;
  box-shadow: 0 2px 6px rgba(0,0,0,0.05);
}

.card .title {
  color: #6b7280;
  font-size: 14px;
}

.card .value {
  font-size: 28px;
  font-weight: bold;
  margin-top: 8px;
}

.card .warn {
  color: #dc2626;
}

.placeholder {
  margin-top: 30px;
  height: 240px;
  background: #fff;
  border-radius: 6px;
  display: flex;
  align-items: center;
  justify-content: center;
  color: #9ca3af;
  font-size: 16px;
}
</style>
