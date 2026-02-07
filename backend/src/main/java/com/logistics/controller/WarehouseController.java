package com.logistics.controller;

import com.logistics.entity.WarehouseStock;
import com.logistics.service.WarehouseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

/**
 * 仓库管理接口
 */
@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    
    @Resource
    private WarehouseService warehouseService;
    
    /**
     * 查询所有库存
     */
    @GetMapping("/stockList")
    public Result<List<WarehouseStock>> getStockList() {
        List<WarehouseStock> list = warehouseService.list();
        return Result.success(list);
    }
    
    /**
     * 查询库存预警商品
     */
    @GetMapping("/warnStockList")
    public Result<List<WarehouseStock>> getWarnStockList() {
        List<WarehouseStock> list = warehouseService.getWarnStockList();
        return Result.success(list);
    }
    
    /**
     * 按仓库统计库存
     */
    @GetMapping("/sumByWarehouse")
    public Result<?> sumByWarehouse() {
        return Result.success(warehouseService.sumStockByWarehouse());
    }
}