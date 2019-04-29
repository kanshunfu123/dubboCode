package com.xiaowei.sys.platform.core.common.dal.paging;

import com.xiaowei.sys.platform.core.common.dal.paging.BasePage;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysDictionaryDataDO;

/**
 * The table SYS_DICTIONARY_DATA SYS_DICTIONARY_DATA
 */
public class AllDictionaryListPagePage extends BasePage<SysDictionaryDataDO>{

    /**
     * delFlag 删除状态(0-正常，1-删除).
     */
    private String delFlag;
    /**
     * codeName 代码名称.
     */
    private String codeName;

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
}
