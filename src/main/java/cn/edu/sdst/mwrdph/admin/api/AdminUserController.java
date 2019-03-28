package cn.edu.sdst.mwrdph.admin.api;

import cn.edu.sdst.mwrdph.admin.service.AdminUserService;
import cn.edu.sdst.mwrdph.entity.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/user")
public class AdminUserController {

    @Autowired
    private AdminUserService userService;

    @GetMapping
    public ResponseEntity<List<UserPO>> queryTopUser(
            @RequestParam(name = "pageIndex", required = false) int pageIndex,
            @RequestParam(name = "pageSize", required = false) int pageSize) {
        return ResponseEntity.ok(userService.queryTopUser(pageIndex,pageSize));
    }

    @GetMapping("/query")
    public ResponseEntity<List<UserPO>> queryUserByItems(String name, Integer id) {
        return ResponseEntity.ok(userService.queryUserByItems(name, id));
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public void delPc(@PathVariable("id") Integer id) {
        userService.delUser(id);
    }

    @RequestMapping(value = "/dels", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String delUsers(@RequestBody List<Integer> ids) {
        for (int i = 0; i < ids.size(); i++) {
            userService.delUser(ids.get(i));
        }
        return "更新路段成功";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String updateUser(@RequestBody UserPO user) {
        userService.updateUser(user);
        return "更新用户成功";

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String addUser(@RequestBody UserPO user) {
        userService.addUser(user);
        return "添加用户成功";

    }

}
