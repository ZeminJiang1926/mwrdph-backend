package cn.edu.sdst.mwrdph.front.vo;

import lombok.Data;

/**
 * 事件排名
 *
 * @author ZhangYu
 * @date 2019/3/7
 */
@Data
public class RankItemOfIncidentsVO {
    private Long detectorId;
    private String name;
    private Double lat;
    private Double lng;
    private Integer lowSpeed;
    private Integer speeding;
    private Integer retrograde;
    private Integer occupyEmergencyLane;
    private Integer count;
}
