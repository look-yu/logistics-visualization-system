package com.logistics.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.logistics.entity.TransportTask;
import com.logistics.service.TransportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

/**
 * 运输管理接口
 */
@RestController
@RequestMapping("/transport")
public class TransportController {
    
    @Resource
    private TransportService transportService;
    
    /**
     * 查询所有运输任务
     */
    @GetMapping("/taskList")
    public Result<List<TransportTask>> getTaskList() {
        List<TransportTask> list = transportService.list();
        return Result.success(list);
    }
    
    /**
     * 按订单号查询运输任务
     */
    @GetMapping("/taskByOrderNo/{orderNo}")
    public Result<List<TransportTask>> getTaskByOrderNo(@PathVariable String orderNo) {
        QueryWrapper<TransportTask> wrapper = new QueryWrapper<>();
        wrapper.eq("order_no", orderNo);
        List<TransportTask> list = transportService.list(wrapper);
        return Result.success(list);
    }
    
    /**
     * 按状态查询运输任务
     */
    @GetMapping("/taskByStatus/{status}")
    public Result<List<TransportTask>> getTaskByStatus(@PathVariable Integer status) {
        QueryWrapper<TransportTask> wrapper = new QueryWrapper<>();
        wrapper.eq("status", status);
        List<TransportTask> list = transportService.list(wrapper);
        return Result.success(list);
    }
}