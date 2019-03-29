package cn.edu.sdst.mwrdph.enums;

import lombok.Getter;
import lombok.ToString;

/**
 * 成功信息枚举
 *
 * @author ZhangYu
 * @date 2019/2/12
 */
@Getter
@ToString(callSuper = true)
public enum SuccessEnum {
    /**
     * CRUD执行结果
     */
    REQUEST_SUCCESS(200, "请求成功"),
    INSERT_SUCCESS(201, "数据插入成功"),
    CREATE_SUCCESS(201, "数据创建成功"),
    UPDATE_SUCCESS(202, "数据更新成功"),
    DELETE_SUCCESS(203, "数据删除成功");
    private int code;
    private String message;

    SuccessEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
