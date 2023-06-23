package com.middle.ccs.order.service.impl;

import com.middle.ccs.order.dao.BoxDetailServiceMapper;
import com.middle.ccs.order.dao.BoxServiceMapper;
import com.middle.ccs.order.dao.OrderServiceMapper;
import com.middle.ccs.order.entity.dto.BoxMainDTO;
import com.middle.ccs.order.entity.po.BoxDetail;
import com.middle.ccs.order.entity.po.BoxMain;
import com.middle.ccs.order.entity.po.OrderMain;
import com.middle.ccs.order.entity.vo.BoxDetailVO;
import com.middle.ccs.order.service.BoxService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 功能描述: (对外提供预约信息的中台接口)
 * @author 文亮
 * @since 2022年5月13日14:07:01
 */
@Service
@Slf4j
public class BoxServiceImpl implements BoxService {

    @Resource
    private BoxServiceMapper boxServiceMapper;

    @Resource
    private BoxDetailServiceMapper boxDetailServiceMapper;

    @Resource
    private OrderServiceMapper orderServiceMapper;

    /**
     * 保存
     * @return 保存成功行数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer save(List<BoxMainDTO> boxMainDTO) {
        int i = 0;
        for (BoxMainDTO entity: boxMainDTO) {
            BoxMain boxMain = new BoxMain();
            BeanUtils.copyProperties(entity, boxMain);
            i = boxServiceMapper.insert(boxMain);
            if(i != 1) {
                throw new RuntimeException();
            }
            List<BoxDetail> boxDetailList = entity.getTurnsInfoList();
            for (BoxDetail boxDetail : boxDetailList) {
                boxDetail.setBoxImitateId(entity.getBoxImitateId());
                i = boxDetailServiceMapper.insert(boxDetail);
                if(i != 1) {
                    throw new RuntimeException();
                }
            }
        }
        // 更新订单状态
        OrderMain orderMain = new OrderMain();
        orderMain.setOrderId(boxMainDTO.get(0).getOrderId());
        orderMain.setOrderStatus(400);
        i = this.orderServiceMapper.updateById(orderMain);
//        if(i != 1) {
//            throw new RuntimeException();
//        }
        return i;
    }

    /**
     * 获取今日0~9999编号
     * @return 编号
     */
    @Override
    public Integer getId() {
        return boxServiceMapper.getId();
    }

    /**
     * 获取箱报告数据
     * @return
     */
    @Override
    public List<BoxDetailVO> getBoxReport() {
        // 整表关联
        return boxServiceMapper.getBoxReport();
    }
}
