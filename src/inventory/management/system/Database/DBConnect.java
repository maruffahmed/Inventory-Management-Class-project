/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.management.system.Database;
import inventory.management.system.StoreController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maruf
 */
public class DBConnect {
    public Connection connection;
    
    public  Connection getConnection(){
        String dbName="signal_icon";
        String userName="root";
        String password="";

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection= DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    
    public ResultSet SelectQuery(String query, Connection conn) throws SQLException{
        Statement statement = null;
        try {
            statement = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(StoreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet resultSet = null;
        resultSet = statement.executeQuery(query);
        return resultSet;
    }
    
    public void UpdateQuery(String query, String newValue, int productId, Connection conn) throws SQLException{
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1,newValue);
        statement.setInt(2,productId);
        statement.execute();
    }
    
    public void UpdateQuery(String query, int newValue, int productId, Connection conn) throws SQLException{
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1,newValue);
        statement.setInt(2,productId);
        statement.execute();
    }
}
