package com.example.demo.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Slf4j
@ControllerAdvice
public class HtmlException {

    @ExceptionHandler(BaseException.class)
    public String baseException(BaseException e, Model model) {

        model.addAttribute("errorCode", e.getCode());
        model.addAttribute("errorMessage", e.getMessage());

        log.error("HtmlException 발생: 코드={}, 메시지={}", e.getCode(), e.getMessage(), e);
        return "error/customError";
    }

    @ExceptionHandler(Exception.class)
    public String genericException(Exception e, Model model) {

        String decodedMessage = URLDecoder.decode(e.getMessage(), StandardCharsets.UTF_8);

        model.addAttribute("errorCode", "500");
        model.addAttribute("errorMessage", "알 수 없는 오류: " + decodedMessage);

        log.error("예기치 않은 오류(Html->genericException):  {}", decodedMessage, e);

        return "error/generalError";
    }

}