package cn.edu.sdst.mwrdph.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 事件信息表
 *
 * @author ZhangYu
 * @date 2019/2/12
 */
@Data
@Table(name = "mwr_incident")
@NoArgsConstructor
@AllArgsConstructor
public class IncidentPO {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private Long sectionId;
    private Long detectorId;
    private Integer type;
    private Double distance;
    private Double speed;
    private String info;
    @Column(name = "is_checked")
    private Boolean checked;
    private Date createdTime;
    private Date updateTime;
    private Date timestamp;
}
