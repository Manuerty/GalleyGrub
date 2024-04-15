package edu.badpals.galleyGrub.receipt;

import edu.badpals.galleyGrub.order.Command;
import edu.badpals.galleyGrub.extras.Extra;
import edu.badpals.galleyGrub.items.Item;
public class Receipt implements Ticket {
    private Double total;
    private Extra firstExtra;
    private Command order;

    public Receipt(Command order){
        this.order = order;
    }
    public Command getOrder(){
        return order;
    }

    public void setChain(Extra extra) {
        firstExtra.setNextExtra(extra);
    }

    public Extra getChain(){
        // TODO: Implement this function
        return null;
    }

    public Double total(){
        this.total = 0.0;
        for (Item item : order.itemList()  ){
            this.total += item.price();
        }
        return this.total;
    }

    public void sumExtrasCharge(){
        // TODO: Implement this function
        ;
    }

    public void print(){
        System.out.println("Receipt");
        System.out.println("-------");
        order.display();
        System.out.println("Total: " + total());
    }

}
