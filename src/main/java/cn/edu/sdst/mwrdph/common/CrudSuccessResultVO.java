package cn.edu.sdst.mwrdph.common;

import cn.edu.sdst.mwrdph.enums.SuccessEnum;
import lombok.ToString;

/**
 * 数据库相关操作成功结果视图
 *
 * @author ZhangYu
 * @date 2019/2/13
 */
@ToString
public class CrudSuccessResultVO extends SuccessResultVO {
    public CrudSuccessResultVO(SuccessEnum successEnum, int count) {
        super(successEnum.getCode(), successEnum.getMessage() + " count:" + count);
    }
}
