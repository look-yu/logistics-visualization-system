package com.logistics.controller;

import com.logistics.service.OrderService;
import com.logistics.service.TransportService;
import com.logistics.service.WarehouseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 可视化看板接口
 */
@RestController
@RequestMapping("/dashboard")
public class DashboardController {
    
    @Resource
    private OrderService orderService;
    
    @Resource
    private WarehouseService warehouseService;
    
    @Resource
    private TransportService transportService;
    
    /**
     * 获取看板首页所有数据
     */
    @GetMapping("/homeData")
    public Result<Map<String, Object>> getHomeData() {
        Map<String, Object> data = new HashMap<>();
        // 订单状态统计
        data.put("orderStatusData", orderService.countOrderByStatus());
        // 仓库库存统计
        data.put("warehouseStockData", warehouseService.sumStockByWarehouse());
        // 运输任务状态统计
        data.put("transportStatusData", transportService.countTaskByStatus());
        return Result.success(data);
    }
    
    /**
     * 获取订单按仓库统计数据
     */
    @GetMapping("/orderByWarehouse")
    public Result<?> getOrderByWarehouse() {
        return Result.success(orderService.countOrderByWarehouse());
    }
    
    /**
     * 获取运输方式统计数据
     */
    @GetMapping("/transportByType")
    public Result<?> getTransportByType() {
        return Result.success(transportService.countTaskByTransportType());
    }
}