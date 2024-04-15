package edu.badpals.galleyGrub.order;

import edu.badpals.galleyGrub.items.Item;
import java.util.List;
import java.util.ArrayList;

public class Order implements Command{
    private Double total;
    private final List<Item> items = new ArrayList<>();
    public void addItem(String name, double price){
        items.add(new Item(name, price));
    }
    public void addItem(String name, double price, String extra){
        items.add(new Item(name, price, extra));
    }
    public int size(){
        return items.size();
    }
    public List<Item> itemList(){
        return items;
    }
    public Double getTotal(){
        return total;
    }
    public void updateTotal(Double price){
        total += price;
    }
    public void display(){
        for (Item item : items){
            itemDisplay(item);
        }
    }
    private void itemDisplay(Item item){
        System.out.println(item.toString());
    }
}
