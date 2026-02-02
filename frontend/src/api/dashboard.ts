//前端“访问后端接口的说明书”
//告诉前端：有哪些接口,接口返回的数据长什么样
import axios from 'axios'

/**
 * Axios 实例
 * 统一配置后端地址
 */
const request = axios.create({
  baseURL: 'http://localhost:8000', // FastAPI 后端
  timeout: 5000
})

/**
 * =============================
 * 订单状态统计
 * 来源表：order_info
 * SQL 含义：
 * SELECT order_status, COUNT(*) FROM order_info GROUP BY order_status;
 * =============================
 */
export interface OrderStatusStat {
  order_status: string   // 对应 order_info.order_status
  count: number          // 订单数量
}

export const getOrderStatusStats = () => {
  return request.get<OrderStatusStat[]>(
    '/dashboard/order-status'
  )
}

/**
 * =============================
 * 仓库库存统计
 * 来源表：warehouse_stock
 * SQL 含义：
 * SELECT warehouse_name, stock_quantity FROM warehouse_stock;
 * =============================
 */
export interface WarehouseStockStat {
  warehouse_name: string   // 仓库名称
  stock_quantity: number   // 库存数量
}

export const getWarehouseStockStats = () => {
  return request.get<WarehouseStockStat[]>(
    '/dashboard/warehouse-stock'
  )
}
