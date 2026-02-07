<!-- src/App.vue -->
<template>
  <!-- 先写纯文本，验证是否渲染 -->
  <div class="app-container">
    <h1>物流可视化系统（测试）</h1>
    <div>侧边导航</div>
    <div>
      <router-view /> <!-- 路由出口 -->
    </div>
  </div>
</template>

<script setup lang="ts">
// 清空所有复杂逻辑，只保留基础
</script>

<style scoped>
/* 简单样式，确保元素显示 */
.app-container {
  width: 100%;
  height: 100vh;
  margin: 0;
  padding: 20px;
}
</style>