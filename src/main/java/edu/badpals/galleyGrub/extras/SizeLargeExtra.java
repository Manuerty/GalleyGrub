package edu.badpals.galleyGrub.extras;

import edu.badpals.galleyGrub.order.Command;
import edu.badpals.galleyGrub.items.Prices;
import java.util.Optional;

public class SizeLargeExtra extends Extra{
    public void sumExtras(Command order){
        Optional<Double> largeCharge = order.itemList().stream()
                                    .filter(item -> item.extra().equalsIgnoreCase(Extra.LARGE))
                            .map(item -> Prices.getPrice(Extra.LARGE))
                            .reduce(Double::sum);

        largeCharge.ifPresent(order::updateTotal);

        this.nextExtra.ifPresent(chain -> chain.sumExtras(order));
    }
}
