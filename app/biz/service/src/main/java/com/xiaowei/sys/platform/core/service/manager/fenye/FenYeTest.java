package com.xiaowei.sys.platform.core.service.manager.fenye;

import com.xiaowei.sys.platform.core.facade.service.vo.fenye.StandListPageVO;
import com.yeecli.component.common.model.Result;

/**
 * @author ZiBao
 * @date 2018/9/29
 */
public interface FenYeTest {
    public Result<StandListPageVO>findStandardList();
}
