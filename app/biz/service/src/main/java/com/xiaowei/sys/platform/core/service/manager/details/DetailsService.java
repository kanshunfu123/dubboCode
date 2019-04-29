package com.xiaowei.sys.platform.core.service.manager.details;
import com.xiaowei.sys.platform.core.facade.service.req.details.DetailsReq;
import org.springframework.stereotype.Service;

/**
 * Created by WingsChan on 2018/9/7.
 */
@Service
public interface DetailsService {
   void addDetailsInfo(DetailsReq addReqs);

}
