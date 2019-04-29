package com.xiaowei.sys.platform.core.service.manager.details;

import com.xiaowei.sys.platform.core.common.dal.dao.SysStandardDetailsDAO;
import com.xiaowei.sys.platform.core.common.dal.dataobject.SysStandardDetailsDO;
import com.xiaowei.sys.platform.core.facade.service.req.details.DetailsReq;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: qianjin
 * @CreateDate: 2018/6/8 17:10
 */
@Service
@Configuration
@Transactional(rollbackFor = Exception.class)
public class DetailsServiceImpl implements DetailsService {
    private final static Logger logger = Logger.getLogger(DetailsServiceImpl.class);
    @Autowired
    private SysStandardDetailsDAO sysStandardDetailsDAO;

    @Override
    public void addDetailsInfo(DetailsReq addReqs) {
        SysStandardDetailsDO sysStandardDetailsDO = new SysStandardDetailsDO();
        BeanUtils.copyProperties(sysStandardDetailsDO, addReqs);
        sysStandardDetailsDAO.insert(sysStandardDetailsDO);
    }


}
