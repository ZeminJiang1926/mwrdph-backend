package cn.edu.sdst.mwrdph.entity;

import cn.edu.sdst.mwrdph.enums.TrafficIncidentEnum;
import cn.edu.sdst.mwrdph.typehandler.TrafficIncidentEnumTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.ColumnType;
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
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mwr_incident")
public class IncidentPO {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private Long sectionId;
    private Long detectorId;
    @ColumnType(typeHandler = TrafficIncidentEnumTypeHandler.class)
    private TrafficIncidentEnum type;
    private Double distance;
    private Double speed;
    private String info;
    private Boolean checked;
    private Date createTime;
    private Date updateTime;
    private Date timestamp;
}
