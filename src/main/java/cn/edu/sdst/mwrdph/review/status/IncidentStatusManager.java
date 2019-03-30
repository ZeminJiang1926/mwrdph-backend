package cn.edu.sdst.mwrdph.review.status;

import cn.edu.sdst.mwrdph.review.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Demo class
 *
 * @author ZhangYu
 * @date 2019/3/29
 */
@Component
public class IncidentStatusManager {

    @Autowired
    ReviewMapper reviewMapper;

    public int finishIncidentReview(Long incidentId, Long reviewId) {
        return reviewMapper.updateIncidentStatus(incidentId, true, false, reviewId);
    }

    public int setIncidentToReviewing(Long incidentId) {
        return reviewMapper.updateIncidentStatus(incidentId, null, true, null);
    }

    public int clearIncidentReviewingFlag(Long incidentId, Long reviewId ) {
        return reviewMapper.updateIncidentStatus(incidentId, null, false, reviewId);
    }
}
