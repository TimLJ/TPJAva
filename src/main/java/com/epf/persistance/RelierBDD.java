package com.epf.persistance;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.epf")
public class RelierBDD  {

    @Bean
    public DataSource GetDataSource () {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setUsername("epf");
        dataSource.setPassword("mot_de_passe");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/pvz");
        return dataSource;
    }

    @Bean
    public JdbcTemplate GetJdbcTemplate (DataSource GetDataSource) {
        return new JdbcTemplate(GetDataSource);
    }

}
