/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package inventory.management.system;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class InventoryManagementSystem extends Application {
    
    
    @Override
    public void start(Stage stage) throws Exception {
        try {
            Image icon = new Image(getClass().getResourceAsStream("assets/icon.png"));
        
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle("Login - Signal Icon");
            stage.getIcons().add(icon);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
