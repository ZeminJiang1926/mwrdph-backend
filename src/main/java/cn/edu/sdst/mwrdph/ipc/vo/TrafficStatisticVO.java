package cn.edu.sdst.mwrdph.ipc.vo;

import lombok.Data;

import java.util.Date;

/**
 * 单检测器统计数据
 *
 * @author ZhangYu
 * @date 2019/2/17
 */
@Data
public class TrafficStatisticVO {
    private Long detectorId;
    private Long sectionId;
    private Integer volume;
    private Double speed;
    private Date timestamp;
}
