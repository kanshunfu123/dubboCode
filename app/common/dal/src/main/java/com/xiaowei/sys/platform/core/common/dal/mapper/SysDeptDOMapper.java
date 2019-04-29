package com.xiaowei.sys.platform.core.common.dal.mapper;

import com.xiaowei.sys.platform.core.common.dal.dataobject.SysDeptDO;
import com.xiaowei.sys.platform.core.common.dal.paging.AllDeptPageListPage;
import java.util.List;
import com.xiaowei.sys.platform.core.common.dal.resultmap.DeptTreeResult;
import com.xiaowei.sys.platform.core.common.dal.resultmap.GetDeptInfoByUuid;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table SYS_DEPT.
 * 部门表
 */
public interface SysDeptDOMapper{

    /**
     * desc:插入表:SYS_DEPT.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO SYS_DEPT( DEL_FLAG ,CREATE_BY ,UPDATE_BY ,SYS_DEPT_NAME ,SYS_DEPT_UUID ,SYS_DEPT_LEVEL ,SYS_DEPT_REMARK ,SYS_DEPT_PARENT_ID ,SYS_DEPT_SEQ ,CREATE_TIME ,UPDATE_TIME )VALUES( #{delFlag,jdbcType=CHAR} ,#{createBy,jdbcType=VARCHAR} ,#{updateBy,jdbcType=VARCHAR} ,#{sysDeptName,jdbcType=VARCHAR} ,#{sysDeptUuid,jdbcType=VARCHAR} ,#{sysDeptLevel,jdbcType=VARCHAR} ,#{sysDeptRemark,jdbcType=VARCHAR} ,#{sysDeptParentId,jdbcType=VARCHAR} ,#{sysDeptSeq,jdbcType=INTEGER} ,#{createTime,jdbcType=TIMESTAMP} ,#{updateTime,jdbcType=TIMESTAMP} )
     * @param entity entity
     * @return int
     */
    int insert(SysDeptDO entity);
    /**
     * desc:更新表:SYS_DEPT.<br/>
     * descSql =  UPDATE SYS_DEPT SET DEL_FLAG = #{delFlag,jdbcType=CHAR} ,CREATE_BY = #{createBy,jdbcType=VARCHAR} ,UPDATE_BY = #{updateBy,jdbcType=VARCHAR} ,SYS_DEPT_NAME = #{sysDeptName,jdbcType=VARCHAR} ,SYS_DEPT_UUID = #{sysDeptUuid,jdbcType=VARCHAR} ,SYS_DEPT_LEVEL = #{sysDeptLevel,jdbcType=VARCHAR} ,SYS_DEPT_REMARK = #{sysDeptRemark,jdbcType=VARCHAR} ,SYS_DEPT_PARENT_ID = #{sysDeptParentId,jdbcType=VARCHAR} ,SYS_DEPT_SEQ = #{sysDeptSeq,jdbcType=INTEGER} ,CREATE_TIME = #{createTime,jdbcType=TIMESTAMP} ,UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP} WHERE ID = #{id,jdbcType=BIGINT}
     * @param entity entity
     * @return int
     */
    int update(SysDeptDO entity);
    /**
     * desc:根据主键删除数据:SYS_DEPT.<br/>
     * descSql =  DELETE FROM sys_dept WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return int
     */
    int deleteById(Long id);
    /**
     * desc:根据主键获取数据:SYS_DEPT.<br/>
     * descSql =  SELECT * FROM sys_dept WHERE ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return SysDeptDO
     */
    SysDeptDO getById(Long id);
    /**
     * desc:根据UUID获取数据:SYS_DEPT.<br/>
     * descSql =  SELECT * FROM sys_dept WHERE sys_dept_uuid = #{deptUuid,jdbcType=VARCHAR}
     * @param deptUuid deptUuid
     * @return SysDeptDO
     */
    SysDeptDO getByUuid(@Param("deptUuid")String deptUuid);
    /**
     * desc:根据 父级id 获取数据:SYS_DEPT.<br/>
     * descSql =  SELECT * FROM sys_dept WHERE sys_dept_code_name=#{sysDeptCodeName,jdbcType=BIGINT}
     * @param sysDeptCodeName sysDeptCodeName
     * @return SysDeptDO
     */
    SysDeptDO getLevelByParentId(Long sysDeptCodeName);
    /**
     * desc:分页查询部门列表.<br/>
     * descSql =  SELECT sys_dept_uuid,sys_dept_name FROM sys_dept WHERE del_flag=0
     * @param allDeptPageList allDeptPageList
     * @return int
     */
    int allDeptPageListCount(AllDeptPageListPage allDeptPageList);
    /**
     * desc:分页查询部门列表.<br/>
     * descSql =  SELECT sys_dept_uuid,sys_dept_name FROM sys_dept WHERE del_flag=0
     * @param allDeptPageList allDeptPageList
     * @return List<SysDeptDO>
     */
    List<SysDeptDO> allDeptPageListResult(AllDeptPageListPage allDeptPageList);
    /**
     * desc:部门更新之后，进行批量子部门.<br/>
     * descSql =  UPDATE sys_dept SET sys_dept_parent_id=#{sysDept.sysDeptParentId,jdbcType=BIGINT}, sys_dept_level = #{sysDept.sysDeptLevel,jdbcType=VARCHAR}, update_time = #{sysDept.updateTime,jdbcType=TIMESTAMP}, update_by = #{sysDept.updateBy,jdbcType=VARCHAR} WHERE id = #{sysDept.id,jdbcType=BIGINT} 
     * @param list list
     * @return Integer
     */
    Integer batchUpdateLevel(List<SysDeptDO> list);
    /**
     * desc:树形组织架构.<br/>
     * descSql =  SELECT id ,SYS_DEPT_NAME LABEL ,SYS_DEPT_UUID ,SYS_DEPT_LEVEL ,SYS_DEPT_REMARK ,sys_dept_code_name ,DEL_FLAG ,SYS_DEPT_SEQ ,SYS_DEPT_PARENT_ID FROM sys_dept WHERE del_flag=0
     * @return List<DeptTreeResult>
     */
    List<DeptTreeResult> deptTree();
    /**
     * desc:同一层级下，部门名称是否相同.<br/>
     * descSql =  SELECT COUNT(id) FROM sys_dept AND sys_dept_name=#{deptName,jdbcType=VARCHAR} AND sys_dept_parent_id=#{deptParentId,jdbcType=BIGINT} AND SYS_DEPT_UUID != #{sysDeptUuid,jdbcType=BIGINT} AND del_flag=0 
     * @param deptParentId deptParentId
     * @param deptName deptName
     * @param sysDeptUuid sysDeptUuid
     * @return int
     */
    int countByNameAndParentId(@Param("deptParentId")Long deptParentId,@Param("deptName")String deptName,@Param("sysDeptUuid")String sysDeptUuid);
    /**
     * desc:查询子部门.<br/>
     * descSql =  SELECT * FROM sys_dept WHERE sys_dept_level LIKE CONCAT( #{level,jdbcType=VARCHAR}, '%') AND del_flag=0
     * @param level level
     * @return List<SysDeptDO>
     */
    List<SysDeptDO> getChildDeptListByLevel(@Param("level")String level);
    /**
     * desc:根据uuid查看部门信息.<br/>
     * descSql =  SELECT * FROM sys_dept WHERE sys_dept_uuid=#{sysDeptUuid,jdbcType=VARCHAR} AND del_flag=0
     * @param sysDeptUuid sysDeptUuid
     * @return GetDeptInfoByUuid
     */
    GetDeptInfoByUuid getDeptInfoByUuid(@Param("sysDeptUuid")String sysDeptUuid);
    /**
     * desc:getMAXdeptCodeName.<br/>
     * descSql =  select max(sys_dept_code_name) FROM sys_dept
     * @return Long
     */
    Long getMAXdeptCodeName();
    /**
     * desc:根据 部门参数值 全局唯一.<br/>
     * descSql =  SELECT count(id) FROM sys_dept id=#{id,deptParentId,jdbcType=BIGINT} sys_dept_code_name=#{sysDeptCodeName,jdbcType=BIGINT} sys_dept_uuid!=#{sysDeptUuid,jdbcType=VARCHAR} 
     * @param entity entity
     * @return Integer
     */
    Integer getDeptCodeName(SysDeptDO entity);
    /**
     * desc:新增部门.<br/>
     * descSql =  insert into sys_dept id, sys_dept_uuid, sys_dept_name, sys_dept_code_name, sys_dept_parent_id, sys_dept_level, sys_dept_seq, sys_dept_remark, del_flag, create_by, create_time, update_time, update_by, #{id,jdbcType=BIGINT}, #{sysDeptUuid,jdbcType=VARCHAR}, #{sysDeptName,jdbcType=VARCHAR}, #{sysDeptCodeName,jdbcType=BIGINT}, #{sysDeptParentId,jdbcType=BIGINT}, #{sysDeptLevel,jdbcType=VARCHAR}, #{sysDeptSeq,jdbcType=INTEGER}, #{sysDeptRemark,jdbcType=VARCHAR}, #{delFlag,jdbcType=CHAR}, #{createBy,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=VARCHAR}, 
     * @param entity entity
     * @return int
     */
    int insertDept(SysDeptDO entity);
    /**
     * desc:跟新部门信息.<br/>
     * descSql =  update sys_dept sys_dept_uuid = #{sysDeptUuid,jdbcType=VARCHAR}, sys_dept_name = #{sysDeptName,jdbcType=VARCHAR}, sys_dept_code_name = #{sysDeptCodeName,jdbcType=BIGINT}, sys_dept_parent_id = #{sysDeptParentId,jdbcType=BIGINT}, sys_dept_level = #{sysDeptLevel,jdbcType=VARCHAR}, sys_dept_seq = #{sysDeptSeq,jdbcType=INTEGER}, sys_dept_remark = #{sysDeptRemark,jdbcType=VARCHAR}, del_flag = #{delFlag,jdbcType=CHAR}, create_by = #{createBy,jdbcType=VARCHAR}, create_time = #{createTime,jdbcType=TIMESTAMP}, update_time = #{updateTime,jdbcType=TIMESTAMP}, update_by = #{updateBy,jdbcType=VARCHAR}, where sys_dept_uuid = #{sysDeptUuid,jdbcType=VARCHAR}
     * @param entity entity
     * @return int
     */
    int updateDept(SysDeptDO entity);
    /**
     * desc:根据部门的id查看 部门对象.<br/>
     * descSql =  SELECT id ,SYS_DEPT_NAME LABEL ,SYS_DEPT_UUID ,SYS_DEPT_LEVEL ,SYS_DEPT_REMARK ,sys_dept_code_name ,DEL_FLAG ,SYS_DEPT_SEQ ,SYS_DEPT_PARENT_ID FROM sys_dept WHERE del_flag=0 and ID = #{id,jdbcType=BIGINT}
     * @param id id
     * @return SysDeptDO
     */
    SysDeptDO getDeptByUUID(Long id);
}
