package com.middle.ccs.order.service;


import com.middle.ccs.order.entity.dto.BoxMainDTO;
import com.middle.ccs.order.entity.dto.BoxMainNewDTO;
import com.middle.ccs.order.entity.dto.ReportLatestDTO;
import com.middle.ccs.order.entity.dto.ReportListDTO;
import com.middle.ccs.order.entity.po.ParametersAcc;
import com.middle.ccs.order.entity.vo.BoxDetailVO;

import java.util.List;

/**
 * 功能描述: 箱子业务逻辑层
 * @author 文亮
 * @since 2023年06月09日01:31:21
 */
public interface BoxService {
    /**
     * 保存
     * @param boxMainNewDTO 保存
     * @return 出参
     */
    Integer save(BoxMainNewDTO boxMainNewDTO);

    /**
     * 获取今日0~9999编号
     * @return 编号
     */
    Integer getId();

    /**
     * 获取项报告模板
     * @param reportListDTO
     * @return
     */
    List<BoxDetailVO> getBoxReport(ReportListDTO reportListDTO);

    /**
     * 获取acc加速器数据
     * @return
     */
    ParametersAcc getAccData();

    /**
     * 获取最新一次的箱报告
     * @param reportListDTO
     * @return
     */
    BoxDetailVO getBoxReportLatest(ReportLatestDTO reportListDTO);
}
