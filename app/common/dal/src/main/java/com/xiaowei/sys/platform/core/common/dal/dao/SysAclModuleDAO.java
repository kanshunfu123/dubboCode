package com.xiaowei.sys.platform.core.common.dal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysAclModuleDO;
import java.util.List;
import com.xiaowei.sys.platform.core.common.dal.mapper.SysAclModuleDOMapper;

/**
* The Table sys_acl_module.
* 权限模块表   引入权限模块就可以很容易把菜单层级定义出来，每个菜单项下面有哪些功能就可以在权限模块下面定义权限点，然后就可以根据每个人分配到的权限生成不同的基于权限的菜单
*/
@Repository
public class SysAclModuleDAO{

    @Autowired
    private SysAclModuleDOMapper sysAclModuleDOMapper;

    /**
     * desc:插入表:sys_acl_module.<br/>
     * @param entity entity
     * @return int
     */
    public int insert(SysAclModuleDO entity){
        return sysAclModuleDOMapper.insert(entity);
    }
    /**
     * desc:批量插入表:sys_acl_module.<br/>
     * @param list list
     * @return int
     */
    public int insertBatch(List<SysAclModuleDO> list){
        return sysAclModuleDOMapper.insertBatch(list);
    }
    /**
     * desc:根据主键删除数据:sys_acl_module.<br/>
     * @param id id
     * @return int
     */
    public int deleteById(Long id){
        return sysAclModuleDOMapper.deleteById(id);
    }
    /**
     * desc:根据主键获取数据:sys_acl_module.<br/>
     * @param id id
     * @return SysAclModuleDO
     */
    public SysAclModuleDO getById(Long id){
        return sysAclModuleDOMapper.getById(id);
    }
    /**
     * desc:得到所有的权限模块.<br/>
     * @param entity entity
     * @return List<SysAclModuleDO>
     */
    public List<SysAclModuleDO> getAllAclModel(SysAclModuleDO entity){
        return sysAclModuleDOMapper.getAllAclModel(entity);
    }
    /**
     * desc:根据权限点的模块id 得到对象.<br/>
     * @param id id
     * @return SysAclModuleDO
     */
    public SysAclModuleDO getModuleByAclModuleId(Long id){
        return sysAclModuleDOMapper.getModuleByAclModuleId(id);
    }
}
