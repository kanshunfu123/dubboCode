package com.xiaowei.sys.platform.core.common.dal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysRoleAclDO;
import java.util.List;
import com.xiaowei.sys.platform.core.common.dal.mapper.SysRoleAclDOMapper;

/**
* The Table sys_role_acl.
* 角色和权限中间表
*/
@Repository
public class SysRoleAclDAO{

    @Autowired
    private SysRoleAclDOMapper sysRoleAclDOMapper;

    /**
     * desc:插入表:sys_role_acl.<br/>
     * @param entity entity
     * @return int
     */
    public int insert(SysRoleAclDO entity){
        return sysRoleAclDOMapper.insert(entity);
    }
    /**
     * desc:批量插入表:sys_role_acl.<br/>
     * @param list list
     * @return int
     */
    public int insertBatch(List<SysRoleAclDO> list){
        return sysRoleAclDOMapper.insertBatch(list);
    }
    /**
     * desc:根据主键删除数据:sys_role_acl.<br/>
     * @param id id
     * @return int
     */
    public int deleteById(Long id){
        return sysRoleAclDOMapper.deleteById(id);
    }
    /**
     * desc:根据主键获取数据:sys_role_acl.<br/>
     * @param id id
     * @return SysRoleAclDO
     */
    public SysRoleAclDO getById(Long id){
        return sysRoleAclDOMapper.getById(id);
    }
    /**
     * desc:根据角色id查询角色权限.<br/>
     * @param sysRoleId sysRoleId
     * @return List<SysRoleAclDO>
     */
    public List<SysRoleAclDO> findRoleAclByRoleId(Long sysRoleId){
        return sysRoleAclDOMapper.findRoleAclByRoleId(sysRoleId);
    }
    /**
     * desc:根据角色uuid查询角色权限.<br/>
     * @param sysRoleAclUuid sysRoleAclUuid
     * @return SysRoleAclDO
     */
    public SysRoleAclDO findRoleAclByUuid(String sysRoleAclUuid){
        return sysRoleAclDOMapper.findRoleAclByUuid(sysRoleAclUuid);
    }
    /**
     * desc:根据角色uuid和roleId查询角色权限是否存在.<br/>
     * @param sysRoleId sysRoleId
     * @param sysRoleAclUuid sysRoleAclUuid
     * @return SysRoleAclDO
     */
    public SysRoleAclDO findRoleAclByUuidAndRoleId(Long sysRoleId,String sysRoleAclUuid){
        return sysRoleAclDOMapper.findRoleAclByUuidAndRoleId(sysRoleId, sysRoleAclUuid);
    }
    /**
     * desc:根据角色id删除角色权限.<br/>
     * @param sysRoleId sysRoleId
     * @return int
     */
    public int deleteByRoleId(Long sysRoleId){
        return sysRoleAclDOMapper.deleteByRoleId(sysRoleId);
    }
    /**
     * desc:根据角色编号查询角色权限的uuid.<br/>
     * @param sysRoleId sysRoleId
     * @return List<String>
     */
    public List<String> finddUuidByRoleId(Long sysRoleId){
        return sysRoleAclDOMapper.finddUuidByRoleId(sysRoleId);
    }
    /**
     * desc:根据角色id删除角色权限.<br/>
     * @param sysRoleId sysRoleId
     * @param sysRoleAclUuid sysRoleAclUuid
     * @return int
     */
    public int deleteRoleAclByUuidAndRoleId(Long sysRoleId,String sysRoleAclUuid){
        return sysRoleAclDOMapper.deleteRoleAclByUuidAndRoleId(sysRoleId, sysRoleAclUuid);
    }
    /**
     * desc:根据角色id列表查询权限点id列表.<br/>
     * @param list list
     * @return List<SysRoleAclDO>
     */
    public List<SysRoleAclDO> getAclIdListByRoleIdList(List<SysRoleAclDO> list){
        return sysRoleAclDOMapper.getAclIdListByRoleIdList(list);
    }
}
