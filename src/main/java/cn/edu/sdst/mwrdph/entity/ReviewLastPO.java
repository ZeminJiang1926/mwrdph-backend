package cn.edu.sdst.mwrdph.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Demo class
 *
 * @author ZhangYu
 * @date 2019/3/29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mwr_review_last")
public class ReviewLastPO {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private Long userId;
    private Long lastReviewId;
    private Date createTime;
    private Date updateTime;
}
