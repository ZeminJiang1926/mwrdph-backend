package cn.edu.sdst.mwrdph.front.mapper;

import cn.edu.sdst.mwrdph.entity.StatisticsPO;
import cn.edu.sdst.mwrdph.front.vo.RankItemOfVolumeAndSpeedVO;
import cn.edu.sdst.mwrdph.front.vo.VolumeAndSpeedVO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

/**
 * FrontStatisticsMapper
 *
 * @author ZhangYu
 * @date 2019/2/24
 */
@org.apache.ibatis.annotations.Mapper
public interface FrontStatisticsMapper extends Mapper<StatisticsPO> {
    /**
     * 获取指定id 指定时间 前n分钟内的平均车速和累计流量
     *
     * @param detectorId 检测器id
     * @param date       统计时间点
     * @param n          时间 单位min
     * @return VolumeAndSpeedVO
     */
    VolumeAndSpeedVO queryStatisticVolumeAndSpeed(@Param("detectorId") long detectorId, @Param("date") Date date, @Param("n") int n);

    /**
     * 获取指定时间范围内的流量和速度数据
     *
     * @param detectorId 检测器id
     * @param start      开始时间
     * @param end        结束时间
     * @param period     采样周期
     * @return List<VolumeAndSpeedVO>
     */
    List<VolumeAndSpeedVO> queryVolumeAndSpeedList(@Param("detectorId") long detectorId, @Param("start") Date start, @Param("end") Date end, @Param("period") int period);

    /**
     * 指定日期范围内 流量最高的前n个检测器信息
     *
     * @param start 开始时间
     * @param end   结束时间
     * @param limit 返回数量
     * @param by
     * @return List<RankItemOfVolumeAndSpeedVO>
     */
    List<RankItemOfVolumeAndSpeedVO> queryTopNDetectorByVolume(@Param("start") Date start, @Param("end") Date end, @Param("limit") int limit, @Param("by") String by);

    /**
     * 查询指定检测器 指定日期范围内的流量数据
     *
     * @param detectorId 监测器id
     * @param start      开始时间
     * @param end        结束时间
     * @param period     周期
     * @return List<VolumeAndSpeedVO>
     */
    List<VolumeAndSpeedVO> queryRealTimeVolume(@Param("detectorId") Long detectorId, @Param("start") Date start, @Param("end") Date end, @Param("period") Integer period);

    /**
     * 查询指定检测器 指定日期范围内的流量数据
     *
     * @param detectorId 监测器id
     * @param start      开始时间
     * @param end        结束时间
     * @param period     周期
     * @return List<VolumeAndSpeedVO>
     */
    List<VolumeAndSpeedVO> queryRealTimeSpeed(@Param("detectorId") Long detectorId, @Param("start") Date start, @Param("end") Date end, @Param("period") Integer period);

    /**
     * 获得指定时间范围内的总流量
     *
     * @param detectorId 检测器id
     * @param start      开始时间
     * @param end        结束时间
     * @return 总流量
     */
    Long getTotalVolume(@Param("detectorId") Long detectorId, @Param("start") Date start, @Param("end") Date end);

}
