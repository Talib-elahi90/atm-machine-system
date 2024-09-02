package bms;

import java.sql.*;
import java.sql.DriverManager;

public class Connect {
//    1.Register the Driver
//    2.Create Connection
//    3.Create Statement
//    4.Execute Query
//    5.Close Connection
    Connection c;
    Statement s;
    public Connect(){
        try {
//          Connection String  
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Talib@@12345");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    
    
    }
    
    public static void main(String[] args) {
        
    }
}
