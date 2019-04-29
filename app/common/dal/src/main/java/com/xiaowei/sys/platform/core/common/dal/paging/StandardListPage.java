package com.xiaowei.sys.platform.core.common.dal.paging;

import com.xiaowei.sys.platform.core.common.dal.paging.BasePage;
import com.xiaowei.sys.platform.core.common.dal.resultmap.StandardResult;

/**
 * The table SYS_STANDARD SYS_STANDARD
 */
public class StandardListPage extends BasePage<StandardResult>{

    /**
     * standardName 水质标准名称.
     */
    private String standardName;

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
