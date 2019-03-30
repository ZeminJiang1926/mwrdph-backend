package cn.edu.sdst.mwrdph.review.status;

import cn.edu.sdst.mwrdph.review.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Demo class
 *
 * @author ZhangYu
 * @date 2019/3/30
 */
@Component
public class UserStatusManager {
    @Autowired
    ReviewMapper reviewMapper;

    public void setUserToReviewing(Long userId, Long incidentId) {
        reviewMapper.updateUserStatusInfo(userId, null, true, incidentId);
    }

    public void clearUserReviewingFlag(Long userId) {
        reviewMapper.updateUserStatusInfo(userId, null, false, null);
    }

    public void initUserStatus(Long userId) {
        reviewMapper.initLastReview(userId);
    }
}
