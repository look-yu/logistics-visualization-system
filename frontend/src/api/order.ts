import request from '@/utils/request'

/**
 * 查询所有订单
 */
export const getOrderList = () => {
  return request.get('/order/list')
}

/**
 * 按状态查询订单（0-待发货 1-运输中 2-已签收）
 */
export const getOrderByStatus = (status: number) => {
  return request.get(`/order/listByStatus/${status}`)
}

/**
 * 更新订单状态
 */
export const updateOrderStatus = (id: number, status: number) => {
  return request.post('/order/updateStatus', { id, status })
}

/**
 * 根据ID查询订单
 */
export const getOrderById = (id: number) => {
  return request.get(`/order/getById/${id}`)
}