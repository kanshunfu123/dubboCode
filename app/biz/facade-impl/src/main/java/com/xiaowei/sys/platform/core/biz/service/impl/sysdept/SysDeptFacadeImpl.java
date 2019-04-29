package com.xiaowei.sys.platform.core.biz.service.impl.sysdept;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaowei.sys.platform.core.facade.service.facade.sysdept.SysDeptFacade;
import com.xiaowei.sys.platform.core.facade.service.req.sysdept.SysDeptReq;
import com.xiaowei.sys.platform.core.facade.service.vo.sysdept.SysDeptTreeVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysdept.SysDeptVO;
import com.xiaowei.sys.platform.core.service.exception.ErrorEnum;
import com.xiaowei.sys.platform.core.service.manager.sysdept.SysDeptService;
import com.yeecli.component.common.model.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by MOMO on 2018/9/11.
 */
@Service(version = "1.0.0",provider = "dubboProvider")
public class SysDeptFacadeImpl implements SysDeptFacade {
private Logger logger=Logger.getLogger(SysDeptFacadeImpl.class);
    @Autowired
    private SysDeptService sysDeptService;


    @Override
    public Result<List<SysDeptTreeVO>> deptTreeList() {

       try {
           return sysDeptService.deptTreeList();
       }catch (Exception e){
           logger.error(e.getMessage(), e);
           return Result.wrapErrorResult(ErrorEnum.ERROR_DEPT_TREE_FAIL.getErrorCode(),ErrorEnum.ERROR_DEPT_TREE_FAIL.getErrorMessage());
       }
    }

    @Override
    public Result<Object> insertDept(SysDeptReq sysDeptReq) {
        try {
          return   sysDeptService.insertDept(sysDeptReq);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_ADD_DEPT_FAIL.getErrorCode(),ErrorEnum.ERROR_ADD_DEPT_FAIL.getErrorMessage());
        }
    }

    @Override
    public Result<Object> updateDept(SysDeptReq sysDeptReq) {
        try {
            return sysDeptService.updateDept(sysDeptReq);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_EDIT_DEPT_FAIL.getErrorCode(),ErrorEnum.ERROR_EDIT_DEPT_FAIL.getErrorMessage());
        }
    }

    @Override
    public Result<Object> delDept(SysDeptReq sysDeptReq) {
        try {
           return sysDeptService.delDept(sysDeptReq);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_DELL_DEPT_FAIL.getErrorCode(),ErrorEnum.ERROR_DELL_DEPT_FAIL.getErrorMessage());
        }
    }

    @Override
    public Result<SysDeptVO> getDeptInfoByUuid(String deptUuid) {
        try {
            return sysDeptService.getDeptInfoByUuid(deptUuid);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_DELL_DEPT_FAIL.getErrorCode(),ErrorEnum.ERROR_DELL_DEPT_FAIL.getErrorMessage());
        }
    }
}
