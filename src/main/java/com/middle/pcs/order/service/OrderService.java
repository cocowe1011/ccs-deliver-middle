package com.middle.pcs.order.service;


import com.middle.pcs.order.entity.OrderMain;

import java.util.HashMap;
import java.util.List;

/**
 * 功能描述: 订单业务逻辑层
 * @author 文亮
 * @since 2023年06月09日01:31:21
 */
public interface OrderService {
    Integer save(OrderMain orderMain);
}
