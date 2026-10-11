package com.atguigu.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
@PropertySource("classpath:jdbc.properties")
public class Config {
    @Value("${jdbc.user}")
    private String user;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.driver}")
    private String driver;


    //配置连接池
    @Bean
    public DruidDataSource getDruidDataSource(){
        DruidDataSource dds = new DruidDataSource();
        dds.setUsername(user);
        dds.setPassword(password);
        dds.setUrl(url);
        dds.setDriverClassName(driver);
        return dds;
    }

    //配置jdbc
    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource ds){
        JdbcTemplate jt = new JdbcTemplate(ds);
        return jt;
    }

    //配置事务管理类
    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource ds){
        return new DataSourceTransactionManager(ds);
    }



}
