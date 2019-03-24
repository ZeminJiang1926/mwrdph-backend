package cn.edu.sdst.mwrdph.enums;

import lombok.Getter;

/**
 * 异常信息枚举
 *
 * @author ZhangYu
 * @date 2019/2/12
 */
@Getter
public enum ExceptionEnum {
    // 需要自定义异常信息时在这里定义
    /**
     * 默认资源不存在错误
     */
    BAD_REQUEST(400, "错误请求"),
    NOT_VALIDATION(401, "未验证"),
    FORBIDDEN(403, "服务器拒绝"),
    NOT_FOUNT(404, "资源不存在");
    /**
     * 错误码
     */
    private int code;
    /**
     * 错误信息
     */
    private String message;

    ExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
