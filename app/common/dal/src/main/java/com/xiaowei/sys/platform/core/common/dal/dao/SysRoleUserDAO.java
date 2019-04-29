package com.xiaowei.sys.platform.core.common.dal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysRoleUserDO;
import java.util.List;
import com.xiaowei.sys.platform.core.common.dal.mapper.SysRoleUserDOMapper;

/**
* The Table sys_role_user.
* 角色和用户中间表
*/
@Repository
public class SysRoleUserDAO{

    @Autowired
    private SysRoleUserDOMapper sysRoleUserDOMapper;

    /**
     * desc:插入表:sys_role_user.<br/>
     * @param entity entity
     * @return int
     */
    public int insert(SysRoleUserDO entity){
        return sysRoleUserDOMapper.insert(entity);
    }
    /**
     * desc:批量插入表:sys_role_user.<br/>
     * @param list list
     * @return int
     */
    public int insertBatch(List<SysRoleUserDO> list){
        return sysRoleUserDOMapper.insertBatch(list);
    }
    /**
     * desc:根据主键删除数据:sys_role_user.<br/>
     * @param id id
     * @return int
     */
    public int deleteById(Long id){
        return sysRoleUserDOMapper.deleteById(id);
    }
    /**
     * desc:根据主键获取数据:sys_role_user.<br/>
     * @param id id
     * @return SysRoleUserDO
     */
    public SysRoleUserDO getById(Long id){
        return sysRoleUserDOMapper.getById(id);
    }
    /**
     * desc:批量插入用户角色.<br/>
     * @param list list
     * @return int
     */
    public int insertBatchTwo(List<SysRoleUserDO> list){
        return sysRoleUserDOMapper.insertBatchTwo(list);
    }
    /**
     * desc:批量更新用户角色.<br/>
     * @param list list
     * @return int
     */
    public int updateBatch(List<SysRoleUserDO> list){
        return sysRoleUserDOMapper.updateBatch(list);
    }
    /**
     * desc:根据用户的id查询出用户与角色的关系.<br/>
     * @param userId userId
     * @return List<SysRoleUserDO>
     */
    public List<SysRoleUserDO> getRoleAndUserListByUserid(Long userId){
        return sysRoleUserDOMapper.getRoleAndUserListByUserid(userId);
    }
    /**
     * desc:得到用户已分配的角色id.<br/>
     * @param userId userId
     * @return List<Long>
     */
    public List<Long> getRoleIdListByUserId(Long userId){
        return sysRoleUserDOMapper.getRoleIdListByUserId(userId);
    }
    /**
     * desc:根据角色id查询用户角色关系是否存在.<br/>
     * @param roleId roleId
     * @return List<SysRoleUserDO>
     */
    public List<SysRoleUserDO> findRoleUserByRoleId(Long roleId){
        return sysRoleUserDOMapper.findRoleUserByRoleId(roleId);
    }
}
