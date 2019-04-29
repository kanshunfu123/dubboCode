package com.xiaowei.sys.platform.core.common.dal.mapper;

import com.xiaowei.sys.platform.core.common.dal.dataobject.SysAclDO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table sys_acl.
 * 权限点表
 */
public interface SysAclDOMapper{

    /**
     * desc:插入表:sys_acl.<br/>
     * descSql =  SELECT LAST_INSERT_ID() <![CDATA[ INSERT INTO sys_acl( ID ,SYS_ACL_MODULE_ID ,REMARK ,DEL_FLAG ,CREATE_BY ,UPDATE_BY ,SYS_ACL_URL ,SYS_ACL_CODE ,SYS_ACL_ICON ,SYS_ACL_NAME ,SYS_ACL_TYPE ,SYS_ACL_UUID ,SYS_ACL_SEQ ,CREATE_TIME ,UPDATE_TIME )VALUES( null , #{sysAclModuleId,jdbcType=BIGINT} , #{remark,jdbcType=VARCHAR} , #{delFlag,jdbcType=CHAR} , #{createBy,jdbcType=VARCHAR} , #{updateBy,jdbcType=VARCHAR} , #{sysAclUrl,jdbcType=VARCHAR} , #{sysAclCode,jdbcType=VARCHAR} , #{sysAclIcon,jdbcType=VARCHAR} , #{sysAclName,jdbcType=VARCHAR} , #{sysAclType,jdbcType=CHAR} , #{sysAclUuid,jdbcType=VARCHAR} , #{sysAclSeq,jdbcType=INTEGER} , #{createTime,jdbcType=TIMESTAMP} , #{updateTime,jdbcType=TIMESTAMP} ) ]]>
     * @param entity entity
     * @return int
     */
    int insert(SysAclDO entity);
    /**
     * desc:批量插入表:sys_acl.<br/>
     * descSql =  INSERT INTO sys_acl( ID ,SYS_ACL_MODULE_ID ,REMARK ,DEL_FLAG ,CREATE_BY ,UPDATE_BY ,SYS_ACL_URL ,SYS_ACL_CODE ,SYS_ACL_ICON ,SYS_ACL_NAME ,SYS_ACL_TYPE ,SYS_ACL_UUID ,SYS_ACL_SEQ ,CREATE_TIME ,UPDATE_TIME )VALUES ( null , #{item.sysAclModuleId,jdbcType=BIGINT} , #{item.remark,jdbcType=VARCHAR} , #{item.delFlag,jdbcType=CHAR} , #{item.createBy,jdbcType=VARCHAR} , #{item.updateBy,jdbcType=VARCHAR} , #{item.sysAclUrl,jdbcType=VARCHAR} , #{item.sysAclCode,jdbcType=VARCHAR} , #{item.sysAclIcon,jdbcType=VARCHAR} , #{item.sysAclName,jdbcType=VARCHAR} , #{item.sysAclType,jdbcType=CHAR} , #{item.sysAclUuid,jdbcType=VARCHAR} , #{item.sysAclSeq,jdbcType=INTEGER} , #{item.createTime,jdbcType=TIMESTAMP} , #{item.updateTime,jdbcType=TIMESTAMP} ) 
     * @param list list
     * @return int
     */
    int insertBatch(List<SysAclDO> list);
    /**
     * desc:根据主键删除数据:sys_acl.<br/>
     * descSql =  <![CDATA[ DELETE FROM sys_acl WHERE ID = #{id,jdbcType=BIGINT} ]]>
     * @param id id
     * @return int
     */
    int deleteById(Long id);
    /**
     * desc:根据主键获取数据:sys_acl.<br/>
     * descSql =  SELECT * FROM sys_acl WHERE <![CDATA[ ID = #{id,jdbcType=BIGINT} ]]>
     * @param id id
     * @return SysAclDO
     */
    SysAclDO getById(Long id);
    /**
     * desc:判断用户是否有权限访问系统资源.<br/>
     * descSql =  SELECT id, sys_acl_uuid, sys_acl_code, sys_acl_name, sys_acl_module_id, sys_acl_url, sys_acl_type, sys_acl_icon, sys_acl_seq, remark, del_flag,name FROM sys_acl WHERE sys_acl_url=#{url,jdbcType=VARCHAR} and del_flag=0
     * @param url url
     * @return List<SysAclDO>
     */
    List<SysAclDO> getByUrl(@Param("url")String url);
    /**
     * desc:根据权限点列表查询权限列表.<br/>
     * descSql =  SELECT sys_acl_name, sys_acl_module_id,sys_acl_type,name FROM sys_acl WHERE id IN( SELECT sys_acl_id FROM sys_role_acl WHERE sys_role_id=#{sysRoleId,jdbcType=BIGINT} AND del_flag=0 ) AND del_flag=0
     * @param sysRoleId sysRoleId
     * @return List<SysAclDO>
     */
    List<SysAclDO> getRoleListByAcls(Long sysRoleId);
    /**
     * desc:获得所有权限列表.<br/>
     * descSql =  select ID ,SYS_ACL_MODULE_ID ,DEL_FLAG ,SYS_ACL_URL ,SYS_ACL_CODE ,SYS_ACL_NAME ,SYS_ACL_TYPE ,SYS_ACL_UUID ,SYS_ACL_SEQ ,sys_acl_action ,sys_acl_router ,name ,sys_acl_permission_type from sys_acl where DEL_FLAG=0 and sys_acl_permission_type=#{sysAclPermissionType,jdbcType=INTEGER} 
     * @param entity entity
     * @return List<SysAclDO>
     */
    List<SysAclDO> getAll(SysAclDO entity);
    /**
     * desc:根据权限id集合查询权限点对象的集合.<br/>
     * descSql =  SELECT ID ,SYS_ACL_MODULE_ID ,DEL_FLAG ,SYS_ACL_URL ,SYS_ACL_CODE ,SYS_ACL_NAME ,SYS_ACL_TYPE ,SYS_ACL_UUID ,SYS_ACL_SEQ ,sys_acl_action ,sys_acl_router ,name ,sys_acl_permission_type FROM sys_acl WHERE id IN #{ids.id,jdbcType=VARCHAR} AND DEL_FLAG=0
     * @param list list
     * @return List<SysAclDO>
     */
    List<SysAclDO> getByIdList(List<SysAclDO> list);
    /**
     * desc:根据uuid查询权限点表.<br/>
     * descSql =  select * from sys_acl where sys_acl_uuid=#{sysAclUuid,jdbcType=VARCHAR}
     * @param sysAclUuid sysAclUuid
     * @return SysAclDO
     */
    SysAclDO findSysAclByUuid(@Param("sysAclUuid")String sysAclUuid);
}
