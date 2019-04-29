package com.xiaowei.sys.platform.core.service.manager.sysarea;

import com.xiaowei.sys.platform.core.facade.service.req.sysarea.GetByUuidReq;
import com.xiaowei.sys.platform.core.facade.service.req.sysarea.SysAreaParentIdReq;
import com.xiaowei.sys.platform.core.facade.service.vo.sysarea.SysAreaAddVo;
import com.xiaowei.sys.platform.core.facade.service.vo.sysarea.SysAreaListVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysarea.SysAreaParentIdVo;
import com.xiaowei.sys.platform.core.facade.service.vo.sysarea.GetByUuidVO;
import com.yeecli.component.common.model.Result;

import java.util.List;

/**
 * Created by MOMO on 2018/9/17.
 */
public interface SysAreaService {

    /**
     * 区域递归树
     * @return
     */
    public Result<List<SysAreaListVO>> areaTreeList();
    /**
     * 新增区域
     * @param sysAreaAddVo
     * @return
     */
    public Result<Object>insertSysArea(SysAreaAddVo sysAreaAddVo);
    /**
     * 编辑区域
     * @param sysAreaAddVo
     * @return
     */
    public Result<Object>editSysArea(SysAreaAddVo sysAreaAddVo);
    /**
     * 逻辑删除区域
     * @param sysAreaAddVo
     * @return
     */
    public Result<Object>delSysArea(SysAreaAddVo sysAreaAddVo);

    /**
     * 根据父级id查看子区域
     * @param sysAreaParentIdReq
     * @return
     */
    public Result<List<SysAreaParentIdVo>> getareaListByParentId(SysAreaParentIdReq sysAreaParentIdReq);

    /**
     * 根据uuid查询区域信息
     * @param getByUuidReq
     * @return
     */
    public Result<GetByUuidVO> getByUuid(GetByUuidReq getByUuidReq);

    /**
     * 根据 id 查询区域信息
     * @param getByUuidReq
     * @return
     */
    public Result<GetByUuidVO> getByIdId(GetByUuidReq getByUuidReq);
}
