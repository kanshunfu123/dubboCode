package com.xiaowei.sys.platform.core.common.dal.paging;

import com.xiaowei.sys.platform.core.common.dal.paging.BasePage;
import com.xiaowei.sys.platform.core.common.dal.resultmap.Parameter;

/**
 * The table SYS_PARAMETER_CONFIGURATION SYS_PARAMETER_CONFIGURATION
 */
public class ParameterPage extends BasePage<Parameter>{

    /**
     * delFlag 删除状态(0-正常，1-删除).
     */
    private String delFlag;

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
