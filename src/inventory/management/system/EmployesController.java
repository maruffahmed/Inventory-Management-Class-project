/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.management.system;

import inventory.management.system.Database.DBConnect;
import inventory.management.system.Model.EmployeModel;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author maruf
 */
public class EmployesController implements Initializable {
    
    SceneRender ChangeMyScene = new SceneRender();
    
    //    Database connection
    static public DBConnect connect = new DBConnect();
    static public Connection conn = connect.getConnection();
    
    
    //    Employe list
    ObservableList<EmployeModel> employesModels = FXCollections.observableArrayList();
    
     @FXML
    private TableColumn<EmployeModel, String> employeTEmail;


    @FXML
    private TableColumn<EmployeModel, String> employeTName;

    @FXML
    private TableView<EmployeModel> employeTable;
    
//    input field
    @FXML
    private TextField employeEmail;

    @FXML
    private TextField employeName;

    @FXML
    private TextField employePassword;

    
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
    void employeAddAction(ActionEvent event) throws SQLException {
        String name = employeName.getText();
        String email = employeEmail.getText();
        String password = employePassword.getText();
        
//        Insert the product to database
        String sqlQuery = "Insert into employes(employeName,employeEmail,employePassword) values(?,?,?)";

        PreparedStatement statement = conn.prepareStatement(sqlQuery);
        statement.setString(1,name);
        statement.setString(2,email);
        statement.setString(3,password);
        statement.execute();
// Done the insertion
        EmployeModel newEmploye = new EmployeModel(name, email);
        employeTable.getItems().add(newEmploye);
//        Empty the field
        employeName.setText("");
        employeEmail.setText("");
        employePassword.setText("");
    }

    @FXML
    void employeRemoveAction(ActionEvent event) throws SQLException {
        ObservableList<EmployeModel> allEmploye, singleEmploye;
        allEmploye = employeTable.getItems();
        singleEmploye = employeTable.getSelectionModel().getSelectedItems();
//        Delete the product from database
        String sqlQuery = "DELETE FROM `employes` WHERE employeEmail = ?";

        PreparedStatement statement = conn.prepareStatement(sqlQuery);
        String employeEmail = singleEmploye.get(0).getEmail();
        statement.setString(1,employeEmail);
        statement.execute();
//        Done delete

        singleEmploye.forEach(allEmploye::remove);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
//        employeTId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        employeTName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        employeTEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        //add your data to the table here.
        employeTable.setItems(employesModels);
        
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
                employesModels.add(
                        new EmployeModel(employeSet.getString(2), employeSet.getString(3))
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(StoreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
