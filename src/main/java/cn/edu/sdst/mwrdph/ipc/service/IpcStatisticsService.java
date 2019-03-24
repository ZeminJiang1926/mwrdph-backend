package cn.edu.sdst.mwrdph.ipc.service;

import cn.edu.sdst.mwrdph.entity.StatisticsPO;
import cn.edu.sdst.mwrdph.ipc.mapper.IpcStatisticsMapper;
import cn.edu.sdst.mwrdph.ipc.vo.ReportVO;
import cn.edu.sdst.mwrdph.ipc.vo.TrafficStatisticVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 统计数据服务类
 *
 * @author ZhangYu
 * @date 2019/2/13
 */
@Service
public class IpcStatisticsService {

    @Autowired
    IpcStatisticsMapper mapper;

    public int insertByList(ReportVO<TrafficStatisticVO> reportVO) {
        List<StatisticsPO> statisticsPOS = reportVO.toDOList(StatisticsPO.class);
        for (StatisticsPO statisticsPO : statisticsPOS) {
            statisticsPO.setDirection((short) 1);
        }
        return mapper.insertByList(statisticsPOS);
    }
}
