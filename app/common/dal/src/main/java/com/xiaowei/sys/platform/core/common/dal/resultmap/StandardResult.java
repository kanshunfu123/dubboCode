package com.xiaowei.sys.platform.core.common.dal.resultmap;

import java.io.Serializable;


/**
 * The table 水质标准列表
 */
public class StandardResult  implements Serializable {

private static final long serialVersionUID = -1L;

    /**
     * id 主键.
     */
    private long id;
    /**
     * standardUuid 标准UUID.
     */
    private String standardUuid;
    /**
     * standardName 标准名称.
     */
    private String standardName;
    /**
     * standardTypeid 标准类型 ID关联scentype场景类型ID.
     */
    private String standardTypeid;




    /**
     * Set id 主键.
     */
    public void setId(long id){
        this.id = id;
    }

    /**
     * Get id 主键.
     *
     * @return the string
     */
    public long getId(){
        return id;
    }

    /**
     * Set standardUuid 标准UUID.
     */
    public void setStandardUuid(String standardUuid){
        this.standardUuid = standardUuid;
    }

    /**
     * Get standardUuid 标准UUID.
     *
     * @return the string
     */
    public String getStandardUuid(){
        return standardUuid;
    }

    /**
     * Set standardName 标准名称.
     */
    public void setStandardName(String standardName){
        this.standardName = standardName;
    }

    /**
     * Get standardName 标准名称.
     *
     * @return the string
     */
    public String getStandardName(){
        return standardName;
    }

    /**
     * Set standardTypeid 标准类型 ID关联scentype场景类型ID.
     */
    public void setStandardTypeid(String standardTypeid){
        this.standardTypeid = standardTypeid;
    }

    /**
     * Get standardTypeid 标准类型 ID关联scentype场景类型ID.
     *
     * @return the string
     */
    public String getStandardTypeid(){
        return standardTypeid;
    }



}
