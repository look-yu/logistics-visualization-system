package com.logistics.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.logistics.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

/**
 * 订单数据访问接口
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    /**
     * 按状态统计订单数量（可视化用）
     */
    List<Map<String, Object>> countOrderByStatus();
    
    /**
     * 按仓库统计订单数量
     */
    List<Map<String, Object>> countOrderByWarehouse();
}