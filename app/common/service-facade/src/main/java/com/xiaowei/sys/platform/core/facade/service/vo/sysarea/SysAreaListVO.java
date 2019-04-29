package com.xiaowei.sys.platform.core.facade.service.vo.sysarea;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MOMO on 2018/9/17.
 */
public class SysAreaListVO implements Serializable{

    private long id;
    private String sysAreaName;//区域名称
    private String sysAreaUuid;//区域uuid
    private String level;//层级
    private String sysAreaRemark;//备注
    private Integer sysAreaSeq;//排序
    private Long sysAreaParentId;

    public Long getSysAreaParentId() {
        return sysAreaParentId;
    }

    public void setSysAreaParentId(Long sysAreaParentId) {
        this.sysAreaParentId = sysAreaParentId;
    }

    /**
     * sysAreaCodeNum 参数值.
     */
    private Long sysAreaCodeNum;
    private List<SysAreaListVO> children;

    public String getSysAreaRemark() {
        return sysAreaRemark;
    }

    public void setSysAreaRemark(String sysAreaRemark) {
        this.sysAreaRemark = sysAreaRemark;
    }

    public String getSysAreaName() {
        return sysAreaName;
    }

    public Long getSysAreaCodeNum() {
        return sysAreaCodeNum;
    }

    public void setSysAreaCodeNum(Long sysAreaCodeNum) {
        this.sysAreaCodeNum = sysAreaCodeNum;
    }

    public void setSysAreaName(String sysAreaName) {
        this.sysAreaName = sysAreaName;
    }

    public Integer getSysAreaSeq() {
        return sysAreaSeq;
    }

    public void setSysAreaSeq(Integer sysAreaSeq) {
        this.sysAreaSeq = sysAreaSeq;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<SysAreaListVO> getChildren() {
        return children;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setChildren(List<SysAreaListVO> children) {
        this.children = children;
    }

    public String getSysAreaUuid() {
        return sysAreaUuid;
    }

    public void setSysAreaUuid(String sysAreaUuid) {
        this.sysAreaUuid = sysAreaUuid;
    }
}
