package com.logistics.controller;

import com.logistics.entity.WarehouseStock;
import com.logistics.service.WarehouseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WarehouseController {

    private final WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping("/warehouse")
    public List<WarehouseStock> list() {
        return warehouseService.getAllStocks();
    }
}
