package com.jdyh.springfeature.bean;

import lombok.Data;

@Data
public class SysLogBean {
	
	private String sysLogId;
	
	private String className;
	 
    private String methodName;
 
    private String params;
 
    private Long exeuTime;
 
    private String remark;
 
    private String createDate;


}
