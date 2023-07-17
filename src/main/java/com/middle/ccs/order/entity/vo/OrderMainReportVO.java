package com.middle.ccs.order.entity.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @classDesc: 实体类:(OrderMain)
 * @author: makejava
 * @date: 2023-06-09 01:36:55
 */
@Data
public class OrderMainReportVO {
    private static final long serialVersionUID = -14336138781844056L;
    /**
    * 主键
    */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long orderId;
            
    /**
    * 订单编号
    */
    @JsonSerialize(using = ToStringSerializer.class)
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
    @JsonSerialize(using = ToStringSerializer.class)
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
    private Integer slUpperLimit;
                
    /**
    * 束流设定值
    */    
    private Integer slSet;
                
    /**
    * 束流下限值
    */    
    private Integer slLowerLimit;
                
    /**
    * 功率上限
    */    
    private BigDecimal glUpperLimit;
                
    /**
    * 功率设定值
    */    
    private BigDecimal glSet;
                
    /**
    * 功率下限值
    */    
    private BigDecimal glLowerLimit;
                
    /**
    * 扫宽上限
    */    
    private Integer skUpperLimit;
                
    /**
    * 扫宽设定值
    */    
    private Integer skSet;
                
    /**
    * 扫宽下限值
    */    
    private Integer skLowerLimit;
                
    /**
    * 扫描频率上限
    */    
    private BigDecimal smplUpperLimit;
                
    /**
    * 扫描频率设定值
    */    
    private BigDecimal smplSet;
                
    /**
    * 扫描频率下限值
    */    
    private BigDecimal smplLowerLimit;
                
    /**
    * PFN电压上限
    */    
    private BigDecimal pfnUpperLimit;
                
    /**
    * PFN电压设定值
    */    
    private BigDecimal pfnSet;
                
    /**
    * PFN电压下限值
    */    
    private BigDecimal pfnLowerLimit;
                
    /**
    * 能量上限
    */    
    private BigDecimal nlUpperLimit;
                
    /**
    * 能量设定值
    */    
    private BigDecimal nlSet;
                
    /**
    * 能量下限值
    */    
    private BigDecimal nlLowerLimit;
                
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
    private BigDecimal sxSpeedSet;

    /**
     * 束下速度上限
     */
    private BigDecimal sxSpeedUpperLimit;

    /**
     * 束下速度下限
     */
    private BigDecimal sxSpeedLowerLimit;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 订单开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;

    /**
     * 订单开结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;

    /**
     * 束流最小值
     */
    private String slMin;
    /**
     * 束流平均值
     */
    private String slAverage;
    /**
     * 束流最大值
     */
    private String slMax;

    /**
     * 束下速度最小值
     */
    private String speedMin;
    /**
     * 束下速度平均值
     */
    private String speedAverage;
    /**
     * 束下速度最大值
     */
    private String speedMax;

    /**
     * 扫描宽度最小值
     */
    private String skMin;
    /**
     * 扫描宽度平均值
     */
    private String skAverage;
    /**
     * 扫描宽度最大值
     */
    private String skMax;

    /**
     * 功率最小值
     */
    private String glMin;
    /**
     * 功率平均值
     */
    private String glAverage;
    /**
     * 功率最大值
     */
    private String glMax;

    /**
     * 扫描频率最小值
     */
    private String smplMin;
    /**
     * 扫描频率平均值
     */
    private String smplAverage;
    /**
     * 扫描频率最大值
     */
    private String smplMax;

    /**
     * PFN电压最小值
     */
    private String pfnMin;
    /**
     * PFN电压平均值
     */
    private String pfnAverage;
    /**
     * PFN电压最大值
     */
    private String pfnMax;

    /**
     * 能量最小值
     */
    private String nlMin;
    /**
     * 能量平均值
     */
    private String nlAverage;
    /**
     * 能量最大值
     */
    private String nlMax;

    /**
     * 操作员
     */
    private String creatorName;

    /**
     * 订单总个数
     */
    private Integer orderTotal;

    /**
     * 订单合格个数
     */
    private Integer passTotal;

    /**
     * 订单不合格个数
     */
    private Integer unpassTotal;

    /**
     * 订单合格模拟id列表
     */
    private String passStr;

    /**
     * 订单不合格模拟id列表
     */
    private String unpassStr;
}
