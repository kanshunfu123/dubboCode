package com.xiaowei.sys.platform.core.common.dal.resultmap;

import java.io.Serializable;


/**
 * The table 树形字典架构
 */
public class GetDictionaryInfoByUuid  implements Serializable {

private static final long serialVersionUID = -1L;

    /**
     * id .
     */
    private Long id;
    /**
     * parentId .
     */
    private String parentId;
    /**
     * delFlag .
     */
    private String delFlag;
    /**
     * label .
     */
    private String label;
    /**
     * uuid .
     */
    private String uuid;
    /**
     * codeLevel .
     */
    private String codeLevel;
    /**
     * serialNumber .
     */
    private Integer serialNumber;
    /**
     * codeName .
     */
    private String codeName;
    /**
     * codeValue .
     */
    private String codeValue;




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
     * Set parentId .
     */
    public void setParentId(String parentId){
        this.parentId = parentId;
    }

    /**
     * Get parentId .
     *
     * @return the string
     */
    public String getParentId(){
        return parentId;
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
     * Set uuid .
     */
    public void setUuid(String uuid){
        this.uuid = uuid;
    }

    /**
     * Get uuid .
     *
     * @return the string
     */
    public String getUuid(){
        return uuid;
    }

    /**
     * Set codeLevel .
     */
    public void setCodeLevel(String codeLevel){
        this.codeLevel = codeLevel;
    }

    /**
     * Get codeLevel .
     *
     * @return the string
     */
    public String getCodeLevel(){
        return codeLevel;
    }

    /**
     * Set serialNumber .
     */
    public void setSerialNumber(Integer serialNumber){
        this.serialNumber = serialNumber;
    }

    /**
     * Get serialNumber .
     *
     * @return the string
     */
    public Integer getSerialNumber(){
        return serialNumber;
    }

    /**
     * Set codeName .
     */
    public void setCodeName(String codeName){
        this.codeName = codeName;
    }

    /**
     * Get codeName .
     *
     * @return the string
     */
    public String getCodeName(){
        return codeName;
    }

    /**
     * Set codeValue .
     */
    public void setCodeValue(String codeValue){
        this.codeValue = codeValue;
    }

    /**
     * Get codeValue .
     *
     * @return the string
     */
    public String getCodeValue(){
        return codeValue;
    }



}
