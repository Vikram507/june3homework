package com.restaurants;

import java.util.List;

import javax.sql.DataSource;

import com.restaurants.ItalianRestaurant;

public interface FrenchRestaurantDAO {
	
	 /** 
     * This is the method to be used to initialize
     * database resources ie. connection.
  */
  public void setDataSource(DataSource ds);
  
  /** 
     * This is the method to be used to create
     * a record in the Student table.
  */
  public void create(String name, String masterchef);
  
  /** 
     * This is the method to be used to list down
     * a record from the Student table corresponding
     * to a passed student id.
  */
  public FrenchRestaurant getRestaurant(Integer id);
  
  /** 
     * This is the method to be used to list down
     * all the records from the Student table.
  */
  public List<FrenchRestaurant> listFrenchRestaurants();
  
  /** 
     * This is the method to be used to delete
     * a record from the Student table corresponding
     * to a passed student id.
  */
  public void delete(Integer id);
  
  /** 
     * This is the method to be used to update
     * a record into the Student table.
  */
  public void update(Integer id, String masterchef);
  
}
