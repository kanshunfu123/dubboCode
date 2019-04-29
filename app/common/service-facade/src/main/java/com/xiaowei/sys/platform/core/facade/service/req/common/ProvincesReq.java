package com.xiaowei.sys.platform.core.facade.service.req.common;

import java.io.Serializable;

/**
 * Created by MOMO on 2018/10/31.
 */
public class ProvincesReq implements Serializable {
    //省
    private String province;
    //市
    private String city;
    //市
    private String area;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
