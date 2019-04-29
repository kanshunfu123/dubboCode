package com.xiaowei.sys.platform.core.biz.service.impl.sysarea;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaowei.sys.platform.core.facade.service.facade.sysarea.SysAreaFacade;
import com.xiaowei.sys.platform.core.facade.service.req.sysarea.GetByUuidReq;
import com.xiaowei.sys.platform.core.facade.service.req.sysarea.SysAreaParentIdReq;
import com.xiaowei.sys.platform.core.facade.service.vo.sysarea.GetByUuidVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysarea.SysAreaAddVo;
import com.xiaowei.sys.platform.core.facade.service.vo.sysarea.SysAreaListVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysarea.SysAreaParentIdVo;
import com.xiaowei.sys.platform.core.service.exception.ErrorEnum;
import com.xiaowei.sys.platform.core.service.manager.sysarea.SysAreaService;
import com.yeecli.component.common.model.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by MOMO on 2018/9/17.
 */
@Service(version = "1.0.0", provider = "dubboProvider")
public class SysAreaFacadeImpl implements SysAreaFacade {

    private Logger logger = Logger.getLogger(SysAreaFacadeImpl.class);
    @Autowired
    private SysAreaService areaTreeList;

    @Override
    public Result<List<SysAreaListVO>> areaTreeList() {
        try {
            return areaTreeList.areaTreeList();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_AREA_TREE_FAIL.getErrorCode(), ErrorEnum.ERROR_AREA_TREE_FAIL.getErrorMessage());
        }
    }

    @Override
    public Result<Object> insertSysArea(SysAreaAddVo sysAreaAddVo) {
        try {
            return areaTreeList.insertSysArea(sysAreaAddVo);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_ADD_AREA_TREE_FAIL.getErrorCode(), ErrorEnum.ERROR_ADD_AREA_TREE_FAIL.getErrorMessage());
        }

    }

    @Override
    public Result<Object> editSysArea(SysAreaAddVo sysAreaAddVo) {
        try {
            return areaTreeList.editSysArea(sysAreaAddVo);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_EDIT_AREA_TREE_FAIL.getErrorCode(), ErrorEnum.ERROR_EDIT_AREA_TREE_FAIL.getErrorMessage());
        }
    }

    @Override
    public Result<Object> delSysArea(SysAreaAddVo sysAreaAddVo) {
        try {
            return areaTreeList.delSysArea(sysAreaAddVo);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_DEL_AREA_TREE_FAIL.getErrorCode(), ErrorEnum.ERROR_DEL_AREA_TREE_FAIL.getErrorMessage());
        }
    }

    @Override
    public Result<List<SysAreaParentIdVo>> getareaListByParentId(SysAreaParentIdReq sysAreaParentIdReq) {
        try {
            return areaTreeList.getareaListByParentId(sysAreaParentIdReq);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_CHILD_AREA_LIST_FAIL.getErrorCode(), ErrorEnum.ERROR_CHILD_AREA_LIST_FAIL.getErrorMessage());
        }
    }

    @Override
    public Result<GetByUuidVO> getByUuid(GetByUuidReq getByUuidReq) {
        try {
            return areaTreeList.getByUuid(getByUuidReq);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_AREA_UUID_INFO_FAIL.getErrorCode(), ErrorEnum.ERROR_AREA_UUID_INFO_FAIL.getErrorMessage());
        }
    }

    @Override
    public Result<GetByUuidVO> getByIdId(GetByUuidReq getByUuidReq) {
        try {
            return areaTreeList.getByIdId(getByUuidReq);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_AREA_ID_INFO_FAIL.getErrorCode(), ErrorEnum.ERROR_AREA_ID_INFO_FAIL.getErrorMessage());
        }
    }
}