package com.xiaowei.sys.platform.core.common.dal.mapper;

import com.xiaowei.sys.platform.core.common.dal.dataobject.SysStandardDO;
import java.util.List;
import com.xiaowei.sys.platform.core.common.dal.paging.StandardListPage;
import com.xiaowei.sys.platform.core.common.dal.resultmap.StandardResult;
import com.xiaowei.sys.platform.core.common.dal.paging.StandByNamePage;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table sys_standard.
 * SYS_STANDARD
 */
public interface SysStandardDOMapper{

    /**
     * desc:插入表:sys_standard.<br/>
     * descSql =  SELECT LAST_INSERT_ID() <![CDATA[ INSERT INTO sys_standard( ID ,STANDARD_TYPEID ,DEL_FLAG ,CREATE_BY ,UPDATE_BY ,STANDARD_NAME ,STANDARD_UUID ,CREATE_TIME ,UPDATE_TIME )VALUES( null , #{standardTypeid,jdbcType=VARCHAR} , #{delFlag,jdbcType=CHAR} , #{createBy,jdbcType=VARCHAR} , #{updateBy,jdbcType=VARCHAR} , #{standardName,jdbcType=VARCHAR} , #{standardUuid,jdbcType=VARCHAR} , #{createTime,jdbcType=TIMESTAMP} , #{updateTime,jdbcType=TIMESTAMP} ) ]]>
     * @param entity entity
     * @return int
     */
    int insert(SysStandardDO entity);
    /**
     * desc:批量插入表:sys_standard.<br/>
     * descSql =  INSERT INTO sys_standard( ID ,STANDARD_TYPEID ,DEL_FLAG ,CREATE_BY ,UPDATE_BY ,STANDARD_NAME ,STANDARD_UUID ,CREATE_TIME ,UPDATE_TIME )VALUES ( null , #{item.standardTypeid,jdbcType=VARCHAR} , #{item.delFlag,jdbcType=CHAR} , #{item.createBy,jdbcType=VARCHAR} , #{item.updateBy,jdbcType=VARCHAR} , #{item.standardName,jdbcType=VARCHAR} , #{item.standardUuid,jdbcType=VARCHAR} , #{item.createTime,jdbcType=TIMESTAMP} , #{item.updateTime,jdbcType=TIMESTAMP} ) 
     * @param list list
     * @return int
     */
    int insertBatch(List<SysStandardDO> list);
    /**
     * desc:更新表:SYS_STANDARD.<br/>
     * descSql =  UPDATE sys_standard SET DEL_FLAG = #{delFlag,jdbcType=CHAR} ,CREATE_BY = #{createBy,jdbcType=VARCHAR} ,UPDATE_BY = #{updateBy,jdbcType=VARCHAR} ,STANDARD_NAME = #{standardName,jdbcType=VARCHAR} ,STANDARD_TYPEID = #{standardTypeid,jdbcType=VARCHAR} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} WHERE standard_uuid = #{standardUuid,jdbcType=VARCHAR}
     * @param entity entity
     * @return int
     */
    int update(SysStandardDO entity);
    /**
     * desc:根据主键删除数据:SYS_STANDARD.<br/>
     * descSql =  DELETE FROM SYS_STANDARD WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return int
     */
    int deleteById(Long id);
    /**
     * desc:根据主键获取数据:SYS_STANDARD.<br/>
     * descSql =  SELECT * FROM SYS_STANDARD WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return SysStandardDO
     */
    SysStandardDO getById(Long id);
    /**
     * desc:根据uuid获取数据:SYS_STANDARD.<br/>
     * descSql =  SELECT * FROM sys_standard WHERE standard_uuid = #{standardUuid,jdbcType=VARCHAR} and del_flag=0
     * @param standardUuid standardUuid
     * @return SysStandardDO
     */
    SysStandardDO getstandardByUuid(@Param("standardUuid")String standardUuid);
    /**
     * desc:逻辑删除.<br/>
     * descSql =  UPDATE sys_standard SET DEL_FLAG = #{delFlag,jdbcType=CHAR} WHERE standard_uuid = #{standardUuid,jdbcType=VARCHAR}
     * @param delFlag delFlag
     * @param standardUuid standardUuid
     * @return int
     */
    int deleteByUuid(@Param("delFlag")String delFlag,@Param("standardUuid")String standardUuid);
    /**
     * desc:水质标准分页.<br/>
     * descSql =  select standard.id, standard.standard_uuid, standard.standard_name, standard.standard_typeid from sys_standard standard AND standard.del_flag=0 AND standard.standard_name LIKE CONCAT('%',#{standardName,jdbcType=VARCHAR},'%') order by create_time desc
     * @param standardList standardList
     * @return int
     */
    int standardPagingCount(StandardListPage standardList);
    /**
     * desc:水质标准分页.<br/>
     * descSql =  select standard.id, standard.standard_uuid, standard.standard_name, standard.standard_typeid from sys_standard standard AND standard.del_flag=0 AND standard.standard_name LIKE CONCAT('%',#{standardName,jdbcType=VARCHAR},'%') order by create_time desc
     * @param standardList standardList
     * @return List<StandardResult>
     */
    List<StandardResult> standardPagingResult(StandardListPage standardList);
    /**
     * desc:根据标准名查询是否存在.<br/>
     * descSql =  select count(id) from sys_standard where standard_name=#{standardName,jdbcType=VARCHAR}
     * @param standardName standardName
     * @return int
     */
    int findSysStandardByName(@Param("standardName")String standardName);
    /**
     * desc:根据标准名查询是否存在.<br/>
     * descSql =  select count(id) from sys_standard where standard_name=#{standardName,jdbcType=VARCHAR} and id=#{id,jdbcType=BIGINT}
     * @param id id
     * @param standardName standardName
     * @return int
     */
    int findSysStandardByMyName(@Param("id")Long id,@Param("standardName")String standardName);
    /**
     * desc:查询数量.<br/>
     * descSql =  SELECT COUNT(id) FROM sys_standard WHERE standard_typeid=#{standardTypeid,jdbcType=VARCHAR} AND del_flag=0
     * @param standardTypeid standardTypeid
     * @return int
     */
    int getStandard(@Param("standardTypeid")String standardTypeid);
    /**
     * desc:根据Typeid获取数据:SYS_STANDARD.<br/>
     * descSql =  SELECT * FROM sys_standard WHERE standard_typeid = #{standardTypeid,jdbcType=VARCHAR} and del_flag=0
     * @param standardTypeid standardTypeid
     * @return List<SysStandardDO>
     */
    List<SysStandardDO> getstandardByTypeid(@Param("standardTypeid")String standardTypeid);
    /**
     * desc:水质标准分页查询，带明细.<br/>
     * descSql =  select id, standard_uuid, standard_name,standard_uuid, del_flag, standard_typeid from sys_standard AND del_flag=#{delFlag,jdbcType=VARCHAR} AND standard_name like CONCAT('%',#{standardName,jdbcType=VARCHAR},'%') order by create_time desc
     * @param standByName standByName
     * @return int
     */
    int standByNamePagingCount(StandByNamePage standByName);
    /**
     * desc:水质标准分页查询，带明细.<br/>
     * descSql =  select id, standard_uuid, standard_name,standard_uuid, del_flag, standard_typeid from sys_standard AND del_flag=#{delFlag,jdbcType=VARCHAR} AND standard_name like CONCAT('%',#{standardName,jdbcType=VARCHAR},'%') order by create_time desc
     * @param standByName standByName
     * @return List<SysStandardDO>
     */
    List<SysStandardDO> standByNamePagingResult(StandByNamePage standByName);
    /**
     * desc:修改时根据标准名查询是否存在.<br/>
     * descSql =  select count(id) from sys_standard where standard_name=#{standardName,jdbcType=VARCHAR} and id!=#{id,jdbcType=BIGINT}
     * @param id id
     * @param standardName standardName
     * @return int
     */
    int findStandardByMyName(@Param("id")Long id,@Param("standardName")String standardName);
}
