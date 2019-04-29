package com.xiaowei.sys.platform.core.biz.service.impl.standard;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaowei.sys.platform.core.facade.service.facade.standard.StandardFacade;
import com.xiaowei.sys.platform.core.facade.service.req.standard.*;
import com.xiaowei.sys.platform.core.facade.service.vo.standard.StandardEditVO;
import com.xiaowei.sys.platform.core.facade.service.vo.standard.StandardPaginVO;
import com.xiaowei.sys.platform.core.facade.service.vo.standard.standByNamePagingVO;
import com.xiaowei.sys.platform.core.service.exception.ErrorEnum;
import com.xiaowei.sys.platform.core.service.manager.standard.StandardService;
import com.yeecli.component.common.model.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by WingsChan on 2018/9/7.
 */
@Service(version = "1.0.0", provider = "dubboProvider")
public class StandardFacadeImpl implements StandardFacade {
    private Logger logger = Logger.getLogger(StandardFacadeImpl.class);
    @Autowired
    StandardService standardService;
    /**
     *
     * @param standardInfo
     * @return根据uuid查询standard表
     */
    @Override
    public Result<StandardEditVO> getstandardByUuid(StandardInfo standardInfo) {
        try{
            return standardService.getstandardByUuid(standardInfo);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_STANDARD_FAND_FAIL.getErrorCode(), ErrorEnum.ERROR_STANDARD_FAND_FAIL.getErrorMessage());
        }

    }

    /**
     *
     * @param standardInfo
     * @return(uuid删除)
     */
    @Override
    public Result<Object> deleteStandard(StandardInfo standardInfo) {
            return standardService.deleteStandardByUuid(standardInfo);
    }



    /**
     *
     * @param reqAdd
     * @return修改
     */
    @Override
    public Result<Object> updateStandard(StandardReqAdd reqAdd) {
        return standardService.updateStandard(reqAdd);
    }
    /**
     *
     * @param standardPageReq
     * @return分页查询
     */
    @Override
    public Result<StandardPaginVO> standardPageList(StandardPageReq standardPageReq) {
        return Result.wrapSuccessfulResult(standardService.standardPageList(standardPageReq));
    }

    @Override
    public Result<standByNamePagingVO> standByNamePaging(StandByNamePagingReq standByNamePagingReq) {
        try {
            return standardService.standByNamePaging(standByNamePagingReq);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_STAND_PAGE_FAIL.getErrorCode(), ErrorEnum.ERROR_STAND_PAGE_FAIL.getErrorMessage());
        }
    }
}
