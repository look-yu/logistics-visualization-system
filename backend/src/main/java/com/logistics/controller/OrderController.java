package com.logistics.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.logistics.entity.Order;
import com.logistics.service.OrderService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * 订单管理接口
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    
    @Resource
    private OrderService orderService;
    
    /**
     * 查询所有订单
     */
    @GetMapping("/list")
    public Result<List<Order>> getOrderList() {
        List<Order> list = orderService.list();
        return Result.success(list);
    }
    
    /**
     * 按状态查询订单
     */
    @GetMapping("/listByStatus/{status}")
    public Result<List<Order>> getOrderByStatus(@PathVariable Integer status) {
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.eq("status", status);
        List<Order> list = orderService.list(wrapper);
        return Result.success(list);
    }
    
    /**
     * 更新订单状态
     */
    @PostMapping("/updateStatus")
    public Result<?> updateOrderStatus(@RequestParam Long id, @RequestParam Integer status) {
        Order order = new Order();
        order.setId(id);
        order.setStatus(status);
        boolean success = orderService.updateById(order);
        if (success) {
            return Result.success(null);
        } else {
            return Result.error("更新订单状态失败");
        }
    }
    
    /**
     * 根据ID查询订单
     */
    @GetMapping("/getById/{id}")
    public Result<Order> getOrderById(@PathVariable Long id) {
        Order order = orderService.getById(id);
        return Result.success(order);
    }
}