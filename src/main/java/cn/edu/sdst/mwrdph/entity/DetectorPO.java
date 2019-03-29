package cn.edu.sdst.mwrdph.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 监测器信息表
 *
 * @author ZhangYu
 * @date 2019/2/13
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mwr_detector")
public class DetectorPO {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private Long sectionId;
    private String name;
    private Short direction;
    private Double lng;
    private Double lat;
    private Boolean radarAlive;
    private Boolean hasCamera;
    private String videoUrl;
    private Boolean cameraAlive;
    private Boolean deleted;
    private Date createTime;
    private Date updateTime;
    private Long pcId;
    private String laneIp;
}
