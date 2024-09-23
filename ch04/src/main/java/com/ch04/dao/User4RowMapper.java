package com.ch04.dao;


import com.ch04.dto.User4Dto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User4RowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        User4Dto dto = new User4Dto();
        dto.setUid(rs.getString(1));
        dto.setName(rs.getString(2));
        dto.setGender(rs.getString(3));
        dto.setAge(rs.getInt(4));
        dto.setHp(rs.getString(5));
        dto.setAddr(rs.getString(6));

        return dto;
    }
}
