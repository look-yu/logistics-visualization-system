你这个项目 = Vue3 + TypeScript + Vite + 数据可视化（ECharts）+ 后端接口

所以插件分 5 类：

类别	插件
前端运行	Node.js / npm
构建工具	Vite
Vue 支持	@vitejs/plugin-vue
数据请求	axios
数据可视化	echarts
编辑器支持	VS Code 插件

```
backend
├─ pom.xml
└─ src
   └─ main
      ├─ java
      │  └─ com
      │     └─ logistics
      │        ├─ LogisticsApplication.java
      │        ├─ controller
      │        │  ├─ DashboardController.java
      │        │  ├─ OrderController.java
      │        │  ├─ WarehouseController.java
      │        │  └─ TransportController.java
      │        ├─ service
      │        │  ├─ OrderService.java
      │        │  ├─ WarehouseService.java
      │        │  └─ TransportService.java
      │        ├─ mapper
      │        │  ├─ OrderMapper.java
      │        │  ├─ WarehouseMapper.java
      │        │  └─ TransportMapper.java
      │        └─ entity
      │           ├─ Order.java
      │           ├─ WarehouseStock.java
      │           └─ TransportTask.java
      └─ resources
         ├─ application.yml
         └─ mapper
            ├─ OrderMapper.xml
            ├─ WarehouseMapper.xml
            └─ TransportMapper.xml