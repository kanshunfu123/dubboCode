package com.xiaowei.sys.platform.core.facade.service.req.sysuser;

import com.xiaowei.sys.platform.core.facade.service.req.BaseReq;

import java.io.Serializable;

/**
 * Created by MOMO on 2018/10/11.
 */
public class DeptUserReq extends BaseReq implements Serializable {
    private String currentUserUuid;
    private Long sysUserId;

    public String getCurrentUserUuid() {
        return currentUserUuid;
    }

    public void setCurrentUserUuid(String currentUserUuid) {
        this.currentUserUuid = currentUserUuid;
    }

    public Long getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
    }
}
