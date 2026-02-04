package com.logistics.service;

import com.logistics.entity.Order;
import com.logistics.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    private final OrderMapper orderMapper;

    public OrderService(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public List<Order> getAllOrders() {
        return orderMapper.selectAll();
    }

    public List<Map<String, Object>> getOrderStatusStats() {
        return orderMapper.countByStatus();
    }
}
