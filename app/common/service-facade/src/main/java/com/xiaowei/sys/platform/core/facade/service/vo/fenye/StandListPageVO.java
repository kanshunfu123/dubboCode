package com.xiaowei.sys.platform.core.facade.service.vo.fenye;

import com.xiaowei.sys.platform.core.common.dal.paging.BasePage;

/**
 * @author ZiBao
 * @date 2018/9/29
 */
public class StandListPageVO extends BasePage<StandardVO> {
    private String delFlag="0";

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
