package cn.edu.sdst.mwrdph.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.ToString;

/**
 * 交通事件枚举
 *
 * @author ZhangYu
 * @date 2019/2/12
 */
@Getter
@ToString(callSuper = true)
public enum TrafficIncidentEnum {

    /**
     * 交通事件类型
     */
    NOT_ILLEGAL(-1, "未违章"),
    LOW_SPEED(0, "低速"),
    SPEEDING(1, "超速"),
    OCCUPY_EMERGENCY_LANE(2, "占用应急车道"),
    RETROGRADE(3, "逆行"),
    LANE_CHANGE(4, "变道"),
    PARKING(5, "违停");


    private int code;
    private String alias;

    @JsonValue
    public int getCode() {
        return code;
    }

    TrafficIncidentEnum(int code, String alias) {
        this.code = code;
        this.alias = alias;
    }

    @JsonCreator
    public static TrafficIncidentEnum ofCode(int code) {
        for (TrafficIncidentEnum ele : TrafficIncidentEnum.values()) {
            if (ele.getCode() == code) {
                return ele;
            }
        }
        return null;
    }

    public static TrafficIncidentEnum ofAlias(String alias) {
        for (TrafficIncidentEnum ele : TrafficIncidentEnum.values()) {
            if (ele.getAlias() == alias) {
                return ele;
            }
        }
        return null;
    }
}
