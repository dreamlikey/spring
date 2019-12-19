package com.wdq.spring.demo.example;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author wudq
 * @date 2019/9/3
 */
@Component
public class SelfProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof Example) {
			System.out.println("-------Example before post processor");
		}
		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Bean '" + beanName + "' created : " + bean.toString());
		if (bean instanceof Example) {
			System.out.println("--------Example after post processor");
		}
		return null;
	}
}
