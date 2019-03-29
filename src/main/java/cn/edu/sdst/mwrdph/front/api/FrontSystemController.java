package cn.edu.sdst.mwrdph.front.api;

import cn.edu.sdst.mwrdph.front.service.FrontSystemService;
import cn.edu.sdst.mwrdph.front.vo.SystemStatusVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统状态相关接口
 *
 * @author ZhangYu
 * @date 2019/2/23
 */
@RestController
@RequestMapping("/v1/front_api/system")
public class FrontSystemController {

    @Autowired
    FrontSystemService frontSystemService;

    /**
     * 获取系统监测器的当前状态
     */
    @GetMapping("/status")
    public ResponseEntity<SystemStatusVO> querySystemStatus() {
        SystemStatusVO systemStatusVO = frontSystemService.querySystemStatus();
        return ResponseEntity.ok(systemStatusVO);
    }
}
