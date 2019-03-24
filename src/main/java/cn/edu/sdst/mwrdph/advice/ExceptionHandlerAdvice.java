package cn.edu.sdst.mwrdph.advice;

import cn.edu.sdst.mwrdph.common.ExceptionResultVO;
import cn.edu.sdst.mwrdph.exception.MwrException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 异常处理
 *
 * @author ZhangYu
 * @date 2019/2/12
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    /**
     * 通用异常处理
     *
     * @param e MwrException
     * @return ExceptionResultVO json string
     */
    @ExceptionHandler(MwrException.class)
    public ResponseEntity<ExceptionResultVO> handleException(MwrException e) {
        return ResponseEntity.status(e.getCode()).body(new ExceptionResultVO(e.getExceptionEnum()));
    }
}
