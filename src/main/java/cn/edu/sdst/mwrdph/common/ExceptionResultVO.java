package cn.edu.sdst.mwrdph.common;

import cn.edu.sdst.mwrdph.enums.ExceptionEnum;
import lombok.ToString;

/**
 * 异常结果
 *
 * @author ZhangYu
 * @date 2019/2/12
 */
@ToString
public class ExceptionResultVO extends ResultVO {

    public ExceptionResultVO() {
        super(ExceptionEnum.NOT_FOUNT.getCode(), ExceptionEnum.NOT_FOUNT.getMessage());
    }

    public ExceptionResultVO(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getCode(), exceptionEnum.getMessage());
    }
}
