package cn.edu.sdst.mwrdph.review.service;

import cn.edu.sdst.mwrdph.review.mapper.ReviewUserMapper;
import cn.edu.sdst.mwrdph.review.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Demo class
 *
 * @author ZhangYu
 * @date 2019/3/30
 */
@Service
public class ReviewUserService {
    @Autowired
    ReviewUserMapper reviewUserMapper;

    public UserVO getUserInfo(Long userId) {
        return reviewUserMapper.getUserInfo(userId);
    }
}
