package com.xiaowei.sys.platform.core.service.manager.sysrole;

import com.xiaowei.sys.platform.core.common.dal.dataobject.SysRoleDO;
import com.xiaowei.sys.platform.core.facade.service.req.sysrole.*;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.RoleListPageVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.SysAllRoleVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.roleacl.AclModuleLevelDtoVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.roleacl.RoleAndAclVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysuser.SysUserRoleMenuVO;
import com.yeecli.component.common.model.Result;

import java.util.List;

/**
 * Created by MOMO on 2018/9/17.
 */
public interface SysRoleService {

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
    public Result<RoleAndAclVO> roleAndAclsTree(String sysRoleUuid, RoleMmmpGG roleMmmpGG);

    /**
     * //根据用户id查询对应菜单
     *
     * @param userId
     * @return
     */
    public List<AclModuleLevelDtoVO> userAclTree(Long userId, RoleMmmpGG roleMmmpGG);

    /**
     * 动态权限菜单列表 最终
     *
     * @param userId
     * @return
     */
    public Result<SysUserRoleMenuVO> userRoleMenu(Long userId, RoleMmmpGG roleMmmpGG);

    /**
     * 删除用户信息
     */
    public Result<Object> delByUuid(SysRoleReq sysRoleReq);

    /**
     * 添加角色信息
     */
    public Result<Object> addSysRole(AddSysRoleReq addSysRoleReq);

    /**
     * 修改角色信息
     */
    public Result<Object> editSysRole(EditSysRoleReq editSysRoleReq);

    /**
     * 查询全部角色
     *
     * @return
     */
    public Result<List<SysAllRoleVO>> getAllRoleListByNoParam();

}
