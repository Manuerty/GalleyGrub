package edu.badpals.galleyGrub.receipt;

import edu.badpals.galleyGrub.order.Command;
import edu.badpals.galleyGrub.extras.Extra;
public interface Ticket {
    public Command getOrder();
    public void setChain(Extra extra);
    public Double total();
    public void sumExtrasCharge();
    public void print();

}
