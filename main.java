import java.util.Scanner;
import java.util.HashMap;

public class Main
{
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        HashMap<String, Float> inventory = new HashMap<String, Float>();
        HashMap<String, Integer> inventoryquantity = new HashMap<String, Integer>();
        
        boolean startup = true;
        while (startup) {
            System.out.println("Inventory Management System"); 
            System.out.println("1. Add Item"); 
            System.out.println("2. Set Quantity"); 
            System.out.println("3. Display Inventory"); 
            System.out.println("4. Exit"); 
            System.out.print("Enter your Choice: "); 
            int choice = input.nextInt();
            input.nextLine();
            
            if (choice==1) {
                System.out.print("Enter Item Name: "); 
                String itemname = input.nextLine();
                    
                System.out.print("Enter Item Price: ");
                float enterprice = input.nextFloat();
                
                System.out.print("Enter Item Quantity: ");
                int enterquantity = input.nextInt();
                
                if (inventory.containsKey(itemname)){
                    System.out.println("Sorry, this item already exists.");
                }
                else {
                    inventory.put(itemname, enterprice);
                    inventoryquantity.put(itemname, enterquantity);
                    System.out.print("Item Added.");
                }
            }
            else if (choice==2){
                System.out.print("Enter Item Name: ");
                String itemname = input.nextLine();
                if (!inventoryquantity.containsKey(itemname)){
                    System.out.println("Sorry, this item cannot be found.");
                }
                else {
                    System.out.print("Enter New Quantity: ");
                    int enterquantity = input.nextInt();
                    
                    if (enterquantity < 0){
                    System.out.println("Sorry, quantity cannot be set to the negatives.");
                    }
                    else {
                        inventoryquantity.put(itemname, enterquantity);
                        System.out.print("Quantity of " + itemname);
                        System.out.println(" is set to " + enterquantity);
                    }
                }
            }
            else if (choice==3){
                System.out.println("Inventory: ");
                System.out.println("Item:\tPrice:\tQuantity: ");
                System.out.println("--------------------------------------");
                for (String invname : inventory.keySet()){
                    System.out.print(invname + "\t");
                }
                System.out.println();
                for (Float price : inventory.values()){
                    System.out.print(price + "\t");
                }
                System.out.println();
                for (int quantity : inventoryquantity.values()){
                    System.out.print(quantity + "\t");
                }
                System.out.println();
            }
            else if (choice==4){
                System.out.println("Shutting down... Goodbye!");
                startup = false;
            }
            else {
                System.out.println("Invalid option. Please try again.");
            }
        }
    }
}