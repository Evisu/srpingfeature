package com.jdyh.springfeature.common;

import lombok.Getter;

@Getter
public enum ResponseCodeEnum {

	/**
	 * 操作成功
	 */
	SUCCESS(200, "操作成功"),
	
	/**
	 *  系统内部异常
	 */
    SERVER_ERROR(500, "系統异常"),

    /**
     * 请求错误
     */
    REQUEST_ERROR(400, "请求错误"),
    
    /**
     * 未授权
     */
    UNAUTHORIZED(401, "未授权"),
    
    /**
     * 不可访问
     */
    NOT_ACCESSIBLE(403, "不可访问"),
    
    /**
     * 不存在
     */
    NOT_FOUND(404, "不存在"),
    
    /**
     * 方法不被允许
     */
    METHOD_NOT_ALLOWED(405, "方法不被允许"),
    
    /**
     * 不支持当前媒体类型
     */
    UNSUPPORTED_MEDIA_TYPE(415, "不支持当前媒体类型"),

    /**
     * 令牌失效
     */
    TOKEN_LOSE_EFFICACY(1001,"您的登录令牌已失效，请重新登录");

    private Integer code;

    private String message;

    ResponseCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ResponseCodeEnum getByCode(Integer code) {

        for (ResponseCodeEnum responseCodeEnum : ResponseCodeEnum.values()) {
            if (responseCodeEnum.getCode().equals(code)) {
                return responseCodeEnum;
            }
        }
        return null;
    }
}
