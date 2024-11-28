package com.example.demo.exception;


import com.example.demo.dto.ResponseDto;
import com.example.demo.dto.ResultObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ApiException {

    @ExceptionHandler(BaseException.class)
    public ResponseDto<ResultObject> exception(BaseException e) {
        log.error("ApiException  : 코드={}, 메시지={}", e.getCode(), e.getMessage(), e);
        return new ResponseDto<>(e);
    }
}
