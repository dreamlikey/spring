package com.wdq.spring.demo.example;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * @author wudq
 * @date 2019/9/3
 * @Description:
 */
@Component
public class SelfBeanNameAware implements BeanNameAware {
	@Override
	public void setBeanName(String name) {
		System.out.println("BeanNameAware");
	}
}
