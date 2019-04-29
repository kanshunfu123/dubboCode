package com.xiaowei.sys.platform.core.common.dal.mapper;

import com.xiaowei.sys.platform.core.common.dal.dataobject.SysAreaDO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table sys_area.
 * 区域 省市县三级联动
 */
public interface SysAreaDOMapper{

    /**
     * desc:插入表:sys_area.<br/>
     * descSql =  SELECT LAST_INSERT_ID() <![CDATA[ INSERT INTO sys_area( ID ,SYS_AREA_PARENT_ID ,DEL_FLAG ,CREATE_BY ,UPDATE_BY ,SYS_AREA_NAME ,SYS_AREA_UUID ,SYS_AREA_LEVEL ,SYS_AREA_REMARK ,CREATE_TIME ,UPDATE_TIME )VALUES( null , #{sysAreaParentId,jdbcType=BIGINT} , #{delFlag,jdbcType=CHAR} , #{createBy,jdbcType=VARCHAR} , #{updateBy,jdbcType=VARCHAR} , #{sysAreaName,jdbcType=VARCHAR} , #{sysAreaUuid,jdbcType=VARCHAR} , #{sysAreaLevel,jdbcType=VARCHAR} , #{sysAreaRemark,jdbcType=VARCHAR} , #{createTime,jdbcType=TIMESTAMP} , #{updateTime,jdbcType=TIMESTAMP} ) ]]>
     * @param entity entity
     * @return int
     */
    int insert(SysAreaDO entity);
    /**
     * desc:批量插入表:sys_area.<br/>
     * descSql =  INSERT INTO sys_area( ID ,SYS_AREA_PARENT_ID ,DEL_FLAG ,CREATE_BY ,UPDATE_BY ,SYS_AREA_NAME ,SYS_AREA_UUID ,SYS_AREA_LEVEL ,SYS_AREA_REMARK ,CREATE_TIME ,UPDATE_TIME )VALUES ( null , #{item.sysAreaParentId,jdbcType=BIGINT} , #{item.delFlag,jdbcType=CHAR} , #{item.createBy,jdbcType=VARCHAR} , #{item.updateBy,jdbcType=VARCHAR} , #{item.sysAreaName,jdbcType=VARCHAR} , #{item.sysAreaUuid,jdbcType=VARCHAR} , #{item.sysAreaLevel,jdbcType=VARCHAR} , #{item.sysAreaRemark,jdbcType=VARCHAR} , #{item.createTime,jdbcType=TIMESTAMP} , #{item.updateTime,jdbcType=TIMESTAMP} ) 
     * @param list list
     * @return int
     */
    int insertBatch(List<SysAreaDO> list);
    /**
     * desc:根据主键删除数据:sys_area.<br/>
     * descSql =  <![CDATA[ DELETE FROM sys_area WHERE ID = #{id,jdbcType=BIGINT} ]]>
     * @param id id
     * @return int
     */
    int deleteById(Long id);
    /**
     * desc:根据主键获取数据:sys_area.<br/>
     * descSql =  SELECT * FROM sys_area WHERE <![CDATA[ ID = #{id,jdbcType=BIGINT} ]]>
     * @param id id
     * @return SysAreaDO
     */
    SysAreaDO getById(Long id);
    /**
     * desc:根据UUID获取数据:sys_area.<br/>
     * descSql =  SELECT ID,SYS_AREA_PARENT_ID,DEL_FLAG,CREATE_BY,UPDATE_BY ,SYS_AREA_NAME,SYS_AREA_UUID,SYS_AREA_LEVEL,SYS_AREA_REMARK,sys_area_code_num FROM sys_area WHERE SYS_AREA_UUID = #{sysAreaUuid,jdbcType=VARCHAR} and del_flag=0
     * @param sysAreaUuid sysAreaUuid
     * @return SysAreaDO
     */
    SysAreaDO getByUuid(@Param("sysAreaUuid")String sysAreaUuid);
    /**
     * desc:根据id获取数据:sys_area.<br/>
     * descSql =  SELECT ID,SYS_AREA_PARENT_ID,DEL_FLAG,CREATE_BY,UPDATE_BY ,SYS_AREA_NAME,SYS_AREA_UUID,SYS_AREA_LEVEL,SYS_AREA_REMARK,sys_area_code_num FROM sys_area WHERE ID = #{id,jdbcType=BIGINT} and del_flag=0
     * @param id id
     * @return SysAreaDO
     */
    SysAreaDO getByIdId(Long id);
    /**
     * desc:根据UUID获取数据:sys_area.<br/>
     * descSql =  SELECT * FROM sys_area WHERE sys_area_uuid IN #{uuid.sysAreaUuid,jdbcType=VARCHAR} 
     * @param list list
     * @return List<SysAreaDO>
     */
    List<SysAreaDO> getByUuidList(List<SysAreaDO> list);
    /**
     * desc:根据父级id查看子区域.<br/>
     * descSql =  select ID,SYS_AREA_PARENT_ID ,SYS_AREA_NAME,SYS_AREA_UUID,sys_area_code_num from sys_area and del_flag=#{delFlag,jdbcType=CHAR} and sys_area_parent_id=#{sysAreaParentId,jdbcType=BIGINT} 
     * @param entity entity
     * @return List<SysAreaDO>
     */
    List<SysAreaDO> getareaListByParentId(SysAreaDO entity);
    /**
     * desc:根据用户id查询区域信息，由里往外查询.<br/>
     * descSql =  SELECT ID,SYS_AREA_NAME,SYS_AREA_UUID,SYS_AREA_LEVEL,sys_area_seq,sys_area_parent_id FROM sys_area WHERE id=#{areaId,jdbcType=BIGINT} AND DEL_FLAG=0
     * @param areaId areaId
     * @return SysAreaDO
     */
    SysAreaDO areaInfo(Long areaId);
    /**
     * desc:区域树.<br/>
     * descSql =  select ID ,sys_area_seq ,sys_area_parent_id ,SYS_AREA_NAME ,SYS_AREA_UUID ,SYS_AREA_LEVEL ,SYS_AREA_REMARK ,sys_area_code_num FROM sys_area where DEL_FLAG=0
     * @return List<SysAreaDO>
     */
    List<SysAreaDO> areaTree();
    /**
     * desc:根据区域id列表查询区域信息.<br/>
     * descSql =  SELECT ID,SYS_AREA_NAME,SYS_AREA_UUID,SYS_AREA_LEVEL,sys_area_seq,sys_area_parent_id,sys_area_code_num FROM sys_area WHERE id IN #{item.id,jdbcType=BIGINT} AND DEL_FLAG=0
     * @param list list
     * @return List<SysAreaDO>
     */
    List<SysAreaDO> areaListByareAIds(List<SysAreaDO> list);
    /**
     * desc:添加表:sys_area.<br/>
     * descSql =  insert into sys_area id, sys_area_uuid, sys_area_name, sys_area_level, sys_area_parent_id, sys_area_remark, del_flag, create_by, create_time, update_time, update_by, sys_area_code_num, sys_area_seq, #{id,jdbcType=BIGINT}, #{sysAreaUuid,jdbcType=VARCHAR}, #{sysAreaName,jdbcType=VARCHAR}, #{sysAreaLevel,jdbcType=VARCHAR}, #{sysAreaParentId,jdbcType=BIGINT}, #{sysAreaRemark,jdbcType=VARCHAR}, #{delFlag,jdbcType=CHAR}, #{createBy,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=VARCHAR}, #{sysAreaCodeNum,jdbcType=BIGINT}, #{sysAreaSeq,jdbcType=INTEGER}, 
     * @param entity entity
     * @return int
     */
    int insertSysArea(SysAreaDO entity);
    /**
     * desc:编辑字典信息.<br/>
     * descSql =  update sys_area sys_area_uuid = #{sysAreaUuid,jdbcType=VARCHAR}, sys_area_name = #{sysAreaName,jdbcType=VARCHAR}, sys_area_level = #{sysAreaLevel,jdbcType=VARCHAR}, sys_area_parent_id = #{sysAreaParentId,jdbcType=BIGINT}, sys_area_remark = #{sysAreaRemark,jdbcType=VARCHAR}, del_flag = #{delFlag,jdbcType=CHAR}, create_by = #{createBy,jdbcType=VARCHAR}, create_time = #{createTime,jdbcType=TIMESTAMP}, update_time = #{updateTime,jdbcType=TIMESTAMP}, update_by = #{updateBy,jdbcType=VARCHAR}, sys_area_code_num = #{sysAreaCodeNum,jdbcType=BIGINT}, sys_area_seq =#{sysAreaSeq,jdbcType=INTEGER}, where sys_area_uuid = #{sysAreaUuid,jdbcType=VARCHAR}
     * @param entity entity
     * @return int
     */
    int updateSysArea(SysAreaDO entity);
    /**
     * desc:同一层级下，区域名称是否相同.<br/>
     * descSql =  SELECT COUNT(id) FROM sys_area AND sys_area_name=#{sysAreaName,jdbcType=VARCHAR} AND sys_area_parent_id=#{sysAreaParentId,jdbcType=BIGINT} AND sys_area_uuid!=#{sysAreaUuid,jdbcType=VARCHAR} AND del_flag=0 
     * @param sysAreaParentId sysAreaParentId
     * @param sysAreaName sysAreaName
     * @param sysAreaUuid sysAreaUuid
     * @return int
     */
    int getSysAreaNameNameAndBySysAreaParentId(@Param("sysAreaParentId")Long sysAreaParentId,@Param("sysAreaName")String sysAreaName,@Param("sysAreaUuid")String sysAreaUuid);
    /**
     * desc:区域更新之后，进行批量子级区域.<br/>
     * descSql =  UPDATE sys_area SET SYS_AREA_LEVEL = #{sysArea.sysAreaLevel,jdbcType=VARCHAR} ,CREATE_BY = #{sysArea.createBy,jdbcType=VARCHAR} ,UPDATE_BY = #{sysArea.updateBy,jdbcType=VARCHAR} ,CREATE_TIME = #{sysArea.createTime,jdbcType=TIMESTAMP} ,UPDATE_TIME = #{sysArea.updateTime,jdbcType=TIMESTAMP} WHERE id = #{sysArea.id,jdbcType=BIGINT} 
     * @param list list
     * @return int
     */
    int updatebatchUpdateLevel(List<SysAreaDO> list);
    /**
     * desc:查询子区域.<br/>
     * descSql =  SELECT * FROM sys_area WHERE sys_area_level LIKE CONCAT( #{level,jdbcType=VARCHAR}, '%') AND del_flag=0
     * @param level level
     * @return List<SysAreaDO>
     */
    List<SysAreaDO> getChildAreaListByLevel(@Param("level")String level);
    /**
     * desc:根据 区域字段值 全局唯一.<br/>
     * descSql =  SELECT count(id) FROM sys_area sys_area_code_num=#{sysAreaCodeNum,jdbcType=BIGINT} 
     * @param entity entity
     * @return Integer
     */
    Integer getAreaSysAreaCodeNum(SysAreaDO entity);
    /**
     * desc:根据 父级id 获取数据:sys_area.<br/>
     * descSql =  SELECT ID ,SYS_AREA_PARENT_ID ,DEL_FLAG ,CREATE_BY ,UPDATE_BY ,SYS_AREA_NAME ,SYS_AREA_UUID ,SYS_AREA_LEVEL ,SYS_AREA_REMARK ,CREATE_TIME ,UPDATE_TIME ,sys_area_code_num ,sys_area_seq FROM sys_area WHERE sys_area_code_num=#{sysAreaCodeNum,jdbcType=BIGINT}
     * @param sysAreaCodeNum sysAreaCodeNum
     * @return SysAreaDO
     */
    SysAreaDO getLevelByParentId(Long sysAreaCodeNum);
}
