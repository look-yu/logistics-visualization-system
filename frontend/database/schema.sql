#建库 + 建表（结构）


-- =========================
-- 1. 创建数据库
-- =========================
CREATE DATABASE IF NOT EXISTS logistics_db
CHARACTER SET utf8mb4
COLLATE utf8mb4_general_ci;

USE logistics_db;

-- =========================
-- 2. 订单信息表
-- =========================
CREATE TABLE IF NOT EXISTS order_info (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
    order_no VARCHAR(50) NOT NULL COMMENT '订单编号',
    customer_name VARCHAR(100) COMMENT '客户名称',
    order_status VARCHAR(20) COMMENT '订单状态',
    origin VARCHAR(100) COMMENT '发货地',
    destination VARCHAR(100) COMMENT '目的地',
    create_time DATETIME COMMENT '创建时间',
    delivery_time DATETIME COMMENT '完成时间',
    is_deleted TINYINT DEFAULT 0 COMMENT '逻辑删除',
    INDEX idx_order_no (order_no),
    INDEX idx_order_status (order_status)
) COMMENT='物流订单表';

-- =========================
-- 3. 仓储库存表
-- =========================
CREATE TABLE IF NOT EXISTS warehouse_stock (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
    warehouse_name VARCHAR(100) COMMENT '仓库名称',
    product_name VARCHAR(100) COMMENT '货物名称',
    stock_quantity INT COMMENT '库存数量',
    warning_threshold INT COMMENT '预警阈值',
    update_time DATETIME COMMENT '更新时间'
) COMMENT='仓储库存表';

-- =========================
-- 4. 运输任务表
-- =========================
CREATE TABLE IF NOT EXISTS transport_task (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
    order_id BIGINT COMMENT '关联订单ID',
    vehicle_no VARCHAR(50) COMMENT '车辆编号',
    driver_name VARCHAR(50) COMMENT '司机姓名',
    transport_status VARCHAR(20) COMMENT '运输状态',
    start_time DATETIME COMMENT '开始时间',
    end_time DATETIME COMMENT '结束时间',
    INDEX idx_order_id (order_id),
    INDEX idx_transport_status (transport_status)
) COMMENT='运输任务表';

-- =========================
-- 5. 车辆信息表
-- =========================
CREATE TABLE IF NOT EXISTS vehicle_info (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
    vehicle_no VARCHAR(50) COMMENT '车辆编号',
    vehicle_type VARCHAR(50) COMMENT '车辆类型',
    capacity INT COMMENT '载重能力',
    status VARCHAR(20) COMMENT '车辆状态'
) COMMENT='车辆信息表';

-- =========================
-- 6. 操作日志表
-- =========================
CREATE TABLE IF NOT EXISTS operation_log (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
    operator VARCHAR(50) COMMENT '操作人',
    operation VARCHAR(255) COMMENT '操作内容',
    operation_time DATETIME COMMENT '操作时间'
) COMMENT='系统操作日志表';
