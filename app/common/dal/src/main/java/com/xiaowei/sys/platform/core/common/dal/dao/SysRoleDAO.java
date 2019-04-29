package com.xiaowei.sys.platform.core.common.dal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysRoleDO;
import java.util.List;
import com.xiaowei.sys.platform.core.common.dal.paging.RoleListPage;
import com.xiaowei.sys.platform.core.common.dal.mapper.SysRoleDOMapper;

/**
* The Table sys_role.
* 角色
*/
@Repository
public class SysRoleDAO{

    @Autowired
    private SysRoleDOMapper sysRoleDOMapper;

    /**
     * desc:插入表:sys_role.<br/>
     * @param entity entity
     * @return int
     */
    public int insert(SysRoleDO entity){
        return sysRoleDOMapper.insert(entity);
    }
    /**
     * desc:批量插入表:sys_role.<br/>
     * @param list list
     * @return int
     */
    public int insertBatch(List<SysRoleDO> list){
        return sysRoleDOMapper.insertBatch(list);
    }
    /**
     * desc:根据主键删除数据:SYS_ROLE.<br/>
     * @param id id
     * @return int
     */
    public int deleteById(Long id){
        return sysRoleDOMapper.deleteById(id);
    }
    /**
     * desc:根据主键获取数据:SYS_ROLE.<br/>
     * @param id id
     * @return SysRoleDO
     */
    public SysRoleDO getById(Long id){
        return sysRoleDOMapper.getById(id);
    }
    /**
     * desc:根据uuid获取数据:SYS_ROLE.<br/>
     * @param sysRoleUuid sysRoleUuid
     * @return SysRoleDO
     */
    public SysRoleDO getByUuid(String sysRoleUuid){
        return sysRoleDOMapper.getByUuid(sysRoleUuid);
    }
    /**
     * desc:根据用户的id查询角色信息.<br/>
     * @param uId uId
     * @return List<SysRoleDO>
     */
    public List<SysRoleDO> getRoleByUserId(Long uId){
        return sysRoleDOMapper.getRoleByUserId(uId);
    }
    /**
     * desc:根据角色uuid查询角色列表id.<br/>
     * @param list list
     * @return List<SysRoleDO>
     */
    public List<SysRoleDO> getRoleListByRoleUUID(List<String> list){
        return sysRoleDOMapper.getRoleListByRoleUUID(list);
    }
    /**
     * desc:查询全部角色.<br/>
     * @return List<SysRoleDO>
     */
    public List<SysRoleDO> getAllRoleListByNoParam(){
        return sysRoleDOMapper.getAllRoleListByNoParam();
    }
    /**
     * desc:修改用户角色.<br/>
     * @param entity entity
     * @return int
     */
    public int updateRole(SysRoleDO entity){
        return sysRoleDOMapper.updateRole(entity);
    }
    /**
     * desc:根据角色名称查询角色信息.<br/>
     * @param sysRoleName sysRoleName
     * @return SysRoleDO
     */
    public SysRoleDO findSysRoleByName(String sysRoleName){
        return sysRoleDOMapper.findSysRoleByName(sysRoleName);
    }
    /**
     * desc:修改时根据角色名称查询角色信息.<br/>
     * @param sysRoleName sysRoleName
     * @param sysRoleUuid sysRoleUuid
     * @return SysRoleDO
     */
    public SysRoleDO findSysRoleByNameAndUuid(String sysRoleName,String sysRoleUuid){
        return sysRoleDOMapper.findSysRoleByNameAndUuid(sysRoleName, sysRoleUuid);
    }
    /**
     * desc:角色列表分页.<br/>
     * @param roleList roleList
     * @return RoleListPage
     */
    public RoleListPage roleListPage(RoleListPage roleList){
        int total = sysRoleDOMapper.roleListPageCount(roleList);
        if(total>0){
            roleList.setDatas(sysRoleDOMapper.roleListPageResult(roleList));
        }
        roleList.setTotal(total);
        return roleList;
    }
    /**
     * desc:查询除自己之外是否还存在相同名称.<br/>
     * @param id id
     * @param sysRoleName sysRoleName
     * @return int
     */
    public int checkRoleName(Long id,String sysRoleName){
        return sysRoleDOMapper.checkRoleName(id, sysRoleName);
    }
}
