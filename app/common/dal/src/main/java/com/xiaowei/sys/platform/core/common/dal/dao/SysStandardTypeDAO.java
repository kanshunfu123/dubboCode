package com.xiaowei.sys.platform.core.common.dal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysStandardTypeDO;
import java.util.List;
import com.xiaowei.sys.platform.core.common.dal.mapper.SysStandardTypeDOMapper;

/**
* The Table sys_standard_type.
* 水质标准类型
*/
@Repository
public class SysStandardTypeDAO{

    @Autowired
    private SysStandardTypeDOMapper sysStandardTypeDOMapper;

    /**
     * desc:插入表:sys_standard_type.<br/>
     * @param entity entity
     * @return int
     */
    public int insert(SysStandardTypeDO entity){
        return sysStandardTypeDOMapper.insert(entity);
    }
    /**
     * desc:批量插入表:sys_standard_type.<br/>
     * @param list list
     * @return int
     */
    public int insertBatch(List<SysStandardTypeDO> list){
        return sysStandardTypeDOMapper.insertBatch(list);
    }
    /**
     * desc:根据主键删除数据:sys_standard_type.<br/>
     * @param id id
     * @return int
     */
    public int deleteById(Long id){
        return sysStandardTypeDOMapper.deleteById(id);
    }
    /**
     * desc:根据主键获取数据:sys_standard_type.<br/>
     * @param id id
     * @return SysStandardTypeDO
     */
    public SysStandardTypeDO getById(Long id){
        return sysStandardTypeDOMapper.getById(id);
    }
    /**
     * desc:根据codeValue查询codeName.<br/>
     * @param codeValue codeValue
     * @return SysStandardTypeDO
     */
    public SysStandardTypeDO getNameByValue(String codeValue){
        return sysStandardTypeDOMapper.getNameByValue(codeValue);
    }
    /**
     * desc:根据parentValue查询水质标准类型.<br/>
     * @param parentValue parentValue
     * @return List<SysStandardTypeDO>
     */
    public List<SysStandardTypeDO> getByValue(String parentValue){
        return sysStandardTypeDOMapper.getByValue(parentValue);
    }
}
