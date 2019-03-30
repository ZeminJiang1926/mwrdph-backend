package cn.edu.sdst.mwrdph.review.api;

import cn.edu.sdst.mwrdph.review.service.ReviewService;
import cn.edu.sdst.mwrdph.review.vo.ReviewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 事件审查接口
 *
 * @author ZhangYu
 * @date 2019/3/28
 */
@RequestMapping("/v1/review")
@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @GetMapping
    public ResponseEntity<ReviewVO> getIncidentInfo(@RequestParam("user_id") Long userId) {
        return ResponseEntity.ok(reviewService.getIncidentInfo(userId));
    }


    @PostMapping
    public ResponseEntity<String> updateIncidentInfo(@RequestBody ReviewVO reviewVO) {
        System.out.println(reviewVO);
        return ResponseEntity.ok(reviewService.updateIncidentReviewInfo(reviewVO));
    }

}