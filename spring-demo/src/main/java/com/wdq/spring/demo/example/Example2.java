package com.wdq.spring.demo.example;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author wudq
 * @date 2019/9/3
 * @Description:
 */
@Component
public class Example2 implements InitializingBean {


	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("-------生命周期回调 PostConstruct2");
	}
}
