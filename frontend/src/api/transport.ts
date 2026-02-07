import request from '@/utils/request'

/**
 * 查询所有运输任务
 */
export const getTaskList = () => {
  return request.get('/transport/taskList')
}

/**
 * 按订单号查询运输任务
 */
export const getTaskByOrderNo = (orderNo: string) => {
  return request.get(`/transport/taskByOrderNo/${orderNo}`)
}

/**
 * 按状态查询运输任务（0-未开始 1-运输中 2-已完成）
 */
export const getTaskByStatus = (status: number) => {
  return request.get(`/transport/taskByStatus/${status}`)
}