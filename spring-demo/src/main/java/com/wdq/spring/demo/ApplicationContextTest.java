package com.wdq.spring.demo;

import com.wdq.spring.demo.example.Example;
import com.wdq.spring.demo.service.GoodsService;

import org.springframework.aop.framework.ProxyConfig;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wudq
 * @date 2019/9/3
 * @Description:
 */
public class ApplicationContextTest {
	public static void main(String[] args) {

		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("com.wdq.spring.demo");
		ProxyConfig proxyConfig = context.getBean(ProxyConfig.class);
		proxyConfig.setExposeProxy(Boolean.TRUE);
		Example example = context.getBean(Example.class);
//		example.saveGoods();
		example.getGoods();
	}
}
