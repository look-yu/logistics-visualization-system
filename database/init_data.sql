#初始化数据（INSERT）

USE logistics_db;

-- 订单数据
USE logistics_db;



INSERT INTO order_info
(order_no, customer_name, order_status, origin, destination, create_time, delivery_time)
VALUES
-- 最近 30 天订单（用于趋势图）
('ORD1001','客户A','待发货','北京','上海',NOW()-INTERVAL 30 DAY,NULL),
('ORD1002','客户B','运输中','广州','深圳',NOW()-INTERVAL 29 DAY,NULL),
('ORD1003','客户C','已完成','杭州','南京',NOW()-INTERVAL 28 DAY,NOW()-INTERVAL 26 DAY),
('ORD1004','客户D','异常','成都','重庆',NOW()-INTERVAL 27 DAY,NULL),

('ORD1005','客户A','已完成','北京','天津',NOW()-INTERVAL 25 DAY,NOW()-INTERVAL 23 DAY),
('ORD1006','客户B','运输中','上海','苏州',NOW()-INTERVAL 24 DAY,NULL),
('ORD1007','客户C','待发货','武汉','长沙',NOW()-INTERVAL 23 DAY,NULL),
('ORD1008','客户D','已完成','西安','郑州',NOW()-INTERVAL 22 DAY,NOW()-INTERVAL 20 DAY),

('ORD1009','客户A','异常','广州','佛山',NOW()-INTERVAL 20 DAY,NULL),
('ORD1010','客户B','已完成','南京','合肥',NOW()-INTERVAL 19 DAY,NOW()-INTERVAL 17 DAY),

-- 最近一周（Dashboard 今日/本周统计）
('ORD1051','客户X','待发货','北京','上海',NOW()-INTERVAL 6 DAY,NULL),
('ORD1052','客户Y','运输中','广州','深圳',NOW()-INTERVAL 5 DAY,NULL),
('ORD1053','客户Z','已完成','杭州','南京',NOW()-INTERVAL 4 DAY,NOW()-INTERVAL 2 DAY),
('ORD1054','客户M','异常','成都','重庆',NOW()-INTERVAL 3 DAY,NULL),
('ORD1055','客户N','运输中','上海','苏州',NOW()-INTERVAL 2 DAY,NULL),
('ORD1056','客户P','待发货','武汉','长沙',NOW()-INTERVAL 1 DAY,NULL),
('ORD1057','客户Q','已完成','北京','天津',NOW(),NOW());


-- 仓储库存数据


INSERT INTO warehouse_stock
(warehouse_name, product_name, stock_quantity, warning_threshold, update_time)
VALUES
('北京仓库','电子产品',120,50,NOW()),
('北京仓库','食品',40,60,NOW()),      -- ⚠ 预警
('上海仓库','服装',300,100,NOW()),
('上海仓库','日用品',80,100,NOW()),   -- ⚠ 预警
('广州仓库','电子产品',200,80,NOW()),
('广州仓库','食品',150,60,NOW()),
('成都仓库','机械配件',30,50,NOW()),  -- ⚠ 预警
('武汉仓库','医疗物资',500,200,NOW());


-- 运输任务数据DELETE FROM transport_task;


INSERT INTO transport_task
(order_id, vehicle_no, driver_name, transport_status, start_time, end_time)
VALUES
(1,'京A10001','张三','已完成',NOW()-INTERVAL 5 DAY,NOW()-INTERVAL 3 DAY),
(2,'粤B20002','李四','运输中',NOW()-INTERVAL 2 DAY,NULL),
(3,'沪C30003','王五','异常',NOW()-INTERVAL 4 DAY,NULL),
(4,'川D40004','赵六','已完成',NOW()-INTERVAL 6 DAY,NOW()-INTERVAL 4 DAY),
(5,'鄂E50005','孙七','运输中',NOW()-INTERVAL 1 DAY,NULL);
(order_id, vehicle_no, driver_name, transport_status, start_time, end_time)
VALUES
(1,'京A10001','张三','已完成',NOW()-INTERVAL 5 DAY,NOW()-INTERVAL 3 DAY),
(2,'粤B20002','李四','运输中',NOW()-INTERVAL 2 DAY,NULL),
(3,'沪C30003','王五','异常',NOW()-INTERVAL 4 DAY,NULL),
(4,'川D40004','赵六','已完成',NOW()-INTERVAL 6 DAY,NOW()-INTERVAL 4 DAY),
(5,'鄂E50005','孙七','运输中',NOW()-INTERVAL 1 DAY,NULL);


-- 车辆信息数据
INSERT INTO vehicle_info
(vehicle_no, vehicle_type, capacity, status)
VALUES
('京A10001','厢式货车',5000,'空闲'),
('粤B20002','冷链车',3000,'在途'),
('沪C30003','平板车',8000,'维修'),
('川D40004','厢式货车',6000,'空闲'),
('鄂E50005','冷链车',4000,'在途');

