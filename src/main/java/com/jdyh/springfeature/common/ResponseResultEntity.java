package com.jdyh.springfeature.common;

import java.io.Serializable;

import lombok.Data;

@Data
public class ResponseResultEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
     * 	200为请求成功， 其它code均为请求错误
     */
    private Integer code;

    /**
     * 返回数据
     */
    private Object data;

    /**
     * 错误信息
     */
    private String message;
    
    
    public ResponseResultEntity() {
        this.code = ResponseCodeEnum.SUCCESS.getCode();
        this.message = "";
    }


    public ResponseResultEntity(Integer code) {
        this();
        this.code = code;
    }
    
    public ResponseResultEntity(Object data) {
        this();
        this.data = data;
    }

    public ResponseResultEntity(String message) {
        this.code = ResponseCodeEnum.SERVER_ERROR.getCode();
        this.message = message;
    }

    public ResponseResultEntity(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseResultEntity(ResponseCodeEnum responseCodeEnum) {
        this.code = responseCodeEnum.getCode();
        this.message = responseCodeEnum.getMessage();
    }
}
