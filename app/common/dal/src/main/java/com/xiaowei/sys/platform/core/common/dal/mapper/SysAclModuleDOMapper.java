package com.xiaowei.sys.platform.core.common.dal.mapper;

import com.xiaowei.sys.platform.core.common.dal.dataobject.SysAclModuleDO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table sys_acl_module.
 * 权限模块表   引入权限模块就可以很容易把菜单层级定义出来，每个菜单项下面有哪些功能就可以在权限模块下面定义权限点，然后就可以根据每个人分配到的权限生成不同的基于权限的菜单
 */
public interface SysAclModuleDOMapper{

    /**
     * desc:插入表:sys_acl_module.<br/>
     * descSql =  SELECT LAST_INSERT_ID() <![CDATA[ INSERT INTO sys_acl_module( ID ,SYS_ACL_MODULE_PARENT_ID ,DEL_FLAG ,CREATE_BY ,UPDATE_BY ,SYS_ACL_MODULE_CODE ,SYS_ACL_MODULE_ICON ,SYS_ACL_MODULE_NAME ,SYS_ACL_MODULE_UUID ,SYS_ACL_MODULE_LEVEL ,SYS_ACL_MODULE_REMARK ,SYS_ACL_MODULE_SEQ ,CREATE_TIME ,UPDATE_TIME )VALUES( null , #{sysAclModuleParentId,jdbcType=BIGINT} , #{delFlag,jdbcType=CHAR} , #{createBy,jdbcType=VARCHAR} , #{updateBy,jdbcType=VARCHAR} , #{sysAclModuleCode,jdbcType=VARCHAR} , #{sysAclModuleIcon,jdbcType=VARCHAR} , #{sysAclModuleName,jdbcType=VARCHAR} , #{sysAclModuleUuid,jdbcType=VARCHAR} , #{sysAclModuleLevel,jdbcType=VARCHAR} , #{sysAclModuleRemark,jdbcType=VARCHAR} , #{sysAclModuleSeq,jdbcType=INTEGER} , #{createTime,jdbcType=TIMESTAMP} , #{updateTime,jdbcType=TIMESTAMP} ) ]]>
     * @param entity entity
     * @return int
     */
    int insert(SysAclModuleDO entity);
    /**
     * desc:批量插入表:sys_acl_module.<br/>
     * descSql =  INSERT INTO sys_acl_module( ID ,SYS_ACL_MODULE_PARENT_ID ,DEL_FLAG ,CREATE_BY ,UPDATE_BY ,SYS_ACL_MODULE_CODE ,SYS_ACL_MODULE_ICON ,SYS_ACL_MODULE_NAME ,SYS_ACL_MODULE_UUID ,SYS_ACL_MODULE_LEVEL ,SYS_ACL_MODULE_REMARK ,SYS_ACL_MODULE_SEQ ,CREATE_TIME ,UPDATE_TIME )VALUES ( null , #{item.sysAclModuleParentId,jdbcType=BIGINT} , #{item.delFlag,jdbcType=CHAR} , #{item.createBy,jdbcType=VARCHAR} , #{item.updateBy,jdbcType=VARCHAR} , #{item.sysAclModuleCode,jdbcType=VARCHAR} , #{item.sysAclModuleIcon,jdbcType=VARCHAR} , #{item.sysAclModuleName,jdbcType=VARCHAR} , #{item.sysAclModuleUuid,jdbcType=VARCHAR} , #{item.sysAclModuleLevel,jdbcType=VARCHAR} , #{item.sysAclModuleRemark,jdbcType=VARCHAR} , #{item.sysAclModuleSeq,jdbcType=INTEGER} , #{item.createTime,jdbcType=TIMESTAMP} , #{item.updateTime,jdbcType=TIMESTAMP} ) 
     * @param list list
     * @return int
     */
    int insertBatch(List<SysAclModuleDO> list);
    /**
     * desc:根据主键删除数据:sys_acl_module.<br/>
     * descSql =  <![CDATA[ DELETE FROM sys_acl_module WHERE ID = #{id,jdbcType=BIGINT} ]]>
     * @param id id
     * @return int
     */
    int deleteById(Long id);
    /**
     * desc:根据主键获取数据:sys_acl_module.<br/>
     * descSql =  SELECT * FROM sys_acl_module WHERE <![CDATA[ ID = #{id,jdbcType=BIGINT} ]]>
     * @param id id
     * @return SysAclModuleDO
     */
    SysAclModuleDO getById(Long id);
    /**
     * desc:得到所有的权限模块.<br/>
     * descSql =  select ID ,SYS_ACL_MODULE_PARENT_ID ,SYS_ACL_MODULE_CODE ,SYS_ACL_MODULE_NAME ,SYS_ACL_MODULE_UUID ,SYS_ACL_MODULE_LEVEL ,SYS_ACL_MODULE_SEQ ,sys_acl_module_type from sys_acl_module where del_flag=0 and sys_acl_module_type=#{sysAclModuleType,jdbcType=INTEGER} 
     * @param entity entity
     * @return List<SysAclModuleDO>
     */
    List<SysAclModuleDO> getAllAclModel(SysAclModuleDO entity);
    /**
     * desc:根据权限点的模块id 得到对象.<br/>
     * descSql =  select sys_acl_module_name from sys_acl_module where del_flag=0 AND id=#{id,jdbcType=BIGINT}
     * @param id id
     * @return SysAclModuleDO
     */
    SysAclModuleDO getModuleByAclModuleId(Long id);
}
