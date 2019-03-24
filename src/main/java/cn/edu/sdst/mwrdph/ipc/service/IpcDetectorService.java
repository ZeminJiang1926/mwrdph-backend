package cn.edu.sdst.mwrdph.ipc.service;

import cn.edu.sdst.mwrdph.entity.DetectorPO;
import cn.edu.sdst.mwrdph.ipc.mapper.IpcDetectorMapper;
import cn.edu.sdst.mwrdph.ipc.vo.DetectorStatusVO;
import cn.edu.sdst.mwrdph.ipc.vo.ReportVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Demo class
 *
 * @author ZhangYu
 * @date 2019/2/13
 */
@Service
public class IpcDetectorService {

    @Autowired
    IpcDetectorMapper mapper;

    public int updateStatusByList(ReportVO<DetectorStatusVO> reportVO) {
        return mapper.updateStatusByList(reportVO.toDOList(DetectorPO.class));
    }
}
