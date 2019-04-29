package com.xiaowei.sys.platform.core.common.dal.mapper;

import com.xiaowei.sys.platform.core.common.dal.dataobject.SysDictionaryDataDO;
import com.xiaowei.sys.platform.core.common.dal.resultmap.DictionaryTreeResult;
import java.util.List;
import com.xiaowei.sys.platform.core.common.dal.resultmap.GetDictionaryInfoByUuid;
import com.xiaowei.sys.platform.core.common.dal.resultmap.GetDictionaryInfoByCodeValue;
import com.xiaowei.sys.platform.core.common.dal.paging.AllDictionaryListPagePage;
import com.xiaowei.sys.platform.core.common.dal.paging.GetChildDictByCodevaluePage;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table SYS_DICTIONARY_DATA.
 * SYS_DICTIONARY_DATA
 */
public interface SysDictionaryDataDOMapper{

    /**
     * desc:插入表:SYS_DICTIONARY_DATA.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO SYS_DICTIONARY_DATA( UUID ,DEL_FLAG ,CODE_NAME ,CREATE_BY ,UPDATE_BY ,PARENT_ID ,CODE_VALUE ,SERIAL_NUMBER ,CREATE_TIME ,UPDATE_TIME )VALUES( #{uuid,jdbcType=VARCHAR} ,#{delFlag,jdbcType=CHAR} ,#{codeName,jdbcType=VARCHAR} ,#{createBy,jdbcType=VARCHAR} ,#{updateBy,jdbcType=VARCHAR} ,#{parentId,jdbcType=INTEGER} ,#{codeValue,jdbcType=INTEGER} ,#{serialNumber,jdbcType=INTEGER} ,#{createTime,jdbcType=TIMESTAMP} ,#{updateTime,jdbcType=TIMESTAMP} )
     * @param entity entity
     * @return int
     */
    int insert(SysDictionaryDataDO entity);
    /**
     * desc:更新表:SYS_DICTIONARY_DATA.<br/>
     * descSql =  UPDATE SYS_DICTIONARY_DATA SET UUID = #{uuid,jdbcType=VARCHAR} ,DEL_FLAG = #{delFlag,jdbcType=CHAR} ,CODE_NAME = #{codeName,jdbcType=VARCHAR} ,CREATE_BY = #{createBy,jdbcType=VARCHAR} ,UPDATE_BY = #{updateBy,jdbcType=VARCHAR} ,PARENT_ID = #{parentId,jdbcType=INTEGER} ,CODE_VALUE = #{codeValue,jdbcType=VARCHAR} ,SERIAL_NUMBER = #{serialNumber,jdbcType=INTEGER} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} WHERE ID = #{id,jdbcType=BIGINT}
     * @param entity entity
     * @return int
     */
    int update(SysDictionaryDataDO entity);
    /**
     * desc:根据主键删除数据:SYS_DICTIONARY_DATA.<br/>
     * descSql =  DELETE FROM SYS_DICTIONARY_DATA WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return int
     */
    int deleteById(Long id);
    /**
     * desc:根据主键获取数据:SYS_DICTIONARY_DATA.<br/>
     * descSql =  SELECT * FROM sys_dictionary_data WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return SysDictionaryDataDO
     */
    SysDictionaryDataDO getById(Long id);
    /**
     * desc:更新表:sys_dictionary_data.<br/>
     * descSql =  insert into sys_dictionary_data uuid, code_name, code_value, parent_id, code_level, serial_number, code_remake, del_flag, create_time, create_by, update_time, update_by, #{uuid,jdbcType=VARCHAR}, #{codeName,jdbcType=VARCHAR}, #{codeValue,jdbcType=VARCHAR}, #{parentId,jdbcType=VARCHAR}, #{codeLevel,jdbcType=VARCHAR}, #{serialNumber,jdbcType=INTEGER}, #{codeRemake,jdbcType=VARCHAR}, #{delFlag,jdbcType=CHAR}, #{createTime,jdbcType=TIMESTAMP}, #{createBy,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=VARCHAR}, 
     * @param entity entity
     * @return SysDictionaryDataDO
     */
    SysDictionaryDataDO saveDictionary(SysDictionaryDataDO entity);
    /**
     * desc:同一层级下，代码名称是否相同.<br/>
     * descSql =  SELECT COUNT(id) FROM sys_dictionary_data AND code_name=#{codeName,jdbcType=VARCHAR} AND parent_id=#{parentId,jdbcType=VARCHAR} AND del_flag=0 
     * @param codeName codeName
     * @param parentId parentId
     * @return int
     */
    int getBycodeNameAndByparentId(@Param("codeName")String codeName,@Param("parentId")String parentId);
    /**
     * desc:树形字典架构.<br/>
     * descSql =  SELECT DEL_FLAG, id ,CODE_NAME LABEL ,CODE_NAME ,UUID ,CODE_LEVEL ,SERIAL_NUMBER ,PARENT_ID ,code_value FROM sys_dictionary_data
     * @return List<DictionaryTreeResult>
     */
    List<DictionaryTreeResult> dictionaryTree();
    /**
     * desc:根据UUID获取数据:sys_dictionary_data.<br/>
     * descSql =  SELECT id, uuid, code_name, code_value, parent_id, code_level, serial_number, code_remake, del_flag, create_time, create_by, update_time, update_by FROM sys_dictionary_data WHERE uuid = #{uuid,jdbcType=VARCHAR}
     * @param uuid uuid
     * @return SysDictionaryDataDO
     */
    SysDictionaryDataDO getByUuid(@Param("uuid")String uuid);
    /**
     * desc:查询子级字典.<br/>
     * descSql =  SELECT id, uuid, code_name, code_value, parent_id, code_level, serial_number, code_remake, del_flag, create_time, create_by, update_time, update_by FROM sys_dictionary_data WHERE code_level LIKE CONCAT( #{level,jdbcType=VARCHAR}, '%') AND del_flag=0
     * @param level level
     * @return List<SysDictionaryDataDO>
     */
    List<SysDictionaryDataDO> getChildDictionaryListByLevel(@Param("level")String level);
    /**
     * desc:跟新字典信息.<br/>
     * descSql =  update sys_dictionary_data uuid = #{uuid,jdbcType=VARCHAR}, code_name = #{codeName,jdbcType=VARCHAR}, code_value = #{codeValue,jdbcType=VARCHAR}, parent_id = #{parentId,jdbcType=VARCHAR}, code_level = #{codeLevel,jdbcType=VARCHAR}, serial_number = #{serialNumber,jdbcType=INTEGER}, code_remake = #{codeRemake,jdbcType=VARCHAR}, del_flag = #{delFlag,jdbcType=CHAR}, create_time = #{createTime,jdbcType=TIMESTAMP}, create_by = #{createBy,jdbcType=VARCHAR}, update_time = #{updateTime,jdbcType=TIMESTAMP}, update_by = #{updateBy,jdbcType=VARCHAR}, where uuid = #{uuid,jdbcType=VARCHAR}
     * @param entity entity
     * @return int
     */
    int updateDictionary(SysDictionaryDataDO entity);
    /**
     * desc:字典更新之后，进行批量子级字典.<br/>
     * descSql =  UPDATE sys_dictionary_data SET CODE_LEVEL = #{sysDictionary.codeLevel,jdbcType=VARCHAR} ,CREATE_BY = #{sysDictionary.createBy,jdbcType=VARCHAR} ,UPDATE_BY = #{sysDictionary.updateBy,jdbcType=VARCHAR} ,CREATE_TIME = #{sysDictionary.createTime,jdbcType=TIMESTAMP} ,UPDATE_TIME = #{sysDictionary.updateTime,jdbcType=TIMESTAMP} WHERE id = #{sysDictionary.id,jdbcType=BIGINT} 
     * @param list list
     * @return int
     */
    int updatebatchUpdateLevel(List<SysDictionaryDataDO> list);
    /**
     * desc:根据uuid查看字典信息.<br/>
     * descSql =  SELECT id, uuid, code_name, code_value, parent_id, code_level, serial_number, code_remake, del_flag, create_time, create_by, update_time, update_by FROM sys_dictionary_data WHERE uuid=#{uuid,jdbcType=VARCHAR} AND del_flag=0
     * @param uuid uuid
     * @return GetDictionaryInfoByUuid
     */
    GetDictionaryInfoByUuid getDictionaryInfoByUuid(@Param("uuid")String uuid);
    /**
     * desc:根据codeValue查看字典信息.<br/>
     * descSql =  SELECT id, parent_id, code_name, code_value, del_flag, create_time, create_by, update_time, update_by, uuid, serial_number, code_level FROM sys_dictionary_data WHERE code_value=#{codeValue,jdbcType=VARCHAR} AND del_flag=0
     * @param codeValue codeValue
     * @return GetDictionaryInfoByCodeValue
     */
    GetDictionaryInfoByCodeValue getDictionaryInfoByCodeValue(@Param("codeValue")String codeValue);
    /**
     * desc:根据parentId查询.<br/>
     * descSql =  SELECT id, parent_id, code_name, code_value, del_flag, create_time, create_by, update_time, update_by, uuid, serial_number, code_level FROM sys_dictionary_data WHERE parent_id=#{parentId,jdbcType=VARCHAR} AND del_flag=0
     * @param parentId parentId
     * @return List<SysDictionaryDataDO>
     */
    List<SysDictionaryDataDO> getDictionaryInfoByParentId(@Param("parentId")String parentId);
    /**
     * desc:根据 字典字段值值 全局唯一.<br/>
     * descSql =  SELECT count(id) FROM sys_dictionary_data code_value=#{codeValue,jdbcType=VARCHAR} uuid=#{uuid,jdbcType=VARCHAR} 
     * @param entity entity
     * @return Integer
     */
    Integer getDictionaryCodeValue(SysDictionaryDataDO entity);
    /**
     * desc:根据id列表查询.<br/>
     * descSql =  select id, uuid, code_name, code_value, parent_id, FROM sys_dictionary_data AND del_flag=0 AND id in #{ids.id,jdbcType=BIGINT} 
     * @param list list
     * @return List<SysDictionaryDataDO>
     */
    List<SysDictionaryDataDO> getDictByIds(List<SysDictionaryDataDO> list);
    /**
     * desc:根据 父级id 获取数据:SYS_DICTIONARY.<br/>
     * descSql =  SELECT id, uuid, code_name, code_value, parent_id, code_level, serial_number, code_remake, del_flag, create_time, create_by, update_time, update_by FROM sys_dictionary_data WHERE code_value=#{codeValue,jdbcType=VARCHAR} and del_flag=0
     * @param codeValue codeValue
     * @return SysDictionaryDataDO
     */
    SysDictionaryDataDO getLevelByParentId(@Param("codeValue")String codeValue);
    /**
     * desc:模糊分页查询字典列表.<br/>
     * descSql =  select uuid,code_name,code_value,del_flag from sys_dictionary_data del_flag=#{delFlag,jdbcType=CHAR} AND code_name concat like('%',#{codeName,jdbcType=VARCHAR},'%') order by create_time desc
     * @param allDictionaryListPage allDictionaryListPage
     * @return int
     */
    int allDictionaryListPageCount(AllDictionaryListPagePage allDictionaryListPage);
    /**
     * desc:模糊分页查询字典列表.<br/>
     * descSql =  select uuid,code_name,code_value,del_flag from sys_dictionary_data del_flag=#{delFlag,jdbcType=CHAR} AND code_name concat like('%',#{codeName,jdbcType=VARCHAR},'%') order by create_time desc
     * @param allDictionaryListPage allDictionaryListPage
     * @return List<SysDictionaryDataDO>
     */
    List<SysDictionaryDataDO> allDictionaryListPageResult(AllDictionaryListPagePage allDictionaryListPage);
    /**
     * desc:根据code_value集合 分批查询孙子 数据字典.<br/>
     * descSql =  select id,uuid,code_name,code_value,parent_id from sys_dictionary_data and parent_id = #{parentId,jdbcType=VARCHAR} and del_flag=#{delFlag,jdbcType=CHAR} 
     * @param entity entity
     * @return List<SysDictionaryDataDO>
     */
    List<SysDictionaryDataDO> getChildDictByCodevalue(SysDictionaryDataDO entity);
    /**
     * desc:根据code_value集合 分批查询孙子 数据字典.<br/>
     * descSql =  select id,uuid,code_name,code_value,parent_id from sys_dictionary_data and parent_id = #{parentId,jdbcType=VARCHAR} and code_name LIKE CONCAT('%',#{codeName,jdbcType=VARCHAR},'%') and code_value LIKE CONCAT('%',#{codeValue,jdbcType=VARCHAR},'%') and del_flag=#{delFlag,jdbcType=CHAR} ORDER BY create_time desc
     * @param getChildDictByCodevalue getChildDictByCodevalue
     * @return int
     */
    int getChildDictByCodevaluePagingCount(GetChildDictByCodevaluePage getChildDictByCodevalue);
    /**
     * desc:根据code_value集合 分批查询孙子 数据字典.<br/>
     * descSql =  select id,uuid,code_name,code_value,parent_id from sys_dictionary_data and parent_id = #{parentId,jdbcType=VARCHAR} and code_name LIKE CONCAT('%',#{codeName,jdbcType=VARCHAR},'%') and code_value LIKE CONCAT('%',#{codeValue,jdbcType=VARCHAR},'%') and del_flag=#{delFlag,jdbcType=CHAR} ORDER BY create_time desc
     * @param getChildDictByCodevalue getChildDictByCodevalue
     * @return List<SysDictionaryDataDO>
     */
    List<SysDictionaryDataDO> getChildDictByCodevaluePagingResult(GetChildDictByCodevaluePage getChildDictByCodevalue);
    /**
     * desc:通过id查询字典.<br/>
     * descSql =  select * from sys_dictionary_data where id=#{id,jdbcType=BIGINT} and del_flag=0
     * @param id id
     * @return SysDictionaryDataDO
     */
    SysDictionaryDataDO getDictById(Long id);
}
