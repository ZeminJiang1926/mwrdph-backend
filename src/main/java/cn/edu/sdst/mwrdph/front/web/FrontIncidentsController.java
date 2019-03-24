package cn.edu.sdst.mwrdph.front.web;

import cn.edu.sdst.mwrdph.front.service.FrontIncidentService;
import cn.edu.sdst.mwrdph.front.vo.RankItemOfIncidentsVO;
import cn.edu.sdst.mwrdph.front.vo.TrafficIncidentVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 交通事件相关接口
 *
 * @author ZhangYu
 * @date 2019/2/27
 */
@RestController
@RequestMapping("/v1/front_api/incidents")
public class FrontIncidentsController {
    @Autowired
    private FrontIncidentService incidentService;

    /**
     * 获取最新上报的事件
     */
    @GetMapping
    public ResponseEntity<List<TrafficIncidentVO>> getLatestIncident(
            @RequestParam("limit") Integer limit) {
        return ResponseEntity.ok(incidentService.getLatestIncidents(limit));
    }

    /**
     * 获取指定雷达的最新上报事件
     */
    @GetMapping("/{detector_id}")
    public ResponseEntity<List<TrafficIncidentVO>> getLatestIncident(
            @PathVariable("detector_id") Long detectorId,
            @RequestParam("limit") Integer limit) {
        return ResponseEntity.ok(incidentService.getLatestIncidents(detectorId, limit));
    }

    /**
     * 获取指定时间范围内的时间数据
     */
    @GetMapping({"/range", "/range/{detector_id}"})
    public ResponseEntity<List<TrafficIncidentVO>> getIncidents(
            @PathVariable(name = "detector_id", required = false) Long detectorId,
            @Param("start") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date start,
            @Param("end") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date end) {
        return ResponseEntity.ok(incidentService.getIncidents(detectorId, start, end));
    }

    /**
     * 获取指定时间范围内 事件数最多 的监测点的相关信息
     */
    @GetMapping("/top")
    public ResponseEntity<List<RankItemOfIncidentsVO>> getTopDetectorByIncident(
            @Param("start") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date start,
            @Param("end") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date end,
            @Param("limit") Integer limit) {
        return ResponseEntity.ok(incidentService.getTopNDetectorByIncidents(start, end, limit));
    }

    @GetMapping({"/total", "/total/{detector_id}"})
    public ResponseEntity<Long> getTotalIncident(
            @PathVariable(value = "detector_id", required = false) Long detectorId,
            @Param("start") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date start,
            @Param("end") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date end) {
        return ResponseEntity.ok(incidentService.getTotalIncident(detectorId, start, end));
    }
}
