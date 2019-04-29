package com.xiaowei.sys.platform.core.common.dal.mapper;

import com.xiaowei.sys.platform.core.common.dal.dataobject.SysRoleAclDO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table sys_role_acl.
 * 角色和权限中间表
 */
public interface SysRoleAclDOMapper{

    /**
     * desc:插入表:sys_role_acl.<br/>
     * descSql =  SELECT LAST_INSERT_ID() <![CDATA[ INSERT INTO sys_role_acl( ID ,SYS_ACL_ID ,SYS_ROLE_ID ,DEL_FLAG ,CREATE_BY ,UPDATE_BY ,SYS_ROLE_ACL_UUID ,CREATE_TIME ,UPDATE_TIME )VALUES( null , #{sysAclId,jdbcType=BIGINT} , #{sysRoleId,jdbcType=BIGINT} , #{delFlag,jdbcType=CHAR} , #{createBy,jdbcType=VARCHAR} , #{updateBy,jdbcType=VARCHAR} , #{sysRoleAclUuid,jdbcType=VARCHAR} , #{createTime,jdbcType=TIMESTAMP} , #{updateTime,jdbcType=TIMESTAMP} ) ]]>
     * @param entity entity
     * @return int
     */
    int insert(SysRoleAclDO entity);
    /**
     * desc:批量插入表:sys_role_acl.<br/>
     * descSql =  INSERT INTO sys_role_acl( ID ,SYS_ACL_ID ,SYS_ROLE_ID ,DEL_FLAG ,CREATE_BY ,UPDATE_BY ,SYS_ROLE_ACL_UUID ,CREATE_TIME ,UPDATE_TIME )VALUES ( null , #{item.sysAclId,jdbcType=BIGINT} , #{item.sysRoleId,jdbcType=BIGINT} , #{item.delFlag,jdbcType=CHAR} , #{item.createBy,jdbcType=VARCHAR} , #{item.updateBy,jdbcType=VARCHAR} , #{item.sysRoleAclUuid,jdbcType=VARCHAR} , #{item.createTime,jdbcType=TIMESTAMP} , #{item.updateTime,jdbcType=TIMESTAMP} ) 
     * @param list list
     * @return int
     */
    int insertBatch(List<SysRoleAclDO> list);
    /**
     * desc:根据主键删除数据:sys_role_acl.<br/>
     * descSql =  <![CDATA[ DELETE FROM sys_role_acl WHERE ID = #{id,jdbcType=BIGINT} ]]>
     * @param id id
     * @return int
     */
    int deleteById(Long id);
    /**
     * desc:根据主键获取数据:sys_role_acl.<br/>
     * descSql =  SELECT * FROM sys_role_acl WHERE <![CDATA[ ID = #{id,jdbcType=BIGINT} ]]>
     * @param id id
     * @return SysRoleAclDO
     */
    SysRoleAclDO getById(Long id);
    /**
     * desc:根据角色id查询角色权限.<br/>
     * descSql =  select * from sys_role_acl where sys_role_id=#{sysRoleId,jdbcType=BIGINT}
     * @param sysRoleId sysRoleId
     * @return List<SysRoleAclDO>
     */
    List<SysRoleAclDO> findRoleAclByRoleId(Long sysRoleId);
    /**
     * desc:根据角色uuid查询角色权限.<br/>
     * descSql =  select * from sys_role_acl where sys_role_acl_uuid=#{sysRoleAclUuid,jdbcType=BIGINT}
     * @param sysRoleAclUuid sysRoleAclUuid
     * @return SysRoleAclDO
     */
    SysRoleAclDO findRoleAclByUuid(@Param("sysRoleAclUuid")String sysRoleAclUuid);
    /**
     * desc:根据角色uuid和roleId查询角色权限是否存在.<br/>
     * descSql =  select * from sys_role_acl where sys_role_acl_uuid=#{sysRoleAclUuid,jdbcType=BIGINT} and sys_role_id=#{sysRoleId,jdbcType=BIGINT}
     * @param sysRoleId sysRoleId
     * @param sysRoleAclUuid sysRoleAclUuid
     * @return SysRoleAclDO
     */
    SysRoleAclDO findRoleAclByUuidAndRoleId(@Param("sysRoleId")Long sysRoleId,@Param("sysRoleAclUuid")String sysRoleAclUuid);
    /**
     * desc:根据角色id删除角色权限.<br/>
     * descSql =  delete from sys_role_acl where sys_role_id=#{sysRoleId,jdbcType=BIGINT}
     * @param sysRoleId sysRoleId
     * @return int
     */
    int deleteByRoleId(Long sysRoleId);
    /**
     * desc:根据角色编号查询角色权限的uuid.<br/>
     * descSql =  select sys_role_acl_uuid from sys_role_acl where sys_role_id=#{sysRoleId,jdbcType=BIGINT}
     * @param sysRoleId sysRoleId
     * @return List<String>
     */
    List<String> finddUuidByRoleId(Long sysRoleId);
    /**
     * desc:根据角色id删除角色权限.<br/>
     * descSql =  delete from sys_role_acl where sys_role_id=#{sysRoleId,jdbcType=BIGINT} and sys_role_acl_uuid=#{sysRoleAclUuid,jdbcType=BIGINT}
     * @param sysRoleId sysRoleId
     * @param sysRoleAclUuid sysRoleAclUuid
     * @return int
     */
    int deleteRoleAclByUuidAndRoleId(@Param("sysRoleId")Long sysRoleId,@Param("sysRoleAclUuid")String sysRoleAclUuid);
    /**
     * desc:根据角色id列表查询权限点id列表.<br/>
     * descSql =  SELECT sys_acl_id FROM sys_role_acl WHERE sys_role_id in #{roleIds.sysRoleId,jdbcType=BIGINT} AND DEL_FLAG=0
     * @param list list
     * @return List<SysRoleAclDO>
     */
    List<SysRoleAclDO> getAclIdListByRoleIdList(List<SysRoleAclDO> list);
}
