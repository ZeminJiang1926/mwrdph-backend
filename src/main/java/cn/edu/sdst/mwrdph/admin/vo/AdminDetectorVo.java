package cn.edu.sdst.mwrdph.admin.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 管理界面前端展示检测器表
 *
 * @author wzh
 * @date 2019/3/30
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mwr_detector")
public class AdminDetectorVo {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private Long sectionId;
    private String name;
    private Short direction;
    private Double lng;
    private Double lat;
    private Short radarAlive;
    private Short hasCamera;
    private String videoUrl;
    private Short cameraAlive;
    private Short deleted;
    private Date createTime;
    private Date updateTime;
    private Long pcId;
    private String laneIp;
}
