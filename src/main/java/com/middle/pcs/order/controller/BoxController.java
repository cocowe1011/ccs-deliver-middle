package com.middle.pcs.order.controller;

import com.middle.pcs.hander.ResponseResult;
import com.middle.pcs.order.entity.dto.BoxMainDTO;
import com.middle.pcs.order.entity.po.BoxMain;
import com.middle.pcs.order.service.BoxService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 箱子操作控制层
 * @author 文亮
 */
@RestController
@RequestMapping("/box")
public class BoxController {

    @Resource
    private BoxService boxService;

    /**
     * 保存
     * @param boxMainDTO 保存
     * @return 出参
     */
    @RequestMapping("/save")
    public ResponseResult<Integer> save(@RequestBody List<BoxMainDTO> boxMainDTO) {
        return ResponseResult.success(boxService.save(boxMainDTO));
    }

    /**
     * 获取今日0~9999编号
     * @return 编号
     */
    @RequestMapping("/getId")
    public ResponseResult<Integer> getId() {
        return ResponseResult.success(boxService.getId());
    }
}
