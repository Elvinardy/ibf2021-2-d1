package main.java.shopping;

import java.beans.Transient;
import java.util.Scanner;

public class commandHandle {
    private shoppingCart cart;

    public commandHandle() {
        cart = new shoppingCart();
    }

    public shoppingCart getCart() {
        return cart;
    }

    public void handleAdd(String command, String arguments, Scanner scan) {
        
        while ("add".equals(command)) {
            String [] strArray = arguments.trim().split(","); 
 
            while ("".equals(arguments.trim())) {  //if input is empty, print out this msg and ask for user input again
                System.out.println("Please add an item " +
                        "or items separted with a comma");
                command = scan.next(); // ask for user input again
                arguments = scan.nextLine();
                arguments.trim().split(",");
            }

            strArray = arguments.trim().split(","); //declaring to put the arguments into the String array

            for (int i = 0; i < strArray.length; i++) { 
                
                if (cart.getCart().contains(strArray[i].trim())) { //if there is the same object in the cart
                    System.out.println("You have " + 
                            strArray[i] + " in your cart");
                    continue;
                }

                cart.addItem(strArray[i].trim()); //adding new input item in the cart
                System.out.println(strArray[i] + " added to the cart");
            }

            break;
        }
    }

    /* public void handleAdd2(String command, String arguments, Scanner scan) {
        String [] strArray = arguments.trim().split(",");

        for (int i = 0; i < strArray.length; i++) {
                
            if (cart.getCart().contains(strArray[i].trim())) {
                System.out.println("You have " + 
                        strArray[i] + " in your cart");
                continue;
            }

            cart.addItem(strArray[i].trim());
            System.out.println(strArray[i] + " added to the cart");
        }
    } */

    public void handleDelete(String command, String arguments, Scanner scan) {
         
        while ("delete".equals(command)) {

            int position = -1;

            while (position == -1) {

                try {
                    position = Integer.parseInt(arguments.trim()); //change the String arguments input nto an Integer.
                } catch (NumberFormatException nfe) {
                    System.out.println("Please provide a number"); //if input is not a number String
                }

                if (!(position < 0) && position < cart.numberOfItemsInCart()) { //delete item index item according to input in position index
                    String item = cart.deleteItem(position);
                    System.out.println(item + " removed from cart");
                    break;
                }

                System.out.println("Incorrect item index"); //error message
                position = -1;
                command = scan.next();
                arguments = scan.nextLine();
            }

            break;
        }
    }

    public void handleList(String command){

        while ("list".equals(command)) {

            if (cart.numberOfItemsInCart() == 0) //if cart is empty, print out this
                System.out.println("Your cart is empty");
            
            for (int i = 0; i < cart.getCart().size(); i++)
                System.out.println("" + (i+1) + "." + cart.getCart().get(i)); //if cart has item, print out each item in the cart using a for loop_

            break;
        }
    }
}
