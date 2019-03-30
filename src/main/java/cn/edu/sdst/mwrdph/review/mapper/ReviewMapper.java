package cn.edu.sdst.mwrdph.review.mapper;

import cn.edu.sdst.mwrdph.enums.TrafficIncidentEnum;
import cn.edu.sdst.mwrdph.review.po.ReviewLastPO;
import cn.edu.sdst.mwrdph.review.vo.ReviewVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 该类提供了事件审查逻辑相关数据库操作
 *
 * @author ZhangYu
 * @date 2019/3/29
 */
@Mapper
public interface ReviewMapper {
    ReviewLastPO getReviewHistoryInfo(@Param("userId") Long userId);

    int updateUserStatusInfo(@Param("userId") Long userId, @Param("reviewId") Long lastReviewId, @Param("checking") Boolean checking, @Param("incidentId") Long incidentId);

    Long getReviewingIncidetnId(@Param("userId") Long userId);

    /**
     * 获取该用户最后一次Review操作的事件（Incident）的Id
     *
     * @param userId 用户ID
     * @return 若存在则返回事件ID, 若不存在则返回null
     */
    Long getLastReviewedIncidentId(@Param("userId") Long userId);

    /**
     * 初始化用户审查记录表(mwr_review_last)
     * <p>
     * 该表用来记录用户最后一次审批的review,防止对一个用户多次推送相同事件
     *
     * @param userId 用户id
     * @return 影响条数
     */
    int initLastReview(@Param("userId") Long userId);

    /**
     * 更新用户审查记录表
     * 在更新该记录前请确包已经初始化该用户的记录
     * 否则将会将会影响整个审查系统的运行
     *
     * @param userId   用户id
     * @param reviewId 审查id
     * @return 影响条数
     */
    int updateLastReviewId(@Param("userId") Long userId, @Param("reviewId") Long reviewId);

    /**
     * 更新事件的状态信息
     * <p>
     * 是否结束审查/是否正在审查
     *
     * @param end      是否结束
     * @param checking 是否正在审查
     * @return 影响条数
     */
    int updateIncidentStatus(@Param("incidentId") Long incidentId, @Param("end") Boolean end, @Param("checking") Boolean checking, @Param("reviewId") Long reviewId);


    /**
     * 获取一个新的事件审查对象
     * 该方法通过每次返回大于 lastIncidentId 而保证 每个用户不会重复推送事件
     *
     * @param lastIncidentId 最后一次审查事件的Id；如果第一次审查请传0
     * @return 审查信息
     */
    ReviewVO getNewIncidentReviewInfo(@Param("lastIncidentId") Long lastIncidentId);

    ReviewVO getIncidentReviewInfoByIncidentId(@Param("incidentId") Long incidentId);


    /**
     * 获取指定事件被判为指定类型的数量
     *
     * @param incidentId 事件Id
     * @param type       类型
     * @return 数量
     */
    int countSameJudeTypeByIncidentId(@Param("incidentId") Long incidentId, @Param("type") TrafficIncidentEnum type);

    /**
     * 插入新的审查记录
     *
     * @param reviewVO 审查结果
     * @return 影响条数
     */
    int insertNewReviewHistory(ReviewVO reviewVO);
}
