package com.logistics.mapper;

import com.logistics.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {

    List<Order> selectAll();

    List<Map<String, Object>> countByStatus();
}
