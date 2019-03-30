package cn.edu.sdst.mwrdph.review.service;

import cn.edu.sdst.mwrdph.review.mapper.ReviewMapper;
import cn.edu.sdst.mwrdph.review.po.ReviewLastPO;
import cn.edu.sdst.mwrdph.review.status.IncidentStatusManager;
import cn.edu.sdst.mwrdph.review.status.UserStatusManager;
import cn.edu.sdst.mwrdph.review.vo.ReviewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Demo class
 *
 * @author ZhangYu
 * @date 2019/3/29
 */
@Service
public class ReviewService {
    @Autowired
    ReviewMapper reviewMapper;
    @Autowired
    UserStatusManager userStatusManager;
    @Autowired
    IncidentStatusManager incidentStatusManager;

    @Transactional
    public ReviewVO getIncidentInfo(Long userId) {
        ReviewLastPO reviewLast = reviewMapper.getReviewHistoryInfo(userId);
        ReviewVO reviewVO;
        if (reviewLast == null) {
            reviewMapper.initLastReview(userId);
            reviewVO = getIncidentReviewInfo(userId, 0L);
        } else if (reviewLast.getIncidentId() != null) {
            reviewVO = reviewMapper.getIncidentReviewInfoByIncidentId(reviewLast.getIncidentId());
        } else {
            Long lastIncidentId = reviewLast.getLastReviewIncidentId() == null ? 0L : reviewLast.getLastReviewIncidentId();
            reviewVO = getIncidentReviewInfo(userId, lastIncidentId);
        }
        reviewVO.setUserId(userId);
        return reviewVO;
    }


    private ReviewVO getIncidentReviewInfo(Long userId, Long lastIncidentId) {
        ReviewVO reviewVO = reviewMapper.getNewIncidentReviewInfo(lastIncidentId);
        if (reviewVO == null || reviewVO.getIncidentId() == null) {
            // 事件id == null, 说明没有新事件，此时应将用户状态置为空
            userStatusManager.clearUserReviewingFlag(userId);
            reviewVO = new ReviewVO();
        } else {
            // 维护事件状态和用户状态
            userStatusManager.setUserToReviewing(userId, reviewVO.getIncidentId());
            incidentStatusManager.setIncidentToReviewing(reviewVO.getIncidentId());
        }
        return reviewVO;
    }


    @Transactional
    public String updateIncidentReviewInfo(ReviewVO reviewVO) {
        int count = reviewMapper.countSameJudeTypeByIncidentId(reviewVO.getIncidentId(), reviewVO.getType());
        boolean end = count == 1;
        reviewMapper.insertNewReviewHistory(reviewVO);
        if (end) {
            incidentStatusManager.finishIncidentReview(reviewVO.getIncidentId(), reviewVO.getReviewId());
        } else {
            incidentStatusManager.clearIncidentReviewingFlag(reviewVO.getIncidentId(), reviewVO.getReviewId());
        }
        reviewMapper.updateLastReviewId(reviewVO.getUserId(), reviewVO.getReviewId());
        userStatusManager.clearUserReviewingFlag(reviewVO.getUserId());
        return "ok";
    }
}
