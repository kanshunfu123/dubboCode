package com.xiaowei.sys.platform.core.common.dal.mapper;

import com.xiaowei.sys.platform.core.common.dal.dataobject.SysParameterConfigurationDO;
import java.util.List;
import com.xiaowei.sys.platform.core.common.dal.paging.ParameterPage;
import com.xiaowei.sys.platform.core.common.dal.resultmap.Parameter;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table sys_parameter_configuration.
 * SYS_PARAMETER_CONFIGURATION
 */
public interface SysParameterConfigurationDOMapper{

    /**
     * desc:插入表:sys_parameter_configuration.<br/>
     * descSql =  SELECT LAST_INSERT_ID() <![CDATA[ INSERT INTO sys_parameter_configuration( ID ,UUID ,DEL_FLAG ,CREATE_BY ,UPDATE_BY ,PARAMETER_NAME ,FIELD_VALUE ,SERIAL_NUMBER ,PARAMETER_VALUE ,CREATE_TIME ,UPDATE_TIME )VALUES( null , #{uuid,jdbcType=VARCHAR} , #{delFlag,jdbcType=CHAR} , #{createBy,jdbcType=VARCHAR} , #{updateBy,jdbcType=VARCHAR} , #{parameterName,jdbcType=VARCHAR} , #{fieldValue,jdbcType=INTEGER} , #{serialNumber,jdbcType=INTEGER} , #{parameterValue,jdbcType=INTEGER} , #{createTime,jdbcType=TIMESTAMP} , #{updateTime,jdbcType=TIMESTAMP} ) ]]>
     * @param entity entity
     * @return int
     */
    int insert(SysParameterConfigurationDO entity);
    /**
     * desc:批量插入表:sys_parameter_configuration.<br/>
     * descSql =  INSERT INTO sys_parameter_configuration( ID ,UUID ,DEL_FLAG ,CREATE_BY ,UPDATE_BY ,PARAMETER_NAME ,FIELD_VALUE ,SERIAL_NUMBER ,PARAMETER_VALUE ,CREATE_TIME ,UPDATE_TIME )VALUES ( null , #{item.uuid,jdbcType=VARCHAR} , #{item.delFlag,jdbcType=CHAR} , #{item.createBy,jdbcType=VARCHAR} , #{item.updateBy,jdbcType=VARCHAR} , #{item.parameterName,jdbcType=VARCHAR} , #{item.fieldValue,jdbcType=INTEGER} , #{item.serialNumber,jdbcType=INTEGER} , #{item.parameterValue,jdbcType=INTEGER} , #{item.createTime,jdbcType=TIMESTAMP} , #{item.updateTime,jdbcType=TIMESTAMP} ) 
     * @param list list
     * @return int
     */
    int insertBatch(List<SysParameterConfigurationDO> list);
    /**
     * desc:根据主键删除数据:sys_parameter_configuration.<br/>
     * descSql =  <![CDATA[ DELETE FROM sys_parameter_configuration WHERE ID = #{id,jdbcType=BIGINT} ]]>
     * @param id id
     * @return int
     */
    int deleteById(Long id);
    /**
     * desc:根据主键获取数据:sys_parameter_configuration.<br/>
     * descSql =  SELECT * FROM sys_parameter_configuration WHERE <![CDATA[ ID = #{id,jdbcType=BIGINT} ]]>
     * @param id id
     * @return SysParameterConfigurationDO
     */
    SysParameterConfigurationDO getById(Long id);
    /**
     * desc:更新参数表.<br/>
     * descSql =  update sys_parameter_configuration uuid = #{uuid,jdbcType=VARCHAR}, parameter_name = #{parameterName,jdbcType=VARCHAR}, parameter_value = #{parameterValue,jdbcType=VARCHAR}, field_value = #{fieldValue,jdbcType=VARCHAR}, serial_number = #{serialNumber,jdbcType=INTEGER}, parameter_remake = #{parameterRemake,jdbcType=VARCHAR}, del_flag = #{delFlag,jdbcType=CHAR}, create_time = #{createTime,jdbcType=TIMESTAMP}, create_by = #{createBy,jdbcType=VARCHAR}, update_time = #{updateTime,jdbcType=TIMESTAMP}, update_by = #{updateBy,jdbcType=VARCHAR}, where uuid=#{uuid,jdbcType=VARCHAR}
     * @param entity entity
     * @return int
     */
    int updateParameter(SysParameterConfigurationDO entity);
    /**
     * desc:根据fieldValue查看参数信息.<br/>
     * descSql =  SELECT id, uuid, parameter_name, parameter_value, field_value, serial_number, parameter_remake, del_flag, create_time, create_by, update_time, update_by FROM sys_parameter_configuration WHERE field_value=#{fieldValue,jdbcType=VARCHAR} AND del_flag=0 order by serial_number
     * @param fieldValue fieldValue
     * @return List<SysParameterConfigurationDO>
     */
    List<SysParameterConfigurationDO> getParameterInfoByFieldValue(@Param("fieldValue")String fieldValue);
    /**
     * desc:更新表:sys_parameter_configuration.<br/>
     * descSql =  insert into sys_parameter_configuration id, uuid, parameter_name, parameter_value, field_value, serial_number, parameter_remake, del_flag, create_time, create_by, update_time, update_by, #{id,jdbcType=BIGINT}, #{uuid,jdbcType=VARCHAR}, #{parameterName,jdbcType=VARCHAR}, #{parameterValue,jdbcType=VARCHAR}, #{fieldValue,jdbcType=VARCHAR}, #{serialNumber,jdbcType=INTEGER}, #{parameterRemake,jdbcType=VARCHAR}, #{delFlag,jdbcType=CHAR}, #{createTime,jdbcType=TIMESTAMP}, #{createBy,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=VARCHAR}, 
     * @param entity entity
     * @return SysParameterConfigurationDO
     */
    SysParameterConfigurationDO saveParameter(SysParameterConfigurationDO entity);
    /**
     * desc:根据字段值获取数据:sys_parameter_configuration.<br/>
     * descSql =  SELECT id, uuid, parameter_name, parameter_value, field_value, serial_number, parameter_remake, del_flag, create_time, create_by, update_time, update_by FROM sys_parameter_configuration WHERE uuid = #{uuid,jdbcType=VARCHAR} and del_flag=0
     * @param uuid uuid
     * @return SysParameterConfigurationDO
     */
    SysParameterConfigurationDO getByUuid(@Param("uuid")String uuid);
    /**
     * desc:分页查询参数列表 信息.<br/>
     * descSql =  SELECT id ,parameter_name, parameter_value, serial_number FROM sys_parameter_configuration AND del_flag=#{delFlag,jdbcType=VARCHAR} ORDER BY serial_number ASC
     * @param parameter parameter
     * @return int
     */
    int parameterPagingCount(ParameterPage parameter);
    /**
     * desc:分页查询参数列表 信息.<br/>
     * descSql =  SELECT id ,parameter_name, parameter_value, serial_number FROM sys_parameter_configuration AND del_flag=#{delFlag,jdbcType=VARCHAR} ORDER BY serial_number ASC
     * @param parameter parameter
     * @return List<Parameter>
     */
    List<Parameter> parameterPagingResult(ParameterPage parameter);
    /**
     * desc:根据 参数 参数值 全局唯一.<br/>
     * descSql =  SELECT count(id) FROM sys_parameter_configuration parameter_value=#{parameterValue,jdbcType=VARCHAR} 
     * @param entity entity
     * @return Integer
     */
    Integer getParameterValue(SysParameterConfigurationDO entity);
    /**
     * desc:查询已存在的数量.<br/>
     * descSql =  select * from sys_parameter_configuration where parameter_value=#{parameterValue,jdbcType=VARCHAR}
     * @param parameterValue parameterValue
     * @return List<SysParameterConfigurationDO>
     */
    List<SysParameterConfigurationDO> getCountsByValue(@Param("parameterValue")String parameterValue);
    /**
     * desc:查询已存在的数量.<br/>
     * descSql =  select * from sys_parameter_configuration where parameter_name=#{parameterName,jdbcType=VARCHAR}
     * @param parameterName parameterName
     * @return List<SysParameterConfigurationDO>
     */
    List<SysParameterConfigurationDO> getCountsByName(@Param("parameterName")String parameterName);
    /**
     * desc:查询已存在的数量.<br/>
     * descSql =  select * from sys_parameter_configuration where field_value=#{fieldValue,jdbcType=VARCHAR}
     * @param fieldValue fieldValue
     * @return SysParameterConfigurationDO
     */
    SysParameterConfigurationDO getCountsByFieldValue(@Param("fieldValue")String fieldValue);
    /**
     * desc:查询已存在的数量,排除自己.<br/>
     * descSql =  select id, uuid, parameter_name, parameter_value, field_value, serial_number, parameter_remake, del_flag, create_time, create_by, update_time, update_by from sys_parameter_configuration where parameter_value=#{parameterValue,jdbcType=VARCHAR} AND parameter_name=#{parameterName,jdbcType=VARCHAR} AND id!=#{id,jdbcType=BIGINT}
     * @param id id
     * @param parameterName parameterName
     * @param parameterValue parameterValue
     * @return List<SysParameterConfigurationDO>
     */
    List<SysParameterConfigurationDO> getCountsByAll(@Param("id")Long id,@Param("parameterName")String parameterName,@Param("parameterValue")String parameterValue);
    /**
     * desc:编辑时,查询已存在的数量,排除自身.<br/>
     * descSql =  select id, uuid, parameter_name, parameter_value, field_value, serial_number, parameter_remake, del_flag, create_time, create_by, update_time, update_by from sys_parameter_configuration where parameter_value=#{parameterValue,jdbcType=VARCHAR} AND id!=#{id,jdbcType=BIGINT}
     * @param id id
     * @param parameterValue parameterValue
     * @return List<SysParameterConfigurationDO>
     */
    List<SysParameterConfigurationDO> getEditCountsByValue(@Param("id")Long id,@Param("parameterValue")String parameterValue);
    /**
     * desc:编辑时,查询已存在的数量,排除自身.<br/>
     * descSql =  select id, uuid, parameter_name, parameter_value, field_value, serial_number, parameter_remake, del_flag, create_time, create_by, update_time, update_by from sys_parameter_configuration where parameter_name=#{parameterName,jdbcType=VARCHAR} AND id!=#{id,jdbcType=BIGINT}
     * @param id id
     * @param parameterName parameterName
     * @return List<SysParameterConfigurationDO>
     */
    List<SysParameterConfigurationDO> getEditCountsByName(@Param("id")Long id,@Param("parameterName")String parameterName);
    /**
     * desc:根据字典的code_value 查询详情.<br/>
     * descSql =  select uuid, parameter_name, parameter_value, field_value from sys_parameter_configuration where field_value=#{fieldValue,jdbcType=VARCHAR} AND DEL_FLAG=#{delFlag,jdbcType=VARCHAR}
     * @param entity entity
     * @return List<SysParameterConfigurationDO>
     */
    List<SysParameterConfigurationDO> getDictAttrValueList(SysParameterConfigurationDO entity);
    /**
     * desc:根据id列表查询数据详情.<br/>
     * descSql =  select uuid, parameter_name, parameter_value, field_value from sys_parameter_configuration AND del_flag=0 AND id in #{ids.id,jdbcType=BIGINT} 
     * @param list list
     * @return List<SysParameterConfigurationDO>
     */
    List<SysParameterConfigurationDO> getParameterByIds(List<SysParameterConfigurationDO> list);
    /**
     * desc:根据id查询参数对象.<br/>
     * descSql =  select * from sys_parameter_configuration where id=#{id,jdbcType=BIGINT} and del_flag=0
     * @param id id
     * @return SysParameterConfigurationDO
     */
    SysParameterConfigurationDO getParameterById(Long id);
    /**
     * desc:根据 参数 参数值 全局唯一.<br/>
     * descSql =  SELECT count(id) FROM sys_parameter_configuration AND field_value=#{fieldValue,jdbcType=VARCHAR} AND del_flag=0 
     * @param entity entity
     * @return Integer
     */
    Integer getCountFieldValue(SysParameterConfigurationDO entity);
}
