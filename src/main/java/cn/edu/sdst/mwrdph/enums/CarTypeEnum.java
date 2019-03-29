package cn.edu.sdst.mwrdph.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.ToString;

/**
 * 车辆类型
 *
 * @author ZhangYu
 * @date 2019/3/28
 */
@Getter
@ToString(callSuper = true)
public enum CarTypeEnum {
    /**
     * 车辆类型，code与数据库一一对应
     */
    SMALL(1, "小型车"),
    MID(2, "中型车"),
    LARGE(3, "大型车");

    private final int code;
    private final String alias;

    CarTypeEnum(int code, String alias) {
        this.code = code;
        this.alias = alias;
    }

    @JsonValue
    public int getCode() {
        return code;
    }

    @JsonCreator
    public static CarTypeEnum ofCode(int code) {
        for (CarTypeEnum ele : CarTypeEnum.values()) {
            if (ele.code == code) {
                return ele;
            }
        }
        return null;
    }

    public static CarTypeEnum ofAlias(String alias) {
        for (CarTypeEnum ele : CarTypeEnum.values()) {
            if (ele.alias == alias) {
                return ele;
            }
        }
        return null;
    }
}

