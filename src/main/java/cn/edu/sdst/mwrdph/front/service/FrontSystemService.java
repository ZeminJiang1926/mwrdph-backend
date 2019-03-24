package cn.edu.sdst.mwrdph.front.service;

import cn.edu.sdst.mwrdph.front.mapper.FrontDetectorMapper;
import cn.edu.sdst.mwrdph.front.vo.SystemStatusVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统状态服务
 *
 * @author ZhangYu
 * @date 2019/2/23
 */
@Service
public class FrontSystemService {
    @Autowired
    FrontDetectorMapper mapper;

    public SystemStatusVO querySystemStatus() {
        return mapper.querySystemStatus();
    }
}
