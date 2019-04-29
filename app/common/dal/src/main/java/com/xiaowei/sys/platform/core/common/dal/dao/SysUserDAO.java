package com.xiaowei.sys.platform.core.common.dal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysUserDO;
import com.xiaowei.sys.platform.core.common.dal.paging.UserDeptAreaRolesPage;
import com.xiaowei.sys.platform.core.common.dal.resultmap.userRoleSArea;
import java.util.List;
import com.xiaowei.sys.platform.core.common.dal.mapper.SysUserDOMapper;

/**
* The Table SYS_USER.
* 用户
*/
@Repository
public class SysUserDAO{

    @Autowired
    private SysUserDOMapper sysUserDOMapper;

    /**
     * desc:插入表:SYS_USER.<br/>
     * @param entity entity
     * @return int
     */
    public int insert(SysUserDO entity){
        return sysUserDOMapper.insert(entity);
    }
    /**
     * desc:更新表:SYS_USER.<br/>
     * @param entity entity
     * @return int
     */
    public int update(SysUserDO entity){
        return sysUserDOMapper.update(entity);
    }
    /**
     * desc:根据主键删除数据:SYS_USER.<br/>
     * @param id id
     * @return int
     */
    public int deleteById(Long id){
        return sysUserDOMapper.deleteById(id);
    }
    /**
     * desc:根据主键获取数据:SYS_USER.<br/>
     * @param id id
     * @return SysUserDO
     */
    public SysUserDO getById(Long id){
        return sysUserDOMapper.getById(id);
    }
    /**
     * desc:根据主键获取数据:SYS_USER.<br/>
     * @param sysUserUuid sysUserUuid
     * @return SysUserDO
     */
    public SysUserDO getByUuid(String sysUserUuid){
        return sysUserDOMapper.getByUuid(sysUserUuid);
    }
    /**
     * desc:根据手机号/邮箱登录.<br/>
     * @param sysUserEmail sysUserEmail
     * @param sysUserPhone sysUserPhone
     * @return SysUserDO
     */
    public SysUserDO loginByUsername(String sysUserEmail,String sysUserPhone){
        return sysUserDOMapper.loginByUsername(sysUserEmail, sysUserPhone);
    }
    /**
     * desc:根据部门id查询该部门是否有用户.<br/>
     * @param deptId deptId
     * @return int
     */
    public int userCountByDeptId(Long deptId){
        return sysUserDOMapper.userCountByDeptId(deptId);
    }
    /**
     * desc:多条件查询用户信息，部门、携带部门、角色、区域.<br/>
     * @param userDeptAreaRoles userDeptAreaRoles
     * @return UserDeptAreaRolesPage
     */
    public UserDeptAreaRolesPage userPaging(UserDeptAreaRolesPage userDeptAreaRoles){
        int total = sysUserDOMapper.userPagingCount(userDeptAreaRoles);
        if(total>0){
            userDeptAreaRoles.setDatas(sysUserDOMapper.userPagingResult(userDeptAreaRoles));
        }
        userDeptAreaRoles.setTotal(total);
        return userDeptAreaRoles;
    }
    /**
     * desc:根据用户uuid查看 用户信息.<br/>
     * @param sysUserUuid sysUserUuid
     * @return userRoleSArea
     */
    public userRoleSArea getUserInfiByUuid(String sysUserUuid){
        return sysUserDOMapper.getUserInfiByUuid(sysUserUuid);
    }
    /**
     * desc:新增/编辑 用户名、邮箱唯一.<br/>
     * @param uuid uuid
     * @param email email
     * @param phone phone
     * @return int
     */
    public int checkPhoneORemailUniqueness(String uuid,String email,String phone){
        return sysUserDOMapper.checkPhoneORemailUniqueness(uuid, email, phone);
    }
    /**
     * desc:更新用户.<br/>
     * @param entity entity
     * @return int
     */
    public int updateUser(SysUserDO entity){
        return sysUserDOMapper.updateUser(entity);
    }
    /**
     * desc:新增用户.<br/>
     * @param entity entity
     * @return int
     */
    public int insertUser(SysUserDO entity){
        return sysUserDOMapper.insertUser(entity);
    }
    /**
     * desc:根据部门id集合查询用户列表.<br/>
     * @param list list
     * @return List<SysUserDO>
     */
    public List<SysUserDO> getUserListByDeptIds(List<SysUserDO> list){
        return sysUserDOMapper.getUserListByDeptIds(list);
    }
    /**
     * desc:测试用户手动输入排序.<br/>
     * @param entity entity
     * @return List<SysUserDO>
     */
    public List<SysUserDO> testUserOrderByParams(SysUserDO entity){
        return sysUserDOMapper.testUserOrderByParams(entity);
    }
}
