package cn.edu.sdst.mwrdph.front.service;

import cn.edu.sdst.mwrdph.front.mapper.FrontStatisticsMapper;
import cn.edu.sdst.mwrdph.front.utils.TimeUtils;
import cn.edu.sdst.mwrdph.front.vo.RankItemOfVolumeAndSpeedVO;
import cn.edu.sdst.mwrdph.front.vo.VolumeAndSpeedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 前端统计数据服务
 *
 * @author ZhangYu
 * @date 2019/3/1
 */
@Service
public class FrontStatisticService {

    private static List<String> ORDER_COLUMNS = Arrays.asList("volume", "speed");

    @Autowired
    FrontStatisticsMapper statisticsMapper;

    /**
     * 获取指定id 指定时间 前n分钟内的平均车速和累计流量
     *
     * @param detectorId 检测器id
     * @param date       统计时间点
     * @param n          时间 单位 sec
     * @return VolumeAndSpeedVO
     */
    public VolumeAndSpeedVO getStatisticVolumeAndSpeed(long detectorId, Date date, int n) {
        VolumeAndSpeedVO vo = statisticsMapper.queryStatisticVolumeAndSpeed(detectorId, date, n);
        vo.setIndex(date.getTime());
        vo.setTime(date);
        return vo;
    }

    /**
     * 获取指定时间范围内的流量和速度数据，并按period行重采样
     * 重采样方式：速度取平均，流量求和
     *
     * @param detectorId 检测器id
     * @param start      开始时间
     * @param end        结束时间
     * @param period     采样周期
     * @return List<VolumeAndSpeedVO>
     */
    public List<VolumeAndSpeedVO> getVolumeAndSpeedList(long detectorId, Date start, Date end, int period) {
        List<VolumeAndSpeedVO> list = statisticsMapper.queryVolumeAndSpeedList(detectorId, start, end, period);
        // 重采样后时间需重新设置
        return recoverTimeAndIndex(period, list);
    }

    /**
     * 指定日期范围内 按指定字段排序后的前limit个信息
     *
     * @param start start 开始时间
     * @param end   start 结束时间
     * @param limit 返回数量
     * @return List<VolumeAndSpeedVO>
     */
    public List<RankItemOfVolumeAndSpeedVO> getTopDetectorBy(Date start, Date end, int limit, String by) {
        if (!ORDER_COLUMNS.contains(by)) {
            throw new RuntimeException("无效的排序字段 " + by);
        }
        return statisticsMapper.queryTopNDetectorByVolume(start, end, limit, by);
    }

    /**
     * 获取实时流量(start, end]
     *
     * @param detectorId 检测器id
     * @param start      开始时间
     * @param end        结束时间
     * @param period     周期
     * @return List<VolumeAndSpeedVO>
     */
    public List<VolumeAndSpeedVO> getRealTimeVolume(Long detectorId, Date start, Date end, Integer period) {
        List<VolumeAndSpeedVO> list = statisticsMapper.queryRealTimeVolume(detectorId,
                TimeUtils.ceilToMin(start, period),
                TimeUtils.toPeriodMax(end, period), period);
        return recoverTimeAndIndex(period, list);
    }

    /**
     * 获取实时速度(start, end]
     *
     * @param detectorId 检测器id
     * @param start      开始时间
     * @param end        结束时间
     * @param period     周期
     * @return List<VolumeAndSpeedVO>
     */
    public List<VolumeAndSpeedVO> getRealTimeSpeed(Long detectorId, Date start, Date end, Integer period) {
        List<VolumeAndSpeedVO> list = statisticsMapper.queryRealTimeSpeed(detectorId,
                TimeUtils.ceilToMin(start, period),
                TimeUtils.toPeriodMax(end, period), period);
        return recoverTimeAndIndex(period, list);
    }


    /**
     * 恢复重采样时减小的时间戳
     *
     * @param period 重采样周期
     * @param list   List<VolumeAndSpeedVO>
     * @return index 和 time 正确的列表
     */
    private List<VolumeAndSpeedVO> recoverTimeAndIndex(Integer period, List<VolumeAndSpeedVO> list) {
        list.forEach(vs -> {
            vs.setIndex(vs.getIndex() * period * 1000);
            vs.setTime(new Date(vs.getIndex()));
        });
        return list;
    }

    /**
     * 获得指定时间范围内的总流量
     *
     * @param detectorId 检测器Id(Optional)
     * @param start      开始时间
     * @param end        结束时间
     * @return 总流量
     */
    public Long getTotalVolume(Long detectorId, Date start, Date end) {
        return statisticsMapper.getTotalVolume(detectorId, start, end);
    }
}