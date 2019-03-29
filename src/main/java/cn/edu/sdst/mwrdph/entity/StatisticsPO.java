package cn.edu.sdst.mwrdph.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 流量速度表
 *
 * @author ZhangYu
 * @date 2019/2/16
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mwr_statistics")
public class StatisticsPO {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private Long detectorId;
    private Long sectionId;
    private Short direction;
    private Integer volume;
    private Double speed;
    private Date createTime;
    private Date timestamp;
}
