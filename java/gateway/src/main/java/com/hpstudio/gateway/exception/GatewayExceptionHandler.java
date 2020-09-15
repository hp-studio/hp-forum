package com.hpstudio.gateway.exception;

import com.hpstudio.gateway.entity.Result;
import com.hpstudio.gateway.exception.exceptionType.PasswordErrorException;
import com.hpstudio.gateway.exception.exceptionType.TokenEmptyException;
import com.hpstudio.gateway.exception.exceptionType.TokenErrorException;
import com.hpstudio.gateway.exception.exceptionType.UserNotExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author mawen
 * @date 2020/9/10 17:05
 * @email 455766076@qq.com
 */
@ControllerAdvice
@Slf4j
public class GatewayExceptionHandler {

    @ExceptionHandler(PasswordErrorException.class)
    public ResponseEntity<Result> passwordError(PasswordErrorException e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.ok(Result.fail(e.getMessage()));
    }

    @ExceptionHandler({TokenErrorException.class,io.jsonwebtoken.SignatureException.class})
    public ResponseEntity<Result> tokenError(TokenErrorException e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.ok(Result.fail(e.getMessage()));
    }


    @ExceptionHandler(UserNotExistException.class)
    public ResponseEntity<Result> userNotExist(UserNotExistException e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.ok(Result.fail(e.getMessage()));
    }


    @ExceptionHandler(TokenEmptyException.class)
    public ResponseEntity<Result> tokenEmpty(TokenEmptyException e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.ok(Result.fail(e.getMessage()));
    }
}
