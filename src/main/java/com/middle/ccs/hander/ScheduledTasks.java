package com.middle.ccs.hander;
import com.middle.ccs.order.dao.BoxServiceMapper;
import com.middle.ccs.order.dao.OrderParametersMapper;
import com.middle.ccs.order.entity.po.OrderParameters;
import com.middle.ccs.order.entity.po.ParametersAcc;
import org.springframework.beans.BeanUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author 文亮
 * @description TODO 定时器
 * @date 2024-04-2024/4/1-0:41
 */

@Component
public class ScheduledTasks {

    @Resource
    private BoxServiceMapper boxServiceMapper;
    @Resource
    private OrderParametersMapper orderParametersMapper;

    private OrderParameters orderParameters = new OrderParameters();

    @Scheduled(fixedDelay = 2000)
    public void queryDatabaseEveryTwoSeconds() {
        // 查询ccs数据库
        ParametersAcc parametersAcc = boxServiceMapper.getAccData();
        if(null != parametersAcc) {
            BeanUtils.copyProperties(parametersAcc, orderParameters);
            orderParameters.setId(9);
            orderParametersMapper.updateById(orderParameters);
        }
    }
}
