import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jonathan Hansen on 31-01-17.
 */
public class Main {
    static ArrayList<Item> allItems = new ArrayList<Item>();
    static GroceryList purchase = new GroceryList();

        public static void main(String[] args) throws Exception{
            Scanner console = new Scanner(System.in);
            read();
            boolean run = true;
            while(run){
            mainMenu(console);
            run = cart(console);
            }
            checkout();
            System.out.println("Thank you for visiting our store :)");
    }

        public static void mainMenu (Scanner console){
            System.out.println("What item do you want to add to cart?");
            for(Item i: allItems){
                System.out.println(i);
            }
            System.out.print("Put in the ID of the item you want to add to your cart:");
            int answer = console.nextInt();
            for(Item i: allItems){
                if(answer == i.getId()){
                    System.out.println("you have chosen " + i.getName() + ", it costs " + i.getPrice() + " per item. How many do you want?");
                    int quantity = console.nextInt();
                    GroceryItemOrder order = new GroceryItemOrder(i, quantity);
                    purchase.addItem(order);
                    System.out.println("You have chosen to add " + quantity + " " + i.getName() + " for a price of " + order.getSubTotal());
                }
            }
        }
        public static boolean cart (Scanner console){
            System.out.println("Your cart now contains:");
            purchase.print();
            System.out.println("Do you want to add more items to your cart? \n1. Yes\n2. No");
            int answer = console.nextInt();
            switch (answer){
                case 1:
                    return true;
                case 2:
                    return false;
                default:
                    System.out.println("False input.");
                    cart(console);
            }
                return false;
             }
        public static void read() throws Exception {
        Scanner fileScan = new Scanner(new File("groceryItemList.txt"));
        int id = 0;
        while(fileScan.hasNextLine()) {
            String line = fileScan.nextLine();
            Scanner lineScan = new Scanner(line);
            while (lineScan.hasNextLine()) {
                String name = line;
                double price = fileScan.nextDouble();
                Item i1 = new Item(id, name, price);
                id++;
                allItems.add(i1);
                break;
            }
        }
    }
        public static void checkout() throws Exception{
            PrintStream output = new PrintStream(new File("reciept.txt"));
            System.out.println("Your reciept:");
            purchase.print();
            output.println("Price:\t\t Quantity\t Name:");
            for(GroceryItemOrder g: purchase.getItems()){
                output.println(g.toString());
            }
            output.println();
            output.println("Your total: " + purchase.getTotal() + " kr.");
            System.out.println("Your reciept has been printet to a .txt file :)");

        }
}
