#初始化数据（INSERT）

USE logistics_db;

-- 订单数据
INSERT INTO order_info (order_no, customer_name, order_status, origin, destination, create_time)
VALUES
('ORD001', '客户A', '已完成', '北京', '上海', NOW()),
('ORD002', '客户B', '运输中', '广州', '深圳', NOW()),
('ORD003', '客户C', '待发货', '杭州', '南京', NOW());

-- 仓储库存数据
INSERT INTO warehouse_stock (warehouse_name, product_name, stock_quantity, warning_threshold, update_time)
VALUES
('上海仓库', '电子产品', 120, 50, NOW()),
('北京仓库', '食品', 40, 60, NOW());

-- 运输任务数据
INSERT INTO transport_task (order_id, vehicle_no, driver_name, transport_status, start_time)
VALUES
(1, '京A12345', '张三', '已完成', NOW()),
(2, '粤B54321', '李四', '运输中', NOW());
