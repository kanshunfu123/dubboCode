package com.xiaowei.sys.platform.core.service.manager.sysrole.usermenu;

import com.xiaowei.sys.platform.core.common.dal.dataobject.SysRoleDO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.RoleMenuVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.usermenu.AclModuleLevelMenuDtoVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysrole.usermenu.UserIsSuperMainInfoVO;
import com.yeecli.component.common.model.Result;

import java.util.List;

/**
 * Created by 李杰 on 2018/9/20.
 */
public interface SysUserMenusServer {

    /**
     * 动态菜单按钮 ---》》》 兼容多个系统
     */
    public Result<List<AclModuleLevelMenuDtoVO>> dynamicMenu(UserIsSuperMainInfoVO userIsSuperMainInfoVO);
    /**
     * 根据当前用户uuid 查询角色列表
     */
    public Result<List<RoleMenuVO>> getRoleListByRoleUUID(UserIsSuperMainInfoVO userIsSuperMainInfoVO);

    /**
     * 动态菜单按钮 ---》》》 只兼容后台管理系统
     * @param userIsSuperMainInfoVO
     * @return
     */
    public Result<List<String>> finalDynamicMenu(UserIsSuperMainInfoVO userIsSuperMainInfoVO);
}
