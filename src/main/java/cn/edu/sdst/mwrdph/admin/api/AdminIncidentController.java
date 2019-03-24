package cn.edu.sdst.mwrdph.admin.api;


import cn.edu.sdst.mwrdph.admin.service.AdminIncidentService;
import cn.edu.sdst.mwrdph.entity.IncidentPO;
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
@RequestMapping("/admin/incident")
public class AdminIncidentController {
    @Autowired
    private AdminIncidentService incidentService;

    /**
     * 获取最新上报的事件
     */
    @GetMapping
    public ResponseEntity<List<IncidentPO>> getLatestIncident(
    ) {
        return ResponseEntity.ok(incidentService.getLatestIncidents(50));
    }

    @GetMapping("unChecked")
    public ResponseEntity<List<IncidentPO>> getIncidentsUnChecked(
    ) {
        return ResponseEntity.ok(incidentService.getIncidentsUnChecked());
    }

    /**
     * 获取指定雷达的最新上报事件
     */
    @GetMapping("/{detector_id}")
    public ResponseEntity<List<IncidentPO>> getLatestIncident(
            @PathVariable("detector_id") Long detectorId,
            @RequestParam("limit") Integer limit) {
        return ResponseEntity.ok(incidentService.getLatestIncidents(detectorId, limit));
    }

    /**
     * 获取指定时间范围内的时间数据
     */
    @GetMapping({"/range"})
    public ResponseEntity<List<IncidentPO>> getIncidents(
            @RequestParam(name = "section_id", required = false) Long sectionId,
            @RequestParam(name = "start", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date start,
            @RequestParam(name = "end", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date end,
            @RequestParam(name = "checkList[]", required = false) List<Integer> checkList) {
        return ResponseEntity.ok(incidentService.getIncidents(sectionId, start, end, checkList));
    }


}
