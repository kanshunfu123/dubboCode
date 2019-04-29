package com.xiaowei.sys.platform.core.common.dal.mapper;

import com.xiaowei.sys.platform.core.common.dal.dataobject.SysStandardTypeDO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table sys_standard_type.
 * 水质标准类型
 */
public interface SysStandardTypeDOMapper{

    /**
     * desc:插入表:sys_standard_type.<br/>
     * descSql =  SELECT LAST_INSERT_ID() <![CDATA[ INSERT INTO sys_standard_type( ID ,DEL_FLAG ,CODE_NAME ,CREATE_BY ,UPDATE_BY ,CODE_VALUE ,PARENT_VALUE ,CREATE_TIME ,UPDATE_TIME )VALUES( null , #{delFlag,jdbcType=CHAR} , #{codeName,jdbcType=VARCHAR} , #{createBy,jdbcType=VARCHAR} , #{updateBy,jdbcType=VARCHAR} , #{codeValue,jdbcType=VARCHAR} , #{parentValue,jdbcType=INTEGER} , #{createTime,jdbcType=TIMESTAMP} , #{updateTime,jdbcType=TIMESTAMP} ) ]]>
     * @param entity entity
     * @return int
     */
    int insert(SysStandardTypeDO entity);
    /**
     * desc:批量插入表:sys_standard_type.<br/>
     * descSql =  INSERT INTO sys_standard_type( ID ,DEL_FLAG ,CODE_NAME ,CREATE_BY ,UPDATE_BY ,CODE_VALUE ,PARENT_VALUE ,CREATE_TIME ,UPDATE_TIME )VALUES ( null , #{item.delFlag,jdbcType=CHAR} , #{item.codeName,jdbcType=VARCHAR} , #{item.createBy,jdbcType=VARCHAR} , #{item.updateBy,jdbcType=VARCHAR} , #{item.codeValue,jdbcType=VARCHAR} , #{item.parentValue,jdbcType=INTEGER} , #{item.createTime,jdbcType=TIMESTAMP} , #{item.updateTime,jdbcType=TIMESTAMP} ) 
     * @param list list
     * @return int
     */
    int insertBatch(List<SysStandardTypeDO> list);
    /**
     * desc:根据主键删除数据:sys_standard_type.<br/>
     * descSql =  <![CDATA[ DELETE FROM sys_standard_type WHERE ID = #{id,jdbcType=BIGINT} ]]>
     * @param id id
     * @return int
     */
    int deleteById(Long id);
    /**
     * desc:根据主键获取数据:sys_standard_type.<br/>
     * descSql =  SELECT * FROM sys_standard_type WHERE <![CDATA[ ID = #{id,jdbcType=BIGINT} ]]>
     * @param id id
     * @return SysStandardTypeDO
     */
    SysStandardTypeDO getById(Long id);
    /**
     * desc:根据codeValue查询codeName.<br/>
     * descSql =  select * from sys_standard_type where code_value=#{codeValue,jdbcType=VARCHAR}
     * @param codeValue codeValue
     * @return SysStandardTypeDO
     */
    SysStandardTypeDO getNameByValue(@Param("codeValue")String codeValue);
    /**
     * desc:根据parentValue查询水质标准类型.<br/>
     * descSql =  select * from sys_standard_type where parent_value=#{parentValue,jdbcType=VARCHAR}
     * @param parentValue parentValue
     * @return List<SysStandardTypeDO>
     */
    List<SysStandardTypeDO> getByValue(@Param("parentValue")String parentValue);
}
