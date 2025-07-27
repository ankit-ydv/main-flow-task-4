package homepage;

 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // --- IMPORTANT: REPLACE WITH YOUR DETAILS ---
    private static final String URL = "jdbc:mysql://localhost:3306/mainflow_db";
    private static final String USER = "root";
    private static final String PASSWORD = "H7@7r8p2";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish the connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            
            System.out.println("Connected to MySQL database successfully!");
            
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
            // You can print the stack trace for more details on the error
        }
        return connection;
    }

    // This main method lets you test the connection directly
    public static void main(String[] args) {
        // Attempt to get a connection
        Connection conn = getConnection();
        
        // Close the connection if it was successful
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
            }
        }
    }
}