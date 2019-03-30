package cn.edu.sdst.mwrdph.admin.api;


import cn.edu.sdst.mwrdph.admin.service.AdminIncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cn.edu.sdst.mwrdph.admin.vo.AdminIncidentVo;

import java.util.Date;
import java.util.List;

/**
 * 交通事件相关接口
 *
 * @author wzh
 * @date 2019/3/30
 */
@RestController
@RequestMapping("/admin/incident")
public class AdminIncidentController {
    @Autowired
    private AdminIncidentService incidentService;

    /***
     * 获取最新上报时间
     * @param pageIndex
     * @param pageSize
     * @return ResponseEntity<List < AdminIncidentVo>>
     */
    @GetMapping
    public ResponseEntity<List<AdminIncidentVo>> getLatestIncident(
            @RequestParam(name = "pageIndex", required = false) int pageIndex,
            @RequestParam(name = "pageSize", required = false) int pageSize
    ) {
        return ResponseEntity.ok(incidentService.getLatestIncidents(pageIndex, pageSize));
    }

    /**
     * 事件修改
     * @param reviewItem
     * @return
     */

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public int updateIncident(@RequestBody AdminIncidentVo reviewItem) {
        return incidentService.updateReview(reviewItem);
    }

    /**
     * 获取指定时间、指定路段的事件
     *
     * @param pageIndex
     * @param pageSize
     * @param sectionId
     * @param start
     * @param end
     * @param checkList
     * @return ResponseEntity<List < AdminIncidentVo>>
     */
    @GetMapping({"/range"})
    public ResponseEntity<List<AdminIncidentVo>> getIncidents(
            @RequestParam(name = "pageIndex", required = false) int pageIndex,
            @RequestParam(name = "pageSize", required = false) int pageSize,
            @RequestParam(name = "section_id", required = false) Long sectionId,
            @RequestParam(name = "start", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date start,
            @RequestParam(name = "end", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date end,
            @RequestParam(name = "checkList[]", required = false) List<Integer> checkList) {
        return ResponseEntity.ok(incidentService.getIncidents(sectionId, start, end, checkList, pageIndex, pageSize));
    }


}
