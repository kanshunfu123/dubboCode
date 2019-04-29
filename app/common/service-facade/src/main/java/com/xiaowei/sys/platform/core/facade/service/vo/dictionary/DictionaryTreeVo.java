package com.xiaowei.sys.platform.core.facade.service.vo.dictionary;



import java.io.Serializable;
import java.util.List;

public class DictionaryTreeVo implements Serializable {
    private List<DictionaryTreeVo> children;
    /**
     * id .
     */
    private Long id;
    /**
     * ParentId .
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
     * Uuid .
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

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    /**
     *
     * codeName
     */
    private String codeName;


    private String codeValue;

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    public List<DictionaryTreeVo> getChildren() {
        return children;
    }

    public void setChildren(List<DictionaryTreeVo> children) {
        this.children = children;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCodeLevel() {
        return codeLevel;
    }

    public void setCodeLevel(String codeLevel) {
        this.codeLevel = codeLevel;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }


}
