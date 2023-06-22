package com.middle.pcs.order.service;


import com.middle.pcs.order.entity.dto.BoxMainDTO;

import java.util.List;

/**
 * 功能描述: 箱子业务逻辑层
 * @author 文亮
 * @since 2023年06月09日01:31:21
 */
public interface BoxService {
    /**
     * 保存
     * @param boxMainDTO 保存
     * @return 出参
     */
    Integer save(List<BoxMainDTO> boxMainDTO);

    /**
     * 获取今日0~9999编号
     * @return 编号
     */
    Integer getId();
}
