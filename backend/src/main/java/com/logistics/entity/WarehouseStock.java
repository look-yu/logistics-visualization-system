package com.logistics.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 仓库库存实体（对应数据库warehouse_stock表）
 */
@Data
@TableName("warehouse_stock")
public class WarehouseStock {
    /** 主键ID */
    @TableId(type = IdType.AUTO)
    private Long id;
    
    /** 仓库名称 */
    private String warehouseName;
    
    /** 商品名称 */
    private String goodsName;
    
    /** 商品编码 */
    private String goodsCode;
    
    /** 库存数量 */
    private Integer stockNum;
    
    /** 库存预警值 */
    private Integer warnNum;
    
    /** 最后更新时间 */
    private String updateTime;
}