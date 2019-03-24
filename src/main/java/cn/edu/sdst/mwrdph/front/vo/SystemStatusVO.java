package cn.edu.sdst.mwrdph.front.vo;

import lombok.Data;

/**
 * 系统状态
 *
 * @author ZhangYu
 * @date 2019/2/23
 */
@Data
public class SystemStatusVO {
    private Integer radarTotal;
    private Integer radarAliveTotal;

    private Integer cameraTotal;
    private Integer cameraAliveTotal;
}
