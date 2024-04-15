package edu.badpals.galleyGrub.extras;

import java.util.Optional;
import edu.badpals.galleyGrub.order.Command;

public abstract class Extra{
    static final String CHEESE = "Cheese";
    static final String SAUCE = "Sauce";
    static final String LARGE = "Large";
    String extraProduct;
    Optional<Extra> nextExtra = Optional.ofNullable(null);
    public void setNextExtra(Extra extra) {
        nextExtra = Optional.of(extra);
    }
    public void sumExtras(Command command) {}
}
