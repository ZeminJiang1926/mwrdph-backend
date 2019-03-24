package cn.edu.sdst.mwrdph.front.service;

import cn.edu.sdst.mwrdph.entity.IncidentPO;
import cn.edu.sdst.mwrdph.front.mapper.FrontIncidentMapper;
import cn.edu.sdst.mwrdph.front.utils.TimeUtils;
import cn.edu.sdst.mwrdph.front.vo.RankItemOfIncidentsVO;
import cn.edu.sdst.mwrdph.front.vo.TrafficIncidentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 交通事件服务
 *
 * @author ZhangYu
 * @date 2019/2/27
 */
@Service
public class FrontIncidentService {
    @Autowired
    private FrontIncidentMapper incidentMapper;

    /**
     * 获得最新事件
     *
     * @param limit 个数
     * @return List<TrafficIncidentVO>
     */
    public List<TrafficIncidentVO> getLatestIncidents(Integer limit) {
        List<IncidentPO> latest = incidentMapper.getLatest(null, limit);
        return latest.stream().map(TrafficIncidentVO::new).collect(Collectors.toList());
    }

    /**
     * 获得指定监测器的最新事件
     *
     * @param detectorId 监测器id
     * @param limit      个数
     * @return List<TrafficIncidentVO>
     */
    public List<TrafficIncidentVO> getLatestIncidents(Long detectorId, Integer limit) {
        List<IncidentPO> latest = incidentMapper.getLatest(detectorId, limit);
        return latest.stream().map(TrafficIncidentVO::new).collect(Collectors.toList());
    }

    /**
     * 获取指定时间范围内的事件
     *
     * @param detectorId 监测器id
     * @param start      开始时间
     * @param end        结束时间
     * @return List<IncidentPO>
     */
    public List<TrafficIncidentVO> getIncidents(Long detectorId, Date start, Date end) {
        List<IncidentPO> incidents = incidentMapper.getIncidents(detectorId, TimeUtils.toNextPoint(start), end);
        return incidents.stream().map(TrafficIncidentVO::new).collect(Collectors.toList());
    }

    /**
     * 获取时间数量最多的前limit条监测器信息
     *
     * @param start 开始时间
     * @param end   结束时间
     * @param limit 条数
     * @return List<RankItemOfIncidentsVO>
     */
    public List<RankItemOfIncidentsVO> getTopNDetectorByIncidents(Date start, Date end, Integer limit) {
        return incidentMapper.getTopNDetectorByIncidents(start, end, limit);
    }

    /**
     * 获得指定时间范围内的事件总数
     *
     * @param detectorId 检测器Id (optional)
     * @param start      开始时间
     * @param end        结束时间
     * @return 事件总数
     */
    public Long getTotalIncident(Long detectorId, Date start, Date end) {
        return incidentMapper.getTotalIncident(detectorId, start, end);
    }
}
