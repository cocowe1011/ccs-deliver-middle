package com.middle.pcs.order.service.impl;

import com.middle.pcs.order.dao.OrderServiceMapper;
import com.middle.pcs.order.entity.OrderMain;
import com.middle.pcs.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 功能描述: (对外提供预约信息的中台接口)
 * @author 文亮
 * @since 2022年5月13日14:07:01
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderServiceMapper orderServiceMapper;


    @Override
    public Integer save(OrderMain orderMain) {
        return orderServiceMapper.insert(orderMain);
    }
}
