/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package inventory.management.system;

import inventory.management.system.Database.DBConnect;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author maruf
 */
public class LoginController implements Initializable {
    
    //    Database connection
    static public DBConnect connect = new DBConnect();
    static public Connection conn = connect.getConnection();

    @FXML
    private TextField emailAddress;
    @FXML
    private TextField password;
    @FXML
    private void UserLogin(MouseEvent event) throws IOException {
        String userName = this.emailAddress.getText();
        String pass = this.password.getText();
        
//         Fetch all employe from database

        String employeQuery = "Select * From employes";
        ResultSet employeSet = null;
        try {
            employeSet = connect.SelectQuery(employeQuery,conn);
        } catch (SQLException ex) {
            Logger.getLogger(StoreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(employeSet.next()){
                if(employeSet.getString(3).equalsIgnoreCase(userName) && employeSet.getString(4).equals(pass)){
                    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
                    Scene scene = new Scene(root);

                    stage.setScene(scene);
                    stage.setTitle("Home - Signal Icon");
                    stage.show();
                }
//                else{
//                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Login Failed", ButtonType.OK);
//                    alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
//                    alert.show();
//                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(StoreController.class.getName()).log(Level.SEVERE, null, ex);
        }

        

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
