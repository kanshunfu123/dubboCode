package com.xiaowei.sys.platform.core.facade.service.facade.common;

import com.xiaowei.sys.platform.core.facade.service.req.common.ProvincesReq;
import com.xiaowei.sys.platform.core.facade.service.vo.common.ProvincesVO;
import com.yeecli.component.common.model.Result;

/**
 * Created by MOMO on 2018/10/31.
 */
public interface ProvincesFacade {
    /**
     * 根据省市区uuid 分别查询对应的对象
     * @param provincesReq
     * @return
     */
    public Result<ProvincesVO> provinces(ProvincesReq provincesReq);
}
