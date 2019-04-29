package com.xiaowei.sys.platform.core.service.manager.standard;
import com.xiaowei.sys.platform.core.facade.service.req.standard.*;
import com.xiaowei.sys.platform.core.facade.service.vo.standard.StandardEditVO;
import com.xiaowei.sys.platform.core.facade.service.vo.standard.StandardPaginVO;
import com.xiaowei.sys.platform.core.facade.service.vo.standard.standByNamePagingVO;
import com.yeecli.component.common.model.Result;
import org.springframework.stereotype.Service;

/**
 * Created by WingsChan on 2018/9/7.
 */
@Service
public interface StandardService {
    /**
     * 删除
     * @param standardInfo
     * @return
     */
    Result<Object> deleteStandardByUuid(StandardInfo standardInfo);
    /**
     * 通过uuid查询标准表
     * @param standardInfo
     * @return
     */
    Result<StandardEditVO> getstandardByUuid(StandardInfo standardInfo);
    /**
     * 修改
     * @param addReqs
     * @return
     */
    Result<Object> updateStandard(StandardReqAdd addReqs);
    /**
     * 分页查询
     * @param standardPageReq
     * @return
     */
    StandardPaginVO standardPageList(StandardPageReq standardPageReq);

    /**
     * 通过类型id查标准表
     * @param standardTypeid
     * @return
     */
    public Result<Object> getStandardByTypeid(String standardTypeid);

    /**
     * 水质标准分页查询，带明细
     * @param standByNamePagingReq
     * @return
     */
    public Result<standByNamePagingVO> standByNamePaging(StandByNamePagingReq standByNamePagingReq);
}
