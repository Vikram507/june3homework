package com.restaurants;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;


public class FrenchJDBCTemplate implements FrenchRestaurantDAO{
	
	  private DataSource dataSource;
	  private JdbcTemplate jdbcTemplateObject;
	   
	  public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }

	@Override
	public void create(String name, String masterchef) {
		 String SQL = "insert into french (name, masterchef) values (?, ?)";
	      jdbcTemplateObject.update( SQL, name, masterchef);
	      System.out.println("Created Record Name = " + name + " Masterchef = " + masterchef);
	      return;		
	}

	@Override
	public FrenchRestaurant getRestaurant(Integer id) {
		 String SQL = "select * from french where id = ?";
	     FrenchRestaurant frenchr = jdbcTemplateObject.queryForObject(SQL, 
	         new Object[]{id}, new FrenchMapper());
	      
	      return frenchr;		
	}

	@Override
	public List<FrenchRestaurant> listFrenchRestaurants() {
		String SQL = "select * from french";
	      List <FrenchRestaurant> fr = jdbcTemplateObject.query(SQL, new FrenchMapper());
	      return fr;
	}

	@Override
	public void delete(Integer id) {
		String SQL = "delete from french where id = ?";
	      jdbcTemplateObject.update(SQL, id);
	      System.out.println("Deleted Record with ID = " + id );
	      return;		
	}

	@Override
	public void update(Integer id,String name) {
		String SQL = "update french set name = ? where id = ?";
	      jdbcTemplateObject.update(SQL, name, id);
	      System.out.println("Updated Record with ID = " + id );
	      return;
	}

	
	
}
