package cn.edu.sdst.mwrdph.ipc.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 单检测器状态
 *
 * @author ZhangYu
 * @date 2019/2/13
 */
@Data
public class DetectorStatusVO {
    private Long sectionId;
    @JsonProperty("detector_id")
    private Long id;
    private Boolean radarAlive;
    private Boolean cameraAlive;
}
