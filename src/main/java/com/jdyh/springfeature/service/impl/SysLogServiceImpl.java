package com.jdyh.springfeature.service.impl;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.jdyh.springfeature.bean.SysLogBean;
import com.jdyh.springfeature.service.SysLogService;

@Service
public class SysLogServiceImpl implements SysLogService {

	@Override
	public void save(SysLogBean sysLogBean) {
		// TODO 保存系统日志实现
		System.out.println(JSON.toJSONString(sysLogBean));
	}

}
