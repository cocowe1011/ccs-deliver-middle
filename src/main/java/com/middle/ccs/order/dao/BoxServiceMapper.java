package com.middle.ccs.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.middle.ccs.order.entity.dto.ReportListDTO;
import com.middle.ccs.order.entity.po.BoxMain;
import com.middle.ccs.order.entity.vo.BoxDetailVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 功能描述: (对外提供预约信息的中台接口)
 * @author 文亮
 * @since 2022年5月13日14:07:01
 */
@Mapper
public interface BoxServiceMapper extends BaseMapper<BoxMain> {
    /**
     * 获取今日箱子上货数
     * @return 上货数量
     */
    Integer getId();

    /**
     * 获取箱报告模板
     * @param reportListDTO
     * @return
     */
    List<BoxDetailVO> getBoxReport(ReportListDTO reportListDTO);
}
