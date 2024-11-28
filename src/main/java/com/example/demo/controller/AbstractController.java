package com.example.demo.controller;

import com.example.demo.dto.ResponseDto;
import com.example.demo.dto.ResultObject;

public abstract class AbstractController {

    public <T> ResponseDto<T> ok() {
        return ok(null, ResultObject.getSuccess());
    }

    public <T> ResponseDto<T> ok(T data) {
        return ok(data, ResultObject.getSuccess());
    }

    public <T> ResponseDto<T> ok(T data, ResultObject result) {
        ResponseDto<T> obj = new ResponseDto<>();
        obj.setResult(result);
        obj.setData(data);
        return obj;
    }
}