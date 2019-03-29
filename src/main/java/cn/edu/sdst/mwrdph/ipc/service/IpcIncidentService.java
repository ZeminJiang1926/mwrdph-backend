package cn.edu.sdst.mwrdph.ipc.service;

import cn.edu.sdst.mwrdph.entity.DetectorPO;
import cn.edu.sdst.mwrdph.entity.IncidentPO;
import cn.edu.sdst.mwrdph.ipc.mapper.IpcDetectorMapper;
import cn.edu.sdst.mwrdph.ipc.mapper.IpcIncidentMapper;
import cn.edu.sdst.mwrdph.ipc.utils.IncidentInfoUtils;
import cn.edu.sdst.mwrdph.ipc.vo.ReportVO;
import cn.edu.sdst.mwrdph.ipc.vo.TrafficIncidentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * 交通事件服务
 *
 * @author ZhangYu
 * @date 2019/2/12
 */
@Service
public class IpcIncidentService {

    @Autowired
    private IpcIncidentMapper incidentMapper;
    @Autowired
    private IpcDetectorMapper detectorMapper;
    @Autowired
    RemoteIncidentVideoService remoteIncidentVideoService;

    public int insertByList(ReportVO<TrafficIncidentVO> incidentsReportVO) {
        System.out.println(incidentsReportVO);
        List<String> infoList = new ArrayList<>(incidentsReportVO.getItems().size());

        for (TrafficIncidentVO item : incidentsReportVO.getItems()) {
            DetectorPO detectorPO = detectorMapper.selectByPrimaryKey(item.getDetectorId());
            infoList.add(IncidentInfoUtils.generateInfo(detectorPO.getName(), item.getDistance(), item.getType()));
        }

        List<IncidentPO> incidents = incidentsReportVO.toDOList(IncidentPO.class);

        int index = 0;
        for (IncidentPO incident : incidents) {
            incident.setInfo(infoList.get(index));
            index++;
        }

        int status = incidentMapper.insertByList(incidents);

        // for (IncidentPO incident : incidents) {
        //     remoteIncidentVideoService.record(incident.getDetectorId(), incident.getId(), incident.getTimestamp());
        // }
        return status;
    }
}
