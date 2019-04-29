package com.xiaowei.sys.platform.core.facade.service.vo.sysuser;

import java.io.Serializable;

/**
 * Created by MOMO on 2018/9/13.
 */
public class SysUserAreaInfoVO  implements Serializable {
    private String province;//省
    private String city;//市
    private String district;//区

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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
