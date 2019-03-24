package cn.edu.sdst.mwrdph.front.vo;

import lombok.Data;


/**
 * 流量速度排名
 *
 * @author ZhangYu
 * @date 2019/3/6
 */
@Data
public class RankItemOfVolumeAndSpeedVO {
    private Integer volume;
    private Double speed;
    private Long detectorId;
    private String name;
    private Double lng;
    private Double lat;
}
