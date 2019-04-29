package com.xiaowei.sys.platform.core.facade.service.vo.sysarea;

import java.util.List;

/**
 * Created by MOMO on 2018/9/17.
 */
public class SysUserAreaVO {
    private String areaName;//区域名称
    private String level;//层级
    private List<SysUserAreaVO> areaNameList;

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<SysUserAreaVO> getAreaNameList() {
        return areaNameList;
    }

    public void setAreaNameList(List<SysUserAreaVO> areaNameList) {
        this.areaNameList = areaNameList;
    }
}
