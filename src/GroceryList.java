import java.util.ArrayList;

/**
 * Created by jona0 on 31-01-17.
 */
public class GroceryList {
    private ArrayList<GroceryItemOrder> items;

    public GroceryList() {
        this.items = new ArrayList<GroceryItemOrder>();
    }

    public void addItem (GroceryItemOrder item){
        this.items.add(item);

    }

    public void print(){
        System.out.println("Price:\t\t Quantity\t Name:");
        for(GroceryItemOrder g: items){
            System.out.println(g.getSubTotal() + " kr.\t\t"  + g.getQuantity() + " \t\t" + g.getItem().getName());
        }
        System.out.println("Your total is: " + getTotal() + " kr.");
    }

    public double getTotal(){
        double total = 0.0;
        for (GroceryItemOrder g: items){
            total += g.getSubTotal();
        }
        return total;
    }

    public ArrayList<GroceryItemOrder> getItems() {
        return items;
    }

    public void setItems(ArrayList<GroceryItemOrder> items) {
        this.items = items;
    }
}
