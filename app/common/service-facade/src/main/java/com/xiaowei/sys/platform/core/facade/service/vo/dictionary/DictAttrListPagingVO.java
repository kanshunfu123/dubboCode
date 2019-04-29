package com.xiaowei.sys.platform.core.facade.service.vo.dictionary;

import com.xiaowei.sys.platform.core.common.dal.paging.BasePage;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MOMO on 2018/10/16.
 */
public class DictAttrListPagingVO extends BasePage<DictAttrListVO> implements Serializable{

    /**
     * 属性值
     */
    private List<DictAttrValueListVO> attrValue;
    /**
     * id 字典id.
     */
    private Long id;
    /**
     * uuid uuid.
     */
    private String uuid;
    /**
     * codeName 代码名称.
     */
    private String codeName;

    /**
     * parentId 上级id.
     */
    private String parentId;

    /**
     * codeValue 代码值 关联sys_parameter_configuration表field_value.
     */
    private String codeValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    public List<DictAttrValueListVO> getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(List<DictAttrValueListVO> attrValue) {
        this.attrValue = attrValue;
    }
}
