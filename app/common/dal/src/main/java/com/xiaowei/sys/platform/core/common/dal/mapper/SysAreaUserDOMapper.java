package com.xiaowei.sys.platform.core.common.dal.mapper;

import com.xiaowei.sys.platform.core.common.dal.dataobject.SysAreaUserDO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table sys_area_user.
 * SYS_AREA_USER
 */
public interface SysAreaUserDOMapper{

    /**
     * desc:插入表:sys_area_user.<br/>
     * descSql =  SELECT LAST_INSERT_ID() <![CDATA[ INSERT INTO sys_area_user( ID ,SYS_AREA_ID ,SYS_USER_ID ,DEL_FLAG ,CREATE_BY ,UPDATE_BY ,CREATE_TIME ,UPDATE_TIME )VALUES( null , #{sysAreaId,jdbcType=BIGINT} , #{sysUserId,jdbcType=BIGINT} , #{delFlag,jdbcType=CHAR} , #{createBy,jdbcType=VARCHAR} , #{updateBy,jdbcType=VARCHAR} , #{createTime,jdbcType=TIMESTAMP} , #{updateTime,jdbcType=TIMESTAMP} ) ]]>
     * @param entity entity
     * @return int
     */
    int insert(SysAreaUserDO entity);
    /**
     * desc:批量插入表:sys_area_user.<br/>
     * descSql =  INSERT INTO sys_area_user( ID ,SYS_AREA_ID ,SYS_USER_ID ,DEL_FLAG ,CREATE_BY ,UPDATE_BY ,CREATE_TIME ,UPDATE_TIME )VALUES ( null , #{item.sysAreaId,jdbcType=BIGINT} , #{item.sysUserId,jdbcType=BIGINT} , #{item.delFlag,jdbcType=CHAR} , #{item.createBy,jdbcType=VARCHAR} , #{item.updateBy,jdbcType=VARCHAR} , #{item.createTime,jdbcType=TIMESTAMP} , #{item.updateTime,jdbcType=TIMESTAMP} ) 
     * @param list list
     * @return int
     */
    int insertBatch(List<SysAreaUserDO> list);
    /**
     * desc:根据主键删除数据:sys_area_user.<br/>
     * descSql =  <![CDATA[ DELETE FROM sys_area_user WHERE ID = #{id,jdbcType=INTEGER} ]]>
     * @param id id
     * @return int
     */
    int deleteById(Long id);
    /**
     * desc:根据主键获取数据:sys_area_user.<br/>
     * descSql =  SELECT * FROM sys_area_user WHERE <![CDATA[ ID = #{id,jdbcType=INTEGER} ]]>
     * @param id id
     * @return SysAreaUserDO
     */
    SysAreaUserDO getById(Long id);
    /**
     * desc:批量更新用户与区域.<br/>
     * descSql =  update sys_area_user set del_flag = #{item.delFlag,jdbcType=CHAR}, update_time = #{item.updateTime,jdbcType=TIMESTAMP}, update_by = #{item.updateBy,jdbcType=VARCHAR} where sys_user_id = #{item.sysUserId,jdbcType=VARCHAR} 
     * @param list list
     * @return int
     */
    int updateBatch(List<SysAreaUserDO> list);
    /**
     * desc:批量插入用户与区域.<br/>
     * descSql =  insert into sys_area_user ( sys_user_id, sys_area_id, del_flag, create_by, create_time, update_time, update_by,sys_user_area_uuid) values (#{areas.sysUserId,jdbcType=BIGINT}, #{areas.sysAreaId,jdbcType=BIGINT}, #{areas.delFlag,jdbcType=CHAR}, #{areas.createBy,jdbcType=VARCHAR}, #{areas.createTime,jdbcType=TIMESTAMP}, #{areas.updateTime,jdbcType=TIMESTAMP}, #{areas.updateBy,jdbcType=VARCHAR},#{areas.sysUserAreaUuid,jdbcType=VARCHAR}) 
     * @param list list
     * @return int
     */
    int insertBatchaa(List<SysAreaUserDO> list);
    /**
     * desc:根据用户id，查询用户的区域id.<br/>
     * descSql =  select sys_area_id from sys_area_user where sys_user_id=#{sysUserId,jdbcType=BIGINT} AND del_flag = 0
     * @param sysUserId sysUserId
     * @return List<SysAreaUserDO>
     */
    List<SysAreaUserDO> getAreaUserListByUserId(Long sysUserId);
    /**
     * desc:删除区域.<br/>
     * descSql =  SELECT COUNT(id) FROM sys_area_user WHERE sys_area_id=#{sysAreaId,jdbcType=BIGINT} AND del_flag=0
     * @param sysAreaId sysAreaId
     * @return int
     */
    int getArea(Long sysAreaId);
}
