package com.restaurants;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;



public class ItalianMapper implements RowMapper<ItalianRestaurant>{

	 public ItalianRestaurant mapRow(ResultSet rs, int rowNum) throws SQLException {
	      ItalianRestaurant italianr = new ItalianRestaurant();
	      italianr.setId(rs.getInt("id"));
	      italianr.setName(rs.getString("name"));
	      italianr.setMasterchef(rs.getString("masterchef"));
	      
	      return italianr;
	   }
}
