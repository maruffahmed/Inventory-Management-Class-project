/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author maruf
 */
public class HomeController implements Initializable {

    //    Database connection
    static public DBConnect connect = new DBConnect();
    static public Connection conn = connect.getConnection();
//    Custom class for scene change
    SceneRender ChangeMyScene = new SceneRender();
    
    private int totalProduct = 0;
    private int totalEmployes = 0;
    private int stockPrice = 0;
    private int totalSell = 0;
    
    @FXML
    private Label totalEmploye;

    @FXML
    private Label totalProductsStored;

    @FXML
    private Label totalSellPrice;

    @FXML
    private Label totalStockPrice;
    
    @FXML
    void gotoAbout(MouseEvent event) throws IOException {
        ChangeMyScene.to("About.fxml", "About - Signal Icon", event);
    }

    @FXML
    void gotoEmp(MouseEvent event) throws IOException {
        ChangeMyScene.to("Employes.fxml", "Employes - Signal Icon", event);
    }

    @FXML
    void gotoHome(MouseEvent event) throws IOException {
        ChangeMyScene.to("Home.fxml", "Home - Signal Icon", event);
    }

    @FXML
    void gotoSells(MouseEvent event) throws IOException {
        ChangeMyScene.to("Sells.fxml", "Sells - Signal Icon", event);
    }

    @FXML
    void gotoSettings(MouseEvent event) throws IOException {
        ChangeMyScene.to("Settings.fxml", "Settings - Signal Icon", event);
    }
    
    @FXML
    void gotoStore(MouseEvent event) throws IOException {
        ChangeMyScene.to("Store.fxml", "Store - Signal Icon", event);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //        Fetch all product from database
        String productQuery = "Select * From products";
        ResultSet productSet = null;
        try {
            productSet = connect.SelectQuery(productQuery,conn);
        } catch (SQLException ex) {
            Logger.getLogger(StoreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(productSet.next()){
                totalProduct++;
                stockPrice += Integer.parseInt(productSet.getString(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StoreController.class.getName()).log(Level.SEVERE, null, ex);
        }
//        Fetch all employe from database

        String employeQuery = "Select * From employes";
        ResultSet employeSet = null;
        try {
            employeSet = connect.SelectQuery(employeQuery,conn);
        } catch (SQLException ex) {
            Logger.getLogger(StoreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(employeSet.next()){
                totalEmployes++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StoreController.class.getName()).log(Level.SEVERE, null, ex);
        }

        totalProductsStored.setText(Integer.toString(totalProduct));
        totalEmploye.setText(Integer.toString(totalEmployes));
        totalStockPrice.setText(Integer.toString(stockPrice));
        totalSellPrice.setText(Integer.toString(totalSell));
    }    
    
}
