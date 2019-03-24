package cn.edu.sdst.mwrdph.front.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 实时流量/速度数据
 *
 * @author ZhangYu
 * @date 2019/2/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VolumeAndSpeedVO {
    private Long index;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time;
    private Integer count;
    private Long volume;
    private Double speed;
}
