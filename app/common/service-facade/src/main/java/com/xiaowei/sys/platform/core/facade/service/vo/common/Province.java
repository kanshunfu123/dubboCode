package com.xiaowei.sys.platform.core.facade.service.vo.common;

import java.io.Serializable;

/**
 * Created by MOMO on 2018/10/31.
 * 省
 */
public class Province implements Serializable{
    private long id;
    //区域名称
    private String sysAreaName;
    //区域uuid
    private String sysAreaUuid;
    private Long sysAreaCodeNum;
    private Long sysAreaParentId;
    private String delFlag;

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

    public Long getSysAreaCodeNum() {
        return sysAreaCodeNum;
    }

    public void setSysAreaCodeNum(Long sysAreaCodeNum) {
        this.sysAreaCodeNum = sysAreaCodeNum;
    }

    public Long getSysAreaParentId() {
        return sysAreaParentId;
    }

    public void setSysAreaParentId(Long sysAreaParentId) {
        this.sysAreaParentId = sysAreaParentId;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
