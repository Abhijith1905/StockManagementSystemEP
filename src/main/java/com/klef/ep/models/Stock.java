package com.klef.ep.models;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;



@Entity
@Table(name="stock_table")
public class Stock implements Serializable
{
  @Id
  @Column(name="stock_itemcode" ,length=10)
  private String itemCode;
   
  @Column(name="stock_Name",nullable=false,length=30)
  private String itemName;
  
   @Column(name="stock_category",nullable=false,length=30)
  private String category;
   
   @Column(name="stock_quantity",nullable=false,precision=10,scale=0)
  private int quantity;
   
   @Column(name="stock_unitPrice",nullable=false,precision=10,scale=4)
  private double unitPrice;
   
   @Column(name="stock_purchasedate",nullable=false)
  private String purchasedate;

  @Column(name="stock_addedBy", nullable=false, length=50)
   private String addedBy;
  public String getAddedBy() {
    return addedBy;
  }
  public void setAddedBy(String addedBy) {
    this.addedBy = addedBy;
  }
  

     @Lob
      @Column()
      private Blob imagedata;    
     
  public Blob getImagedata() {
      return imagedata;
    }

    public void setImagedata(Blob imagedata) {
      this.imagedata = imagedata;
    }

  public String getItemCode() {
    return itemCode;
  }

  public void setItemCode(String itemCode) {
    this.itemCode = itemCode;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public double getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(double unitPrice) {
    this.unitPrice = unitPrice;
  }

  public String getPurchasedate() {
    return purchasedate;
  }

  public void setPurchasedate(String purchasedate) {
    this.purchasedate = purchasedate;
  }
}