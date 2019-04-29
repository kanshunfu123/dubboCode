package com.xiaowei.sys.platform.core.service.manager.sysarea;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.xiaowei.sys.platform.core.common.dal.dao.SysAreaDAO;
import com.xiaowei.sys.platform.core.common.dal.dao.SysAreaUserDAO;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysAreaDO;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysAreaUserDO;
import com.xiaowei.sys.platform.core.facade.service.req.sysarea.GetByUuidReq;
import com.xiaowei.sys.platform.core.facade.service.req.sysarea.SysAreaParentIdReq;
import com.xiaowei.sys.platform.core.facade.service.util.DateUtil;
import com.xiaowei.sys.platform.core.facade.service.util.LevelUtil;
import com.xiaowei.sys.platform.core.facade.service.util.StringUtils;
import com.xiaowei.sys.platform.core.facade.service.vo.sysarea.GetByUuidVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysarea.SysAreaAddVo;
import com.xiaowei.sys.platform.core.facade.service.vo.sysarea.SysAreaListVO;
import com.xiaowei.sys.platform.core.facade.service.vo.sysarea.SysAreaParentIdVo;
import com.xiaowei.sys.platform.core.service.exception.ErrorEnum;
import com.yeecli.component.common.model.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Created by MOMO on 2018/9/17.
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Configuration
public class SysAreaServiceImpl implements SysAreaService {
    @Autowired
    private SysAreaDAO sysAreaDAO;
    @Autowired
    private SysAreaUserDAO sysAreaUserDAO;

    @Override
    public Result<List<SysAreaListVO>> areaTreeList() {
        //递归树最终结果集
        List<SysAreaListVO> dtoList = Lists.newArrayList();
        //得到所有部门
        List<SysAreaDO> sysAreaDOS = sysAreaDAO.areaTree();
        sysAreaDOS.forEach(aa -> {
            SysAreaListVO sysAreaListVO = new SysAreaListVO();
            sysAreaListVO.setId(aa.getId());
            sysAreaListVO.setSysAreaUuid(aa.getSysAreaUuid());
            sysAreaListVO.setSysAreaName(aa.getSysAreaName());
            sysAreaListVO.setSysAreaSeq(aa.getSysAreaSeq());
            sysAreaListVO.setLevel(aa.getSysAreaLevel());
            sysAreaListVO.setSysAreaParentId(aa.getSysAreaParentId());
            sysAreaListVO.setSysAreaRemark(aa.getSysAreaRemark());
            sysAreaListVO.setSysAreaCodeNum(aa.getSysAreaCodeNum());
            dtoList.add(sysAreaListVO);
        });
        return Result.wrapSuccessfulResult(deptMenuToTree(dtoList));
    }


    @Override
    public Result<Object> insertSysArea(SysAreaAddVo sysAreaAddVo) {
        SysAreaDO sysAreaDO = new SysAreaDO();
        BeanUtils.copyProperties(sysAreaAddVo, sysAreaDO);
        int count = sysAreaDAO.getAreaSysAreaCodeNum(sysAreaDO);
        if (count > 0) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_ADD_AREA_CODE_NAME_FAIL.getErrorCode(), ErrorEnum.ERROR_ADD_AREA_CODE_NAME_FAIL.getErrorMessage());

        }
        if (sysAreaDO.getSysAreaParentId() == null) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_ADD_AREA_PARENT_ID_NAME_FAIL.getErrorCode(), ErrorEnum.ERROR_ADD_AREA_PARENT_ID_NAME_FAIL.getErrorMessage());

        }
        if (checkExist(null, sysAreaAddVo.getSysAreaName(), null)) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_AREA_NAME_EXIST_FAIL.getErrorCode(), ErrorEnum.ERROR_AREA_NAME_EXIST_FAIL.getErrorMessage());
        }
        //根据uuid计算  level层级
        String level = getLevel(sysAreaDO.getSysAreaParentId());
        String newLevel = LevelUtil.calculateLevel(level, sysAreaDO.getSysAreaParentId());
        sysAreaDO.setSysAreaLevel(newLevel);
        sysAreaDO.setDelFlag("0");
        sysAreaDO.setCreateTime(DateUtil.getDateTime());
        sysAreaDO.setCreateBy(sysAreaAddVo.getUserName());
        sysAreaDO.setUpdateTime(DateUtil.getDateTime());
        sysAreaDO.setUpdateBy(sysAreaAddVo.getUserName());
        sysAreaDO.setSysAreaUuid(StringUtils.genUUID());
        sysAreaDAO.insertSysArea(sysAreaDO);
        return Result.wrapSuccessfulResult("添加区域成功");
    }

    @Override
    public Result<Object> editSysArea(SysAreaAddVo sysAreaAddVo) {
        SysAreaDO before = sysAreaDAO.getByUuid(sysAreaAddVo.getSysAreaUuid());
        if (before == null) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_UPDATE_AREA_NO_EXIST_FAIL.getErrorCode(), ErrorEnum.ERROR_UPDATE_AREA_NO_EXIST_FAIL.getErrorMessage());
        }
        if (checkExist(sysAreaAddVo.getSysAreaParentId(), sysAreaAddVo.getSysAreaName(), sysAreaAddVo.getSysAreaUuid())) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_AREA_NAME_EXIST_FAIL.getErrorCode(), ErrorEnum.ERROR_AREA_NAME_EXIST_FAIL.getErrorMessage());
        }

        SysAreaDO after = new SysAreaDO();
        BeanUtils.copyProperties(sysAreaAddVo, after);

        //得到父级level
        String level = null;
        SysAreaDO sysAreaDO = sysAreaDAO.getLevelByParentId(sysAreaAddVo.getSysAreaParentId());
        Long fatherId = 0L;
        if (sysAreaDO != null) {
            level = sysAreaDO.getSysAreaLevel();
            fatherId = sysAreaDO.getSysAreaCodeNum();
        } else {
            SysAreaDO sysAreaDOaa = new SysAreaDO();
            sysAreaDOaa.setSysAreaCodeNum(sysAreaAddVo.getSysAreaParentId());
            sysAreaDOaa.setSysAreaUuid(sysAreaAddVo.getSysAreaUuid());
            int countaa = sysAreaDAO.getAreaSysAreaCodeNum(sysAreaDOaa);
            if (countaa <= 0) {
                return Result.wrapErrorResult(ErrorEnum.ERROR_AREA_CODE_NAME_NOT_EXIST_FAIL.getErrorCode(), ErrorEnum.ERROR_AREA_CODE_NAME_NOT_EXIST_FAIL.getErrorMessage());
            }
        }
        String newLevel = LevelUtil.calculateLevel(level, fatherId);
        after.setSysAreaLevel(newLevel);
        //是否需要更新子部门
        updateWithChild(before, after, fatherId, sysAreaAddVo);
        return Result.wrapSuccessfulResult("更新区域成功");

    }

    @Override
    public Result<Object> delSysArea(SysAreaAddVo sysAreaAddVo) {
        SysAreaDO sysAreaDO = sysAreaDAO.getByUuid(sysAreaAddVo.getSysAreaUuid());
        int count = sysAreaUserDAO.getArea(sysAreaDO.getId());
        if (null == sysAreaDO) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_DEL_AREA_NO_EXIST_FAIL.getErrorCode(), ErrorEnum.ERROR_DEL_AREA_NO_EXIST_FAIL.getErrorMessage());
        }
        if (checkExist(sysAreaDO.getSysAreaCodeNum(), null, null)) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_DEL_AREA_EXIST_CHILD_DEPT_FAIL.getErrorCode(), ErrorEnum.ERROR_DEL_AREA_EXIST_CHILD_DEPT_FAIL.getErrorMessage());
        }
//        SysAreaUserDO sysAreaUserDO=new SysAreaUserDO();
////        sysAreaUserDO.setSysAreaId(sysAreaDO.getId());
////        Integer count=sysAreaUserDAO.getArea(sysAreaUserDO);

        if (count > 0) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_DEL_AREA_EXIST_CHILD_DEPT_FAIL.getErrorCode(), ErrorEnum.ERROR_DEL_AREA_EXIST_CHILD_DEPT_FAIL.getErrorMessage());
        }
        SysAreaDO after = new SysAreaDO();
        after.setSysAreaUuid(sysAreaAddVo.getSysAreaUuid());
        //TODO
        after.setDelFlag("1");
        after.setUpdateBy(sysAreaAddVo.getUserName());
        after.setUpdateTime(DateUtil.getDateTime());
        sysAreaDAO.updateSysArea(after);
        return Result.wrapSuccessfulResult("删除区域成功");
    }

    private String getLevel(Long parentId) {
        if (parentId == null) {
            return null;
        }
        SysAreaDO sysAreaDO = sysAreaDAO.getLevelByParentId(parentId);
        if (sysAreaDO == null) {
            return null;
        } else {
            return sysAreaDO.getSysAreaLevel();
        }
    }

    public List<SysAreaListVO> deptMenuToTree(List<SysAreaListVO> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
            return Lists.newArrayList();
        }
        //可以放相同的key，比普通的map高级
        //把当前的tree以level为key 相同level的部门作为value，放到map里
        // level->[dept1,dept2,....]
        Multimap<String, SysAreaListVO> levelDeptMap = ArrayListMultimap.create();
        //用来保存第一层级的树,同时也是最终的部门树
        List<SysAreaListVO> rootList = Lists.newArrayList();
        for (SysAreaListVO dto : dtoList) {
            levelDeptMap.put(dto.getLevel(), dto);
            if (LevelUtil.ROOT.equals(dto.getLevel())) {
                rootList.add(dto);
            }
        }
        //按照 seq 从小到大 对部门树进行排序
        Collections.sort(rootList, new Comparator<SysAreaListVO>() {
            @Override
            public int compare(SysAreaListVO o1, SysAreaListVO o2) {
                return o1.getSysAreaSeq() - o2.getSysAreaSeq();
            }
        });
        //递归生成树
        transformDeptTree(rootList, LevelUtil.ROOT, levelDeptMap);
        return rootList;
    }

    private void transformDeptTree(List<SysAreaListVO> deptLevelList, String level, Multimap<String, SysAreaListVO> levelDeptMap) {
        int size = deptLevelList.size();
        for (int i = 0; i < size; i++) {
            //遍历该层的每个元素
            SysAreaListVO depetMenuDto = deptLevelList.get(i);
            //处理当前层级的数据
            String nexeLevel = LevelUtil.calculateLevel(level, depetMenuDto.getSysAreaCodeNum());
            //处理下一层
            List<SysAreaListVO> tempDeptList = (List<SysAreaListVO>) levelDeptMap.get(nexeLevel);
            if (!CollectionUtils.isEmpty(tempDeptList)) {
                //排序
                Collections.sort(tempDeptList, deptSeqComparator);
                //设置下一层部门
                depetMenuDto.setChildren(tempDeptList);
                //进入到下一层处理
                transformDeptTree(tempDeptList, nexeLevel, levelDeptMap);
            }
        }
    }

    private Comparator<SysAreaListVO> deptSeqComparator = new Comparator<SysAreaListVO>() {
        @Override
        public int compare(SysAreaListVO o1, SysAreaListVO o2) {
            return o1.getSysAreaSeq() - o2.getSysAreaSeq();
        }
    };

    private boolean checkExist(Long sysAreaParentId, String sysAreaName, String sysAreaUuid) {

        return sysAreaDAO.getSysAreaNameNameAndBySysAreaParentId(sysAreaParentId, sysAreaName, sysAreaUuid) > 0;
    }

    private void updateWithChild(SysAreaDO before, SysAreaDO after, long fatherId, SysAreaAddVo sysAreaAddVo) {
        //更新过后的字典level
        String newLevelPrefix = after.getSysAreaLevel();
        //更新之前的字典level
        String oldLevelPrefix = before.getSysAreaLevel();
        String newLevel = LevelUtil.calculateLevel(oldLevelPrefix, before.getSysAreaCodeNum());
        if (!newLevelPrefix.equals(oldLevelPrefix)) {
            //查询子子孙孙 进行更新
            List<SysAreaDO> dicList = sysAreaDAO.getChildAreaListByLevel(newLevel);
            if (!CollectionUtils.isEmpty(dicList)) {
                for (SysAreaDO dict : dicList) {
                    String level = dict.getSysAreaLevel();
                    if (level.indexOf(oldLevelPrefix) == 0) {
                        level = newLevelPrefix + level.substring(oldLevelPrefix.length());
                        dict.setSysAreaLevel(level);
                        dict.setSysAreaParentId(fatherId);
                        //TODO
                        dict.setCreateTime(new Date());
                        dict.setCreateBy(sysAreaAddVo.getUserName());
                        dict.setUpdateTime(new Date());
                        dict.setUpdateBy(sysAreaAddVo.getUserName());
                    }
                }
                sysAreaDAO.updatebatchUpdateLevel(dicList);
            }
        }
        after.setSysAreaParentId(fatherId);
        sysAreaDAO.updateSysArea(after);
    }

    @Override
    public Result<List<SysAreaParentIdVo>> getareaListByParentId(SysAreaParentIdReq sysAreaParentIdReq) {

        SysAreaDO sysArea = sysAreaDAO.getByUuid(sysAreaParentIdReq.getSysAreaUuid());
        if (null == sysArea) {
            return Result.wrapErrorResult(ErrorEnum.ERROR_FATHER_AREA_NOT_EXIST_FAIL.getErrorCode(), ErrorEnum.ERROR_FATHER_AREA_NOT_EXIST_FAIL.getErrorMessage());
        }
        List<SysAreaParentIdVo> sysAreaParentIdVos = Lists.newArrayList();
        SysAreaDO entity = new SysAreaDO();
        entity.setSysAreaParentId(sysArea.getSysAreaCodeNum());
        entity.setDelFlag("0");
        List<SysAreaDO> sysAreaDOS = sysAreaDAO.getareaListByParentId(entity);
        if (CollectionUtils.isEmpty(sysAreaDOS)) {
            return Result.wrapSuccessfulResult(sysAreaParentIdVos);
        }
        sysAreaDOS.forEach(sysAreaDO -> {
            SysAreaParentIdVo sysAreaParentIdVo = new SysAreaParentIdVo();
            BeanUtils.copyProperties(sysAreaDO, sysAreaParentIdVo);
            sysAreaParentIdVos.add(sysAreaParentIdVo);
        });
        return Result.wrapSuccessfulResult(sysAreaParentIdVos);
    }

    @Override
    public Result<GetByUuidVO> getByUuid(GetByUuidReq getByUuidReq) {
        GetByUuidVO getByUuidVO = new GetByUuidVO();
        SysAreaDO sysAreaDO = sysAreaDAO.getByUuid(getByUuidReq.getSysAreaUuid());
        if (sysAreaDO!=null){
         BeanUtils.copyProperties(sysAreaDO,getByUuidVO);
        }
        return Result.wrapSuccessfulResult(getByUuidVO);
    }

    @Override
    public Result<GetByUuidVO> getByIdId(GetByUuidReq getByUuidReq) {
        GetByUuidVO getByUuidVO = new GetByUuidVO();
        SysAreaDO sysAreaDO = sysAreaDAO.getByIdId(getByUuidReq.getId());
        if (sysAreaDO!=null){
            BeanUtils.copyProperties(sysAreaDO,getByUuidVO);
        }
        return Result.wrapSuccessfulResult(getByUuidVO);
    }
}
