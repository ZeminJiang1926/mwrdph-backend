package cn.edu.sdst.mwrdph.common;

import cn.edu.sdst.mwrdph.enums.SuccessEnum;
import lombok.Data;

/**
 * 请求成功结果
 *
 * @author ZhangYu
 * @date 2019/2/12
 */
@Data
public class SuccessResultVO extends ResultVO {

    public SuccessResultVO() {
        super(SuccessEnum.REQUEST_SUCCESS.getCode(), SuccessEnum.REQUEST_SUCCESS.getMessage());
    }

    public SuccessResultVO(String message) {
        this(400, message);
    }

    public SuccessResultVO(int status, String message) {
        super(status, message);
    }

    public SuccessResultVO(SuccessEnum successEnum) {
        super(successEnum.getCode(), successEnum.getMessage());
    }
}