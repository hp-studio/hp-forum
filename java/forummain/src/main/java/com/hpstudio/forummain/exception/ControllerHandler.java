package com.hpstudio.forummain.exception;

import com.hpstudio.forummain.entity.Result;
import com.hpstudio.forummain.exception.exceptionType.WrapperException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * controller异常切面捕捉
 * @author mawen
 * @date 2020/9/10 10:49
 * @email 455766076@qq.com
 */
@Slf4j
@RestControllerAdvice
public class ControllerHandler {

    @ExceptionHandler(WrapperException.class)
    public ResponseEntity<Result> handleException(WrapperException e,Object object) {
        log.error(e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.OK).body(Result.fail(e.getMessage()));
    }
}
