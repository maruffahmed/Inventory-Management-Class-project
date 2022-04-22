/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.management.system;

import inventory.management.system.Database.DBConnect;
import inventory.management.system.Model.ProductModel;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author maruf
 */
public class SellsController implements Initializable {
    
    SceneRender ChangeMyScene = new SceneRender();
    
    //    Database connection
    static public DBConnect connect = new DBConnect();
    static public Connection conn = connect.getConnection();
    
        //    Product list
    ObservableList<ProductModel> productsModels = FXCollections.observableArrayList();
    
    @FXML
    private TableView<ProductModel> productTable;
    
    @FXML
    private TableColumn<ProductModel, String> productTBrand;

    @FXML
    private TableColumn<ProductModel, String> productTCat;

    @FXML
    private TableColumn<ProductModel, Integer> productTId;

    @FXML
    private TableColumn<ProductModel, String> productTName;

    @FXML
    private TableColumn<ProductModel, Integer> productTQuantity;

    @FXML
    private TableColumn<ProductModel, Integer> productTSellP;
    
    @FXML
    private TextField productQuantity;
    
//    Selector
    @FXML
    private ChoiceBox<String> productIdDropDown;
    
    private ArrayList<String> productsIds = new ArrayList<String>();
    
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
    
    @FXML
    void productAddAction(ActionEvent event) throws SQLException {
        Integer id = Integer.parseInt(productIdDropDown.getSelectionModel().getSelectedItem());
        Integer quantity = Integer.parseInt(productQuantity.getText());
        
//        Insert the product to database
        String sqlQuery = "Insert into sells(productId,sellQuantity) values(?,?)";

        PreparedStatement statement = conn.prepareStatement(sqlQuery);
        statement.setInt(1,id);
        statement.setInt(2,quantity);
        statement.execute();
// Done the insertion
    
//        Fetch all product from database
//        sqlQuery = "SELECT * FROM `products` WHERE productId = ?";
//        statement = conn.prepareStatement(sqlQuery);
//        statement.setInt(1,id);
//        ResultSet resultSet = statement.executeQuery(sqlQuery);
        
//        End fatching product
//    System.out.println(resultSet.getString(2));
//        ProductModel newProduct = new ProductModel(id, name, category, brand, quantity, purses, sell);
//        productTable.getItems().add(newProduct);
//        Empty the field
//        productIdDropDown.setSelectionModel("");
//        productQuantity.setText("");
    }

    @FXML
    void productRemoveAction(ActionEvent event) throws SQLException {
//        ObservableList<ProductModel> allProduct, singleProduct;
//        allProduct = productTable.getItems();
//        singleProduct = productTable.getSelectionModel().getSelectedItems();
////        Delete the product from database
//        String sqlQuery = "DELETE FROM `products` WHERE productId = ?";
//
//        PreparedStatement statement = conn.prepareStatement(sqlQuery);
//        int productId = singleProduct.get(0).getProductId();
//        statement.setInt(1,productId);
//        statement.execute();
////        Done delete
//
//        singleProduct.forEach(allProduct::remove);
    }
    
    @FXML
    void onIdEditChange(TableColumn.CellEditEvent<ProductModel, Integer> productStringCellEditEvent) throws SQLException {
//        ProductModel product = productTable.getSelectionModel().getSelectedItem();
////        Update database
//        String sqlQuery = "UPDATE `products` SET `productId`=? WHERE productId = ?";
//        connect.UpdateQuery(sqlQuery, productStringCellEditEvent.getNewValue(), product.getProductId(), conn);
////        
//        product.setProductId(productStringCellEditEvent.getNewValue());
    }
    @FXML
    void onNameEditChange(TableColumn.CellEditEvent<ProductModel, String> productStringCellEditEvent) throws SQLException {
//        ProductModel product = productTable.getSelectionModel().getSelectedItem();
////        Update database
//        String sqlQuery = "UPDATE `products` SET `productName`= ? WHERE productId = ?";
//        connect.UpdateQuery(sqlQuery, productStringCellEditEvent.getNewValue(), product.getProductId(), conn);
////      
//        product.setProductName(productStringCellEditEvent.getNewValue());
    }
    @FXML
    void onCatEditChange(TableColumn.CellEditEvent<ProductModel, String> productStringCellEditEvent) throws SQLException {
//        ProductModel product = productTable.getSelectionModel().getSelectedItem();
////        Update database
//        String sqlQuery = "UPDATE `products` SET `productCategory`= ? WHERE productId = ?";
//        connect.UpdateQuery(sqlQuery, productStringCellEditEvent.getNewValue(), product.getProductId(), conn);
////    
//        product.setProductCategory(productStringCellEditEvent.getNewValue());
    }
    
    @FXML
    void onBrandEditChange(TableColumn.CellEditEvent<ProductModel, String> productStringCellEditEvent) throws SQLException {
//        ProductModel product = productTable.getSelectionModel().getSelectedItem();
////        Update database
//        String sqlQuery = "UPDATE `products` SET `productBrand`= ? WHERE productId = ?";
//        connect.UpdateQuery(sqlQuery, productStringCellEditEvent.getNewValue(), product.getProductId(), conn);
//
//// 
//        product.setProductBrand(productStringCellEditEvent.getNewValue());
    }
    
    @FXML
    void onQuntityEditChange(TableColumn.CellEditEvent<ProductModel, Integer> productStringCellEditEvent) throws SQLException {
//        ProductModel product = productTable.getSelectionModel().getSelectedItem();
////        Update database
//        String sqlQuery = "UPDATE `products` SET `productQuantity`= ? WHERE productId = ?";
//        connect.UpdateQuery(sqlQuery, productStringCellEditEvent.getNewValue(), product.getProductId(), conn);
//
//// 
//        product.setProductQuantity(productStringCellEditEvent.getNewValue());
    }
    
    @FXML
    void onPursesPriceEditChange(TableColumn.CellEditEvent<ProductModel, Integer> productStringCellEditEvent) throws SQLException {
//        ProductModel product = productTable.getSelectionModel().getSelectedItem();
////        Update database
//        String sqlQuery = "UPDATE `products` SET `productPursesPrice`= ? WHERE productId = ?";
//        connect.UpdateQuery(sqlQuery, productStringCellEditEvent.getNewValue(), product.getProductId(), conn);
//// 
//        product.setProductPursesPrice(productStringCellEditEvent.getNewValue());
    }
    
    @FXML
    void onSellPriceEditChange(TableColumn.CellEditEvent<ProductModel, Integer> productStringCellEditEvent) throws SQLException {
//        ProductModel product = productTable.getSelectionModel().getSelectedItem();
////        Update database
//        String sqlQuery = "UPDATE `products` SET `productSellPrice`= ? WHERE productId = ?";
//        connect.UpdateQuery(sqlQuery, productStringCellEditEvent.getNewValue(), product.getProductId(), conn);
//// 
//        product.setProductSellPrice(productStringCellEditEvent.getNewValue());
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //        Fetch all product from database
        String sql = "Select * From products";
        ResultSet resultSet = null;
        try {
            resultSet = connect.SelectQuery(sql,conn);
        } catch (SQLException ex) {
            Logger.getLogger(StoreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(resultSet.next()){
                    productsIds.add(resultSet.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StoreController.class.getName()).log(Level.SEVERE, null, ex);
        }
//        End fatching product
        productIdDropDown.getItems().addAll(productsIds);
        
    }    
    
}
