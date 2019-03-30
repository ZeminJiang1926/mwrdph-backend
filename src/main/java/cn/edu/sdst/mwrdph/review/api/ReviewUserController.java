package cn.edu.sdst.mwrdph.review.api;

import cn.edu.sdst.mwrdph.review.service.ReviewUserService;
import cn.edu.sdst.mwrdph.review.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Demo class
 *
 * @author ZhangYu
 * @date 2019/3/30
 */
@RestController
@RequestMapping("/v1/review/user")
public class ReviewUserController {

    @Autowired
    ReviewUserService reviewUserService;

    @GetMapping("/{user_id}")
    public ResponseEntity<UserVO> getUserInfo(@PathVariable("user_id") Long userId) {
        return ResponseEntity.ok(reviewUserService.getUserInfo(userId));
    }
}
