package com.xiaowei.sys.platform.core.biz.service.impl.common;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaowei.sys.platform.core.facade.service.facade.common.ProvincesFacade;
import com.xiaowei.sys.platform.core.facade.service.req.common.ProvincesReq;
import com.xiaowei.sys.platform.core.facade.service.vo.common.ProvincesVO;
import com.xiaowei.sys.platform.core.service.exception.ErrorEnum;
import com.xiaowei.sys.platform.core.service.manager.common.ProvincesService;
import com.yeecli.component.common.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by MOMO on 2018/10/31.
 */
@Service(version = "1.0.0", provider = "dubboProvider")
public class ProvincesFacadeImpl implements ProvincesFacade {
    private Logger logger= LoggerFactory.getLogger(ProvincesFacadeImpl.class) ;
    @Autowired
    private ProvincesService provincesService;

    @Override
    public Result<ProvincesVO> provinces(ProvincesReq provincesReq) {
        try {
            return provincesService.provinces(provincesReq);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_PRIVANCES_FAIL.getErrorCode(), ErrorEnum.ERROR_PRIVANCES_FAIL.getErrorMessage());
        }
    }
}
