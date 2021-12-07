package main.java.shopping;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class shoppingCart {
    
        private List<String> cart = new ArrayList<>(); //declare an ArrayList for the cart
    
        public String listCart() {
            return cart.toString(); //return cart item as a String, if not it would return a memory value
        }
    
        public int numberOfItemsInCart() { //returns the number of items in the cart Array
            return cart.size();
        }
    
        public void addItem(String item) { //adding items to the ArrayLists
            cart.add(item);
        }
    
        public boolean isItemInCart(String item) { //check if there is any item in the cart
            return cart.contains(item);
        }
    
        public String deleteItem(int i) { //delete item according to index of item
    
            if (i >= cart.size()) {
                return "Out Of Bounds"; // if  number index is more than the size of the items in the cart
            }
    
            if (!cart.isEmpty()) {
                cart.remove(i);
                return "Item Removed"; //if cart is not empty, delete item according to the input index
            }
    
            return "Your cart is empty"; // else cart is empty
        }
    
        public List<String> getCart() { //return list of the cart
            return cart;
        }
    }
    