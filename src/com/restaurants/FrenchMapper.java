package com.restaurants;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.restaurants.*;

public class FrenchMapper implements RowMapper<FrenchRestaurant>{
	 public FrenchRestaurant mapRow(ResultSet rs, int rowNum) throws SQLException {
	      FrenchRestaurant fr = new FrenchRestaurant();
	      fr.setId(rs.getInt("id"));
	      fr.setName(rs.getString("name"));
	      fr.setMasterchef(rs.getString("masterchef"));
	      
	      return fr;
	   }
	
}
