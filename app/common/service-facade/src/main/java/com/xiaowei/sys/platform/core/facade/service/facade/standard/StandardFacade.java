package com.xiaowei.sys.platform.core.facade.service.facade.standard;

import com.xiaowei.sys.platform.core.facade.service.req.standard.*;
import com.xiaowei.sys.platform.core.facade.service.vo.standard.StandardEditVO;
import com.xiaowei.sys.platform.core.facade.service.vo.standard.StandardPaginVO;
import com.xiaowei.sys.platform.core.facade.service.vo.standard.standByNamePagingVO;
import com.yeecli.component.common.model.Result;

/**
 * Created by WingsChan on 2018/9/7.
 */
public interface StandardFacade {
    /**
     *
     *通过id获取标准standard表
     * @return
     */
    Result<StandardEditVO> getstandardByUuid(StandardInfo standardInfo);
    /**
     *
     *删除
     * @return
     */
    Result<Object> deleteStandard(StandardInfo standardInfo);

    /**
     *
     *修改
     * @return
     */
    Result<Object> updateStandard(StandardReqAdd reqAdd);

    /**
     *
     *分页查询
     * @return
     */
      Result<StandardPaginVO> standardPageList(StandardPageReq standardPageReq);

    /**
     * 水质标准分页查询，带明细
     * @param standByNamePagingReq
     * @return
     */
    public Result<standByNamePagingVO> standByNamePaging(StandByNamePagingReq standByNamePagingReq);
}
