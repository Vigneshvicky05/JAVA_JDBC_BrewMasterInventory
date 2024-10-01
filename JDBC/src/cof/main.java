package cof;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			coffeeshop inventory = new coffeeshop();
			user currentUser = new user();
			details det=new details();
			int choice;

			while (true) {
			    boolean loggedIn = false;
			    boolean isAdmin = false;

			    while (!loggedIn) {
			        System.out.println("WELCOME TO THE COFFEE SHOP MANAGER");
			        System.out.println("ENTER THE LOGIN DETAILS");
			        System.out.println("ENTER THE USERNAME OR ADMINNAME:");
			        currentUser.setName(scanner.nextLine());
			        System.out.println("ENTER THE PASSWORD:");
			        currentUser.setPass(scanner.nextLine());

			        try {
			            if (currentUser.getName().equals("a") && currentUser.getPass().equals("a")) {
			                loggedIn = true;
			                isAdmin = true;
			                System.out.println("SUCCESSFULLY LOGGED IN AS ADMIN.");
			            } else if (currentUser.getName().equals("u") && currentUser.getPass().equals("u")) {
			                loggedIn = true;
			                System.out.println("SUCCESSFULLY LOGGED IN AS USER.");
			            } else {
			                throw new Invalidexception("Invalid login. Please try again");
			            }
			        } catch (Invalidexception e) {
			            System.out.println(e.getMessage());
			        }
			    }

			    if (isAdmin) {
			        do {
			            System.out.println("ADMIN OPTIONS:");
			            System.out.println("1. Add Coffee Shop");
			            System.out.println("2. Remove Coffee Shop");
			            System.out.println("3. Update Coffee Shop");
			            System.out.println("4. Search Coffee Shop");
			            System.out.println("5. Show All Coffee Shops");
			            System.out.println("6. Exit");
			            choice = scanner.nextInt();
			            scanner.nextLine();
			            switch (choice) {
			                case 1:
			                  //  inventory.add();
			                	
			                	System.out.println("enter id,name,location,rating,opentime,closetime:");
			                    det.setId(scanner.nextInt());
			                    scanner.nextLine();
			                    det.setName(scanner.next()+scanner.nextLine());
			                    det.setLocation(scanner.next()+scanner.nextLine());
			                    det.setRating(scanner.nextDouble());
			                    scanner.nextLine();
			                    det.setOpeningTime(scanner.nextInt());
			                    scanner.nextLine();
			                    det.setClosingTime(scanner.nextInt());
			                   // scanner.nextLine();
			                	 boolean addSts=inventory.add(det);
			                	 if(addSts) {
			                		 System.out.println("coffee details added");
			                	 }
			                	 else {
			                		 System.out.println("coffee details not added");
			                	 }
			                    break;
			                case 2:
			                    System.out.println("Enter the ID of the coffee shop to remove:");
			                    int id=scanner.nextInt();
			                    inventory.remove(id);
			                  //  inventory.remove(removeId);
			                    break;
			                case 3:
			                    System.out.println("Enter the ID of the coffee shop to update:");
			                    int id1 = scanner.nextInt();
			                   // scanner.nextLine();
			                    det.setId(id1);
			                    System.out.println("Enter the name to update:");
			                    String name =scanner.nextLine();
			                    det.setName(scanner.nextLine());
			                    System.out.println("Enter the location to update:");
			                    det.setLocation(scanner.nextLine());
			                    System.out.println("Enter the Rating to update:");
			                    //Double rating=scanner.next());
			                    det.setRating(scanner.nextDouble());
			                    System.out.println("Enter the openingtime to update:");
			                    det.setOpeningTime(scanner.nextInt());
			                    scanner.nextLine();
			                    System.out.println("Enter the closingtime to update:");
			                    det.setClosingTime(scanner.nextInt());
			                    inventory.update(det);
			                    break;
			                case 4:
			                    System.out.println("Enter the ID of the coffee shop to search:");
			                    String searchId = scanner.nextLine();
			                //    inventory.search(searchId);
			                    break;
			                case 5:
			                    inventory.show();
			                    break;
			                case 6:
			                    System.out.println("Logout");
			                    break;
			                default:
			                    System.out.println("Invalid choice. Please try again.");
			                    break;
			            }
			        } while (choice != 6);

			    } else {
			        do {
			            System.out.println("USER OPTIONS:");
			            System.out.println("1. Show All Coffee Shops");
			            System.out.println("2. Search Coffee Shop");
			            System.out.println("3. Exit");
			            choice = scanner.nextInt();
			            scanner.nextLine();

			            switch (choice) {
			                case 1:
			                    inventory.show();
			                    break;
			                case 2:
			                    System.out.println("Enter the ID of the coffee shop to search:");
			                    String searchId = scanner.nextLine();
			               //     inventory.search(searchId);
			                    break;
			                case 3:
			                    System.out.println("Logout");
			                    break;
			                default:
			                    System.out.println("Invalid choice. Please try again.");
			                    break;
			            }
			        } while (choice != 3);
			    }
			}
		}
    }
}
