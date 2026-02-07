import { createApp } from 'vue'
import { createRouter, createWebHistory } from 'vue-router'
import ElementPlus from 'element-plus' // 引入ElementPlus
import 'element-plus/dist/index.css' // 引入ElementPlus样式
import * as ElementPlusIconsVue from '@element-plus/icons-vue' // 引入所有图标

import App from './App.vue'
import Dashboard from './views/Dashboard.vue'
import OrderList from './views/OrderList.vue'
import WarehouseList from './views/WarehouseList.vue'
import TransportList from './views/TransportList.vue'

// 路由配置
const routes = [
  { path: '/', redirect: '/dashboard' }, // 默认跳转到看板
  { path: '/dashboard', component: Dashboard, name: 'Dashboard' },
  { path: '/order', component: OrderList, name: 'OrderList' },
  { path: '/warehouse', component: WarehouseList, name: 'WarehouseList' },
  { path: '/transport', component: TransportList, name: 'TransportList' }
]

// 创建路由实例
const router = createRouter({
  history: createWebHistory(),
  routes
})

// 创建Vue应用
const app = createApp(App)
// 注册ElementPlus和图标
app.use(ElementPlus)
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  app.component(key, component)
}
// 注册路由
app.use(router)
// 挂载到DOM
app.mount('#app')