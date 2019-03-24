package cn.edu.sdst.mwrdph.front.vo;

import lombok.Data;

import java.util.List;

/**
 * 监测点详情信息
 * Monitoring Point Details View Object
 *
 * @author ZhangYu
 * @date 2019/2/24
 */
@Data
public class MpDetailsVO {
    private VolumeAndSpeedVO perMinute;
    private VolumeAndSpeedVO perHour;

    private String id;
    private String name;
    private String videoUrl;


    private List<VolumeAndSpeedVO> realtimeData;
    private List<TrafficIncidentVO> incidents;
}
