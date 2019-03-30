package cn.edu.sdst.mwrdph.admin.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import java.util.Date;


/**
 * 管理界面前端展示事件表
 *
 * @author wzh
 * @date 2019/3/30
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminIncidentVo {
    @Id
    @KeySql(useGeneratedKeys = true)
    private int id;
    private String sectionName;

    /**
     * 车道
     */
    private int lane;

    private int incidentType;
    private Double distance;
    private Double speed;
    private String licensePlate;

    /**
     * 车型
     */
    private int carType;
    private Boolean checking;
    /**
     * 审查结束与否
     */
    private Boolean end;
    private Date createTime;
    private Date updateTime;
    private Date timestamp;
    private String userName;
}
