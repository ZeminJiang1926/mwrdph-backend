package cn.edu.sdst.mwrdph.common;

import org.springframework.http.ResponseEntity;

/**
 * ResponseEntity的工具类
 *
 * @author ZhangYu
 * @date 2019/2/13
 */
public class ResponseCreater {
    /**
     * 根据ResultVO生成Response
     *
     * @param resultVO ResultVO
     * @param <T>      ResultVO
     * @return ResponseEntity<ResultVO>
     */
    public static <T extends ResultVO> ResponseEntity<T> create(T resultVO) {
        return ResponseEntity.status(resultVO.getStatus()).body(resultVO);
    }
}
