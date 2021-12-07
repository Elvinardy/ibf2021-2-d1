package main.java.shopping;
import java.io.File;
import java.util.Scanner;

    public class Main
    {
        public static void main(String[] args) {

            if(null != args && args.length > 0) {// create directory args[0]
            }
            else {
                String dir = "db";
                File file = new File(dir);         
                       //create directory db
            }
    
            commandHandle  handler = new commandHandle();
            
            System.out.println("Please use only the following commands: "); //initialization print out
            System.out.println("  add <item>");
            System.out.println("  delete <position of item>");
            System.out.println("  list");
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
    
                command = scan.next();  //continue asking for user input
                arguments = scan.nextLine();
            }
           
            scan.close(); //exit program
            System.out.println("Program has ended.");
            System.out.println("thank you.");
        }
    
}

