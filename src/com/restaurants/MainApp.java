package com.restaurants;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.restaurants.ItalianRestaurantJDBCTemplate;

public class MainApp {
   public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

      ItalianRestaurantJDBCTemplate italianJDBCTemplate = 
         (ItalianRestaurantJDBCTemplate)context.getBean("ItalianRestaurantJDBCTemplate");
      
      System.out.println("------Italian Records Creation--------" );
      italianJDBCTemplate.create("Italian1 Restaurant", "Jagan");
      italianJDBCTemplate.create("Italian paradise", "KCR");
      

      System.out.println("------Italian  Listing Multiple Records--------" );
      List<ItalianRestaurant> restaurantslist = italianJDBCTemplate.listItalianRestaurants();
      
      for (ItalianRestaurant record : restaurantslist) {
         System.out.print("ID : " + record.getId() );
         System.out.print(", Name : " + record.getName() );
         System.out.println(", Masterchef : " + record.getMasterchef());
      }

      System.out.println("----Italian Updating Record with ID = 2 -----" );
      italianJDBCTemplate.update(2,"La Pinos");

      System.out.println("----Italian Listing Record with ID = 2 -----" );
      ItalianRestaurant italianr = italianJDBCTemplate.getRestaurant(2);
      System.out.print("ID : " + italianr.getId() );
      System.out.print(", Name : " + italianr.getName() );
      System.out.println(", Masterchef : " + italianr.getMasterchef());
      
      
      System.out.println("----Italian Deleting the Record with iD = 2 -----" );
      italianJDBCTemplate.delete(2);
      
      System.out.println("------Italian Listing Multiple Records after deleting--------" );
      List<ItalianRestaurant> itrs1 = italianJDBCTemplate.listItalianRestaurants();
      
      for (ItalianRestaurant record : itrs1) {
         System.out.print("ID : " + record.getId() );
         System.out.print(", Name : " + record.getName() );
         System.out.println(", Masterchef : " + record.getMasterchef());
      }
      
      
      FrenchJDBCTemplate frenchJDBCTemplate = 
    	         (FrenchJDBCTemplate)context.getBean("frenchJDBCTemplate");
    	      
    	      System.out.println("------French Records Creation--------" );
    	      frenchJDBCTemplate.create("French1 restaurant", "chennai super kings");
    	      frenchJDBCTemplate.create("French2 restaurant", "Mumbai Indians");
    	      frenchJDBCTemplate.create("French3 restaurant", "Kings 11 punjab");
    	      
    	      System.out.println("------French Listing Multiple Records--------" );
    	      List<FrenchRestaurant> frenchrestaurants = frenchJDBCTemplate.listFrenchRestaurants();
    	      
    	      for (FrenchRestaurant record : frenchrestaurants) {
    	          System.out.print("ID : " + record.getId() );
    	          System.out.print(", Name : " + record.getName() );
    	          System.out.println(", Masterchef : " + record.getMasterchef());
    	       }
    	      
    	      System.out.println("----French Updating Record with ID = 2 -----" );
    	      frenchJDBCTemplate.update(3, "Ratatouille");
    	      
    	      System.out.println("----French Listing Record with ID = 3 -----" );
    	      FrenchRestaurant frenchrestuarant = frenchJDBCTemplate.getRestaurant(3);
    	      System.out.print("ID : " + frenchrestuarant.getId() );
    	      System.out.print(", Name : " + frenchrestuarant.getName() );
    	      System.out.println(", Masterchef : " + frenchrestuarant.getMasterchef());
    	      
    	      System.out.println("----French Deleting the Record with iD = 3 -----" );
    	      frenchJDBCTemplate.delete(3);
    	      
    	      System.out.println("------French Listing Multiple Records after deleting--------" );
    	      List<FrenchRestaurant> frs1 = frenchJDBCTemplate.listFrenchRestaurants();
    	      
    	      for (FrenchRestaurant record : frs1) {
    	         System.out.print("ID : " + record.getId() );
    	         System.out.print(", Name : " + record.getName() );
    	         System.out.println(", Masterchef : " + record.getMasterchef());
    	      }
   }
}