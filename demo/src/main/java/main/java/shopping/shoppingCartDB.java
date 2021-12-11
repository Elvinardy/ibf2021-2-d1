package main.java.shopping;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.Buffer;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;




public class shoppingCartDB {
    
    private shoppingCart cart;
    private boolean login = false;      //check user account exists in database
    private String userName = "";
    private String path = "";

    public shoppingCartDB() {   //create a constructor
        cart = new shoppingCart();
    }

    public shoppingCart getCart() {     //method to return shoppingCart items
        return cart;
    }

    public void setUserName(String userName) {      //method that takes in username String
        this.userName = userName;
    }

    public void setPath (String path) {
        this.path = path;
    }

    public void handleAdd(String command, String arguments, Scanner scan) {     //method takes in user input command, and arguments which is the 2nd text
        String [] strArray = arguments.trim().split(",");       // trim the input for white spaces and split using a "," to separate the text input and put it into the String array declared.

        for (int i = 0; i < strArray.length; i++) {     //loop through the String array
                
            if (cart.getCart().contains(strArray[i].trim())) {      //check if a similar iteam is already in the string array
                System.out.println("You have " + 
                        strArray[i] + " in your cart");
                continue;       //continue the loop
            }

            cart.addItem(strArray[i].trim());   //add item from the user input into the String array
            System.out.println(strArray[i] + " added to the cart");
        }
    }

    public void handleDelete(String command, String arguments, Scanner scan) {      //takes in 2 user input (command & arguments) from the scanner
         
        while ("delete".equals(command)) {      //when input command is "delete"

            int position = -1;      //set a starting ppint value

            while (position == -1) {

                try {
                    position = Integer.parseInt(arguments.trim()); //converts the String arguments input nto an Integer.
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

    public void handleList(String command){     //check if user input "list" command from the scanner

        while ("list".equals(command)) {        //if command input is "list", run this line of code

            if (cart.numberOfItemsInCart() == 0) //if cart is empty, print out this
                System.out.println("Your cart is empty");
            
            for (int i = 0; i < cart.getCart().size(); i++)
                System.out.println("" + (i+1) + "." + cart.getCart().get(i)); //if cart has item, print out each item in the cart using a for loop

            break;
        }
    }
    public void handleLogin(String arguments) throws IOException{

        userName = arguments.trim();

        if(!"".equals(userName))      //if argument input is not empty, run the following
            login = true;       //login boolean = true
        else 
            return;
        
        String fileName = path + "/" + userName + ".db";
        File file = new File(fileName);

        if(!file.exists()) {        //if file does not exists, create new file in database
            file.createNewFile();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {      //writes into new File created
                writer.write(fileName);
                writer.newLine();       //create next line for user input
            }
        } else {    
            try (Reader reader = new FileReader(fileName)) {        //if file exists, read existing file
                BufferedReader br = new BufferedReader(reader);
                String line = "";
                
                while ((line = br.readLine()) != null) {        //while input is not empty and does not contain "db", continue writing into file.
                    if(line != null && line.contains(".db"))       //and does not contain "db", continue writing into file.
                continue;

                cart.addItem(line);     //write item input from user into the file
                }
            }
        }
        }
    public void handleSave() {

        if (login = false) {
        System.out.println("Please login before saving your cart!");        //if user does not login
        return;
        }
        
        String fileName = path + "/" + userName + ".db";        //file name directory

        
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {

            for (String s : cart.getCart()) {   //for each loop to run through the cart arraylist and write into file
                writer.write(s);
                writer.newLine();

            }
        
        }
        catch (IOException e) {
            System.err.println("Oops.. unable to write into file");
        }
        System.out.println("item saved into file");
    }

    public void handleUsers() {
        File file = Paths.get("db").toFile();   //call toFile() to get File object from path. create "db" file type

        for (File f : file.listFiles()) {       // For each loop to look through the file directory
            String[] fileNames = f.getName().split("/."); //get user name by separating the directory using split() to get individual username
            System.out.println(fileNames[0]);
        }

    }


}

