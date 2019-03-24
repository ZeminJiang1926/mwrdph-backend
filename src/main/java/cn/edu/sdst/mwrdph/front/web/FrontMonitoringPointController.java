package cn.edu.sdst.mwrdph.front.web;

import cn.edu.sdst.mwrdph.front.service.FrontMonitoringPointService;
import cn.edu.sdst.mwrdph.front.vo.MpDetailsVO;
import cn.edu.sdst.mwrdph.front.vo.MpDistributeItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 监测点相关接口
 *
 * @author ZhangYu
 * @date 2019/2/23
 */
@RestController
@RequestMapping("/v1/front_api/monitoring_points")
public class FrontMonitoringPointController {
    @Autowired
    private FrontMonitoringPointService monitoringPointService;

    /**
     * 获取监测点分布信息
     *
     * @return List<MpDistributeItemVO>>
     */
    @GetMapping
    public ResponseEntity<List<MpDistributeItemVO>> getDistributeInfo() {
        return ResponseEntity.ok(monitoringPointService.getAllDistributeInfo());

    }

    /**
     * 获取单个监测点展示数据
     *
     * @param id 监测点id
     * @return MpDetailsVO
     */
    @GetMapping("/{id}/card")
    public ResponseEntity<MpDetailsVO> queryById(
            @PathVariable("id") long id,
            @RequestParam(value = "lastTime", required = false) Long lastTime) {
        return ResponseEntity.ok(monitoringPointService.getMonitoringPointDetailById(id, lastTime));
    }
}
