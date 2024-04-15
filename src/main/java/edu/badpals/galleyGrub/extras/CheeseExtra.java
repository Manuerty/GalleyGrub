package edu.badpals.galleyGrub.extras;

import edu.badpals.galleyGrub.order.Command;
import edu.badpals.galleyGrub.items.Prices;
import java.util.Optional;

public class CheeseExtra extends Extra{
    public void sumExtras(Command order){
        Optional<Double> cheeseCharge = order.itemList().stream()
                                    .filter(item -> item.extra().equalsIgnoreCase(Extra.CHEESE))
                            .map(item -> Prices.getPrice(Extra.CHEESE))
                            .reduce(Double::sum);

        cheeseCharge.ifPresent(order::updateTotal);

        this.nextExtra.ifPresent(chain -> chain.sumExtras(order));
    }
}
