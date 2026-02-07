package com.logistics.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.logistics.entity.TransportTask;
import com.logistics.mapper.TransportMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 运输任务业务逻辑层
 */
@Service
public class TransportService extends ServiceImpl<TransportMapper, TransportTask> {
    
    @Resource
    private TransportMapper transportMapper;
    
    /**
     * 按运输方式统计任务数量
     */
    public List<Map<String, Object>> countTaskByTransportType() {
        return transportMapper.countTaskByTransportType();
    }
    
    /**
     * 按状态统计运输任务
     */
    public List<Map<String, Object>> countTaskByStatus() {
        return transportMapper.countTaskByStatus();
    }
}