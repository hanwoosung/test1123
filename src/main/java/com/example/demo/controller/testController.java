package com.example.demo.controller;

import com.example.demo.dto.ResponseDto;
import com.example.demo.exception.BaseException;
import com.example.demo.type.ResultType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class testController extends AbstractController {

    @PostMapping("/")
    public @ResponseBody ResponseDto<Void> get() {
        /*throw new BaseException(ResultType.ERROR, "시발에러떳다");*/
        return ok();
    }

    @GetMapping
    public String test() {
        return "test";
    }
}
