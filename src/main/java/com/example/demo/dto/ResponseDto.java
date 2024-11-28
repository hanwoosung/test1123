package com.example.demo.dto;


import com.example.demo.exception.BaseException;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto<T> {

    private ResultObject result;

    private T data;

    public ResponseDto(ResultObject result) {
        this.result = result;
    }

    public ResponseDto(T data) {
        this.data = data;
    }

    public static <T> ResponseDto<T> ok(){
        return new ResponseDto<>(ResultObject.getSuccess());
    }

    public static <T> ResponseDto<T> ok(T data){
        return new ResponseDto<>(ResultObject.getSuccess(),data);
    }

    public static <T> ResponseDto<T> response(T data){
        return new ResponseDto<>(ResultObject.getSuccess(),data);
    }

    public ResponseDto(BaseException e){
        this.result = new ResultObject(e);
    }
}
