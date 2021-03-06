package com.jdyh.springfeature.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdyh.springfeature.annotation.SysLog;
import com.jdyh.springfeature.common.ResponseResultEntity;
import com.jdyh.springfeature.util.RedisUtil;

@RestController
@RequestMapping("/sysLog")
public class SysLogController {
	@Autowired
	private RedisUtil redisUtil;

	@SysLog("系统日志切面测试")
	@RequestMapping("/excute")
	public String excute(@RequestParam("pk") String pk) {

		redisUtil.set("pk", pk);

		return "执行了excute方法";
	}

	@PostMapping("/test")
	public ResponseResultEntity test(@RequestBody Map<String, String> person)
	{
		ResponseResultEntity responseResultEntity = new ResponseResultEntity();
	
		try {
			Thread.sleep(3*1000);
		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
        responseResultEntity.setMessage("执行test方法");
        return responseResultEntity;
	}

}
