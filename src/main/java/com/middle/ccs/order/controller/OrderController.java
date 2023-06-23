package com.middle.ccs.order.controller;

import com.middle.ccs.hander.ResponseResult;
import com.middle.ccs.order.entity.dto.ReportListDTO;
import com.middle.ccs.order.entity.po.OrderMain;
import com.middle.ccs.order.entity.vo.BoxDetailVO;
import com.middle.ccs.order.entity.vo.BoxMainVO;
import com.middle.ccs.order.service.OrderService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
     * 保存方法
     * @param orderMain
     * @return
     */
    @RequestMapping("/update")
    public ResponseResult<Integer> update(@RequestBody OrderMain orderMain) {
        return ResponseResult.success(orderService.update(orderMain));
    }

    /**
     * 或者订单列表
     * @return
     */
    @RequestMapping("/getOrderList")
    public ResponseResult<List<OrderMain>> getOrderList() {
        return ResponseResult.success(orderService.getOrderList());
    }

    /**
     * 获取批报告模板
     * @return
     */
    @RequestMapping("/getOrderMainReport")
    public ResponseResult<List<OrderMain>> getOrderMainReport(@RequestBody ReportListDTO reportListDTO) {
        return ResponseResult.success(orderService.getOrderMainReport(reportListDTO));
    }

    /**
     * 查询批报告
     * @return
     */
    @RequestMapping("/getReportList")
    public ResponseResult<List<BoxMainVO>> getReportList(@RequestBody ReportListDTO reportListDTO) {
        return ResponseResult.success(orderService.getReportList(reportListDTO));
    }
}
