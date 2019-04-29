package com.xiaowei.sys.platform.core.service.manager.sysuser;

import com.xiaowei.sys.platform.core.common.dal.dao.SysLoginLogDAO;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysLoginLogDO;
import com.xiaowei.sys.platform.core.facade.service.req.sysuser.DeptUserReq;
import com.xiaowei.sys.platform.core.facade.service.vo.sysuser.DeptUser;
import com.xiaowei.sys.platform.core.facade.service.vo.sysuser.GetUserInfiByUuidVO;
import com.xiaowei.sys.platform.core.facade.service.req.sysuser.SysUserReq;
import com.xiaowei.sys.platform.core.facade.service.req.sysuser.SysUserUpdateReq;
import com.xiaowei.sys.platform.core.facade.service.req.sysuser.UserDeptAreaRolesPageReq;
import com.xiaowei.sys.platform.core.facade.service.vo.sysuser.SysUserVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysuser.UserDeptAreaRolesPageVO;
import com.yeecli.component.common.model.Result;

import java.util.List;

/**
 * Created by MOMO on 2018/9/11.
 */
public interface SysUserService {
    /**
     * 登录日志
     * @param sysLoginLogDAO
     * @return
     */
    public Result insertLoginLog(SysLoginLogDO sysLoginLogDAO);

    /**
     * 目前根据手机号登录，系统设计可邮箱登录
     *
     * @param sysUserReq
     * @return
     */
    public Result<SysUserVO> loginByUsername(SysUserReq sysUserReq);

    /**
     * 分页查询出  用户、用属于哪个部门、哪个区域、哪个角色
     *
     * @param userDeptAreaRolesPageReq
     * @return
     */
    public Result<UserDeptAreaRolesPageVO> userDeptAreaRolesList(UserDeptAreaRolesPageReq userDeptAreaRolesPageReq);

    /**
     * 根据用户uuid查看 用户信息
     *
     * @param userUuid
     * @return
     */
    public Result<GetUserInfiByUuidVO> getUserInfiByUuid(String userUuid);

    /**
     * 更新用户
     *
     * @return
     */
    public Result<Object> updateUser(SysUserUpdateReq sysUserUpdateReq);

    /**
     * 删除用户
     *
     * @return
     */
    public Result<Object> delUser(SysUserUpdateReq sysUserUpdateReq);

    /**
     * 新增用户
     *
     * @param sysUserUpdateReq
     * @return
     */
    public Result<Object> insertUser(SysUserUpdateReq sysUserUpdateReq);

    /**
     * 根据用户的uuid 得到子部门的员工，最后一级部门只可以查看自己的数据
     * @param deptUserReq
     * @return
     */
    public Result<List<DeptUser>> getChildDeptUserssByUserUuid(DeptUserReq deptUserReq);
}
