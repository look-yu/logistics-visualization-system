import request from '@/utils/request'

/**
 * 查询所有库存
 */
export const getStockList = () => {
  return request.get('/warehouse/stockList')
}

/**
 * 查询库存预警商品（库存≤预警值）
 */
export const getWarnStockList = () => {
  return request.get('/warehouse/warnStockList')
}

/**
 * 按仓库统计库存总量
 */
export const sumByWarehouse = () => {
  return request.get('/warehouse/sumByWarehouse')
}