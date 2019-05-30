package com.jdyh.springfeature.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdyh.springfeature.annotation.SysLog;

@RestController
@RequestMapping("/sysLog")
public class SysLogController {
	
	@SysLog("系统日志切面测试")
	@RequestMapping("/excute")
	public String excute(@RequestParam("pk") String pk) {
		return "执行了excute方法";
	}

}
