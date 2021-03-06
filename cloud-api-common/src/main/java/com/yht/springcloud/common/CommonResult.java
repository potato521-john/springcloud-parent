package com.yht.springcloud.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;
    public CommonResult(Integer code, String msg){
        this(code,msg,null);
    }
    public CommonResult setCode(Integer code){
        this.code = code;
        return this;
    }

    public CommonResult setMsg(String msg){
        this.msg = msg;
        return this;
    }

    public CommonResult setData(T data){
        this.data = data;
        return this;
    }
}
