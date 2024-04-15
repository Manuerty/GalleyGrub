package edu.badpals.galleyGrub.extras;

import edu.badpals.galleyGrub.order.Command;
import edu.badpals.galleyGrub.items.Item;
import java.util.Optional;

public class Regular extends Extra{
    public void sumExtras(Command order){
        Optional<Double> sumRegularPrices = order.itemList().stream()
                                    .map(Item::price)
                                    .reduce(Double::sum);
       sumRegularPrices.ifPresent(order::updateTotal);

       this.nextExtra.ifPresent(chain -> chain.sumExtras(order));
    }
}
