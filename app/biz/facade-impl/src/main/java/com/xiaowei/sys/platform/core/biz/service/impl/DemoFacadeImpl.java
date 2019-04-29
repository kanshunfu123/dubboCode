package com.xiaowei.sys.platform.core.biz.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaowei.sys.platform.core.facade.service.facade.DemoFacade;
import com.yeecli.component.common.model.Result;

/**
 * Created by WingsChan on 2018/9/7.
 */
@Service(version = "1.0.0",provider = "dubboProvider")
public class DemoFacadeImpl implements DemoFacade {

    @Override
    public Result<String> demo() {
        return Result.wrapSuccessfulResult("hello world");
    }
}
