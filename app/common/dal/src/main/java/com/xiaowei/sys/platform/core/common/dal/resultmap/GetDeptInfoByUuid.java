package com.xiaowei.sys.platform.core.common.dal.resultmap;

import java.io.Serializable;


/**
 * The table 树形组织架构
 */
public class GetDeptInfoByUuid  implements Serializable {

private static final long serialVersionUID = -1L;

    /**
     * id .
     */
    private Long id;
    /**
     * sysDeptParentId .
     */
    private Long sysDeptParentId;
    /**
     * delFlag .
     */
    private String delFlag;
    /**
     * sysDeptName .
     */
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
     * sysDeptCodeName .
     */
    private Long sysDeptCodeName;
    /**
     * sysDeptRemark .
     */
    private String sysDeptRemark;
    /**
     * sysDeptSeq .
     */
    private Integer sysDeptSeq;




    /**
     * Set id .
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * Get id .
     *
     * @return the string
     */
    public Long getId(){
        return id;
    }

    /**
     * Set sysDeptParentId .
     */
    public void setSysDeptParentId(Long sysDeptParentId){
        this.sysDeptParentId = sysDeptParentId;
    }

    /**
     * Get sysDeptParentId .
     *
     * @return the string
     */
    public Long getSysDeptParentId(){
        return sysDeptParentId;
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
     * Set sysDeptName .
     */
    public void setSysDeptName(String sysDeptName){
        this.sysDeptName = sysDeptName;
    }

    /**
     * Get sysDeptName .
     *
     * @return the string
     */
    public String getSysDeptName(){
        return sysDeptName;
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
     * Set sysDeptCodeName .
     */
    public void setSysDeptCodeName(Long sysDeptCodeName){
        this.sysDeptCodeName = sysDeptCodeName;
    }

    /**
     * Get sysDeptCodeName .
     *
     * @return the string
     */
    public Long getSysDeptCodeName(){
        return sysDeptCodeName;
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



}
