package com.example.demo.exception;

import com.example.demo.type.ResultType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseException extends RuntimeException {

    private String code;
    private String desc;
    private String message;

    public BaseException(ResultType resultType) {
        super(resultType.getDesc());
        this.code = resultType.getCode();
        this.desc = resultType.getDesc();
    }

    public BaseException(ResultType resultType, String message) {
        super(resultType.getDesc() + " - " + (message != null ? message : "메세지는 없다!"));
        this.code = resultType.getCode();
        this.desc = resultType.getDesc();
        this.message = message != null ? message : "메세지는 없다!";
    }
}