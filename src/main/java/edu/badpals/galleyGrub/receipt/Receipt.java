package edu.badpals.galleyGrub.receipt;

import edu.badpals.galleyGrub.order.Command;
import edu.badpals.galleyGrub.extras.Extra;
import edu.badpals.galleyGrub.items.Item;

public class Receipt implements Ticket {
    private Double total = 0.0;
    private Extra firstExtra = null;
    private Command order;

    public Receipt(Command order){
        this.order = order;
    }
    public Command getOrder(){
        return order;
    }
    public void setChain(Extra extra) {
        firstExtra = extra;
    }
    public Extra getChain(){
        return firstExtra;
    }
    public Double total(){
        if (this.total == 0d) {
            sumExtrasCharge();
            this.total = order.getTotal();
        }
        return this.total;
    }
    public void sumExtrasCharge(){
        if (firstExtra != null) {
            firstExtra.sumExtras(getOrder());
        }
    }
    public void print(){
        System.out.println("Receipt");
        System.out.println("-------");
        order.display();
        System.out.println("Total: " + total());
    }
}
