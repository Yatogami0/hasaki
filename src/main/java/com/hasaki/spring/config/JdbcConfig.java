package com.hasaki.spring.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class JdbcConfig {
	private String url="jdbc:postgresql://192.168.1.94:5432/qyuanxiangdb?useUnicode\\=true&characterEncoding\\=UTF-8\r\n";
    private String driver="org.postgresql.Driver";
    private String username="qyuanxiang";
    private String password="qyuanxiang";


    @Bean(name = "datasouce")
    public DataSource dataSource(){
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
