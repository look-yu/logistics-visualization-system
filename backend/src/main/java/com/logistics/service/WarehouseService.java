package com.logistics.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.logistics.entity.WarehouseStock;
import com.logistics.mapper.WarehouseMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 仓库库存业务逻辑层
 */
@Service
public class WarehouseService extends ServiceImpl<WarehouseMapper, WarehouseStock> {
    
    @Resource
    private WarehouseMapper warehouseMapper;
    
    /**
     * 按仓库统计库存总量
     */
    public List<Map<String, Object>> sumStockByWarehouse() {
        return warehouseMapper.sumStockByWarehouse();
    }
    
    /**
     * 查询库存预警商品
     */
    public List<WarehouseStock> getWarnStockList() {
        return warehouseMapper.getWarnStockList();
    }
}