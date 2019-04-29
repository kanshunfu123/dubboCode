package com.xiaowei.sys.platform.core.common.dal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysStandardDO;
import java.util.List;
import com.xiaowei.sys.platform.core.common.dal.paging.StandardListPage;
import com.xiaowei.sys.platform.core.common.dal.paging.StandByNamePage;
import com.xiaowei.sys.platform.core.common.dal.mapper.SysStandardDOMapper;

/**
* The Table sys_standard.
* SYS_STANDARD
*/
@Repository
public class SysStandardDAO{

    @Autowired
    private SysStandardDOMapper sysStandardDOMapper;

    /**
     * desc:插入表:sys_standard.<br/>
     * @param entity entity
     * @return int
     */
    public int insert(SysStandardDO entity){
        return sysStandardDOMapper.insert(entity);
    }
    /**
     * desc:批量插入表:sys_standard.<br/>
     * @param list list
     * @return int
     */
    public int insertBatch(List<SysStandardDO> list){
        return sysStandardDOMapper.insertBatch(list);
    }
    /**
     * desc:更新表:SYS_STANDARD.<br/>
     * @param entity entity
     * @return int
     */
    public int update(SysStandardDO entity){
        return sysStandardDOMapper.update(entity);
    }
    /**
     * desc:根据主键删除数据:SYS_STANDARD.<br/>
     * @param id id
     * @return int
     */
    public int deleteById(Long id){
        return sysStandardDOMapper.deleteById(id);
    }
    /**
     * desc:根据主键获取数据:SYS_STANDARD.<br/>
     * @param id id
     * @return SysStandardDO
     */
    public SysStandardDO getById(Long id){
        return sysStandardDOMapper.getById(id);
    }
    /**
     * desc:根据uuid获取数据:SYS_STANDARD.<br/>
     * @param standardUuid standardUuid
     * @return SysStandardDO
     */
    public SysStandardDO getstandardByUuid(String standardUuid){
        return sysStandardDOMapper.getstandardByUuid(standardUuid);
    }
    /**
     * desc:逻辑删除.<br/>
     * @param delFlag delFlag
     * @param standardUuid standardUuid
     * @return int
     */
    public int deleteByUuid(String delFlag,String standardUuid){
        return sysStandardDOMapper.deleteByUuid(delFlag, standardUuid);
    }
    /**
     * desc:水质标准分页.<br/>
     * @param standardList standardList
     * @return StandardListPage
     */
    public StandardListPage standardPaging(StandardListPage standardList){
        int total = sysStandardDOMapper.standardPagingCount(standardList);
        if(total>0){
            standardList.setDatas(sysStandardDOMapper.standardPagingResult(standardList));
        }
        standardList.setTotal(total);
        return standardList;
    }
    /**
     * desc:根据标准名查询是否存在.<br/>
     * @param standardName standardName
     * @return int
     */
    public int findSysStandardByName(String standardName){
        return sysStandardDOMapper.findSysStandardByName(standardName);
    }
    /**
     * desc:根据标准名查询是否存在.<br/>
     * @param id id
     * @param standardName standardName
     * @return int
     */
    public int findSysStandardByMyName(Long id,String standardName){
        return sysStandardDOMapper.findSysStandardByMyName(id, standardName);
    }
    /**
     * desc:查询数量.<br/>
     * @param standardTypeid standardTypeid
     * @return int
     */
    public int getStandard(String standardTypeid){
        return sysStandardDOMapper.getStandard(standardTypeid);
    }
    /**
     * desc:根据Typeid获取数据:SYS_STANDARD.<br/>
     * @param standardTypeid standardTypeid
     * @return List<SysStandardDO>
     */
    public List<SysStandardDO> getstandardByTypeid(String standardTypeid){
        return sysStandardDOMapper.getstandardByTypeid(standardTypeid);
    }
    /**
     * desc:水质标准分页查询，带明细.<br/>
     * @param standByName standByName
     * @return StandByNamePage
     */
    public StandByNamePage standByNamePaging(StandByNamePage standByName){
        int total = sysStandardDOMapper.standByNamePagingCount(standByName);
        if(total>0){
            standByName.setDatas(sysStandardDOMapper.standByNamePagingResult(standByName));
        }
        standByName.setTotal(total);
        return standByName;
    }
    /**
     * desc:修改时根据标准名查询是否存在.<br/>
     * @param id id
     * @param standardName standardName
     * @return int
     */
    public int findStandardByMyName(Long id,String standardName){
        return sysStandardDOMapper.findStandardByMyName(id, standardName);
    }
}
