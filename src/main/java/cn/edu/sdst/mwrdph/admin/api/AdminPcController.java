package cn.edu.sdst.mwrdph.admin.api;

import cn.edu.sdst.mwrdph.admin.service.AdminPcService;
import cn.edu.sdst.mwrdph.entity.PcPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/pc")
public class AdminPcController {

    @Autowired
    private AdminPcService adminPcService;

    @GetMapping
    public ResponseEntity<List<PcPO>> queryTopPc() {
        return ResponseEntity.ok(adminPcService.queryTopPc());
    }

    @GetMapping("/query")
    public ResponseEntity<List<PcPO>> queryPcByitems(@RequestParam("user_name") String userName

    ) {
        return ResponseEntity.ok(adminPcService.getPcsByItems(userName));
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public void delPc(@PathVariable("id") Integer id) {
        adminPcService.delPc(id);
    }

    @RequestMapping(value = "/dels", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String delPcs(@RequestBody List<Integer> ids) {
        for (int i = 0; i < ids.size(); i++) {
            adminPcService.delPc(ids.get(i));
        }
        return "更新路段成功";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String updatePc(@RequestBody PcPO pc) {
        adminPcService.updatePc(pc);
        return "更新工控机成功";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addPc(@RequestBody PcPO pc) {
        adminPcService.addPc(pc);
        return "增加工控机成功";
    }


}
