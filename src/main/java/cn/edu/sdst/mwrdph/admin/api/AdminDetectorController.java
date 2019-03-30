package cn.edu.sdst.mwrdph.admin.api;

import cn.edu.sdst.mwrdph.admin.service.AdminDetectorService;
import cn.edu.sdst.mwrdph.entity.DetectorPO;
import cn.edu.sdst.mwrdph.admin.vo.AdminDetectorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wzh
 */
@RestController
@RequestMapping("/admin/detector")
public class AdminDetectorController {
    @Autowired
    private AdminDetectorService detectorService;

    @GetMapping
    public ResponseEntity<List<AdminDetectorVo>> queryTopDetector(
            @RequestParam(name = "pageIndex", required = false) int pageIndex,
            @RequestParam(name = "pageSize", required = false) int pageSize
    ) {
        return ResponseEntity.ok(detectorService.queryTopDetector(pageIndex,pageSize));
    }

    @GetMapping("/query")
    public ResponseEntity<List<AdminDetectorVo>> queryDetectorByItems(String name) {
        return ResponseEntity.ok(detectorService.queryDetectorByItems(name));
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public void delDetector(@PathVariable("id") Long id) {
        detectorService.delDetector(id);
    }

    @RequestMapping(value = "/dels", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String delDetectors(@RequestBody List<Long> ids) {
        for (int i = 0; i < ids.size(); i++) {
            detectorService.delDetector(ids.get(i));
        }
        return "更新路段成功";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String updateDetector(@RequestBody AdminDetectorVo detector) {
        detectorService.updateDetector(detector);
        return "更新传感器成功";

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addDetector(@RequestBody AdminDetectorVo detector) {
        detectorService.addDetector(detector);
        return "添加传感器成功";

    }

}
