package com.xiaowei.sys.platform.core.facade.service.facade.sysrole;

import com.xiaowei.sys.platform.core.facade.service.req.sysrole.*;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.RoleListPageVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.RoleMenuVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.SysAllRoleVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.roleacl.AclModuleLevelDtoVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.roleacl.RoleAndAclVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.roleacl.SysAclVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.usermenu.AclModuleLevelMenuDtoVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.usermenu.UserIsSuperMainInfoVO;
import com.yeecli.component.common.model.Result;

import java.util.List;

/**
 * Created by MOMO on 2018/9/17.
 */
public interface SysRoleFacade {
    /**
     * 分页查询 角色列表
     *
     * @param sysRolePageReq
     * @return
     */
    public Result<RoleListPageVO> roleListPage(SysRolePageReq sysRolePageReq);

    /**
     * 该角色在整个权限的所拥有的权限
     *
     * @param sysRoleUuid
     * @return
     */
    public Result<RoleAndAclVO> roleTree(String sysRoleUuid, RoleMmmpGG roleMmmpGG);

    /**
     * 根据用户id查询对应菜单
     *
     * @param userId
     * @return
     */
    public Result<List<AclModuleLevelDtoVO>> userAclTree(Long userId, RoleMmmpGG roleMmmpGG);

    /**
     * 编辑角色时的权限列表---> 新增
     *
     * @return
     */
    public Result<List<AclModuleLevelDtoVO>> roleEDITTree(String sysRoleUuid, RoleMmmpGG roleMmmpGG);

    /**
     * 动态菜单按钮===============》》废弃
     */
    public Result<List<AclModuleLevelMenuDtoVO>> dynamicMenu(UserIsSuperMainInfoVO userIsSuperMainInfoVO);

    /**
     * 删除角色信息
     */
    public Result<Object> delByUuid(SysRoleReq sysRoleReq);

    /**
     * 添加角色信息
     */
    public Result<Object> addSysRole(AddSysRoleReq addSysRoleReq);

    /*修改角色用户信息*/
    public Result<Object> editSysRole(EditSysRoleReq editSysRoleReq);

    /**
     * 查询全部角色
     *
     * @return
     */
    public Result<List<SysAllRoleVO>> getAllRoleListByNoParam();

    /**
     * 根据当前用户uuid 查询角色列表
     */
    public Result<List<RoleMenuVO>> getRoleListByRoleUUID(UserIsSuperMainInfoVO userIsSuperMainInfoVO);
}
