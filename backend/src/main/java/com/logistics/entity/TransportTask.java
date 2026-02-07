package com.logistics.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.Date;

/**
 * 运输任务实体（对应数据库transport_task表）
 */
@Data
@TableName("transport_task")
public class TransportTask {
    /** 主键ID */
    @TableId(type = IdType.AUTO)
    private Long id;
    
    /** 关联订单编号 */
    private String orderNo;
    
    /** 运输方式：0-快递 1-物流 2-空运 */
    private Integer transportType;
    
    /** 运输单号 */
    private String transportNo;
    
    /** 出发地 */
    private String startAddress;
    
    /** 目的地 */
    private String endAddress;
    
    /** 运输状态：0-未开始 1-运输中 2-已完成 */
    private Integer status;
    
    /** 创建时间 */
    private Date createTime;
    
    /** 预计到达时间 */
    private Date expectArriveTime;
}