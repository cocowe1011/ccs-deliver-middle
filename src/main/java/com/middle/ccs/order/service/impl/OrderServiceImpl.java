package com.middle.ccs.order.service.impl;

import com.middle.ccs.order.dao.OrderServiceMapper;
import com.middle.ccs.order.entity.dto.OrderMainSaveDTO;
import com.middle.ccs.order.entity.dto.ReportListDTO;
import com.middle.ccs.order.entity.po.OrderMain;
import com.middle.ccs.order.entity.vo.BoxMainVO;
import com.middle.ccs.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    /**
     * 保存
     * @return
     */
    @Override
    public Integer save(OrderMainSaveDTO orderMainSaveDTO) {
        OrderMain orderMain = new OrderMain();
        BeanUtils.copyProperties(orderMainSaveDTO, orderMain);
        return orderServiceMapper.insert(orderMain);
    }

    /**
     * 获取订单列表
     * @return
     */
    @Override
    public List<OrderMain> getOrderList() {
        return orderServiceMapper.getOrderList();
    }

    /**
     * 获取箱报告数据
     * @return
     */
    @Override
    public List<OrderMain> getOrderMainReport(ReportListDTO reportListDTO) {
        return orderServiceMapper.getOrderMainReport(reportListDTO);
    }

    /**
     * 更新
     * @param orderMain
     * @return
     */
    @Override
    public Integer update(OrderMain orderMain) {
        return orderServiceMapper.updateById(orderMain);
    }

    /**
     * 查询批报告
     * @param reportListDTO
     * @return
     */
    @Override
    public List<BoxMainVO> getReportList(ReportListDTO reportListDTO) {
        return orderServiceMapper.getReportList(reportListDTO);
    }
}
