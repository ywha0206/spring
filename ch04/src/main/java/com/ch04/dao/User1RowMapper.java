package com.ch04.dao;

import com.ch04.dto.User1Dto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User1RowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        User1Dto dto = new User1Dto();
        dto.setUid(rs.getString(1));
        dto.setName(rs.getString(2));
        dto.setBirth(rs.getString(3));
        dto.setHp(rs.getString(4));
        dto.setAge(rs.getInt(5));

        return dto;
    }
}
