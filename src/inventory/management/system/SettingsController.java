/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.management.system;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author maruf
 */
public class SettingsController implements Initializable {
    @FXML
    void gotoAbout(MouseEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("About.fxml"));
     
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("About - Signal Icon");
        stage.show();
    }

    @FXML
    void gotoEmp(MouseEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Employes.fxml"));
     
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Employes - Signal Icon");
        stage.show();
    }

    @FXML
    void gotoHome(MouseEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
     
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Home - Signal Icon");
        stage.show();
    }

    @FXML
    void gotoSells(MouseEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Sells.fxml"));
     
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Sells - Signal Icon");
        stage.show();
    }

    @FXML
    void gotoSettings(MouseEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Settings.fxml"));
     
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Settings - Signal Icon");
        stage.show();
    }
    
    @FXML
    void gotoStore(MouseEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Store.fxml"));
     
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Store - Signal Icon");
        stage.show();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
