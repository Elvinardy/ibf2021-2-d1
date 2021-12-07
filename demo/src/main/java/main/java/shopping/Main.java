package main.java.shopping;
import java.util.Scanner;

    public class Main
    {
        public static void main(String[] args) {
    
            commandHandle  handler = new commandHandle();
            
            System.out.println("Please use only the following commands: ");
            System.out.println("  add <item>");
            System.out.println("  delete <position of item>");
            System.out.println("  list");
            System.out.println("  exit");
            System.out.println("Welcome to your shopping cart");
    
            Scanner scan = new Scanner(System.in); //declare a scanner
            String command = scan.next(); // takes first String named command
            String arguments = scan.nextLine(); // takes 2nd String named arguments
    
            if (!"add".equals(command) && !"delete".equals(command) && // check user input if keywords like "add", "list" or "delete"
                    !"list".equals(command) && !"exit".equals(command)) {
                System.out.println("Invalid command, program will exit.");
                scan.close();
                return;
            }
    
            while (!"exit".equals(command)) {
    
                if ("add".equals(command)) {
                    handler.handleAdd(command, arguments, scan);
                    System.out.println("-- Item(s) added --");
                }
    
                else if ("delete".equals(command)) {
                    handler.handleDelete(command, arguments, scan);
                    System.out.println("-- Item removed --");
                }
                
                else if ("list".equals(command)) {
                    handler.handleList(command);
                    System.out.println("-- End of list --");
                }
    
                command = scan.next();
                arguments = scan.nextLine();
            }
           
            scan.close();
            System.out.println("Program has ended.");
        }
    
}

