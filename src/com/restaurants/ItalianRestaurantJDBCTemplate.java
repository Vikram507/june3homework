package com.restaurants;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;


public class ItalianRestaurantJDBCTemplate implements ItalianRestaurantDAO{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	   
	public void setDataSource(DataSource ds) {
		 this.dataSource = ds;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   		
	}

	public void create(String name, String masterchef) {
		String SQL = "insert into italian (name, masterchef) values (?, ?)";
	      jdbcTemplateObject.update( SQL, name, masterchef);
	      System.out.println("Created Record Name = " + name + " Masterchef = " + masterchef);
	      return;
		
	}

	public ItalianRestaurant getRestaurant(Integer id) {
		 String SQL = "select * from italian where id = ?";
	     ItalianRestaurant italianrestuarant = jdbcTemplateObject.queryForObject(SQL, 
	     new Object[]{id}, new ItalianMapper());
	     return italianrestuarant;
	}

	
	public List<ItalianRestaurant> listItalianRestaurants() {
		 String SQL = "select * from italian";
	      List <ItalianRestaurant> students = jdbcTemplateObject.query(SQL, new ItalianMapper());
	      return students;
	}

	
	public void delete(Integer id) {
		String SQL = "delete from italian where id = ?";
	      jdbcTemplateObject.update(SQL, id);
	      System.out.println("Deleted Record with ID = " + id );
	      return;		
	}

	
	public void update(Integer id, String name) {
		String SQL = "update italian set name = ? where id = ?";
	      jdbcTemplateObject.update(SQL, name, id);
	      System.out.println("Updated Record with ID = " + id );
	      return;
	}

	

	
	
	
}
