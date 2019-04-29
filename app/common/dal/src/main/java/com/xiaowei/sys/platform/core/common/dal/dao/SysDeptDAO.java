package com.xiaowei.sys.platform.core.common.dal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysDeptDO;
import com.xiaowei.sys.platform.core.common.dal.paging.AllDeptPageListPage;
import java.util.List;
import com.xiaowei.sys.platform.core.common.dal.resultmap.DeptTreeResult;
import com.xiaowei.sys.platform.core.common.dal.resultmap.GetDeptInfoByUuid;
import com.xiaowei.sys.platform.core.common.dal.mapper.SysDeptDOMapper;

/**
* The Table SYS_DEPT.
* 部门表
*/
@Repository
public class SysDeptDAO{

    @Autowired
    private SysDeptDOMapper sysDeptDOMapper;

    /**
     * desc:插入表:SYS_DEPT.<br/>
     * @param entity entity
     * @return int
     */
    public int insert(SysDeptDO entity){
        return sysDeptDOMapper.insert(entity);
    }
    /**
     * desc:更新表:SYS_DEPT.<br/>
     * @param entity entity
     * @return int
     */
    public int update(SysDeptDO entity){
        return sysDeptDOMapper.update(entity);
    }
    /**
     * desc:根据主键删除数据:SYS_DEPT.<br/>
     * @param id id
     * @return int
     */
    public int deleteById(Long id){
        return sysDeptDOMapper.deleteById(id);
    }
    /**
     * desc:根据主键获取数据:SYS_DEPT.<br/>
     * @param id id
     * @return SysDeptDO
     */
    public SysDeptDO getById(Long id){
        return sysDeptDOMapper.getById(id);
    }
    /**
     * desc:根据UUID获取数据:SYS_DEPT.<br/>
     * @param deptUuid deptUuid
     * @return SysDeptDO
     */
    public SysDeptDO getByUuid(String deptUuid){
        return sysDeptDOMapper.getByUuid(deptUuid);
    }
    /**
     * desc:根据 父级id 获取数据:SYS_DEPT.<br/>
     * @param sysDeptCodeName sysDeptCodeName
     * @return SysDeptDO
     */
    public SysDeptDO getLevelByParentId(Long sysDeptCodeName){
        return sysDeptDOMapper.getLevelByParentId(sysDeptCodeName);
    }
    /**
     * desc:分页查询部门列表.<br/>
     * @param allDeptPageList allDeptPageList
     * @return AllDeptPageListPage
     */
    public AllDeptPageListPage allDeptPageList(AllDeptPageListPage allDeptPageList){
        int total = sysDeptDOMapper.allDeptPageListCount(allDeptPageList);
        if(total>0){
            allDeptPageList.setDatas(sysDeptDOMapper.allDeptPageListResult(allDeptPageList));
        }
        allDeptPageList.setTotal(total);
        return allDeptPageList;
    }
    /**
     * desc:部门更新之后，进行批量子部门.<br/>
     * @param list list
     * @return Integer
     */
    public Integer batchUpdateLevel(List<SysDeptDO> list){
        return sysDeptDOMapper.batchUpdateLevel(list);
    }
    /**
     * desc:树形组织架构.<br/>
     * @return List<DeptTreeResult>
     */
    public List<DeptTreeResult> deptTree(){
        return sysDeptDOMapper.deptTree();
    }
    /**
     * desc:同一层级下，部门名称是否相同.<br/>
     * @param deptParentId deptParentId
     * @param deptName deptName
     * @param sysDeptUuid sysDeptUuid
     * @return int
     */
    public int countByNameAndParentId(Long deptParentId,String deptName,String sysDeptUuid){
        return sysDeptDOMapper.countByNameAndParentId(deptParentId, deptName, sysDeptUuid);
    }
    /**
     * desc:查询子部门.<br/>
     * @param level level
     * @return List<SysDeptDO>
     */
    public List<SysDeptDO> getChildDeptListByLevel(String level){
        return sysDeptDOMapper.getChildDeptListByLevel(level);
    }
    /**
     * desc:根据uuid查看部门信息.<br/>
     * @param sysDeptUuid sysDeptUuid
     * @return GetDeptInfoByUuid
     */
    public GetDeptInfoByUuid getDeptInfoByUuid(String sysDeptUuid){
        return sysDeptDOMapper.getDeptInfoByUuid(sysDeptUuid);
    }
    /**
     * desc:getMAXdeptCodeName.<br/>
     * @return Long
     */
    public Long getMAXdeptCodeName(){
        return sysDeptDOMapper.getMAXdeptCodeName();
    }
    /**
     * desc:根据 部门参数值 全局唯一.<br/>
     * @param entity entity
     * @return Integer
     */
    public Integer getDeptCodeName(SysDeptDO entity){
        return sysDeptDOMapper.getDeptCodeName(entity);
    }
    /**
     * desc:新增部门.<br/>
     * @param entity entity
     * @return int
     */
    public int insertDept(SysDeptDO entity){
        return sysDeptDOMapper.insertDept(entity);
    }
    /**
     * desc:跟新部门信息.<br/>
     * @param entity entity
     * @return int
     */
    public int updateDept(SysDeptDO entity){
        return sysDeptDOMapper.updateDept(entity);
    }
    /**
     * desc:根据部门的id查看 部门对象.<br/>
     * @param id id
     * @return SysDeptDO
     */
    public SysDeptDO getDeptByUUID(Long id){
        return sysDeptDOMapper.getDeptByUUID(id);
    }
}
