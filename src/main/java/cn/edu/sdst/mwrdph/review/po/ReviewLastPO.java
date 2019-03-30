package cn.edu.sdst.mwrdph.review.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Demo class
 *
 * @author ZhangYu
 * @date 2019/3/30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewLastPO {
    private Long userId;

    private Long lastReviewId;
    private Long lastReviewIncidentId;

    private Boolean checking;
    private Long incidentId;
}
