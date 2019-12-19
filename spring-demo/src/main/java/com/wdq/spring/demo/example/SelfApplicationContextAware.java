package com.wdq.spring.demo.example;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author wudq
 * @date 2019/9/3
 * @Description:
 */
@Component
public class SelfApplicationContextAware implements ApplicationContextAware {

	ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		System.out.println("ApplicationContextAware");
	}
}
