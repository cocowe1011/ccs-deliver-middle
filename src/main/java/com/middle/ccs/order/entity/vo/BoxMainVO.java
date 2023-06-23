package com.middle.ccs.order.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

@Data
public class BoxMainVO {
    /**
     * 任务编号,暂定为订单表主键id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long orderId;

    /**
     * 订单日期，订单表创建日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date create_time;

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
     * 批次编号
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long batchId;


}
