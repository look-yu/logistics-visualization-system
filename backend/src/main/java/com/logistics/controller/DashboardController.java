package com.logistics.controller;

import com.logistics.service.OrderService;
import com.logistics.service.WarehouseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DashboardController {

    private final OrderService orderService;
    private final WarehouseService warehouseService;

    public DashboardController(OrderService orderService,
                               WarehouseService warehouseService) {
        this.orderService = orderService;
        this.warehouseService = warehouseService;
    }

    @GetMapping("/dashboard/order-status")
    public List<Map<String, Object>> orderStatus() {
        return orderService.getOrderStatusStats();
    }

    @GetMapping("/dashboard/warehouse-stock")
    public Object warehouseStock() {
        return warehouseService.getAllStocks();
    }
}
