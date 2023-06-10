package com.middle.pcs.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.middle.pcs.order.entity.OrderMain;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * 功能描述: (对外提供预约信息的中台接口)
 * @author 文亮
 * @since 2022年5月13日14:07:01
 */
@Mapper
public interface OrderServiceMapper extends BaseMapper<OrderMain> {

    /**
     * 获取订单列表
     * @return
     */
    List<OrderMain> getOrderList();
}
