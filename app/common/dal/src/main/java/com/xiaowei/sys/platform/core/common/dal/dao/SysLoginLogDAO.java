package com.xiaowei.sys.platform.core.common.dal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysLoginLogDO;
import java.util.List;
import com.xiaowei.sys.platform.core.common.dal.mapper.SysLoginLogDOMapper;

/**
* The Table sys_login_log.
* 登录日志
*/
@Repository
public class SysLoginLogDAO{

    @Autowired
    private SysLoginLogDOMapper sysLoginLogDOMapper;

    /**
     * desc:插入表:sys_login_log.<br/>
     * @param entity entity
     * @return int
     */
    public int insert(SysLoginLogDO entity){
        return sysLoginLogDOMapper.insert(entity);
    }
    /**
     * desc:批量插入表:sys_login_log.<br/>
     * @param list list
     * @return int
     */
    public int insertBatch(List<SysLoginLogDO> list){
        return sysLoginLogDOMapper.insertBatch(list);
    }
    /**
     * desc:根据主键删除数据:sys_login_log.<br/>
     * @param id id
     * @return int
     */
    public int deleteById(Long id){
        return sysLoginLogDOMapper.deleteById(id);
    }
    /**
     * desc:根据主键获取数据:sys_login_log.<br/>
     * @param id id
     * @return SysLoginLogDO
     */
    public SysLoginLogDO getById(Long id){
        return sysLoginLogDOMapper.getById(id);
    }
    /**
     * desc:insertLoginLog.<br/>
     * @param entity entity
     * @return int
     */
    public int insertLoginLog(SysLoginLogDO entity){
        return sysLoginLogDOMapper.insertLoginLog(entity);
    }
}
