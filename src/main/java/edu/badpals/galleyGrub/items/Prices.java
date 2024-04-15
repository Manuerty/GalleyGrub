package edu.badpals.galleyGrub.items;

import java.util.Locale;


import java.util.Map;

public class Prices{
    static Map<String,Double> prices;

    public static void initPrices(){
        prices = Map.of(
            "cheese", 0.25,
            "sauce", 0.50,
            "medium", 0.25,
            "large", 0.50
        );
    }

    public static Double getPrice(String item){
        if (!contains(item.toLowerCase(Locale.ROOT))) {
            return 0.0;
        }
        return prices.get(item.toLowerCase(Locale.ROOT));
    }

    public static boolean contains(String item){
        return prices.containsKey(item.toLowerCase(Locale.ROOT));
    }
    public static void display(){
        System.out.println(prices);
    }
}
