package com.xiaowei.sys.platform.core.facade.service.vo.sysdept;

import java.io.Serializable;

/**
 * Created by MOMO on 2018/9/11.
 */
public class SysDeptVO implements Serializable{
    /**
     * delFlag .
     */
    private String delFlag;
    /**
     * label .
     */
    private String label;
    private String sysDeptName;
    /**
     * sysDeptUuid .
     */
    private String sysDeptUuid;
    /**
     * sysDeptLevel .
     */
    private String sysDeptLevel;
    /**
     * sysDeptRemark .
     */
    private String sysDeptRemark;
    /**
     * sysDeptSeq .
     */
    private Integer sysDeptSeq;
    private Long sysDeptCodeName;

    public Long getSysDeptCodeName() {
        return sysDeptCodeName;
    }

    public void setSysDeptCodeName(Long sysDeptCodeName) {
        this.sysDeptCodeName = sysDeptCodeName;
    }

    /**
     * Set delFlag .
     */
    public void setDelFlag(String delFlag){
        this.delFlag = delFlag;
    }

    /**
     * Get delFlag .
     *
     * @return the string
     */
    public String getDelFlag(){
        return delFlag;
    }

    /**
     * Set label .
     */
    public void setLabel(String label){
        this.label = label;
    }

    /**
     * Get label .
     *
     * @return the string
     */
    public String getLabel(){
        return label;
    }

    /**
     * Set sysDeptUuid .
     */
    public void setSysDeptUuid(String sysDeptUuid){
        this.sysDeptUuid = sysDeptUuid;
    }

    /**
     * Get sysDeptUuid .
     *
     * @return the string
     */
    public String getSysDeptUuid(){
        return sysDeptUuid;
    }

    /**
     * Set sysDeptLevel .
     */
    public void setSysDeptLevel(String sysDeptLevel){
        this.sysDeptLevel = sysDeptLevel;
    }

    /**
     * Get sysDeptLevel .
     *
     * @return the string
     */
    public String getSysDeptLevel(){
        return sysDeptLevel;
    }

    /**
     * Set sysDeptRemark .
     */
    public void setSysDeptRemark(String sysDeptRemark){
        this.sysDeptRemark = sysDeptRemark;
    }

    /**
     * Get sysDeptRemark .
     *
     * @return the string
     */
    public String getSysDeptRemark(){
        return sysDeptRemark;
    }

    /**
     * Set sysDeptSeq .
     */
    public void setSysDeptSeq(Integer sysDeptSeq){
        this.sysDeptSeq = sysDeptSeq;
    }

    /**
     * Get sysDeptSeq .
     *
     * @return the string
     */
    public Integer getSysDeptSeq(){
        return sysDeptSeq;
    }

    public String getSysDeptName() {
        return sysDeptName;
    }

    public void setSysDeptName(String sysDeptName) {
        this.sysDeptName = sysDeptName;
    }
}
