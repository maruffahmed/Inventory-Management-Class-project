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
public class ProductModel {
    private SimpleIntegerProperty productId;
    private SimpleStringProperty productName;
    private SimpleStringProperty productCategory;
    private SimpleStringProperty productBrand;
    private SimpleIntegerProperty productQuantity;
    private SimpleIntegerProperty productPursesPrice;
    private SimpleIntegerProperty productSellPrice;
    
    private SimpleIntegerProperty sellsId;
    
    public ProductModel(Integer productId, String productName, String productCategory, String productBrand, Integer productQuantity, Integer productPursesPrice, Integer productSellPrice ){
        this.productId = new SimpleIntegerProperty(productId);
        this.productName = new SimpleStringProperty(productName);
        this.productCategory = new SimpleStringProperty(productCategory);
        this.productBrand = new SimpleStringProperty(productBrand);
        this.productQuantity = new SimpleIntegerProperty(productQuantity);
        this.productPursesPrice = new SimpleIntegerProperty(productPursesPrice);
        this.productSellPrice = new SimpleIntegerProperty(productSellPrice);
    }
    
    public ProductModel(Integer productId, String productName, String productCategory, String productBrand, Integer productQuantity, Integer productPursesPrice, Integer productSellPrice, Integer sellsId ){
        this.productId = new SimpleIntegerProperty(productId);
        this.productName = new SimpleStringProperty(productName);
        this.productCategory = new SimpleStringProperty(productCategory);
        this.productBrand = new SimpleStringProperty(productBrand);
        this.productQuantity = new SimpleIntegerProperty(productQuantity);
        this.productPursesPrice = new SimpleIntegerProperty(productPursesPrice);
        this.productSellPrice = new SimpleIntegerProperty(productSellPrice);
        this.sellsId = new SimpleIntegerProperty(sellsId);
    }
    
    public Integer getSellsId(){
        return sellsId.get();
    }
    public void setSellsId(int sellsId){
        this.sellsId = new SimpleIntegerProperty(sellsId);
    }
    
    public Integer getProductId(){
        return productId.get();
    }
    public void setProductId(int productId){
        this.productId = new SimpleIntegerProperty(productId);
    }
    
    public String getProductName(){
        return productName.get();
    }
    public void setProductName(String productName){
        this.productName = new SimpleStringProperty(productName);
    }
    
    public String getProductCategory(){
        return productCategory.get();
    }
    public void setProductCategory(String productCategory){
        this.productCategory = new SimpleStringProperty(productCategory);
    }
    
    public String getProductBrand(){
        return productBrand.get();
    }
    public void setProductBrand(String productBrand){
        this.productBrand = new SimpleStringProperty(productBrand);
    }
    
    public Integer getProductQuantity(){
        return productQuantity.get();
    }
    public void setProductQuantity(int productQuantity){
        this.productQuantity = new SimpleIntegerProperty(productQuantity);
    }
    
    public Integer getProductPursesPrice(){
        return productPursesPrice.get();
    }
    public void setProductPursesPrice(int productPursesPrice){
        this.productPursesPrice = new SimpleIntegerProperty(productPursesPrice);
    }
    
    public Integer getProductSellPrice(){
        return productSellPrice.get();
    }
    public void setProductSellPrice(int productSellPrice){
        this.productSellPrice = new SimpleIntegerProperty(productSellPrice);
    }
}
