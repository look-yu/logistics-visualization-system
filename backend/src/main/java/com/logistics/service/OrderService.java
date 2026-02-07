package com.logistics.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.logistics.entity.Order;
import com.logistics.mapper.OrderMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 订单业务逻辑层
 */
@Service
public class OrderService extends ServiceImpl<OrderMapper, Order> {
    
    @Resource
    private OrderMapper orderMapper;
    
    /**
     * 按状态统计订单数量
     */
    public List<Map<String, Object>> countOrderByStatus() {
        return orderMapper.countOrderByStatus();
    }
    
    /**
     * 按仓库统计订单数量
     */
    public List<Map<String, Object>> countOrderByWarehouse() {
        return orderMapper.countOrderByWarehouse();
    }
}