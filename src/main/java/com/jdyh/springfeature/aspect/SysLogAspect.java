package com.jdyh.springfeature.aspect;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.jdyh.springfeature.annotation.SysLog;
import com.jdyh.springfeature.bean.SysLogBean;
import com.jdyh.springfeature.service.SysLogService;

/**
 *	 系统日志切面
 * 
 * @author walkman
 *
 */
@Aspect  
@Component
public class SysLogAspect {
	
	@Autowired
	private SysLogService sysLogService;
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Pointcut("@annotation(com.jdyh.springfeature.annotation.SysLog)")
    public void logPointCut() {}
	
	@Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
		logger.info("【系统日志环绕通知：】");
        long beginTime = System.currentTimeMillis();
        Object result = point.proceed();
        long time = System.currentTimeMillis() - beginTime;
        try {
        	saveLog(point,time);
        } catch (Exception e) {
        }
        return result;

	}
	
	private void saveLog(ProceedingJoinPoint point, long time) {
		MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        
        SysLogBean sysLogBean = new SysLogBean();
        sysLogBean.setSysLogId(UUID.randomUUID().toString());
        sysLogBean.setExeuTime(time);
        sysLogBean.setCreateDate(dateFormat.format(new Date()));
        
        SysLog sysLog = method.getAnnotation(SysLog.class);
        if(sysLog != null){
            //注解上的描述
        	sysLogBean.setRemark(sysLog.value());
        }
        
        String className = point.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLogBean.setClassName(className);
        sysLogBean.setMethodName(methodName);
        //请求的参数
        Object[] args = point.getArgs();
        try{
            List<String> list = new ArrayList<String>();
            for (Object o : args) {
                list.add(JSON.toJSONString(o));
            }
            sysLogBean.setParams(list.toString());
        }catch (Exception e){ }
        
        sysLogService.save(sysLogBean);
	
		
	}

}
