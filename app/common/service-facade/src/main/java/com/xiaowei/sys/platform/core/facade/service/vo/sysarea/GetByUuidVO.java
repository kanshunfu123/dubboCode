package com.xiaowei.sys.platform.core.facade.service.vo.sysarea;

import java.io.Serializable;

/**
 * Created by MOMO on 2018/10/18.
 */
public class GetByUuidVO implements Serializable{
    private long id;
    private String sysAreaName;//区域名称
    private String sysAreaUuid;//区域uuid

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSysAreaName() {
        return sysAreaName;
    }

    public void setSysAreaName(String sysAreaName) {
        this.sysAreaName = sysAreaName;
    }

    public String getSysAreaUuid() {
        return sysAreaUuid;
    }

    public void setSysAreaUuid(String sysAreaUuid) {
        this.sysAreaUuid = sysAreaUuid;
    }
}
