/**
 * Created by jona0 on 31-01-17.
 */
public class GroceryItemOrder {
    private Item item;
    private int quantity;

    public GroceryItemOrder(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
    public String toString(){
         return getSubTotal() + " kr.\t\t"  + getQuantity() + " \t\t" + item.getName();
    }
    public double getSubTotal(){
        return item.getPrice()*quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
