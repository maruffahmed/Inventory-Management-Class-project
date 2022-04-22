/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.management.system;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import inventory.management.system.Model.SupplierModel;

/**
 * FXML Controller class
 *
 * @author maruf
 */
public class Store_SupplierController implements Initializable {
    
    @FXML
    private TableView<SupplierModel> suppliersTable;
    
    @FXML
    private TableColumn<SupplierModel, String> supplierContact;

    @FXML
    private TableColumn<SupplierModel, String> supplierDesciption;

    @FXML
    private TableColumn<SupplierModel, String> supplierName;

    
//    Scene changer custom class
    SceneRender ChangeMyScene = new SceneRender();
    
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
    @FXML
    void gotoStock(MouseEvent event) throws IOException {
        ChangeMyScene.to("Store.fxml", "Store - Signal Icon", event);
    }
    @FXML
    void gotoSupplier(MouseEvent event) throws IOException {
        ChangeMyScene.to("Store_Supplier.fxml", "Store - Signal Icon", event);
    }
    @FXML
    void gotoBrands(MouseEvent event) throws IOException {
        ChangeMyScene.to("Store_Brands.fxml", "Store - Signal Icon", event);
    }
    @FXML
    void gotoCategory(MouseEvent event) throws IOException {
        ChangeMyScene.to("Store_Category.fxml", "Store - Signal Icon", event);
    }
    @FXML
    void gotoUnits(MouseEvent event) throws IOException {
        ChangeMyScene.to("Store_Units.fxml", "Store - Signal Icon", event);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        supplierName.setCellValueFactory(new PropertyValueFactory<>("SupplierName"));
        supplierContact.setCellValueFactory(new PropertyValueFactory<>("SupplierContact"));
        supplierDesciption.setCellValueFactory(new PropertyValueFactory<>("SupplierDescription"));
        //add your data to the table here.
        suppliersTable.setItems(suppliersModels);
    }    
    
    // add your data here from any source 
    ObservableList<SupplierModel> suppliersModels = FXCollections.observableArrayList(
            new SupplierModel(1,"Amos", "01789393745", "Chepchieng"),
            new SupplierModel(2,"Keep", "01789906096", "Too")
    );
    
}


