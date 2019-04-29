package com.xiaowei.sys.platform.core.common.dal.mapper;

import com.xiaowei.sys.platform.core.common.dal.dataobject.SysUserDO;
import com.xiaowei.sys.platform.core.common.dal.paging.UserDeptAreaRolesPage;
import java.util.List;
import com.xiaowei.sys.platform.core.common.dal.resultmap.userRoleSArea;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table SYS_USER.
 * 用户
 */
public interface SysUserDOMapper{

    /**
     * desc:插入表:SYS_USER.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO SYS_USER( AREAID ,DEPTID ,ROLEID ,DEL_FLAG ,CREATE_BY ,UPDATE_BY ,SYS_USER_PWD ,SYS_USER_NAME ,SYS_USER_EMAIL ,SYS_USER_PHONE ,SYS_USER_AUTH_SALT ,CREATE_TIME ,UPDATE_TIME )VALUES( #{areaid,jdbcType=BIGINT} ,#{deptid,jdbcType=BIGINT} ,#{roleid,jdbcType=BIGINT} ,#{delFlag,jdbcType=CHAR} ,#{createBy,jdbcType=VARCHAR} ,#{updateBy,jdbcType=VARCHAR} ,#{sysUserPwd,jdbcType=VARCHAR} ,#{sysUserName,jdbcType=VARCHAR} ,#{sysUserEmail,jdbcType=VARCHAR} ,#{sysUserPhone,jdbcType=VARCHAR} ,#{sysUserAuthSalt,jdbcType=VARCHAR} ,#{createTime,jdbcType=TIMESTAMP} ,#{updateTime,jdbcType=TIMESTAMP} )
     * @param entity entity
     * @return int
     */
    int insert(SysUserDO entity);
    /**
     * desc:更新表:SYS_USER.<br/>
     * descSql =  UPDATE SYS_USER SET AREAID = #{areaid,jdbcType=BIGINT} ,DEPTID = #{deptid,jdbcType=BIGINT} ,ROLEID = #{roleid,jdbcType=BIGINT} ,DEL_FLAG = #{delFlag,jdbcType=CHAR} ,CREATE_BY = #{createBy,jdbcType=VARCHAR} ,UPDATE_BY = #{updateBy,jdbcType=VARCHAR} ,SYS_USER_PWD = #{sysUserPwd,jdbcType=VARCHAR} ,SYS_USER_NAME = #{sysUserName,jdbcType=VARCHAR} ,SYS_USER_EMAIL = #{sysUserEmail,jdbcType=VARCHAR} ,SYS_USER_PHONE = #{sysUserPhone,jdbcType=VARCHAR} ,SYS_USER_AUTH_SALT = #{sysUserAuthSalt,jdbcType=VARCHAR} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} WHERE ID = #{id,jdbcType=BIGINT}
     * @param entity entity
     * @return int
     */
    int update(SysUserDO entity);
    /**
     * desc:根据主键删除数据:SYS_USER.<br/>
     * descSql =  DELETE FROM SYS_USER WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return int
     */
    int deleteById(Long id);
    /**
     * desc:根据主键获取数据:SYS_USER.<br/>
     * descSql =  SELECT * FROM SYS_USER WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return SysUserDO
     */
    SysUserDO getById(Long id);
    /**
     * desc:根据主键获取数据:SYS_USER.<br/>
     * descSql =  SELECT * FROM sys_user WHERE sys_user_uuid = #{sysUserUuid,jdbcType=BIGINT} AND del_flag=0
     * @param sysUserUuid sysUserUuid
     * @return SysUserDO
     */
    SysUserDO getByUuid(@Param("sysUserUuid")String sysUserUuid);
    /**
     * desc:根据手机号/邮箱登录.<br/>
     * descSql =  SELECT * FROM sys_user AND sys_user_phone=#{sysUserPhone,jdbcType=VARCHAR} AND sys_user_email=#{sysUserEmail,jdbcType=VARCHAR} 
     * @param sysUserEmail sysUserEmail
     * @param sysUserPhone sysUserPhone
     * @return SysUserDO
     */
    SysUserDO loginByUsername(@Param("sysUserEmail")String sysUserEmail,@Param("sysUserPhone")String sysUserPhone);
    /**
     * desc:根据部门id查询该部门是否有用户.<br/>
     * descSql =  SELECT COUNT(id) FROM sys_user WHERE dept_id=#{deptId,jdbcType=BIGINT} AND del_flag=0
     * @param deptId deptId
     * @return int
     */
    int userCountByDeptId(Long deptId);
    /**
     * desc:多条件查询用户信息，部门、携带部门、角色、区域.<br/>
     * descSql =  SELECT u.id uId,sys_user_name, sys_user_uuid, dept_id, sys_user_phone, sys_user_email, area_id,de.sys_dept_name,de.sys_dept_uuid FROM sys_user u LEFT JOIN sys_dept de ON u.dept_id=de.id AND de.del_flag=#{deDelFlag,jdbcType=VARCHAR} AND u.del_flag=#{uDelFlag,jdbcType=VARCHAR} AND sys_dept_name LIKE CONCAT('%',#{sysDeptName,jdbcType=VARCHAR},'%') AND sys_user_name LIKE CONCAT('%',#{sysUserName,jdbcType=VARCHAR},'%') AND sys_user_uuid =#{sysUserUuid,jdbcType=VARCHAR} ORDER BY u.create_time DESC
     * @param userDeptAreaRoles userDeptAreaRoles
     * @return int
     */
    int userPagingCount(UserDeptAreaRolesPage userDeptAreaRoles);
    /**
     * desc:多条件查询用户信息，部门、携带部门、角色、区域.<br/>
     * descSql =  SELECT u.id uId,sys_user_name, sys_user_uuid, dept_id, sys_user_phone, sys_user_email, area_id,de.sys_dept_name,de.sys_dept_uuid FROM sys_user u LEFT JOIN sys_dept de ON u.dept_id=de.id AND de.del_flag=#{deDelFlag,jdbcType=VARCHAR} AND u.del_flag=#{uDelFlag,jdbcType=VARCHAR} AND sys_dept_name LIKE CONCAT('%',#{sysDeptName,jdbcType=VARCHAR},'%') AND sys_user_name LIKE CONCAT('%',#{sysUserName,jdbcType=VARCHAR},'%') AND sys_user_uuid =#{sysUserUuid,jdbcType=VARCHAR} ORDER BY u.create_time DESC
     * @param userDeptAreaRoles userDeptAreaRoles
     * @return List<userRoleSArea>
     */
    List<userRoleSArea> userPagingResult(UserDeptAreaRolesPage userDeptAreaRoles);
    /**
     * desc:根据用户uuid查看 用户信息.<br/>
     * descSql =  SELECT u.id uId,sys_user_name, sys_user_uuid, dept_id, sys_user_phone, sys_user_email, area_id,de.sys_dept_name,de.sys_dept_uuid FROM sys_user u LEFT JOIN sys_dept de ON u.id=de.id AND de.del_flag=0 WHERE sys_user_uuid=#{sysUserUuid,jdbcType=VARCHAR} AND u.del_flag=0
     * @param sysUserUuid sysUserUuid
     * @return userRoleSArea
     */
    userRoleSArea getUserInfiByUuid(@Param("sysUserUuid")String sysUserUuid);
    /**
     * desc:新增/编辑 用户名、邮箱唯一.<br/>
     * descSql =  SELECT COUNT(id) from sys_user AND sys_user_email=#{email,jdbcType=VARCHAR} AND sys_user_phone=#{phone,jdbcType=VARCHAR} AND sys_user_uuid!=#{uuid,jdbcType=VARCHAR} 
     * @param uuid uuid
     * @param email email
     * @param phone phone
     * @return int
     */
    int checkPhoneORemailUniqueness(@Param("uuid")String uuid,@Param("email")String email,@Param("phone")String phone);
    /**
     * desc:更新用户.<br/>
     * descSql =  update sys_user sys_user_name = #{sysUserName,jdbcType=VARCHAR}, sys_user_uuid = #{sysUserUuid,jdbcType=VARCHAR}, sys_user_pwd = #{sysUserPwd,jdbcType=VARCHAR}, sys_user_auth_salt = #{sysUserAuthSalt,jdbcType=VARCHAR}, dept_id = #{deptId,jdbcType=BIGINT}, sys_user_phone = #{sysUserPhone,jdbcType=VARCHAR}, sys_user_email = #{sysUserEmail,jdbcType=VARCHAR}, area_id = #{areaId,jdbcType=BIGINT}, del_flag = #{delFlag,jdbcType=CHAR}, create_by = #{createBy,jdbcType=VARCHAR}, create_time = #{createTime,jdbcType=TIMESTAMP}, update_time = #{updateTime,jdbcType=TIMESTAMP}, update_by = #{updateBy,jdbcType=VARCHAR}, where sys_user_uuid = #{sysUserUuid,jdbcType=VARCHAR}
     * @param entity entity
     * @return int
     */
    int updateUser(SysUserDO entity);
    /**
     * desc:新增用户.<br/>
     * descSql =  SELECT LAST_INSERT_ID() insert into sys_user id, sys_user_name, sys_user_uuid, sys_user_pwd, sys_user_auth_salt, dept_id, sys_user_phone, sys_user_email, area_id, del_flag, create_by, create_time, update_time, update_by, #{id,jdbcType=BIGINT}, #{sysUserName,jdbcType=VARCHAR}, #{sysUserUuid,jdbcType=VARCHAR}, #{sysUserPwd,jdbcType=VARCHAR}, #{sysUserAuthSalt,jdbcType=VARCHAR}, #{deptId,jdbcType=BIGINT}, #{sysUserPhone,jdbcType=VARCHAR}, #{sysUserEmail,jdbcType=VARCHAR}, #{areaId,jdbcType=BIGINT}, #{delFlag,jdbcType=CHAR}, #{createBy,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=VARCHAR}, 
     * @param entity entity
     * @return int
     */
    int insertUser(SysUserDO entity);
    /**
     * desc:根据部门id集合查询用户列表.<br/>
     * descSql =  SELECT id ,sys_user_name, sys_user_uuid, dept_id, sys_user_phone, sys_user_email, area_id FROM sys_user and del_flag=0 and dept_id IN #{deptIds.deptId,jdbcType=BIGINT} 
     * @param list list
     * @return List<SysUserDO>
     */
    List<SysUserDO> getUserListByDeptIds(List<SysUserDO> list);
    /**
     * desc:测试用户手动输入排序.<br/>
     * descSql =  SELECT * FROM sys_user , ${one} , ${two} 
     * @param entity entity
     * @return List<SysUserDO>
     */
    List<SysUserDO> testUserOrderByParams(SysUserDO entity);
}
