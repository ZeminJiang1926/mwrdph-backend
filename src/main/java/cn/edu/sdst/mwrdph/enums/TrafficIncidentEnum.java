package cn.edu.sdst.mwrdph.enums;

import lombok.Getter;

/**
 * 交通事件枚举
 *
 * @author ZhangYu
 * @date 2019/2/12
 */
@Getter
public enum TrafficIncidentEnum {
    /**
     * 低速行驶
     */
    LOW_SPEED(0, "低速行驶", "低速"),
    /**
     * 超速行驶
     */
    SPEEDING(1, "超速行驶", "超速"),
    /**
     * 占用应急车道
     */
    OCCUPY_EMERGENCY_LANE(2, "占用应急车道", "占道"),
    /**
     * 车辆匝道逆行
     */
    RETROGRADE(3, "车辆匝道逆行", "逆行");
    private int code;
    private String message;
    private String shortName;

    TrafficIncidentEnum() {
    }

    TrafficIncidentEnum(int code, String message, String shortName) {
        this.code = code;
        this.message = message;
        this.shortName = shortName;
    }

    public static TrafficIncidentEnum getByCode(int code) {
        for (TrafficIncidentEnum value : TrafficIncidentEnum.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        return null;
    }
}
