package com.xiaowei.sys.platform.core.biz.service.impl.sysrole;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaowei.sys.platform.core.facade.service.facade.sysrole.SysRoleFacade;
import com.xiaowei.sys.platform.core.facade.service.req.sysrole.*;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.RoleListPageVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.RoleMenuVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.SysAllRoleVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.roleacl.AclModuleLevelDtoVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.roleacl.RoleAndAclVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.roleacl.SysAclVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.usermenu.AclModuleLevelMenuDtoVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.usermenu.UserIsSuperMainInfoVO;
import com.xiaowei.sys.platform.core.service.exception.ErrorEnum;
import com.xiaowei.sys.platform.core.service.manager.sysrole.SysRoleService;
import com.xiaowei.sys.platform.core.service.manager.sysrole.sysroleedit.SysRoleADDService;
import com.xiaowei.sys.platform.core.service.manager.sysrole.usermenu.SysUserMenusServer;
import com.yeecli.component.common.model.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by MOMO on 2018/9/17.
 */
@Service(version = "1.0.0", provider = "dubboProvider")
public class SysRoleFacadeImpl implements SysRoleFacade {
    private Logger logger = Logger.getLogger(SysRoleFacadeImpl.class);
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysRoleADDService roleADDService;
    @Autowired
    private SysUserMenusServer sysUserMenusServer;

    @Override
    public Result<RoleListPageVO> roleListPage(SysRolePageReq sysRolePageReq) {
        try {
            return sysRoleService.roleListPage(sysRolePageReq);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_ROLE_LIST_FAIL.getErrorCode(), ErrorEnum.ERROR_ROLE_LIST_FAIL.getErrorMessage());
        }
    }

    @Override
    public Result<RoleAndAclVO> roleTree(String sysRoleUuid, RoleMmmpGG roleMmmpGG) {
        try {
            Result<RoleAndAclVO> result = sysRoleService.roleAndAclsTree(sysRoleUuid, roleMmmpGG);
            return result;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_ROLE_ACL_TREE_FAIL.getErrorCode(), ErrorEnum.ERROR_ROLE_ACL_TREE_FAIL.getErrorMessage());
        }
    }

    @Override
    public Result<List<AclModuleLevelDtoVO>> userAclTree(Long userId, RoleMmmpGG roleMmmpGG) {
        try {
            return Result.wrapSuccessfulResult(sysRoleService.userAclTree(userId, roleMmmpGG));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_ROLE_ACL_MENU_TREE_FAIL.getErrorCode(), ErrorEnum.ERROR_ROLE_ACL_MENU_TREE_FAIL.getErrorMessage());
        }
    }

    @Override
    public Result<List<AclModuleLevelDtoVO>> roleEDITTree(String sysRoleUuid, RoleMmmpGG roleMmmpGG) {
        try {
            List<AclModuleLevelDtoVO> list = roleADDService.roleTree(roleMmmpGG.getUserId(), roleMmmpGG.getUserPhone());
            return Result.wrapSuccessfulResult(list);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_WATING_PERMISSION_ACL_FAIL.getErrorCode(), ErrorEnum.ERROR_WATING_PERMISSION_ACL_FAIL.getErrorMessage());
        }
    }

    @Override
    public Result<List<AclModuleLevelMenuDtoVO>> dynamicMenu(UserIsSuperMainInfoVO userIsSuperMainInfoVO) {
        try {
            return sysUserMenusServer.dynamicMenu(userIsSuperMainInfoVO);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_USER_ACL_FAIL.getErrorCode(), ErrorEnum.ERROR_USER_ACL_FAIL.getErrorMessage());
        }
    }

    /**
     * 删除角色
     */
    @Override
    public Result<Object> delByUuid(SysRoleReq sysRoleReq) {
        try {
            return sysRoleService.delByUuid(sysRoleReq);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_DELL_DEPT_FAIL.getErrorCode(), ErrorEnum.ERROR_DELL_DEPT_FAIL.getErrorMessage());
        }
    }

    /**
     * 添加角色信息
     */
    @Override
    public Result<Object> addSysRole(AddSysRoleReq addSysRoleReq) {
        return sysRoleService.addSysRole(addSysRoleReq);
    }

    /**
     * 修改角色信息
     */
    @Override
    public Result<Object> editSysRole(EditSysRoleReq editSysRoleReq) {
        return sysRoleService.editSysRole(editSysRoleReq);
    }

    @Override
    public Result<List<SysAllRoleVO>> getAllRoleListByNoParam() {
        try {
            return sysRoleService.getAllRoleListByNoParam();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_ALL_ROLE_FAIL.getErrorCode(), ErrorEnum.ERROR_ALL_ROLE_FAIL.getErrorMessage());
        }
    }

    @Override
    public Result<List<RoleMenuVO>> getRoleListByRoleUUID(UserIsSuperMainInfoVO userIsSuperMainInfoVO) {
        try {
            return sysUserMenusServer.getRoleListByRoleUUID(userIsSuperMainInfoVO);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Result.wrapErrorResult(ErrorEnum.ERROR_MENU_ROLE_FAIL.getErrorCode(), ErrorEnum.ERROR_MENU_ROLE_FAIL.getErrorMessage());
        }
    }
}
