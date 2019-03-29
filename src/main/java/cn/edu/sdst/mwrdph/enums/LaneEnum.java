package cn.edu.sdst.mwrdph.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.ToString;

/**
 * 车道
 *
 * @author ZhangYu
 * @date 2019/3/28
 */
@Getter
@ToString
public enum LaneEnum {
    /**
     * 除应急车道外，其余数值与索引相对应
     */
    EMERGENCY(0), ONE(1), TWO(2), THREE(3), FOUR(4);

    private int code;

    LaneEnum(int code) {
        this.code = code;
    }

    @JsonValue
    public int getCode() {
        return code;
    }

    @JsonCreator
    public static LaneEnum ofCode(int code) {
        for (LaneEnum ele : LaneEnum.values()) {
            if (ele.code == code) {
                return ele;
            }
        }
        return null;
    }
}
