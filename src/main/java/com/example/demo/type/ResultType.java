package com.example.demo.type;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResultType {

    SUCCESS("200", "SUCCESS"),
    ERROR("000", "ERROR");

    private final String code;
    private final String desc;
}