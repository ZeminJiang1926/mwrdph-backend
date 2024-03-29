package cn.edu.sdst.mwrdph.admin.api;

import cn.edu.sdst.mwrdph.admin.service.AdminSectionService;
import cn.edu.sdst.mwrdph.entity.DetectorPO;
import cn.edu.sdst.mwrdph.entity.SectionPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wzh
 */
@RestController
@RequestMapping("/admin/section")
public class AdminSectionController {
    @Autowired
    private AdminSectionService sectionService;

    @GetMapping
    public ResponseEntity<List<SectionPO>> queryTopSections(
            @RequestParam(name = "pageIndex", required = false) int pageIndex,
            @RequestParam(name = "pageSize", required = false) int pageSize
    ) {
        return ResponseEntity.ok(sectionService.queryTopSections(pageIndex,pageSize));
    }

    @GetMapping("/query")
    public ResponseEntity<List<SectionPO>> queryTopSectionsByItems(String name) {
        return ResponseEntity.ok(sectionService.querySectionByItems(name));
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public void delPc(@PathVariable("id") Integer id) {
        sectionService.delSection(id);
    }

    @RequestMapping(value = "/dels", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String delSections(@RequestBody List<Integer> ids) {
        for (int i = 0; i < ids.size(); i++) {
            sectionService.delSection(ids.get(i));
        }
        return "更新路段成功";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String updateSection(@RequestBody SectionPO section) {
        sectionService.updateSection(section);
        return "更新路段成功";

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addSection(@RequestBody SectionPO section) {
        sectionService.addSection(section);
        return "添加路段成功";

    }

}
