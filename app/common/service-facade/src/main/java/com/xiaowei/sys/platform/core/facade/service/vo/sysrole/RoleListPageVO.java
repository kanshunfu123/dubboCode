package com.xiaowei.sys.platform.core.facade.service.vo.sysrole;

import com.xiaowei.sys.platform.core.common.dal.paging.BasePage;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MOMO on 2018/9/17.
 */
public class RoleListPageVO extends BasePage<SysRoleAndAclVO> implements Serializable {
    private String delFlag="0";//

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
