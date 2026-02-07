import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import path from 'path'

export default defineConfig({
  plugins: [vue()],
  server: {
    port: 3000, // 前端启动端口
    open: true, // 启动后自动打开浏览器
    proxy: {
      // 接口代理，解决跨域（核心！）
      '/api': {
        target: 'http://localhost:8080', // 后端地址
        changeOrigin: true,
        rewrite: (path) => path // 保留/api前缀，和后端一致
      }
    }
  },
  resolve: {
    // 路径别名，@指向src目录
    alias: {
      '@': path.resolve(__dirname, 'src')
    }
  }
})