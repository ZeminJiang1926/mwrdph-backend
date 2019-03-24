package cn.edu.sdst.mwrdph.common;

import lombok.Data;

/**
 * 结果视图对象
 *
 * @author ZhangYu
 * @date 2019/2/12
 */
@Data
public class ResultVO {
    /**
     * 状态码
     */
    private Integer status;
    /**
     * 状态信息
     */
    private String message;
    /**
     * 时间戳
     */
    private Long timestamp;

    public ResultVO() {
        this(400, "请求成功");
    }

    public ResultVO(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }
}
