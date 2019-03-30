package cn.edu.sdst.mwrdph.review.vo;

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

/**
 * Demo class
 *
 * @author ZhangYu
 * @date 2019/3/29
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewVO {
    private Long userId;
    private Long incidentId;

    private String timestamp;
    private String sectionName;

    private Double speed;
    private Double distance;
    @ColumnType(typeHandler = CarTypeEnumTypeHandler.class)
    private CarTypeEnum carType;
    @ColumnType(typeHandler = LaneEnumTypeHandler.class)
    private LaneEnum lane;
    private String licensePlate;
    @ColumnType(typeHandler = TrafficIncidentEnumTypeHandler.class)
    private TrafficIncidentEnum type;
    private Long reviewId;
}