package com.xiaowei.sys.platform.core.common.dal.mapper;

import com.xiaowei.sys.platform.core.common.dal.dataobject.SysRoleDO;
import java.util.List;
import com.xiaowei.sys.platform.core.common.dal.paging.RoleListPage;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table sys_role.
 * 角色
 */
public interface SysRoleDOMapper{

    /**
     * desc:插入表:sys_role.<br/>
     * descSql =  SELECT LAST_INSERT_ID() <![CDATA[ INSERT INTO sys_role( ID ,REMARK ,DEL_FLAG ,CREATE_BY ,UPDATE_BY ,SYS_ROLE_NAME ,SYS_ROLE_TYPE ,SYS_ROLE_UUID ,CREATE_TIME ,UPDATE_TIME )VALUES( null , #{remark,jdbcType=VARCHAR} , #{delFlag,jdbcType=CHAR} , #{createBy,jdbcType=VARCHAR} , #{updateBy,jdbcType=VARCHAR} , #{sysRoleName,jdbcType=VARCHAR} , #{sysRoleType,jdbcType=CHAR} , #{sysRoleUuid,jdbcType=VARCHAR} , #{createTime,jdbcType=TIMESTAMP} , #{updateTime,jdbcType=TIMESTAMP} ) ]]>
     * @param entity entity
     * @return int
     */
    int insert(SysRoleDO entity);
    /**
     * desc:批量插入表:sys_role.<br/>
     * descSql =  INSERT INTO sys_role( ID ,REMARK ,DEL_FLAG ,CREATE_BY ,UPDATE_BY ,SYS_ROLE_NAME ,SYS_ROLE_TYPE ,SYS_ROLE_UUID ,CREATE_TIME ,UPDATE_TIME )VALUES ( null , #{item.remark,jdbcType=VARCHAR} , #{item.delFlag,jdbcType=CHAR} , #{item.createBy,jdbcType=VARCHAR} , #{item.updateBy,jdbcType=VARCHAR} , #{item.sysRoleName,jdbcType=VARCHAR} , #{item.sysRoleType,jdbcType=CHAR} , #{item.sysRoleUuid,jdbcType=VARCHAR} , #{item.createTime,jdbcType=TIMESTAMP} , #{item.updateTime,jdbcType=TIMESTAMP} ) 
     * @param list list
     * @return int
     */
    int insertBatch(List<SysRoleDO> list);
    /**
     * desc:根据主键删除数据:SYS_ROLE.<br/>
     * descSql =  DELETE FROM sys_role WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return int
     */
    int deleteById(Long id);
    /**
     * desc:根据主键获取数据:SYS_ROLE.<br/>
     * descSql =  SELECT * FROM sys_role WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return SysRoleDO
     */
    SysRoleDO getById(Long id);
    /**
     * desc:根据uuid获取数据:SYS_ROLE.<br/>
     * descSql =  SELECT * FROM sys_role WHERE sys_role_uuid = #{sysRoleUuid,jdbcType=BIGINT} and del_flag=0
     * @param sysRoleUuid sysRoleUuid
     * @return SysRoleDO
     */
    SysRoleDO getByUuid(@Param("sysRoleUuid")String sysRoleUuid);
    /**
     * desc:根据用户的id查询角色信息.<br/>
     * descSql =  SELECT sys_role_name,sys_role_uuid FROM sys_role WHERE id IN( SELECT role_id FROM sys_role_user roleUser WHERE user_id=#{uId,jdbcType=BIGINT} AND del_flag=0 ) AND del_flag=0
     * @param uId uId
     * @return List<SysRoleDO>
     */
    List<SysRoleDO> getRoleByUserId(Long uId);
    /**
     * desc:根据角色uuid查询角色列表id.<br/>
     * descSql =  SELECT id FROM sys_role WHERE sys_role_uuid IN #{uuids,jdbcType=VARCHAR} AND del_flag=0
     * @param list list
     * @return List<SysRoleDO>
     */
    List<SysRoleDO> getRoleListByRoleUUID(List<String> list);
    /**
     * desc:查询全部角色.<br/>
     * descSql =  SELECT ID,SYS_ROLE_NAME,SYS_ROLE_TYPE,SYS_ROLE_UUID FROM sys_role WHERE del_flag=0
     * @return List<SysRoleDO>
     */
    List<SysRoleDO> getAllRoleListByNoParam();
    /**
     * desc:修改用户角色.<br/>
     * descSql =  update sys_role sys_role_uuid = #{sysRoleUuid,jdbcType=VARCHAR}, sys_role_name = #{sysRoleName,jdbcType=VARCHAR}, sys_role_type = #{sysRoleType,jdbcType=CHAR}, remark = #{remark,jdbcType=VARCHAR}, del_flag = #{delFlag,jdbcType=CHAR}, create_by = #{createBy,jdbcType=VARCHAR}, create_time = #{createTime,jdbcType=TIMESTAMP}, update_time = #{updateTime,jdbcType=TIMESTAMP}, update_by = #{updateBy,jdbcType=VARCHAR}, where sys_role_uuid = #{sysRoleUuid,jdbcType=VARCHAR}
     * @param entity entity
     * @return int
     */
    int updateRole(SysRoleDO entity);
    /**
     * desc:根据角色名称查询角色信息.<br/>
     * descSql =  select * from sys_role where sys_role_name=#{sysRoleName,jdbcType=VARCHAR}
     * @param sysRoleName sysRoleName
     * @return SysRoleDO
     */
    SysRoleDO findSysRoleByName(@Param("sysRoleName")String sysRoleName);
    /**
     * desc:修改时根据角色名称查询角色信息.<br/>
     * descSql =  select * from sys_role where sys_role_name=#{sysRoleName,jdbcType=VARCHAR} and sys_role_uuid!=#{sysRoleUuid,jdbcType=VARCHAR}
     * @param sysRoleName sysRoleName
     * @param sysRoleUuid sysRoleUuid
     * @return SysRoleDO
     */
    SysRoleDO findSysRoleByNameAndUuid(@Param("sysRoleName")String sysRoleName,@Param("sysRoleUuid")String sysRoleUuid);
    /**
     * desc:角色列表分页.<br/>
     * descSql =  select id,sys_role_uuid, sys_role_name, sys_role_type, remark from sys_role AND del_flag=#{delFlag,jdbcType=CHAR} order by create_time desc
     * @param roleList roleList
     * @return int
     */
    int roleListPageCount(RoleListPage roleList);
    /**
     * desc:角色列表分页.<br/>
     * descSql =  select id,sys_role_uuid, sys_role_name, sys_role_type, remark from sys_role AND del_flag=#{delFlag,jdbcType=CHAR} order by create_time desc
     * @param roleList roleList
     * @return List<SysRoleDO>
     */
    List<SysRoleDO> roleListPageResult(RoleListPage roleList);
    /**
     * desc:查询除自己之外是否还存在相同名称.<br/>
     * descSql =  select count(id) from sys_role where sys_role_name=#{sysRoleName,jdbcType=VARCHAR} and id!=#{id,jdbcType=BIGINT}
     * @param id id
     * @param sysRoleName sysRoleName
     * @return int
     */
    int checkRoleName(@Param("id")Long id,@Param("sysRoleName")String sysRoleName);
}
