package com.xiaowei.sys.platform.core.common.dal.paging;

import com.xiaowei.sys.platform.core.common.dal.paging.BasePage;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysDictionaryDataDO;

/**
 * The table SYS_DICTIONARY_DATA SYS_DICTIONARY_DATA
 */
public class GetChildDictByCodevaluePage extends BasePage<SysDictionaryDataDO>{

    /**
     * parentId 上级id.
     */
    private String parentId;
    /**
     * codeName 代码名称.
     */
    private String codeName;
    /**
     * codeValue 代码值 关联sys_parameter_configuration表field_value.
     */
    private String codeValue;
    /**
     * delFlag 删除状态(0-正常，1-删除).
     */
    private String delFlag;

    /**
     * Set parentId 上级id.
     */
    public void setParentId(String parentId){
        this.parentId = parentId;
    }

    /**
     * Get parentId 上级id.
     *
     * @return the string
     */
    public String getParentId(){
        return parentId;
    }

    /**
     * Set codeName 代码名称.
     */
    public void setCodeName(String codeName){
        this.codeName = codeName;
    }

    /**
     * Get codeName 代码名称.
     *
     * @return the string
     */
    public String getCodeName(){
        return codeName;
    }

    /**
     * Set codeValue 代码值 关联sys_parameter_configuration表field_value.
     */
    public void setCodeValue(String codeValue){
        this.codeValue = codeValue;
    }

    /**
     * Get codeValue 代码值 关联sys_parameter_configuration表field_value.
     *
     * @return the string
     */
    public String getCodeValue(){
        return codeValue;
    }

    /**
     * Set delFlag 删除状态(0-正常，1-删除).
     */
    public void setDelFlag(String delFlag){
        this.delFlag = delFlag;
    }

    /**
     * Get delFlag 删除状态(0-正常，1-删除).
     *
     * @return the string
     */
    public String getDelFlag(){
        return delFlag;
    }
}
