package edu.badpals.galleyGrub.items;


public class Item implements Product{

    String name;
    Double price;
    String extra = "";


    public Item (String name, double price){
        this.name = name;
        this.price = price;
    }
    public Item (String name, double price, String extra){
        this.name = name;
        this.price = price;
        this.extra = extra;
    }

    public String name(){
        return this.name;
    }

    public Double price(){
        return this.price;
    }

    public String extra(){
        return this.extra;
    }

    public Boolean isRegular(){
        return  this.extra.isBlank();
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Item item) {
            return this.name.equals(item.name);
        }
        return false;
    }
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
    @Override
    public String toString() {
        if (this.isRegular()) {
            return  name + " , " + price;
        }
        return  name + " w/" + extra() + " , " + price + " + " + Prices.getPrice(extra);
    }
}
