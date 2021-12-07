package main.java.shopping;

import java.util.ArrayList;
import java.util.List;


public class shoppingCart {
    
        private List<String> cart = new ArrayList<>(); //declare an ArrayList for the cart
    
        public String listCart() {
            return cart.toString(); //return cart arraylist as a String representation, if not it would return a memory value
        }
    
        public int numberOfItemsInCart() { //returns the number of items in the cart Array
            return cart.size();
        }
    
        public void addItem(String item) { //adding items to the ArrayLists index
            cart.add(item);
        }
    
        public boolean isItemInCart(String item) { //check if there is any item in the cart. return a boolean
            return cart.contains(item);
        }
    
        public String deleteItem(int i) { //delete item according to index inout
    
            if (i >= cart.size()) {
                return "Out Of Bounds"; // if number index is more than the size of the items in the cart
            }
    
            if (!cart.isEmpty()) {
                cart.remove(i);
                return "Item Removed"; //if cart is not empty, delete item according to the input index
            }
    
            return "Your cart is empty"; // else cart is empty
        }
    
        public List<String> getCart() { //return list of the cart. Getter for cart
            return cart;
        }
    }
    