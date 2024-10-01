package cof;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class coffeeshop {
    private List<details> coffeeShops;
    private Scanner scanner;
    private int idCounter = 1;
    int count=0;
    Statement stmt;
	ResultSet rs;
	String qry=null;
	Percoffee db=new Percoffee();
	Connection con;

   public coffeeshop() {
      coffeeShops = new ArrayList<>();
    scanner = new Scanner(System.in);
   }

    public boolean add(details det) {
    /*    System.out.println("ENTER THE NUMBER OF COFFEE SHOPS TO ADD:");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("ENTER THE DETAILS OF COFFEE SHOP " + (i + 1) + ":");
            details shop = new details();
            System.out.println("ENTER THE NAME OF THE COFFEE SHOP:");
            shop.setName(scanner.nextLine());
            System.out.println("ENTER THE LOCATION OF THE COFFEE SHOP:");
            shop.setLocation(scanner.nextLine());
            System.out.println("ENTER THE AVERAGE CUSTOMER RATING OF THE COFFEE SHOP (0-5):");
            shop.setRating(scanner.nextDouble());
            scanner.nextLine();
            System.out.println("ENTER THE OPENING TIME OF THE COFFEE SHOP (e.g., 08:00 AM):");
            shop.setOpeningTime(scanner.nextLine());
            System.out.println("ENTER THE CLOSING TIME OF THE COFFEE SHOP (e.g., 08:00 PM):");
            shop.setClosingTime(scanner.nextLine());
            shop.setId(generateId(shop));
            coffeeShops.add(shop);
        }
        System.out.println("Successfully added");
    }

    private String generateId(details shop) {
        return String.format(shop.getName() + " %02d", idCounter++);
    }*/
    	
    	boolean sts=false;
    	//int count=0;
    	try {
    		Connection con=db.getDBConnection();
    		stmt=con.createStatement();
    		qry="insert into coffee(id,name,location,rating,openingTime,closingTime)values('"+det.getId()+"','"+det.getName()+"','"+det.getLocation()+"','"+det.getRating()+"','"+det.getOpeningTime()+"','"+det.getClosingTime()+"')";
    				count=stmt.executeUpdate(qry);
    		if(count==1)
    			sts=true;
    		else
    			throw new Exception();
    	}
    	catch(Exception ex) {
    		System.out.println(ex.getMessage());
    		return sts;
    	}
		return sts;
    	
    	
    }

    public void show() {
      //  if (coffeeShops.isEmpty()) {
      //      System.out.println("No coffee shops in the inventory.");
     //       return;
      //  }
    	
    	try {

    		con=db.getDBConnection();

    		stmt=con.createStatement();

    		rs=stmt.executeQuery("select * from coffee");

    		while(rs.next())

    		{

    			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getInt(5)+" "+rs.getInt(6));

    			

    		}
    	}

    		catch(Exception ex)

    		{

    			System.out.println(ex.getMessage());

    			

    		}

        for (int i = 0; i < coffeeShops.size(); i++) {
            System.out.println("DETAILS OF COFFEE SHOP " + (i + 1) + ":");
            System.out.println(coffeeShops.get(i).toString());
        }
    }

   public void remove(int id) {
     //  coffeeShops.removeIf(shop -> shop.getId().equals(id));
       // System.out.println("Coffee shop with ID " + id + " removed.");
	   
	  
	  try {
			con=db.getDBConnection();
			stmt=con.createStatement();
			//int id = 0;
			qry="delete from coffee where id="+id+"";
			count=stmt.executeUpdate(qry);
		}
		catch(Exception e) {
			   System.out.println(e);
		   }
	   
	   
    }

    public void update(details det) 
    {/*
        for (details shop : coffeeShops) {
            if (shop.getId().equals(id)) {
                System.out.println("Updating details for coffee shop with ID: " + id);
                System.out.println("ENTER THE NEW NAME OF THE COFFEE SHOP:");
                shop.setName(scanner.nextLine());
                System.out.println("ENTER THE NEW LOCATION OF THE COFFEE SHOP:");
                shop.setLocation(scanner.nextLine());
                System.out.println("ENTER THE NEW AVERAGE CUSTOMER RATING OF THE COFFEE SHOP (0-5):");
                shop.setRating(scanner.nextDouble());
                scanner.nextLine();
                System.out.println("ENTER THE NEW OPENING TIME OF THE COFFEE SHOP (e.g., 08:00 AM):");
                shop.setOpeningTime(scanner.nextLine());
                System.out.println("ENTER THE NEW CLOSING TIME OF THE COFFEE SHOP (e.g., 08:00 PM):");
                shop.setClosingTime(scanner.nextLine());
                return;
            }
        }
        System.out.println("Coffee shop with ID " + id + " not found.");
    }*/
    	//int count=0;
		try {
			con=db.getDBConnection();
			stmt=con.createStatement();
			count=stmt.executeUpdate("update coffee set name='"+det.getName()+"',location='"+det.getLocation()+"',rating="+det.getRating()+",openingTime="+det.getOpeningTime()+",closingTime="+det.getClosingTime()+" where id="+det.getId()+"");
			//count=stmt.executeUpdate("update coffee set name=('"+det.getName()+"')  where id="+det.getId()+"");
		}catch(Exception e) {
			   System.out.println(e.getMessage());
		   }	
    
    
    
    }

 //   public void search(int id) {
    //    for (details shop : coffeeShops) {
  //          if (shop.getId().equals(id)) {
      //          System.out.println("Details of coffee shop with ID " + id + ":");
        //        System.out.println(shop.toString());
  //              return;
    //        }
        //}
        //System.out.println("Coffee shop with ID " + id + " not found.");
   // }
}

