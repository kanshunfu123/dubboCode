package com.xiaowei.sys.platform.core.common.dal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysStandardDetailsDO;
import java.util.List;
import com.xiaowei.sys.platform.core.common.dal.mapper.SysStandardDetailsDOMapper;

/**
* The Table sys_standard_details.
* SYS_STANDARD_DETAILS
*/
@Repository
public class SysStandardDetailsDAO{

    @Autowired
    private SysStandardDetailsDOMapper sysStandardDetailsDOMapper;

    /**
     * desc:插入表:sys_standard_details.<br/>
     * @param entity entity
     * @return int
     */
    public int insert(SysStandardDetailsDO entity){
        return sysStandardDetailsDOMapper.insert(entity);
    }
    /**
     * desc:更新表:SYS_STANDARD_DETAILS.<br/>
     * @param entity entity
     * @return int
     */
    public int update(SysStandardDetailsDO entity){
        return sysStandardDetailsDOMapper.update(entity);
    }
    /**
     * desc:根据主键删除数据:SYS_STANDARD_DETAILS.<br/>
     * @param id id
     * @return int
     */
    public int deleteById(Long id){
        return sysStandardDetailsDOMapper.deleteById(id);
    }
    /**
     * desc:根据Uuid删除数据:SYS_STANDARD_DETAILS.<br/>
     * @param delFlag delFlag
     * @param detaiUuid detaiUuid
     * @return int
     */
    public int deleteByUuId(String delFlag,String detaiUuid){
        return sysStandardDetailsDOMapper.deleteByUuId(delFlag, detaiUuid);
    }
    /**
     * desc:根据DetailsId删除数据:SYS_STANDARD_DETAILS.<br/>
     * @param detailsId detailsId
     * @return int
     */
    public int deleteByDetailsId(Long detailsId){
        return sysStandardDetailsDOMapper.deleteByDetailsId(detailsId);
    }
    /**
     * desc:根据主键获取数据:SYS_STANDARD_DETAILS.<br/>
     * @param id id
     * @return SysStandardDetailsDO
     */
    public SysStandardDetailsDO getById(Long id){
        return sysStandardDetailsDOMapper.getById(id);
    }
    /**
     * desc:根据DetailsId获取数据:SYS_STANDARD_DETAILS.<br/>
     * @param detailsId detailsId
     * @return List<SysStandardDetailsDO>
     */
    public List<SysStandardDetailsDO> getByDetailsId(Long detailsId){
        return sysStandardDetailsDOMapper.getByDetailsId(detailsId);
    }
}
