package com.xiaowei.sys.platform.core.facade.service.facade.details;

import com.xiaowei.sys.platform.core.facade.service.req.details.DetailsReq;
import com.yeecli.component.common.model.Result;

/**
 * Created by WingsChan on 2018/9/7.
 */
public interface DetailsFacade {
    /**
     * 例子
     *
     * @return
     */
    Result<Boolean> addDetailsInfo(DetailsReq addReqs);


}
