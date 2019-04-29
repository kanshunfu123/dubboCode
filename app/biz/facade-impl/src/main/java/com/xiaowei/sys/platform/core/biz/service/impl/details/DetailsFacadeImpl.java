package com.xiaowei.sys.platform.core.biz.service.impl.details;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaowei.sys.platform.core.facade.service.facade.details.DetailsFacade;
import com.xiaowei.sys.platform.core.facade.service.req.details.DetailsReq;
import com.xiaowei.sys.platform.core.service.manager.details.DetailsService;
import com.yeecli.component.common.model.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by WingsChan on 2018/9/7.
 */
@Service(version = "1.0.0", provider = "dubboProvider")
public class DetailsFacadeImpl implements DetailsFacade {
    @Autowired
    DetailsService detailsService;

    @Override
    public Result<Boolean> addDetailsInfo(DetailsReq addReqs) {
        detailsService.addDetailsInfo(addReqs);
        return Result.wrapSuccessfulResult(true);
    }
}
