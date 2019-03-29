package cn.edu.sdst.mwrdph.entity;

import cn.edu.sdst.mwrdph.enums.CarTypeEnum;
import cn.edu.sdst.mwrdph.enums.LaneEnum;
import cn.edu.sdst.mwrdph.enums.TrafficIncidentEnum;
import cn.edu.sdst.mwrdph.typehandler.CarTypeEnumTypeHandler;
import cn.edu.sdst.mwrdph.typehandler.LaneEnumTypeHandler;
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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mwr_review")
public class ReviewPO {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private Long incidentId;
    private Long userId;
    @ColumnType(typeHandler = LaneEnumTypeHandler.class)
    private LaneEnum lane;
    @ColumnType(typeHandler = CarTypeEnumTypeHandler.class)
    private CarTypeEnum carType;
    private String licensePlate;
    @ColumnType(typeHandler = TrafficIncidentEnumTypeHandler.class)
    private TrafficIncidentEnum incidentType;
    private Long lastId;
    private Boolean end;
    private Date createTime;
    private Date updateTime;
}
