package com.wdq.spring.demo.service;

import com.wdq.spring.demo.example.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @author wudq
 * @date 2019/9/3
 * @Description: TODO
 */
@Component
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	private DataSource dataSource;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void getGoods() {
		System.out.println("get goods");
		String txName = TransactionSynchronizationManager.getCurrentTransactionName();
		System.out.println("--------事务名："+txName);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveGoods() {
		String txName = TransactionSynchronizationManager.getCurrentTransactionName();

//		JdbcTemplate jdbcTemplate = dataSource.getJdbcTemplate();
//		String sql = "INSERT INTO `yun_shop`.`shop`(`shopName`, `shopNo`, `level`) VALUES ('这就是事实', 'n22213', 10);";
//		jdbcTemplate.update(sql);
		System.out.println("--------事务名："+txName);
	}
}
