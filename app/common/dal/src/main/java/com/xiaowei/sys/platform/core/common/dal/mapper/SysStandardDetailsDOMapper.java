package com.xiaowei.sys.platform.core.common.dal.mapper;

import com.xiaowei.sys.platform.core.common.dal.dataobject.SysStandardDetailsDO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table sys_standard_details.
 * SYS_STANDARD_DETAILS
 */
public interface SysStandardDetailsDOMapper{

    /**
     * desc:插入表:sys_standard_details.<br/>
     * descSql =  SELECT LAST_INSERT_ID() <![CDATA[ INSERT INTO sys_standard_details( ID ,DETAILS_ID ,MAX_PARM ,MIN_PARM ,DETAIL_NAME ,DETAIL_UUID ,DEL_FLAG )VALUES( null , #{detailsId,jdbcType=BIGINT} , #{maxParm,jdbcType=VARCHAR} , #{minParm,jdbcType=VARCHAR} , #{detailName,jdbcType=VARCHAR} , #{detailUuid,jdbcType=VARCHAR} ,0 ) ]]>
     * @param entity entity
     * @return int
     */
    int insert(SysStandardDetailsDO entity);
    /**
     * desc:更新表:SYS_STANDARD_DETAILS.<br/>
     * descSql =  UPDATE sys_standard_details SET DETAIL_NAME = #{detailName,jdbcType=VARCHAR} ,MAX_PARM = #{maxParm,jdbcType=VARCHAR} ,MIN_PARM = #{minParm,jdbcType=VARCHAR} ,DEL_FLAG = '0' WHERE detail_uuid = #{detailUuid,jdbcType=VARCHAR}
     * @param entity entity
     * @return int
     */
    int update(SysStandardDetailsDO entity);
    /**
     * desc:根据主键删除数据:SYS_STANDARD_DETAILS.<br/>
     * descSql =  DELETE FROM sys_standard_details WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return int
     */
    int deleteById(Long id);
    /**
     * desc:根据Uuid删除数据:SYS_STANDARD_DETAILS.<br/>
     * descSql =  UPDATE sys_standard_details SET DEL_FLAG = #{delFlag,jdbcType=CHAR} WHERE detail_uuid = #{detaiUuid,jdbcType=VARCHAR}
     * @param delFlag delFlag
     * @param detaiUuid detaiUuid
     * @return int
     */
    int deleteByUuId(@Param("delFlag")String delFlag,@Param("detaiUuid")String detaiUuid);
    /**
     * desc:根据DetailsId删除数据:SYS_STANDARD_DETAILS.<br/>
     * descSql =  UPDATE sys_standard_details SET del_flag='1' WHERE details_id = #{detailsId,jdbcType=BIGINT}
     * @param detailsId detailsId
     * @return int
     */
    int deleteByDetailsId(Long detailsId);
    /**
     * desc:根据主键获取数据:SYS_STANDARD_DETAILS.<br/>
     * descSql =  SELECT * FROM sys_standard_details WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return SysStandardDetailsDO
     */
    SysStandardDetailsDO getById(Long id);
    /**
     * desc:根据DetailsId获取数据:SYS_STANDARD_DETAILS.<br/>
     * descSql =  SELECT * FROM sys_standard_details WHERE DEL_FLAG = '0' and details_id = #{detailsId,jdbcType=BIGINT}
     * @param detailsId detailsId
     * @return List<SysStandardDetailsDO>
     */
    List<SysStandardDetailsDO> getByDetailsId(Long detailsId);
}
