package com.logistics.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.Date;

/**
 * 订单实体（对应数据库order表）
 */
@Data
@TableName("`order`") // 解决order关键字冲突
public class Order {
    /** 主键ID */
    @TableId(type = IdType.AUTO)
    private Long id;
    
    /** 订单编号 */
    private String orderNo;
    
    /** 物流状态：0-待发货 1-运输中 2-已签收 */
    private Integer status;
    
    /** 发货仓库名称 */
    private String warehouseName;
    
    /** 收货地址 */
    private String receiveAddress;
    
    /** 创建时间 */
    private Date createTime;
    
    /** 订单金额 */
    private Double amount;
}