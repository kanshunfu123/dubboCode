package com.xiaowei.sys.platform.core.biz.service.impl.waterstandard;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaowei.sys.platform.core.facade.service.facade.waterstandard.WaterStandardFacade;
import com.xiaowei.sys.platform.core.facade.service.req.waterstandard.SaveStandardReq;
import com.xiaowei.sys.platform.core.facade.service.vo.waterstandard.SysStandardTypeVO;
import com.xiaowei.sys.platform.core.service.manager.waterstandard.WaterStandardService;
import com.yeecli.component.common.model.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version = "1.0.0", provider = "dubboProvider")
public class WaterStandardFacadeImpl implements WaterStandardFacade {
    private Logger logger = Logger.getLogger(WaterStandardFacadeImpl.class);
    @Autowired
    WaterStandardService waterStandardService;

    @Override
    public Result<Object> save(SaveStandardReq saveStandardReq) {
        return waterStandardService.save(saveStandardReq);
    }

    @Override
    public Result<List<SysStandardTypeVO>> findAllStandardType(String codeValue) {
        return waterStandardService.findAllStandardType(codeValue);
    }

    @Override
    public Result<List<SysStandardTypeVO>> findByParentValue(String parentValue) {
        return waterStandardService.findByParentValue(parentValue);
    }
}
