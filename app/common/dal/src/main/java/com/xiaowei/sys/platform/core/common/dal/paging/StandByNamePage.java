package com.xiaowei.sys.platform.core.common.dal.paging;

import com.xiaowei.sys.platform.core.common.dal.paging.BasePage;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysStandardDO;

/**
 * The table SYS_STANDARD SYS_STANDARD
 */
public class StandByNamePage extends BasePage<SysStandardDO>{

    /**
     * delFlag 删除状态(0-正常，1-删除).
     */
    private String delFlag;
    /**
     * standardName 水质标准名称.
     */
    private String standardName;

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
     * Set standardName 水质标准名称.
     */
    public void setStandardName(String standardName){
        this.standardName = standardName;
    }

    /**
     * Get standardName 水质标准名称.
     *
     * @return the string
     */
    public String getStandardName(){
        return standardName;
    }
}
