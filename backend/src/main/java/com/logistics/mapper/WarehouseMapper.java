package com.logistics.mapper;

import com.logistics.entity.WarehouseStock;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WarehouseMapper {

    List<WarehouseStock> selectAll();
}
