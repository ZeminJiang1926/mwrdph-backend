package cn.edu.sdst.mwrdph.front.service;

import cn.edu.sdst.mwrdph.entity.IncidentPO;
import cn.edu.sdst.mwrdph.front.mapper.FrontDetectorMapper;
import cn.edu.sdst.mwrdph.front.mapper.FrontIncidentMapper;
import cn.edu.sdst.mwrdph.front.vo.MpDetailsVO;
import cn.edu.sdst.mwrdph.front.vo.MpDistributeItemVO;
import cn.edu.sdst.mwrdph.front.vo.TrafficIncidentVO;
import cn.edu.sdst.mwrdph.front.vo.VolumeAndSpeedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 监测点服务
 *
 * @author ZhangYu
 * @date 2019/2/24
 */
@Service
public class FrontMonitoringPointService {

    @Autowired
    FrontDetectorMapper detectorMapper;
    @Autowired
    FrontIncidentMapper incidentMapper;

    /**
     * 查询所有监测点的分布信息
     *
     * @return List<MpDistributeItemVO>
     */
    public List<MpDistributeItemVO> getAllDistributeInfo() {
        return detectorMapper.queryDistributeInfo();
    }

    /**
     * 查询指定检测点id的详情信息
     *
     * @param id       监测点id
     * @param lastTime 上次获取时间
     * @return MpDetailsVO
     */
    public MpDetailsVO getMonitoringPointDetailById(Long id, Long lastTime) {
        // 返回 (lasttime, now] 整周期点内的数据
        return doInTest(id, lastTime);
    }

    private MpDetailsVO doInTest(Long id, Long lastTime) {
        // 以3s为一个周期
        long timestamp = System.currentTimeMillis() / 3000 * 3000;

        long count = lastTime == null ? 10 : (timestamp - lastTime) / 3000;

        MpDetailsVO vo = new MpDetailsVO();

        Random random = new Random();
        int bound = 1500;
        // 生成分钟流量/速度
        VolumeAndSpeedVO vAsPerMinute = new VolumeAndSpeedVO(timestamp, new Date(timestamp), 1, (long) (random.nextInt(bound) / 10), random.nextInt(bound) / 10.0);
        vo.setPerMinute(vAsPerMinute);
        // 生成小时流量/速度
        VolumeAndSpeedVO vAsPerHour = new VolumeAndSpeedVO(timestamp, new Date(timestamp), 1, (long) (random.nextInt(bound) / 10), random.nextInt(bound) / 10.0);
        vo.setPerHour(vAsPerHour);

        // 查询最近5条事件
        List<IncidentPO> incidents = incidentMapper.getLatest(id, 6);
        vo.setIncidents(incidents.stream().map(TrafficIncidentVO::new).collect(Collectors.toList()));

        // 查询实时车速/流量
        List<VolumeAndSpeedVO> vAsList = new ArrayList<>(10);
        for (int i = 0; i < count; i++) {
            long tmpTimestamp = timestamp - (count - i) * 3 * 1000;
            VolumeAndSpeedVO vAs = new VolumeAndSpeedVO(tmpTimestamp, new Date(tmpTimestamp), 1, (long) random.nextInt(bound) / 10, random.nextInt(bound) / 10.0);
            vAsList.add(vAs);
        }
        System.out.println(vAsList);
        vo.setRealtimeData(vAsList);
        return vo;
    }

    private MpDetailsVO doInNormal(Long id) {
        long timestamp = System.currentTimeMillis();
        MpDetailsVO vo = new MpDetailsVO();

        // 查询最新流量/车速
        VolumeAndSpeedVO vAsPerMinute = detectorMapper.queryAvgVolumeAndSpeedBeforeMinute(id, timestamp, 1);
        VolumeAndSpeedVO vAsPerHour = detectorMapper.queryAvgVolumeAndSpeedBeforeMinute(id, timestamp, 60);

        vo.setPerMinute(vAsPerMinute);
        vo.setPerHour(vAsPerHour);

        // 查询最近5条事件
        List<IncidentPO> incidents = incidentMapper.getLatest(id, 5);
        vo.setIncidents(incidents.stream().map(TrafficIncidentVO::new).collect(Collectors.toList()));

        // 查询实时车速/流量
        int period = 10;
        List<VolumeAndSpeedVO> vAsList = detectorMapper.queryLatestVolumeAndSpeedWithin(id, timestamp - 60 * 1000, timestamp, period);
        vAsList.forEach(vAs -> vAs.setIndex(vAs.getIndex().longValue() * period));
        vAsList.forEach(vAs -> vAs.setTime(new Date(vAs.getIndex().longValue())));
        vo.setRealtimeData(vAsList);
        return vo;
    }

}
