package com.yc.edusys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.yc.edusys.util.RedisUtils;

/**
 * @author navy
 * @company 源辰信息
 * 
 * Springboot给我们提供了两种“开机启动”某些方法的方式：ApplicationRunner和CommandLineRunner。
 * 这两种方法提供的目的是为了满足，在项目启动的时候立刻执行某些方法。
 * 我们可以通过实现ApplicationRunner和CommandLineRunner来实现，他们都是在SpringApplication 执行之后开始执行的。
 * CommandLineRunner接口可以用来接收字符串数组的命令行参数，ApplicationRunner 是使用ApplicationArguments 用来接收参数的
 */

@Component //被spring容器管理
@Order(2) //如果多个自定义ApplicationRunner，用来标明执行顺序
public class InitControllerRunner implements ApplicationRunner{
	@Autowired
	private RedisUtils redisUtils;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO 需要缓存到redis中的数据
	}
}
