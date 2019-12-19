package com.wdq.spring.demo.example;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author wudq
 * @date 2019/9/11
 * @Description: TODO
 */
@Component
public class DataSource implements InitializingBean {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource() {
		System.out.println("-----初始化JdbcTemplate");
		String url = "jdbc:mysql://192.168.8.112:3306/yun_shop?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		javax.sql.DataSource dataSource = new DriverManagerDataSource(url,"root","123456");
		((DriverManagerDataSource) dataSource).setDriverClassName("com.mysql.jdbc.Driver");
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return this.jdbcTemplate;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
	}
}
