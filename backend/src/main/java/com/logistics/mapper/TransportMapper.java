package com.logistics.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.logistics.entity.TransportTask;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

/**
 * 运输任务数据访问接口
 */
@Mapper
public interface TransportMapper extends BaseMapper<TransportTask> {
    /**
     * 按运输方式统计任务数量
     */
    List<Map<String, Object>> countTaskByTransportType();
    
    /**
     * 按状态统计运输任务
     */
    List<Map<String, Object>> countTaskByStatus();
}