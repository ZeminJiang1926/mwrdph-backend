package cn.edu.sdst.mwrdph.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.ToString;

/**
 * Demo class
 *
 * @author ZhangYu
 * @date 2019/3/30
 */
@ToString
@Getter
public enum UserRoleEnum {
    /**
     * 用户身份信息
     */
    REVIEWER(1, "审查员"),
    ADMINISTRATOR(2, "管理员");

    private int code;
    private String alias;

    UserRoleEnum(int code, String alias) {
        this.code = code;
        this.alias = alias;
    }

    @JsonValue
    public int getCode() {
        return code;
    }

    @JsonCreator
    public static UserRoleEnum ofCode(int code) {
        for (UserRoleEnum ele : UserRoleEnum.values()) {
            if (ele.code == code) {
                return ele;
            }
        }
        return null;
    }

    public static UserRoleEnum ofAlias(String alias) {
        for (UserRoleEnum ele : UserRoleEnum.values()) {
            if (ele.alias == alias) {
                return ele;
            }
        }
        return null;
    }
}
