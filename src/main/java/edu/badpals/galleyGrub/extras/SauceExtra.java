package edu.badpals.galleyGrub.extras;

import edu.badpals.galleyGrub.order.Command;
import edu.badpals.galleyGrub.items.Prices;
import java.util.Optional;

public class SauceExtra extends Extra{
    public void sumExtras(Command order){
            Optional<Double> sauceCharge = order.itemList().stream()
                                        .filter(item -> item.extra().equalsIgnoreCase(Extra.SAUCE))
                                .map(item -> Prices.getPrice(Extra.SAUCE))
                                .reduce(Double::sum);

            sauceCharge.ifPresent(order::updateTotal);

            this.nextExtra.ifPresent(chain -> chain.sumExtras(order));
        }
}
