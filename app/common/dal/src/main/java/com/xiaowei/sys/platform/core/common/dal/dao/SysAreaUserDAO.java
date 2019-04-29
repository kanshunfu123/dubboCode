package com.xiaowei.sys.platform.core.common.dal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysAreaUserDO;
import java.util.List;
import com.xiaowei.sys.platform.core.common.dal.mapper.SysAreaUserDOMapper;

/**
* The Table sys_area_user.
* SYS_AREA_USER
*/
@Repository
public class SysAreaUserDAO{

    @Autowired
    private SysAreaUserDOMapper sysAreaUserDOMapper;

    /**
     * desc:插入表:sys_area_user.<br/>
     * @param entity entity
     * @return int
     */
    public int insert(SysAreaUserDO entity){
        return sysAreaUserDOMapper.insert(entity);
    }
    /**
     * desc:批量插入表:sys_area_user.<br/>
     * @param list list
     * @return int
     */
    public int insertBatch(List<SysAreaUserDO> list){
        return sysAreaUserDOMapper.insertBatch(list);
    }
    /**
     * desc:根据主键删除数据:sys_area_user.<br/>
     * @param id id
     * @return int
     */
    public int deleteById(Long id){
        return sysAreaUserDOMapper.deleteById(id);
    }
    /**
     * desc:根据主键获取数据:sys_area_user.<br/>
     * @param id id
     * @return SysAreaUserDO
     */
    public SysAreaUserDO getById(Long id){
        return sysAreaUserDOMapper.getById(id);
    }
    /**
     * desc:批量更新用户与区域.<br/>
     * @param list list
     * @return int
     */
    public int updateBatch(List<SysAreaUserDO> list){
        return sysAreaUserDOMapper.updateBatch(list);
    }
    /**
     * desc:批量插入用户与区域.<br/>
     * @param list list
     * @return int
     */
    public int insertBatchaa(List<SysAreaUserDO> list){
        return sysAreaUserDOMapper.insertBatchaa(list);
    }
    /**
     * desc:根据用户id，查询用户的区域id.<br/>
     * @param sysUserId sysUserId
     * @return List<SysAreaUserDO>
     */
    public List<SysAreaUserDO> getAreaUserListByUserId(Long sysUserId){
        return sysAreaUserDOMapper.getAreaUserListByUserId(sysUserId);
    }
    /**
     * desc:删除区域.<br/>
     * @param sysAreaId sysAreaId
     * @return int
     */
    public int getArea(Long sysAreaId){
        return sysAreaUserDOMapper.getArea(sysAreaId);
    }
}
