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
public class SupplierModel {

    private SimpleIntegerProperty supplierId;
    private SimpleStringProperty supplierName;
    private SimpleStringProperty supplierContact;
    private SimpleStringProperty supplierDescription;

    public SupplierModel(Integer supplierId, String name, String supplierContact, String supplierDescription) {
        this.supplierId = new SimpleIntegerProperty(supplierId);
        this.supplierName = new SimpleStringProperty(name);
        this.supplierContact = new SimpleStringProperty(supplierContact);
        this.supplierDescription = new SimpleStringProperty(supplierDescription);
    }

    public int getSupplierId() {
        return supplierId.get();
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = new SimpleIntegerProperty(supplierId);
    }

    public String getSupplierName() {
        return supplierName.get();
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = new SimpleStringProperty(supplierName);
    }
    
    public String getSupplierContact() {
        return supplierContact.get();
    }

    public void setSupplierContact(String supplierContact) {
        this.supplierContact = new SimpleStringProperty(supplierContact);
    }

    public String getSupplierDescription() {
        return supplierDescription.get();
    }

    public void setSupplierDescription(String supplierDescription) {
        this.supplierDescription = new SimpleStringProperty(supplierDescription);
    }
}