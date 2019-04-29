package com.xiaowei.sys.platform.core.facade.service.vo.standard;

import com.xiaowei.sys.platform.core.facade.service.vo.details.DetailsVO;
import java.io.Serializable;
import java.util.List;

public class StandardEditVO implements Serializable {
    /**
     * id ID.
     */
    private Long id;
    /**
     * standardTypeid 标准类型 ID关联scentype场景类型ID.
     */
    private String standardTypeid;
    /**
     * codeName 标准类型名称
     */
    private String codeName;
    /**
     * delFlag 删除状态(0-正常，1-删除).
     */
    private String delFlag;
    /**
     * standardName 标准名称.
     */
    private String standardName;
    /**
     * standardUuid uuid.
     */
    private String standardUuid;

    private List<DetailsVO> detailsVOList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getStandardName() {
        return standardName;
    }

    public void setStandardName(String standardName) {
        this.standardName = standardName;
    }

    public String getStandardUuid() {
        return standardUuid;
    }

    public void setStandardUuid(String standardUuid) {
        this.standardUuid = standardUuid;
    }

    public List<DetailsVO> getDetailsVOList() {
        return detailsVOList;
    }

    public void setDetailsVOList(List<DetailsVO> detailsVOList) {
        this.detailsVOList = detailsVOList;
    }
}
