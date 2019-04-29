package com.xiaowei.sys.platform.core.facade.service.vo.common;

import java.io.Serializable;

/**
 * Created by MOMO on 2018/10/31.
 */
public class ProvincesVO implements Serializable {
    //省
    private Province province;
    //市
    private City city;
    //区
    private Area area;
    //省市区 以英文逗号分隔
    private String provinceCityArea;

    public String getProvinceCityArea() {
        Area area1 = getArea();
        City city1 = getCity();
        Province province1 = getProvince();
        if (province1 != null && city1 != null && area1 != null) {
            return province1.getId() + "," + city1.getId() + "," + area1.getId();
        }
        return provinceCityArea;
    }

    public void setProvinceCityArea(String provinceCityArea) {
        this.provinceCityArea = provinceCityArea;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
