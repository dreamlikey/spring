package com.wdq.spring.demo.example;

import com.wdq.spring.demo.service.GoodsService;

import org.springframework.aop.framework.AopContext;
import org.springframework.aop.framework.ProxyConfig;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.annotation.PostConstruct;

/**
 * @author wudq
 * @date 2019/9/3
 */
@Component
public class Example implements InitializingBean{

	@Autowired
	private ConfigurableApplicationContext context;

	@Autowired
	private GoodsService goodsService;

	public void getGoods() {
		goodsService.getGoods();
	}

	@PostConstruct
	public void initExample() {
		System.out.println("生命周期回调 PostConstruct");
		Example example = context.getBean(Example.class);
		example.saveGoods();
	}
//
//	@Override
//	public void afterPropertiesSet() throws Exception {
//		Example example = context.getBean(Example.class);
//		example.saveGoods();
//	}

	@Transactional(rollbackFor = Exception.class)
	public void saveGoods() {
		String txName = TransactionSynchronizationManager.getCurrentTransactionName();
		System.out.println("--------事务名："+txName);
		goodsService.saveGoods();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("------生命周期回调 PostConstruct");
		ProxyConfig proxyConfig = context.getBean(ProxyConfig.class);
		proxyConfig.setExposeProxy(Boolean.TRUE);
		Example example = (Example) AopContext.currentProxy();
//		example.saveGoods();
	}
}
