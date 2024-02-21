package com.middle.ccs.order.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.middle.ccs.order.dao.BoxDetailServiceMapper;
import com.middle.ccs.order.dao.BoxServiceMapper;
import com.middle.ccs.order.dao.OrderServiceMapper;
import com.middle.ccs.order.entity.dto.*;
import com.middle.ccs.order.entity.po.*;
import com.middle.ccs.order.entity.vo.BoxDetailVO;
import com.middle.ccs.order.service.BoxService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
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
    public Integer save(BoxMainNewDTO boxMainNewDTO) {
        int i = 0;
        List<BoxMainDTO> boxMainDTO = boxMainNewDTO.getBoxMainDTOList();
        for (BoxMainDTO entity: boxMainDTO) {
            // 判断是更新还是新增
            BoxMain boxMainTemp = boxServiceMapper.getBoxInfoByBoxImitateId(entity);
            if(null != boxMainTemp) {
                // 已经有箱报告，把原来的箱报告和明细删除掉，在下面重新生成
                i = boxServiceMapper.deleteBoxInfoByBoxId(boxMainTemp.getBoxId());
                if(i < 1) {
                    throw new RuntimeException();
                }
                // 再把boxImitateId的明细删掉
                boxServiceMapper.deleteBoxDetailByBoxImitateId(boxMainTemp.getBoxImitateId());
            }
            // 新增
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
        // 更新订单状态,只有完成批报告才更新状态
        if(boxMainNewDTO.getFinishOrder()) {
            OrderMain orderMain = new OrderMain();
            orderMain.setOrderId(boxMainNewDTO.getOrderId());
            orderMain.setOrderStatus(400);
            orderMain.setEndTime(new Date());
            i = this.orderServiceMapper.updateById(orderMain);
        }
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
    public List<BoxDetailVO> getBoxReport(ReportListDTO reportListDTO) {
        // 整表关联
        return boxServiceMapper.getBoxReport(reportListDTO);
    }

    @Override
    public ParametersAcc getAccData() {
        return boxServiceMapper.getAccData();
    }

    @Override
    public BoxDetailVO getBoxReportLatest(ReportLatestDTO reportListDTO) {
        return boxServiceMapper.getBoxReportLatest(reportListDTO);
    }

    /**
     * 获取箱报告数据
     * @return
     */
    @Override
    public List<BoxMain> getBoxReportByOrderId(ReportListDTO reportListDTO) {
        // 整表关联
        return boxServiceMapper.getBoxInfoByOrderIdDesc(reportListDTO);
    }

    /**
     * 保存
     * @return 保存成功行数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer addBox(AddBoxDTO addBoxDTO) {
        // 查询
        BoxMain boxMain = new BoxMain();
        boxMain.setBoxImitateId(addBoxDTO.getBoxImitateId());
        QueryWrapper<BoxMain> wrapper= new QueryWrapper<>(boxMain);
        BoxMain boxMainCopy = boxServiceMapper.selectOne(wrapper);
        BoxDetail boxDetail = new BoxDetail();
        boxDetail.setBoxImitateId(addBoxDTO.getBoxImitateId());
        QueryWrapper<BoxDetail> wrapper2 = new QueryWrapper<>(boxDetail);
        List<BoxDetail> boxDetailList = boxDetailServiceMapper.selectList(wrapper2);
        // 获取一个最新的模拟id
        Integer beginNum = boxServiceMapper.getId();
        String newBoxImitateId = DateUtil.today().replaceAll("-", "").concat(StringUtils.leftPad(String.valueOf(beginNum + 1), 4, "0"));
        System.out.println(newBoxImitateId);
        // 替换新的模拟id，插入
        boxMainCopy.setBoxImitateId(newBoxImitateId);
        boxMainCopy.setBoxId(null);
        int i = boxServiceMapper.insert(boxMainCopy);
        if(i != 1) {
            throw new RuntimeException();
        }
        for (BoxDetail item : boxDetailList) {
            item.setBoxImitateId(newBoxImitateId);
            item.setBoxDetailId(null);
            i = boxDetailServiceMapper.insert(item);
            if(i != 1) {
                throw new RuntimeException();
            }
        }
        return i;
    }

    /**
     * 通过箱子模拟id删除
     * @param deleteBoxDTO 入参
     * @return 出参
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer deleteBox(DeleteBoxDTO deleteBoxDTO) {
        BoxMain boxMain = new BoxMain();
        boxMain.setBoxImitateId(deleteBoxDTO.getBoxImitateId());
        QueryWrapper<BoxMain> wrapper= new QueryWrapper<>(boxMain);
        boxServiceMapper.delete(wrapper);
        BoxDetail boxDetail = new BoxDetail();
        boxDetail.setBoxImitateId(deleteBoxDTO.getBoxImitateId());
        QueryWrapper<BoxDetail> wrapper2 = new QueryWrapper<>(boxDetail);
        boxDetailServiceMapper.delete(wrapper2);
        return 1;
    }

    /**
     * 修改箱子信息
     * @param boxMain 入参
     * @return 出参
     */
    @Override
    public Integer update(BoxMain boxMain) {
        return boxServiceMapper.updateById(boxMain);
    }
}
