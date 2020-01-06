package com.jdyh.springfeature.bean;

import javax.annotation.Resource;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.jdyh.springfeature.zookeeper.ZooKeeperProSync;

/**
 * 	初始化系统
 * 
 * @author gc
 * @date 2019年12月27日
 * @description
 */
@Component
public class InitSystemBean implements ApplicationRunner{
	
	@Resource
	private ZooKeeperProSync zooKeeperProSync;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		
		System.out.println("初始化系统");
		zooKeeperProSync.start();
		
		
	}

}
