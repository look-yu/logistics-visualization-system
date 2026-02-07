import request from '@/utils/request'

/**
 * 获取看板首页所有数据（订单+仓库+运输）
 */
export const getHomeData = () => {
  return request.get('/dashboard/homeData')
}

/**
 * 获取订单按仓库统计数据
 */
export const getOrderByWarehouse = () => {
  return request.get('/dashboard/orderByWarehouse')
}

/**
 * 获取运输方式统计数据
 */
export const getTransportByType = () => {
  return request.get('/dashboard/transportByType')
}