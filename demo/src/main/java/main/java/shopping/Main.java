package main.java.shopping;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

    public class Main
    {
        public static void main(String[] args) {

           String defaultPath = "db";
           String path = "";

           if (args != null && args.length > 0) {       // ??
               path = args[0];
               File file = new File(args[0]);

               if (!file.exists()) {        // if file don't exist, create new file directory name
                   file.mkdir();
               }
            }
               else {
                   path = defaultPath;
                   File file = new File(path);      //set file path "db"

                   if (!file.exists()){
                       file.mkdirs();
                   }
               }
    
               //create new instance
            shoppingCartDB handler = new shoppingCartDB();
            handler.setPath(path);
            
            System.out.println("Please use only the following commands: "); //initialization print out
            System.out.println(" login <username>");
            System.out.println("  add <item>");
            System.out.println("  delete <position of item>");
            System.out.println("  list");
            System.out.println("  save");
            System.out.println("  users");
            System.out.println("  exit");
            System.out.println("Welcome to your shopping cart");
    
            Scanner scan = new Scanner(System.in); //declare a scanner
            String command = scan.next(); // next() only read the input till the space, places the cursor in the same line after reading the input. takes first String named command. 
            String arguments = scan.nextLine(); // nextLine() reads input including white space between the words, once the input is read, curson is positioned in the next line. takes 2nd String named arguments
    
            if (!"add".equals(command) && !"delete".equals(command) && // check user input if "add", "list" or "delete" is keyed.
                    !"list".equals(command) && !"exit".equals(command)) {
                System.out.println("Invalid command, program will exit."); //close if invalid command is detected
                scan.close();
                return;
            }
    
            while (!"exit".equals(command)) {       //if command is not 'exit' run this while loop
                
                if ("login".equals(command)){
                    //handler.handleLogin(command, arguments, scan); //check login commands.
                    try {
                        handler.handleLogin(arguments);

                    } catch (IOException e){

                    }
                }

                if ("add".equals(command)) {        //if input is "add", call handleAdd method to add item from the argument input into cart
                    handler.handleAdd(command, arguments, scan);
                    System.out.println("-- Item(s) added --");
                }
    
                else if ("delete".equals(command)) {        //if input is "delete", call handleDelete method to delete item from the according to the argument input
                    handler.handleDelete(command, arguments, scan);
                    System.out.println("-- Item removed --");
                }
                
                else if ("list".equals(command)) {      //if input is "list", call handelList method to list all items in the cart ArrayList
                    handler.handleList(command);
                    System.out.println("-- End of list --");
                }

                else if ("save".equals(command)) {
                    handler.handleSave();       //call method that save username in an arraylist
                }

                else if ("users".equals(command)) {     //call method to list all users in the arraylist
                    handler.handleUsers();
                    System.out.println("---End of User---");
                }
    
                command = scan.next();  //continue asking for user input
                arguments = scan.nextLine();
  
            }
           
            scan.close(); //exit program
            System.out.println("Program has ended.");
            System.out.println("thank you.");
        }
    
}

