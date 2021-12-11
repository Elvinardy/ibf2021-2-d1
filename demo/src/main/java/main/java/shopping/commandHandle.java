package main.java.shopping;
import java.util.Scanner;

public class commandHandle {
    private shoppingCart cart;

    public commandHandle() {
        cart = new shoppingCart(); //declare shopping cart object
    }

    public shoppingCart getCart() { //get cart Arraylist
        return cart;
    }

    /*public void handleAdd(String command, String arguments, Scanner scan) { //takes in 2 String input (command & arguments) from the Scanner function
        
        while ("add".equals(command)) {     //check if the first word input is "add"
            String [] strArray = arguments.trim().split(",");       //declare a string array that takes in arguments that is trim() for white spaces and split(",") which splits argument Strings when a "," is detected.
 
            while ("".equals(arguments.trim())) {  //if input is empty, print out this msg and ask for user input again
                System.out.println("Please add an item " +
                        "or items separted with a comma");
                command = scan.next(); // ask for user input again
                arguments = scan.nextLine(); //
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
    }*/

     public void handleAdd(String command, String arguments, Scanner scan) {
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
    }

    public void handleDelete(String command, String arguments, Scanner scan) {
         
        while ("delete".equals(command)) {      //when input command is "delete"

            int position = -1;

            while (position == -1) {

                try {
                    position = Integer.parseInt(arguments.trim()); //change the String arguments input nto an Integer.
                } catch (NumberFormatException nfe) {
                    System.out.println("Please provide a number"); //if input is not a number String
                }

                if (!(position < 0) && position < cart.numberOfItemsInCart()) { //check if command input is within the cart arraylist index i.e not -1 or more than the items in the cart
                    String item = cart.deleteItem(position-1);    //delete item from position from arguments input
                    System.out.println(item + " removed from cart");
                    break;
                }

                System.out.println("Incorrect item index"); //error message when index is less or above the item list index in the arraylist
                position = -1;
                command = scan.next();      //ask for user input again
                arguments = scan.nextLine();
            }

            break;
        }
    }

    public void handleList(String command){

        while ("list".equals(command)) {        //if command input is "list", run this line of code

            if (cart.numberOfItemsInCart() == 0) //if cart is empty, print out this
                System.out.println("Your cart is empty");
            
            for (int i = 0; i < cart.getCart().size(); i++)
                System.out.println("" + (i+1) + "." + cart.getCart().get(i)); //if cart has item, print out each item in the cart using a for loop_

            break;
        }
    }
    /*public void handleLogin(String arguments) {
        userName = arguments.trim();
        File file =new File("db/" + userName + ".db");
    }*/

    public void handleLogin(String arguments) {
    }

    
}
