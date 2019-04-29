package com.xiaowei.sys.platform.core.common.dal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysParameterConfigurationDO;
import java.util.List;
import com.xiaowei.sys.platform.core.common.dal.paging.ParameterPage;
import com.xiaowei.sys.platform.core.common.dal.mapper.SysParameterConfigurationDOMapper;

/**
* The Table sys_parameter_configuration.
* SYS_PARAMETER_CONFIGURATION
*/
@Repository
public class SysParameterConfigurationDAO{

    @Autowired
    private SysParameterConfigurationDOMapper sysParameterConfigurationDOMapper;

    /**
     * desc:插入表:sys_parameter_configuration.<br/>
     * @param entity entity
     * @return int
     */
    public int insert(SysParameterConfigurationDO entity){
        return sysParameterConfigurationDOMapper.insert(entity);
    }
    /**
     * desc:批量插入表:sys_parameter_configuration.<br/>
     * @param list list
     * @return int
     */
    public int insertBatch(List<SysParameterConfigurationDO> list){
        return sysParameterConfigurationDOMapper.insertBatch(list);
    }
    /**
     * desc:根据主键删除数据:sys_parameter_configuration.<br/>
     * @param id id
     * @return int
     */
    public int deleteById(Long id){
        return sysParameterConfigurationDOMapper.deleteById(id);
    }
    /**
     * desc:根据主键获取数据:sys_parameter_configuration.<br/>
     * @param id id
     * @return SysParameterConfigurationDO
     */
    public SysParameterConfigurationDO getById(Long id){
        return sysParameterConfigurationDOMapper.getById(id);
    }
    /**
     * desc:更新参数表.<br/>
     * @param entity entity
     * @return int
     */
    public int updateParameter(SysParameterConfigurationDO entity){
        return sysParameterConfigurationDOMapper.updateParameter(entity);
    }
    /**
     * desc:根据fieldValue查看参数信息.<br/>
     * @param fieldValue fieldValue
     * @return List<SysParameterConfigurationDO>
     */
    public List<SysParameterConfigurationDO> getParameterInfoByFieldValue(String fieldValue){
        return sysParameterConfigurationDOMapper.getParameterInfoByFieldValue(fieldValue);
    }
    /**
     * desc:更新表:sys_parameter_configuration.<br/>
     * @param entity entity
     * @return SysParameterConfigurationDO
     */
    public SysParameterConfigurationDO saveParameter(SysParameterConfigurationDO entity){
        return sysParameterConfigurationDOMapper.saveParameter(entity);
    }
    /**
     * desc:根据字段值获取数据:sys_parameter_configuration.<br/>
     * @param uuid uuid
     * @return SysParameterConfigurationDO
     */
    public SysParameterConfigurationDO getByUuid(String uuid){
        return sysParameterConfigurationDOMapper.getByUuid(uuid);
    }
    /**
     * desc:分页查询参数列表 信息.<br/>
     * @param parameter parameter
     * @return ParameterPage
     */
    public ParameterPage parameterPaging(ParameterPage parameter){
        int total = sysParameterConfigurationDOMapper.parameterPagingCount(parameter);
        if(total>0){
            parameter.setDatas(sysParameterConfigurationDOMapper.parameterPagingResult(parameter));
        }
        parameter.setTotal(total);
        return parameter;
    }
    /**
     * desc:根据 参数 参数值 全局唯一.<br/>
     * @param entity entity
     * @return Integer
     */
    public Integer getParameterValue(SysParameterConfigurationDO entity){
        return sysParameterConfigurationDOMapper.getParameterValue(entity);
    }
    /**
     * desc:查询已存在的数量.<br/>
     * @param parameterValue parameterValue
     * @return List<SysParameterConfigurationDO>
     */
    public List<SysParameterConfigurationDO> getCountsByValue(String parameterValue){
        return sysParameterConfigurationDOMapper.getCountsByValue(parameterValue);
    }
    /**
     * desc:查询已存在的数量.<br/>
     * @param parameterName parameterName
     * @return List<SysParameterConfigurationDO>
     */
    public List<SysParameterConfigurationDO> getCountsByName(String parameterName){
        return sysParameterConfigurationDOMapper.getCountsByName(parameterName);
    }
    /**
     * desc:查询已存在的数量.<br/>
     * @param fieldValue fieldValue
     * @return SysParameterConfigurationDO
     */
    public SysParameterConfigurationDO getCountsByFieldValue(String fieldValue){
        return sysParameterConfigurationDOMapper.getCountsByFieldValue(fieldValue);
    }
    /**
     * desc:查询已存在的数量,排除自己.<br/>
     * @param id id
     * @param parameterName parameterName
     * @param parameterValue parameterValue
     * @return List<SysParameterConfigurationDO>
     */
    public List<SysParameterConfigurationDO> getCountsByAll(Long id,String parameterName,String parameterValue){
        return sysParameterConfigurationDOMapper.getCountsByAll(id, parameterName, parameterValue);
    }
    /**
     * desc:编辑时,查询已存在的数量,排除自身.<br/>
     * @param id id
     * @param parameterValue parameterValue
     * @return List<SysParameterConfigurationDO>
     */
    public List<SysParameterConfigurationDO> getEditCountsByValue(Long id,String parameterValue){
        return sysParameterConfigurationDOMapper.getEditCountsByValue(id, parameterValue);
    }
    /**
     * desc:编辑时,查询已存在的数量,排除自身.<br/>
     * @param id id
     * @param parameterName parameterName
     * @return List<SysParameterConfigurationDO>
     */
    public List<SysParameterConfigurationDO> getEditCountsByName(Long id,String parameterName){
        return sysParameterConfigurationDOMapper.getEditCountsByName(id, parameterName);
    }
    /**
     * desc:根据字典的code_value 查询详情.<br/>
     * @param entity entity
     * @return List<SysParameterConfigurationDO>
     */
    public List<SysParameterConfigurationDO> getDictAttrValueList(SysParameterConfigurationDO entity){
        return sysParameterConfigurationDOMapper.getDictAttrValueList(entity);
    }
    /**
     * desc:根据id列表查询数据详情.<br/>
     * @param list list
     * @return List<SysParameterConfigurationDO>
     */
    public List<SysParameterConfigurationDO> getParameterByIds(List<SysParameterConfigurationDO> list){
        return sysParameterConfigurationDOMapper.getParameterByIds(list);
    }
    /**
     * desc:根据id查询参数对象.<br/>
     * @param id id
     * @return SysParameterConfigurationDO
     */
    public SysParameterConfigurationDO getParameterById(Long id){
        return sysParameterConfigurationDOMapper.getParameterById(id);
    }
    /**
     * desc:根据 参数 参数值 全局唯一.<br/>
     * @param entity entity
     * @return Integer
     */
    public Integer getCountFieldValue(SysParameterConfigurationDO entity){
        return sysParameterConfigurationDOMapper.getCountFieldValue(entity);
    }
}
