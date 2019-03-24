package cn.edu.sdst.mwrdph.exception;

import cn.edu.sdst.mwrdph.enums.ExceptionEnum;

/**
 * 通用异常
 *
 * @author ZhangYu
 * @date 2019/2/12
 */
public class MwrException extends RuntimeException {
    private ExceptionEnum exceptionEnum;

    public MwrException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.exceptionEnum = exceptionEnum;
    }

    public ExceptionEnum getExceptionEnum() {
        return this.exceptionEnum;
    }

    public int getCode() {
        return this.getExceptionEnum().getCode();
    }
}
