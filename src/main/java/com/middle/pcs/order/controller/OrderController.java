package com.middle.pcs.order.controller;

import com.middle.pcs.hander.ResponseResult;
import com.middle.pcs.order.entity.OrderMain;
import com.middle.pcs.order.service.OrderService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 订单业务层
 * @author 文亮
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 保存方法
     * @param orderMain
     * @return
     */
    @RequestMapping("/save")
    public ResponseResult<Integer> save(@RequestBody OrderMain orderMain) {
        return ResponseResult.success(orderService.save(orderMain));
    }

    /**
     * 或者订单列表
     * @return
     */
    @RequestMapping("/getOrderList")
    public ResponseResult<List<OrderMain>> getOrderList() {
        return ResponseResult.success(orderService.getOrderList());
    }
}
