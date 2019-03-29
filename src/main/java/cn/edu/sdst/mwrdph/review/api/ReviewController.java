package cn.edu.sdst.mwrdph.review.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 事件审查接口
 *
 * @author ZhangYu
 * @date 2019/3/28
 */
@RequestMapping("/v1/review")
@RestController
public class ReviewController {

    @GetMapping
    public void getIncident(@RequestParam("user_id")Long useId) {

    }


    public void updateIncident() {

    }
}
