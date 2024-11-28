package com.example.demo.dto;

import com.example.demo.exception.BaseException;
import com.example.demo.type.ResultType;

public class ResultObject {

    public String code;
    public String desc;
    public String message;

    public ResultObject(ResultType resultType) {
        this.code = resultType.getCode();
        this.desc = resultType.getDesc();
    }

    public ResultObject(ResultType resultTypeCode, String message) {
        this.code = resultTypeCode.getCode();
        this.desc = message;
    }

    public ResultObject(BaseException e) {
        this.code = e.getCode();
        this.desc = e.getDesc();
        this.message = e.getMessage();
    }

    public static ResultObject getSuccess() {
        return new ResultObject(ResultType.SUCCESS);
    }

}
