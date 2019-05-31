package com.jdyh.springfeature.service;

import com.jdyh.springfeature.bean.SysLogBean;

public interface SysLogService
{

	/**
	 * 保存系统日志
	 * 
	 * @param sysLogBean
	 */
	public void save(SysLogBean sysLogBean);

}
