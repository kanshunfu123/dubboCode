package com.xiaowei.sys.platform.core.biz.service.impl.parameter;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaowei.sys.platform.core.facade.service.facade.parameter.ParameterFacade;
import com.xiaowei.sys.platform.core.facade.service.req.parameter.ParameterByIdsReq;
import com.xiaowei.sys.platform.core.facade.service.req.parameter.ParameterByUuidReq;
import com.xiaowei.sys.platform.core.facade.service.req.parameter.ParameterPageList;
import com.xiaowei.sys.platform.core.facade.service.vo.parameter.ParameterAddVO;
import com.xiaowei.sys.platform.core.facade.service.vo.parameter.ParameterByIdVO;
import com.xiaowei.sys.platform.core.facade.service.vo.parameter.ParameterByIdsVO;
import com.xiaowei.sys.platform.core.facade.service.vo.parameter.ParameterVo;
import com.xiaowei.sys.platform.core.service.exception.ErrorEnum;
import com.xiaowei.sys.platform.core.service.manager.parameter.ParameterService;
import com.yeecli.component.common.model.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by kanshunfu on2018/9/11
 */
@Service(version = "1.0.0")
public class ParameterFacadeImpl implements ParameterFacade {
    private final static Logger logger = Logger.getLogger(ParameterFacadeImpl.class);
    @Autowired
    private ParameterService parameterService;

    @Override
    public Result<Object> saveParameter(ParameterAddVO parameterAddVO) {
        try {
            return parameterService.saveParameter(parameterAddVO);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_ADD_PARAMETER_FAIL.getErrorCode(), ErrorEnum.ERROR_ADD_PARAMETER_FAIL.getErrorMessage());
        }

    }

    @Override
    public Result<Object> updateParameter(ParameterAddVO parameterAddVO) {
        try {
            return parameterService.updateParameter(parameterAddVO);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_EDIT_PARAMETER_FAIL.getErrorCode(), ErrorEnum.ERROR_EDIT_PARAMETER_FAIL.getErrorMessage());
        }

    }


    @Override
    public Result<Object> delParameter(ParameterVo parameterVo) {
        try {
            return parameterService.delParameter(parameterVo);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_DEL_PARAMETER_FAIL.getErrorCode(), ErrorEnum.ERROR_DEL_PARAMETER_FAIL.getErrorMessage());
        }

    }

    @Override
    public Result<List<ParameterVo>> getInfoByFieldValue(String fieldValue) {
        try {
            return parameterService.getInfoByFieldValue(fieldValue);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_SELECT_PARAMETER_FAIL.getErrorCode(), ErrorEnum.ERROR_SELECT_PARAMETER_FAIL.getErrorMessage());
        }

    }

    @Override
    public Result<List<ParameterByIdsVO>> getParameterByIds(List<ParameterByIdsReq> parameterByIdsReqs) {
        try {
            return parameterService.getParameterByIds(parameterByIdsReqs);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_PARMETER_ID_LIST_FAIL.getErrorCode(), ErrorEnum.ERROR_PARMETER_ID_LIST_FAIL.getErrorMessage());
        }
    }

    @Override
    public Result<ParameterVo> getInfoByUuid(ParameterByUuidReq parameterByUuidReq) {
        try {
            return parameterService.getInfoByUuid(parameterByUuidReq);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_PARMETER_INFO_BY_UUID_FAIL.getErrorCode(), ErrorEnum.ERROR_PARMETER_INFO_BY_UUID_FAIL.getErrorMessage());
        }
    }

    @Override
    public Result<ParameterByIdVO> getParameterById(Long id) {
        try{
            return parameterService.getParameterById(id);
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(),e);
        }
        return Result.wrapErrorResult(ErrorEnum.ERROR_PARMETER_INFO_BY_ID_FAIL.getErrorCode(), ErrorEnum.ERROR_PARMETER_INFO_BY_ID_FAIL.getErrorMessage());
    }
}



