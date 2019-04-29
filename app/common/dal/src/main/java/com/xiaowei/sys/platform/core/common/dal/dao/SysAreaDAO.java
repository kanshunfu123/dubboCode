package com.xiaowei.sys.platform.core.common.dal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysAreaDO;
import java.util.List;
import com.xiaowei.sys.platform.core.common.dal.mapper.SysAreaDOMapper;

/**
* The Table sys_area.
* 区域 省市县三级联动
*/
@Repository
public class SysAreaDAO{

    @Autowired
    private SysAreaDOMapper sysAreaDOMapper;

    /**
     * desc:插入表:sys_area.<br/>
     * @param entity entity
     * @return int
     */
    public int insert(SysAreaDO entity){
        return sysAreaDOMapper.insert(entity);
    }
    /**
     * desc:批量插入表:sys_area.<br/>
     * @param list list
     * @return int
     */
    public int insertBatch(List<SysAreaDO> list){
        return sysAreaDOMapper.insertBatch(list);
    }
    /**
     * desc:根据主键删除数据:sys_area.<br/>
     * @param id id
     * @return int
     */
    public int deleteById(Long id){
        return sysAreaDOMapper.deleteById(id);
    }
    /**
     * desc:根据主键获取数据:sys_area.<br/>
     * @param id id
     * @return SysAreaDO
     */
    public SysAreaDO getById(Long id){
        return sysAreaDOMapper.getById(id);
    }
    /**
     * desc:根据UUID获取数据:sys_area.<br/>
     * @param sysAreaUuid sysAreaUuid
     * @return SysAreaDO
     */
    public SysAreaDO getByUuid(String sysAreaUuid){
        return sysAreaDOMapper.getByUuid(sysAreaUuid);
    }
    /**
     * desc:根据id获取数据:sys_area.<br/>
     * @param id id
     * @return SysAreaDO
     */
    public SysAreaDO getByIdId(Long id){
        return sysAreaDOMapper.getByIdId(id);
    }
    /**
     * desc:根据UUID获取数据:sys_area.<br/>
     * @param list list
     * @return List<SysAreaDO>
     */
    public List<SysAreaDO> getByUuidList(List<SysAreaDO> list){
        return sysAreaDOMapper.getByUuidList(list);
    }
    /**
     * desc:根据父级id查看子区域.<br/>
     * @param entity entity
     * @return List<SysAreaDO>
     */
    public List<SysAreaDO> getareaListByParentId(SysAreaDO entity){
        return sysAreaDOMapper.getareaListByParentId(entity);
    }
    /**
     * desc:根据用户id查询区域信息，由里往外查询.<br/>
     * @param areaId areaId
     * @return SysAreaDO
     */
    public SysAreaDO areaInfo(Long areaId){
        return sysAreaDOMapper.areaInfo(areaId);
    }
    /**
     * desc:区域树.<br/>
     * @return List<SysAreaDO>
     */
    public List<SysAreaDO> areaTree(){
        return sysAreaDOMapper.areaTree();
    }
    /**
     * desc:根据区域id列表查询区域信息.<br/>
     * @param list list
     * @return List<SysAreaDO>
     */
    public List<SysAreaDO> areaListByareAIds(List<SysAreaDO> list){
        return sysAreaDOMapper.areaListByareAIds(list);
    }
    /**
     * desc:添加表:sys_area.<br/>
     * @param entity entity
     * @return int
     */
    public int insertSysArea(SysAreaDO entity){
        return sysAreaDOMapper.insertSysArea(entity);
    }
    /**
     * desc:编辑字典信息.<br/>
     * @param entity entity
     * @return int
     */
    public int updateSysArea(SysAreaDO entity){
        return sysAreaDOMapper.updateSysArea(entity);
    }
    /**
     * desc:同一层级下，区域名称是否相同.<br/>
     * @param sysAreaParentId sysAreaParentId
     * @param sysAreaName sysAreaName
     * @param sysAreaUuid sysAreaUuid
     * @return int
     */
    public int getSysAreaNameNameAndBySysAreaParentId(Long sysAreaParentId,String sysAreaName,String sysAreaUuid){
        return sysAreaDOMapper.getSysAreaNameNameAndBySysAreaParentId(sysAreaParentId, sysAreaName, sysAreaUuid);
    }
    /**
     * desc:区域更新之后，进行批量子级区域.<br/>
     * @param list list
     * @return int
     */
    public int updatebatchUpdateLevel(List<SysAreaDO> list){
        return sysAreaDOMapper.updatebatchUpdateLevel(list);
    }
    /**
     * desc:查询子区域.<br/>
     * @param level level
     * @return List<SysAreaDO>
     */
    public List<SysAreaDO> getChildAreaListByLevel(String level){
        return sysAreaDOMapper.getChildAreaListByLevel(level);
    }
    /**
     * desc:根据 区域字段值 全局唯一.<br/>
     * @param entity entity
     * @return Integer
     */
    public Integer getAreaSysAreaCodeNum(SysAreaDO entity){
        return sysAreaDOMapper.getAreaSysAreaCodeNum(entity);
    }
    /**
     * desc:根据 父级id 获取数据:sys_area.<br/>
     * @param sysAreaCodeNum sysAreaCodeNum
     * @return SysAreaDO
     */
    public SysAreaDO getLevelByParentId(Long sysAreaCodeNum){
        return sysAreaDOMapper.getLevelByParentId(sysAreaCodeNum);
    }
}
