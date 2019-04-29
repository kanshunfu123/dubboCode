package com.xiaowei.sys.platform.core.facade.service.vo.standard;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MOMO on 2018/9/29.
 */
public class BaseStandPPage implements Serializable{

    private List<StandardDetailsvo> detailsVoList;
    private String standardTypeid;//类型从数据字典取出的codeVlue
    private String codeName;//类型名称
    private String standardUuid;//标准Uuid
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

    public List<StandardDetailsvo> getDetailsVoList() {
        return detailsVoList;
    }

    public void setDetailsVoList(List<StandardDetailsvo> detailsVoList) {
        this.detailsVoList = detailsVoList;
    }

    public String getStandardTypeid() {
        return standardTypeid;
    }

    public void setStandardTypeid(String standardTypeid) {
        this.standardTypeid = standardTypeid;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getStandardUuid() {
        return standardUuid;
    }

    public void setStandardUuid(String standardUuid) {
        this.standardUuid = standardUuid;
    }
}
