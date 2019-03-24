package cn.edu.sdst.mwrdph.front.vo;

import cn.edu.sdst.mwrdph.entity.DetectorPO;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 单个监测点分布信息
 * Monitoring Point Distribute Item View Object
 *
 * @author ZhangYu
 * @date 2019/2/23
 */
@Data
@NoArgsConstructor
public class MpDistributeItemVO {

    private Section section;
    /**
     * 监测器id
     */
    private Long id;
    /**
     * 监测点名
     */
    private String name;
    /**
     * 监测监控 url
     */
    private String videoUrl;
    /**
     * 监测点经度
     */
    private Double lng;
    /**
     * 监测点纬度
     */
    private Double lat;
    /**
     * 检测器是否正常
     */
    private Boolean normal;

    public MpDistributeItemVO(DetectorPO detectorPO) {
        this.id = detectorPO.getId();
        this.name = detectorPO.getName();
        this.videoUrl = detectorPO.getVideoUrl();
        this.lng = detectorPO.getLng();
        this.lat = detectorPO.getLat();
        this.normal = judeStatus(detectorPO);
    }

    private Boolean judeStatus(DetectorPO detector) {
        // 雷达异常
        if (!detector.getRadarAlive()) {
            return false;
        }
        // 有摄像头且摄像头异常
        if (detector.getHasCamera() && !detector.getCameraAlive()) {
            return false;
        }
        return true;
    }
}

@Data
class Section {
    private Long id;
    private String name;
    private Double lng;
    private Double lat;
}