package com.epf.Persistance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class DAO {
    @Autowired
    protected JdbcTemplate jdbcTemplate;
}
