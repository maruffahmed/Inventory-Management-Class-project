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
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.IntegerStringConverter;

/**
 * FXML Controller class
 *
 * @author maruf
 */
public class StoreController implements Initializable {
    
//    Database connection
    static public DBConnect connect = new DBConnect();
    static public Connection conn = connect.getConnection();
    
//    Product list
    ObservableList<ProductModel> productsModels = FXCollections.observableArrayList();
    
//    custom class for scene change
    SceneRender ChangeMyScene = new SceneRender();
    
    @FXML
    private TextField ProductSellPrice;

    @FXML
    private TextField productBrand;

    @FXML
    private TextField productCat;

    @FXML
    private TextField productId;

    @FXML
    private TextField productName;

    @FXML
    private TextField productPursesPrice;

    @FXML
    private TextField productQuantity;
    
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
    private TableColumn<ProductModel, Integer> productTPursesP;

    @FXML
    private TableColumn<ProductModel, Integer> productTQuantity;

    @FXML
    private TableColumn<ProductModel, Integer> productTSellP;

    
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
    
    //    Store inner navigation
//    @FXML
//    void gotoStock(MouseEvent event) throws IOException {
//        ChangeMyScene.to("Store.fxml", "Store - Signal Icon", event);
//    } 
//    @FXML
//    void gotoSupplier(MouseEvent event) throws IOException {
//        ChangeMyScene.to("Store_Supplier.fxml", "Store - Signal Icon", event);
//    }
//    @FXML
//    void gotoBrands(MouseEvent event) throws IOException {
//        ChangeMyScene.to("Store_Brands.fxml", "Store - Signal Icon", event);
//    }
//    @FXML
//    void gotoCategory(MouseEvent event) throws IOException {
//        ChangeMyScene.to("Store_Category.fxml", "Store - Signal Icon", event);
//    }
//    @FXML
//    void gotoUnits(MouseEvent event) throws IOException {
//        ChangeMyScene.to("Store_Units.fxml", "Store - Signal Icon", event);
//    }
    
    @FXML
    void productAddAction(ActionEvent event) throws SQLException {
        Integer id = Integer.parseInt(productId.getText());
        String name = productName.getText();
        String category = productCat.getText();
        String brand = productBrand.getText();
        Integer quantity = Integer.parseInt(productQuantity.getText());
        Integer purses = Integer.parseInt(productPursesPrice.getText());
        Integer sell = Integer.parseInt(ProductSellPrice.getText());
        
//        Insert the product to database
        String sqlQuery = "Insert into products(productId,productName,productCategory,productBrand,productQuantity,productPursesPrice,productSellPrice) values(?,?,?,?,?,?,?)";

        PreparedStatement statement = conn.prepareStatement(sqlQuery);
        statement.setInt(1,id);
        statement.setString(2,name);
        statement.setString(3,category);
        statement.setString(4,brand);
        statement.setInt(5,quantity);
        statement.setInt(6,purses);
        statement.setInt(7,sell);
        statement.execute();
// Done the insertion
        ProductModel newProduct = new ProductModel(id, name, category, brand, quantity, purses, sell);
        productTable.getItems().add(newProduct);
//        Empty the field
        productId.setText("");
        productName.setText("");
        productCat.setText("");
        productBrand.setText("");
        productQuantity.setText("");
        productPursesPrice.setText("");
        ProductSellPrice.setText("");
    }

    @FXML
    void productRemoveAction(ActionEvent event) throws SQLException {
        ObservableList<ProductModel> allProduct, singleProduct;
        allProduct = productTable.getItems();
        singleProduct = productTable.getSelectionModel().getSelectedItems();
//        Delete the product from database
        String sqlQuery = "DELETE FROM `products` WHERE productId = ?";

        PreparedStatement statement = conn.prepareStatement(sqlQuery);
        int productId = singleProduct.get(0).getProductId();
        System.out.println(productId);
        statement.setInt(1,productId);
        statement.execute();
//        Done delete

        singleProduct.forEach(allProduct::remove);
    }
    
    @FXML
    void onIdEditChange(TableColumn.CellEditEvent<ProductModel, Integer> productStringCellEditEvent) throws SQLException {
        ProductModel product = productTable.getSelectionModel().getSelectedItem();
//        Update database
        String sqlQuery = "UPDATE `products` SET `productId`=? WHERE productId = ?";
        connect.UpdateQuery(sqlQuery, productStringCellEditEvent.getNewValue(), product.getProductId(), conn);
//        
        product.setProductId(productStringCellEditEvent.getNewValue());
    }
    @FXML
    void onNameEditChange(TableColumn.CellEditEvent<ProductModel, String> productStringCellEditEvent) throws SQLException {
        ProductModel product = productTable.getSelectionModel().getSelectedItem();
//        Update database
        String sqlQuery = "UPDATE `products` SET `productName`= ? WHERE productId = ?";
        connect.UpdateQuery(sqlQuery, productStringCellEditEvent.getNewValue(), product.getProductId(), conn);
//      
        product.setProductName(productStringCellEditEvent.getNewValue());
    }
    @FXML
    void onCatEditChange(TableColumn.CellEditEvent<ProductModel, String> productStringCellEditEvent) throws SQLException {
        ProductModel product = productTable.getSelectionModel().getSelectedItem();
//        Update database
        String sqlQuery = "UPDATE `products` SET `productCategory`= ? WHERE productId = ?";
        connect.UpdateQuery(sqlQuery, productStringCellEditEvent.getNewValue(), product.getProductId(), conn);
//    
        product.setProductCategory(productStringCellEditEvent.getNewValue());
    }
    
    @FXML
    void onBrandEditChange(TableColumn.CellEditEvent<ProductModel, String> productStringCellEditEvent) throws SQLException {
        ProductModel product = productTable.getSelectionModel().getSelectedItem();
//        Update database
        String sqlQuery = "UPDATE `products` SET `productBrand`= ? WHERE productId = ?";
        connect.UpdateQuery(sqlQuery, productStringCellEditEvent.getNewValue(), product.getProductId(), conn);

// 
        product.setProductBrand(productStringCellEditEvent.getNewValue());
    }
    
    @FXML
    void onQuntityEditChange(TableColumn.CellEditEvent<ProductModel, Integer> productStringCellEditEvent) throws SQLException {
        ProductModel product = productTable.getSelectionModel().getSelectedItem();
//        Update database
        String sqlQuery = "UPDATE `products` SET `productQuantity`= ? WHERE productId = ?";
        connect.UpdateQuery(sqlQuery, productStringCellEditEvent.getNewValue(), product.getProductId(), conn);

// 
        product.setProductQuantity(productStringCellEditEvent.getNewValue());
    }
    
    @FXML
    void onPursesPriceEditChange(TableColumn.CellEditEvent<ProductModel, Integer> productStringCellEditEvent) throws SQLException {
        ProductModel product = productTable.getSelectionModel().getSelectedItem();
//        Update database
        String sqlQuery = "UPDATE `products` SET `productPursesPrice`= ? WHERE productId = ?";
        connect.UpdateQuery(sqlQuery, productStringCellEditEvent.getNewValue(), product.getProductId(), conn);
// 
        product.setProductPursesPrice(productStringCellEditEvent.getNewValue());
    }
    
    @FXML
    void onSellPriceEditChange(TableColumn.CellEditEvent<ProductModel, Integer> productStringCellEditEvent) throws SQLException {
        ProductModel product = productTable.getSelectionModel().getSelectedItem();
//        Update database
        String sqlQuery = "UPDATE `products` SET `productSellPrice`= ? WHERE productId = ?";
        connect.UpdateQuery(sqlQuery, productStringCellEditEvent.getNewValue(), product.getProductId(), conn);
// 
        product.setProductSellPrice(productStringCellEditEvent.getNewValue());
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        productTId.setCellValueFactory(new PropertyValueFactory<>("ProductId"));
        productTName.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
        productTCat.setCellValueFactory(new PropertyValueFactory<>("ProductCategory"));
        productTBrand.setCellValueFactory(new PropertyValueFactory<>("ProductBrand"));
        productTQuantity.setCellValueFactory(new PropertyValueFactory<>("ProductQuantity"));
        productTPursesP.setCellValueFactory(new PropertyValueFactory<>("ProductPursesPrice"));
        productTSellP.setCellValueFactory(new PropertyValueFactory<>("ProductSellPrice"));
        //add your data to the table here.
        productTable.setItems(productsModels);
        
        productTable.setEditable(true);
        productTId.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        productTName.setCellFactory(TextFieldTableCell.forTableColumn());
        productTCat.setCellFactory(TextFieldTableCell.forTableColumn());
        productTBrand.setCellFactory(TextFieldTableCell.forTableColumn());
        productTQuantity.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        productTPursesP.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        productTSellP.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        
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
                try {
                    productsModels.add(
                            new ProductModel(
                                    Integer.parseInt(resultSet.getString(1)), 
                                    resultSet.getString(2), 
                                    resultSet.getString(3), 
                                    resultSet.getString(4), 
                                    Integer.parseInt(resultSet.getString(5)), 
                                    Integer.parseInt(resultSet.getString(6)), 
                                    Integer.parseInt(resultSet.getString(7))
                            )
                    );
                } catch (SQLException ex) {
                    Logger.getLogger(StoreController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(StoreController.class.getName()).log(Level.SEVERE, null, ex);
        }
//        End fatching product
        
    }    
    
}
