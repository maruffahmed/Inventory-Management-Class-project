/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.management.system.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author maruf
 */
public class EmployeModel {
    private SimpleStringProperty name;
    private SimpleStringProperty email;
    private SimpleStringProperty password;
    public EmployeModel( String name, String email){
        this.name = new SimpleStringProperty(name);
        this.email = new SimpleStringProperty(email);
    }
    
    
    public String getName(){
        return name.get();
    }
    public void setName(String name){
        this.name = new SimpleStringProperty(name);
    }
    
    public String getEmail(){
        return email.get();
    }
    public void setEmail(String email){
        this.email = new SimpleStringProperty(email);
    }
    
    public String getPassword(){
        return password.get();
    }
    public void setPassword(String pass){
        this.password = new SimpleStringProperty(pass);
    }
}
