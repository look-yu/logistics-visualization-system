import axios from 'axios'

// 创建axios实例
const request = axios.create({
  baseURL: '/api', // 代理前缀，和vite.config.ts中的proxy一致
  timeout: 10000, // 请求超时时间
  headers: {
    'Content-Type': 'application/json;charset=utf-8'
  }
})

// 请求拦截器：可添加token等请求头（暂时为空，后续扩展）
request.interceptors.request.use(
  (config) => {
    return config
  },
  (error) => {
    return Promise.reject(error)
  }
)

// 响应拦截器：统一处理后端返回结果
request.interceptors.response.use(
  (response) => {
    const res = response.data
    // 后端返回的code不是200则视为失败
    if (res.code !== 200) {
      alert(res.msg || '请求失败')
      return Promise.reject(res)
    }
    // 只返回数据部分，简化前端使用
    return res.data
  },
  (error) => {
    alert('接口请求异常：' + (error.message || '网络错误'))
    return Promise.reject(error)
  }
)

export default request