package com.xiaowei.sys.platform.core.facade.service.req.demo;

import com.xiaowei.sys.platform.core.facade.service.req.BaseReq;
import java.io.Serializable;
import java.util.List;

/**
 * 商品详情
 *
 * @author zhangwt
 */
public class DemoReq extends BaseReq implements Serializable {

    /**
     * id
     */
    private String demoId;

    /**
     * name
     */
    private String demoName;

    /**
     * list
     */
    private List<String> strList;

    public String getDemoId() {
        return demoId;
    }

    public void setDemoId(String demoId) {
        this.demoId = demoId;
    }

    public String getDemoName() {
        return demoName;
    }

    public void setDemoName(String demoName) {
        this.demoName = demoName;
    }

    public List<String> getStrList() {
        return strList;
    }

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }
}
