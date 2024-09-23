package com.ch04.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {

    @Bean
    public DataSource DataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/studydb");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");

        dataSource.setMaxTotal(13);//최대 연결 커넥션 갯수
        dataSource.setMaxIdle(13);//최대 유효 커넥션 갯수

        return dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
