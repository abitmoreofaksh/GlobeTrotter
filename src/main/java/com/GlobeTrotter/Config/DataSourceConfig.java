package com.GlobeTrotter.Config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();

        // Set your DB connection details
        config.setJdbcUrl("jdbc:mysql://srv1716.hstgr.io/u683122922_gt");
        config.setUsername("u683122922_shiv");
        config.setPassword("m8|2y&mWXtO");

        // Settings
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(20000); // 20 sec
        config.setMaxLifetime(31000); // 25 sec, less than wait_timeout
        config.setKeepaliveTime(31000); // ping idle conns every 20 sec
        config.setConnectionTimeout(10000); // wait max 10 sec to get a connection

        return new HikariDataSource(config);
    }
}
