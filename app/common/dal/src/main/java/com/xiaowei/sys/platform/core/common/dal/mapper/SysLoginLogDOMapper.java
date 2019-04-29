package com.xiaowei.sys.platform.core.common.dal.mapper;

import com.xiaowei.sys.platform.core.common.dal.dataobject.SysLoginLogDO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table sys_login_log.
 * 登录日志
 */
public interface SysLoginLogDOMapper{

    /**
     * desc:插入表:sys_login_log.<br/>
     * descSql =  SELECT LAST_INSERT_ID() <![CDATA[ INSERT INTO sys_login_log( ID ,USER_ID ,USER_IP ,USER_LOGIN_NAME ,CREATE_TIME )VALUES( null , #{userId,jdbcType=BIGINT} , #{userIp,jdbcType=VARCHAR} , #{userLoginName,jdbcType=VARCHAR} , #{createTime,jdbcType=TIMESTAMP} ) ]]>
     * @param entity entity
     * @return int
     */
    int insert(SysLoginLogDO entity);
    /**
     * desc:批量插入表:sys_login_log.<br/>
     * descSql =  INSERT INTO sys_login_log( ID ,USER_ID ,USER_IP ,USER_LOGIN_NAME ,CREATE_TIME )VALUES ( null , #{item.userId,jdbcType=BIGINT} , #{item.userIp,jdbcType=VARCHAR} , #{item.userLoginName,jdbcType=VARCHAR} , #{item.createTime,jdbcType=TIMESTAMP} ) 
     * @param list list
     * @return int
     */
    int insertBatch(List<SysLoginLogDO> list);
    /**
     * desc:根据主键删除数据:sys_login_log.<br/>
     * descSql =  <![CDATA[ DELETE FROM sys_login_log WHERE ID = #{id,jdbcType=BIGINT} ]]>
     * @param id id
     * @return int
     */
    int deleteById(Long id);
    /**
     * desc:根据主键获取数据:sys_login_log.<br/>
     * descSql =  SELECT * FROM sys_login_log WHERE <![CDATA[ ID = #{id,jdbcType=BIGINT} ]]>
     * @param id id
     * @return SysLoginLogDO
     */
    SysLoginLogDO getById(Long id);
    /**
     * desc:insertLoginLog.<br/>
     * descSql =  insert into sys_login_log id, user_id, user_login_name, user_ip, create_time, #{id,jdbcType=BIGINT}, #{userId,jdbcType=BIGINT}, #{userLoginName,jdbcType=VARCHAR}, #{userIp,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, 
     * @param entity entity
     * @return int
     */
    int insertLoginLog(SysLoginLogDO entity);
}
