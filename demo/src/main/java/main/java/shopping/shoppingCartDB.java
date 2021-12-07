package main.java.shopping;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Set;



public class shoppingCartDB {
    
private File fileDB = Paths.of("db").toFile();
private File userDB;
private boolean login = false;


    
    
    public void Login(String username, ArrayList<String> cart, Set<String> set) {
      String dbFile = fileDB.getAbsolutePath() + "/" + username + ".db";
      this.userDB = userDB;
      this.validateAndCreateDB();
      this.loadUserCart(cart, set);
    }
       
    public void loadShoppingCart {

    }
    public void saveShoppingCart {

    } 
}   
