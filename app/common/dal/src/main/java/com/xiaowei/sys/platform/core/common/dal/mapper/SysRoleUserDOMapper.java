package com.xiaowei.sys.platform.core.common.dal.mapper;

import com.xiaowei.sys.platform.core.common.dal.dataobject.SysRoleUserDO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table sys_role_user.
 * 角色和用户中间表
 */
public interface SysRoleUserDOMapper{

    /**
     * desc:插入表:sys_role_user.<br/>
     * descSql =  SELECT LAST_INSERT_ID() <![CDATA[ INSERT INTO sys_role_user( ID ,ROLE_ID ,USER_ID ,DEL_FLAG ,CREATE_BY ,UPDATE_BY ,SYS_ROLE_USER_UUID ,CREATE_TIME ,UPDATE_TIME )VALUES( null , #{roleId,jdbcType=BIGINT} , #{userId,jdbcType=BIGINT} , #{delFlag,jdbcType=CHAR} , #{createBy,jdbcType=VARCHAR} , #{updateBy,jdbcType=VARCHAR} , #{sysRoleUserUuid,jdbcType=VARCHAR} , #{createTime,jdbcType=TIMESTAMP} , #{updateTime,jdbcType=TIMESTAMP} ) ]]>
     * @param entity entity
     * @return int
     */
    int insert(SysRoleUserDO entity);
    /**
     * desc:批量插入表:sys_role_user.<br/>
     * descSql =  INSERT INTO sys_role_user( ID ,ROLE_ID ,USER_ID ,DEL_FLAG ,CREATE_BY ,UPDATE_BY ,SYS_ROLE_USER_UUID ,CREATE_TIME ,UPDATE_TIME )VALUES ( null , #{item.roleId,jdbcType=BIGINT} , #{item.userId,jdbcType=BIGINT} , #{item.delFlag,jdbcType=CHAR} , #{item.createBy,jdbcType=VARCHAR} , #{item.updateBy,jdbcType=VARCHAR} , #{item.sysRoleUserUuid,jdbcType=VARCHAR} , #{item.createTime,jdbcType=TIMESTAMP} , #{item.updateTime,jdbcType=TIMESTAMP} ) 
     * @param list list
     * @return int
     */
    int insertBatch(List<SysRoleUserDO> list);
    /**
     * desc:根据主键删除数据:sys_role_user.<br/>
     * descSql =  <![CDATA[ DELETE FROM sys_role_user WHERE ID = #{id,jdbcType=BIGINT} ]]>
     * @param id id
     * @return int
     */
    int deleteById(Long id);
    /**
     * desc:根据主键获取数据:sys_role_user.<br/>
     * descSql =  SELECT * FROM sys_role_user WHERE <![CDATA[ ID = #{id,jdbcType=BIGINT} ]]>
     * @param id id
     * @return SysRoleUserDO
     */
    SysRoleUserDO getById(Long id);
    /**
     * desc:批量插入用户角色.<br/>
     * descSql =  insert into sys_role_user (sys_role_user_uuid, role_id, user_id, del_flag, create_by, create_time, update_time, update_by) values ( #{roleAcl.sysRoleUserUuid,jdbcType=VARCHAR}, #{roleAcl.roleId,jdbcType=BIGINT}, #{roleAcl.userId,jdbcType=BIGINT}, #{roleAcl.delFlag,jdbcType=CHAR}, #{roleAcl.createBy,jdbcType=VARCHAR}, #{roleAcl.createTime,jdbcType=TIMESTAMP}, #{roleAcl.updateTime,jdbcType=TIMESTAMP}, #{roleAcl.updateBy,jdbcType=VARCHAR} ) 
     * @param list list
     * @return int
     */
    int insertBatchTwo(List<SysRoleUserDO> list);
    /**
     * desc:批量更新用户角色.<br/>
     * descSql =  update sys_role_user set del_flag = #{item.delFlag,jdbcType=CHAR}, update_time = #{item.updateTime,jdbcType=TIMESTAMP}, update_by = #{item.updateBy,jdbcType=VARCHAR} where user_id =#{item.userId,jdbcType=BIGINT} 
     * @param list list
     * @return int
     */
    int updateBatch(List<SysRoleUserDO> list);
    /**
     * desc:根据用户的id查询出用户与角色的关系.<br/>
     * descSql =  select * from sys_role_user where user_id=#{userId,jdbcType=VARCHAR} and del_flag=0
     * @param userId userId
     * @return List<SysRoleUserDO>
     */
    List<SysRoleUserDO> getRoleAndUserListByUserid(Long userId);
    /**
     * desc:得到用户已分配的角色id.<br/>
     * descSql =  SELECT role_id FROM sys_role_user WHERE user_id =#{userId,jdbcType=BIGINT} AND del_flag=0
     * @param userId userId
     * @return List<Long>
     */
    List<Long> getRoleIdListByUserId(Long userId);
    /**
     * desc:根据角色id查询用户角色关系是否存在.<br/>
     * descSql =  select * from sys_role_user where role_id=#{roleId,jdbcType=BIGINT}
     * @param roleId roleId
     * @return List<SysRoleUserDO>
     */
    List<SysRoleUserDO> findRoleUserByRoleId(Long roleId);
}
