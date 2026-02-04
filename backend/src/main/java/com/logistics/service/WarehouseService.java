package com.logistics.service;

import com.logistics.entity.WarehouseStock;
import com.logistics.mapper.WarehouseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService {

    private final WarehouseMapper warehouseMapper;

    public WarehouseService(WarehouseMapper warehouseMapper) {
        this.warehouseMapper = warehouseMapper;
    }

    public List<WarehouseStock> getAllStocks() {
        return warehouseMapper.selectAll();
    }
}
