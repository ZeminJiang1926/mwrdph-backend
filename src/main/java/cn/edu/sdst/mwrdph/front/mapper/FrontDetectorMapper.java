package cn.edu.sdst.mwrdph.front.mapper;


import cn.edu.sdst.mwrdph.entity.DetectorPO;
import cn.edu.sdst.mwrdph.front.vo.MpDistributeItemVO;
import cn.edu.sdst.mwrdph.front.vo.SystemStatusVO;
import cn.edu.sdst.mwrdph.front.vo.VolumeAndSpeedVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * FrontDetectorMapper
 *
 * @author ZhangYu
 * @date 2019/2/23
 */
@org.apache.ibatis.annotations.Mapper
public interface FrontDetectorMapper extends Mapper<DetectorPO> {
    /**
     * 查询系统整体状态
     *
     * @return 系统整体状态
     */
    SystemStatusVO querySystemStatus();

    /**
     * 按雷达id 查询指定timestamp前n分钟的速度/流量平均值
     *
     * @param detectorId 检测器id;
     * @param timestamp  时间
     * @param period     前n分钟
     * @return VolumeAndSpeedVO
     */
    VolumeAndSpeedVO queryAvgVolumeAndSpeedBeforeMinute(long detectorId, long timestamp, int period);

    /**
     * 按雷达id 查询指定时间范围内[start, end]指定粒度的速度/流量平均值
     *
     * @param detectorId 检测器id
     * @param start      开始时间
     * @param end        结束时间
     * @param period     查询粒度
     * @return List<VolumeAndSpeedVO>
     */
    List<VolumeAndSpeedVO> queryLatestVolumeAndSpeedWithin(long detectorId, long start, long end, int period);

    /**
     * 获取雷达点位分布信息
     *
     * @return List<MpDistributeItemVO>
     */
    List<MpDistributeItemVO> queryDistributeInfo();
}
