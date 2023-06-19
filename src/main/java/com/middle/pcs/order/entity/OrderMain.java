package com.middle.pcs.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @classDesc: 实体类:(OrderMain)
 * @author: makejava
 * @date: 2023-06-09 01:36:55
 */
@Data
@TableName("order_main")
public class OrderMain  {
    private static final long serialVersionUID = -14336138781844056L;
    /**
    * 主键
    */    
    @TableId
    private Long orderId;
            
    /**
    * 订单编号
    */    
    private Long orderNo;
                
    /**
    * 订单名称
    */    
    private String orderName;
                
    /**
    * 是否翻转，0不翻转，1翻转
    */    
    private String revertFlag;
                
    /**
    * 批次编号
    */    
    private Long batchId;
                
    /**
    * 产品名称
    */    
    private String productName;
                
    /**
    * 加速器k值
    */    
    private String acceleratorKValue;
                
    /**
    * 工艺名称
    */    
    private String artName;
                
    /**
    * 装载方式
    */    
    private String loadMethod;
                
    /**
    * 路径名称
    */    
    private String pathName;
                
    /**
    * 圈数
    */    
    private Integer numberTurns;
                
    /**
    * 箱子长度
    */    
    private BigDecimal boxLength;
                
    /**
    * 箱子宽度
    */    
    private BigDecimal boxWidth;
                
    /**
    * 箱子高度
    */    
    private BigDecimal boxHeight;
                
    /**
    * 箱子重量
    */    
    private BigDecimal boxWeight;
                
    /**
    * 束流上限
    */    
    private String slUpperLimit;
                
    /**
    * 束流设定值
    */    
    private String slSet;
                
    /**
    * 束流下限值
    */    
    private String slLowerLimit;
                
    /**
    * 功率上限
    */    
    private String glUpperLimit;
                
    /**
    * 功率设定值
    */    
    private String glSet;
                
    /**
    * 功率下限值
    */    
    private String glLowerLimit;
                
    /**
    * 扫宽上限
    */    
    private String skUpperLimit;
                
    /**
    * 扫宽设定值
    */    
    private String skSet;
                
    /**
    * 扫宽下限值
    */    
    private String skLowerLimit;
                
    /**
    * 扫描频率上限
    */    
    private String smplUpperLimit;
                
    /**
    * 扫描频率设定值
    */    
    private String smplSet;
                
    /**
    * 扫描频率下限值
    */    
    private String smplLowerLimit;
                
    /**
    * PFN电压上限
    */    
    private String pfnUpperLimit;
                
    /**
    * PFN电压设定值
    */    
    private String pfnSet;
                
    /**
    * PFN电压下限值
    */    
    private String pfnLowerLimit;
                
    /**
    * 能量上限
    */    
    private String nlUpperLimit;
                
    /**
    * 能量设定值
    */    
    private String nlSet;
                
    /**
    * 能量下限值
    */    
    private String nlLowerLimit;
                
    /**
    * 订单箱数
    */    
    private Integer orderBoxNum;
                
    /**
    * 剔除箱数
    */    
    private Integer eliminateBoxNum;
                
    /**
    * 上货箱数
    */    
    private Integer exhibitBoxNum;
                
    /**
    * 合格箱数
    */    
    private Integer qualifiedBoxNum;

    /**
     * 束下速度
     */
    private String sxSpeedSet;

}
