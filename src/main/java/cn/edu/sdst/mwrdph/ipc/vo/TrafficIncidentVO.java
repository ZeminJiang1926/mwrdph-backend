package cn.edu.sdst.mwrdph.ipc.vo;

import cn.edu.sdst.mwrdph.enums.TrafficIncidentEnum;
import lombok.Data;

import java.util.Date;

/**
 * 单检测器交通事件
 *
 * @author ZhangYu
 * @date 2019/2/12
 */
@Data
public class TrafficIncidentVO {
    private Long sectionId;
    private Long detectorId;
    private TrafficIncidentEnum type;
    private Double speed;
    private Double distance;
    private Date timestamp;
}
