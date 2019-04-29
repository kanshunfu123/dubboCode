package com.xiaowei.sys.platform.core.biz.service.impl.sysuser;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysLoginLogDO;
import com.xiaowei.sys.platform.core.facade.service.facade.sysuser.SysUserFacade;
import com.xiaowei.sys.platform.core.facade.service.req.sysrole.RoleMmmpGG;
import com.xiaowei.sys.platform.core.facade.service.req.sysuser.DeptUserReq;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.usermenu.UserIsSuperMainInfoVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysuser.*;
import com.xiaowei.sys.platform.core.facade.service.req.sysuser.SysUserReq;
import com.xiaowei.sys.platform.core.facade.service.req.sysuser.SysUserUpdateReq;
import com.xiaowei.sys.platform.core.facade.service.req.sysuser.UserDeptAreaRolesPageReq;
import com.xiaowei.sys.platform.core.service.exception.ErrorEnum;
import com.xiaowei.sys.platform.core.service.manager.sysrole.SysRoleService;
import com.xiaowei.sys.platform.core.service.manager.sysrole.hasurlacl.HasUrlAclService;
import com.xiaowei.sys.platform.core.service.manager.sysrole.usermenu.SysUserMenusServer;
import com.xiaowei.sys.platform.core.service.manager.sysuser.SysUserService;
import com.yeecli.component.common.model.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by MOMO on 2018/9/11.
 */
@Service(version = "1.0.0", provider = "dubboProvider")
public class SysUserFacadeImpl implements SysUserFacade {

    private Logger logger = Logger.getLogger(SysUserFacadeImpl.class);
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysUserMenusServer sysUserMenusServer;
    @Autowired
    private HasUrlAclService hasUrlAclService;

    @Override
    public Result insertLoginLog(SysLoginLogDO sysLoginLogDAO) {
        return sysUserService.insertLoginLog(sysLoginLogDAO);
    }

    @Override
    public Result<SysUserVO> loginByUsername(SysUserReq sysUserReq) {
        try {
            Result<SysUserVO> result = sysUserService.loginByUsername(sysUserReq);
            return result;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_USER_LOGIN_FAIL.getErrorCode(), ErrorEnum.ERROR_USER_LOGIN_FAIL.getErrorMessage());
        }
    }

    @Override
    public Result<UserDeptAreaRolesPageVO> userDeptAreaRolesList(UserDeptAreaRolesPageReq userDeptAreaRolesPageReq) {
        try {
            return sysUserService.userDeptAreaRolesList(userDeptAreaRolesPageReq);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_USER_INFO_LIST_FAIL.getErrorCode(), ErrorEnum.ERROR_USER_INFO_LIST_FAIL.getErrorMessage());
        }
    }

    @Override
    public Result<GetUserInfiByUuidVO> getUserInfiByUuid(String userUuid) {
        try {
            return sysUserService.getUserInfiByUuid(userUuid);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_LOOK_USER_INFO_FAIL.getErrorCode(), ErrorEnum.ERROR_LOOK_USER_INFO_FAIL.getErrorMessage());
        }
    }

    @Override
    public Result<Object> updateUser(SysUserUpdateReq sysUserUpdateReq) {
        try {
            return sysUserService.updateUser(sysUserUpdateReq);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_UPDATE_USER_FAIL.getErrorCode(), ErrorEnum.ERROR_UPDATE_USER_FAIL.getErrorMessage());
        }
    }

    @Override
    public Result<Object> delUser(SysUserUpdateReq sysUserUpdateReq) {
        try {
            return sysUserService.delUser(sysUserUpdateReq);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_DELL_USER_FAIL.getErrorCode(), ErrorEnum.ERROR_DELL_USER_FAIL.getErrorMessage());
        }
    }

    @Override
    public Result<Object> insertUser(SysUserUpdateReq sysUserUpdateReq) {
        try {
            return sysUserService.insertUser(sysUserUpdateReq);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_INSERT_USER_FAIL.getErrorCode(), ErrorEnum.ERROR_INSERT_USER_FAIL.getErrorMessage());
        }
    }

    @Override
    public Result<SysUserRoleMenuVO> userRoleMenu(Long userId, RoleMmmpGG roleMmmpGG) {
        try {
            return sysRoleService.userRoleMenu(userId, roleMmmpGG);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_USER_ACL_FAIL.getErrorCode(), ErrorEnum.ERROR_USER_ACL_FAIL.getErrorMessage());
        }
    }

    @Override
    public Result<List<String>> finalDynamicMenu(UserIsSuperMainInfoVO userIsSuperMainInfoVO) {
        try {
            return sysUserMenusServer.finalDynamicMenu(userIsSuperMainInfoVO);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_USER_ACL_FAIL.getErrorCode(), ErrorEnum.ERROR_USER_ACL_FAIL.getErrorMessage());
        }
    }

    @Override
    public Result<Boolean> hasUrlAcl(String url, Long userId, String userPhone) {
        try {
            return hasUrlAclService.hasUrlAcl(url, userId, userPhone);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_HAS_ACL_FAIL.getErrorCode(), ErrorEnum.ERROR_HAS_ACL_FAIL.getErrorMessage());
        }
    }

    @Override
    public Result<List<DeptUser>> getChildDeptUserssByUserUuid(DeptUserReq deptUserReq) {
        try {
            return sysUserService.getChildDeptUserssByUserUuid(deptUserReq);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_CHILD_DEPT_USER_FAIL.getErrorCode(), ErrorEnum.ERROR_CHILD_DEPT_USER_FAIL.getErrorMessage());
        }
    }
}
