package com.example.goodreads.model;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book>{
    
    @Override
    public Book mapRow(ResultSet rs, int num) throws SQLException{
        return new Book(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getInt("price"),
            rs.getString("type"),
            rs.getString("purchaseDate")
        );
    }
}