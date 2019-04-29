package com.xiaowei.sys.platform.core.common.dal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysAclDO;
import java.util.List;
import com.xiaowei.sys.platform.core.common.dal.mapper.SysAclDOMapper;

/**
* The Table sys_acl.
* 权限点表
*/
@Repository
public class SysAclDAO{

    @Autowired
    private SysAclDOMapper sysAclDOMapper;

    /**
     * desc:插入表:sys_acl.<br/>
     * @param entity entity
     * @return int
     */
    public int insert(SysAclDO entity){
        return sysAclDOMapper.insert(entity);
    }
    /**
     * desc:批量插入表:sys_acl.<br/>
     * @param list list
     * @return int
     */
    public int insertBatch(List<SysAclDO> list){
        return sysAclDOMapper.insertBatch(list);
    }
    /**
     * desc:根据主键删除数据:sys_acl.<br/>
     * @param id id
     * @return int
     */
    public int deleteById(Long id){
        return sysAclDOMapper.deleteById(id);
    }
    /**
     * desc:根据主键获取数据:sys_acl.<br/>
     * @param id id
     * @return SysAclDO
     */
    public SysAclDO getById(Long id){
        return sysAclDOMapper.getById(id);
    }
    /**
     * desc:判断用户是否有权限访问系统资源.<br/>
     * @param url url
     * @return List<SysAclDO>
     */
    public List<SysAclDO> getByUrl(String url){
        return sysAclDOMapper.getByUrl(url);
    }
    /**
     * desc:根据权限点列表查询权限列表.<br/>
     * @param sysRoleId sysRoleId
     * @return List<SysAclDO>
     */
    public List<SysAclDO> getRoleListByAcls(Long sysRoleId){
        return sysAclDOMapper.getRoleListByAcls(sysRoleId);
    }
    /**
     * desc:获得所有权限列表.<br/>
     * @param entity entity
     * @return List<SysAclDO>
     */
    public List<SysAclDO> getAll(SysAclDO entity){
        return sysAclDOMapper.getAll(entity);
    }
    /**
     * desc:根据权限id集合查询权限点对象的集合.<br/>
     * @param list list
     * @return List<SysAclDO>
     */
    public List<SysAclDO> getByIdList(List<SysAclDO> list){
        return sysAclDOMapper.getByIdList(list);
    }
    /**
     * desc:根据uuid查询权限点表.<br/>
     * @param sysAclUuid sysAclUuid
     * @return SysAclDO
     */
    public SysAclDO findSysAclByUuid(String sysAclUuid){
        return sysAclDOMapper.findSysAclByUuid(sysAclUuid);
    }
}
