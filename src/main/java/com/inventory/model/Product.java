package com.inventory.model;
public class Product
{
  private int productId;
  private String productName;
  private String category;
  private String brand;
  private double PurchasingPrice;
  private double sellingPrice;
  private int Quantity;
  private int minimumStock;

public Product(int productId,String productName,String category, String brand,double PurchasingPrice,double sellingPrice,int Quantity,int minimumStock)
  {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.brand = brand;
        this.PurchasingPrice = PurchasingPrice;
        this.sellingPrice = sellingPrice;
        this.Quantity = Quantity;
        this.minimumStock = minimumStock;
    }
//Getter Methods to get the Data because variables of Class Are PRIVATE
    public int getProductId()
    {
      return productId;
    }

    public String getProductName()
    {
      return productName;
    }
    public String getCategory()
    {
      return category;
    }
    public String getBrand()
    {
      return brand;
    }
    public double getPurchasingPrice()
    {
      return PurchasingPrice;
    } 
    public double getSellingPrice()
    {
      return sellingPrice;
    }
    public int getQuantity()
    {
      return Quantity;
    }
    public int getMinimumStock()
    {
      return minimumStock;
    }
    //---------------------------------------------------------
// Setter Methods to set or for Modify Value

    public void setQuantity(int Quantity)
    {
      this.Quantity = Quantity;
    }

    public void setPurchasingPrice(double PurchasingPrice)
    {
      this.PurchasingPrice = PurchasingPrice;
    }

    public void setSellingPrice(double sellingPrice)
    {
      this.sellingPrice = sellingPrice;
    }

    public void setMinimumStock(int minimumStock)
    {
      this.minimumStock = minimumStock;
    }
//------------------------------------------------
    
    @Override
    public String toString()
    {
      return
       "Product Id    : " + productId +
       "\nProduct Name  : " + productName +
       "\nCategory      : "+ category +
       "\nBrand         : " + brand +
       "\nPurchase Price: " + PurchasingPrice +
       "\nSelling Price : " + sellingPrice +
       "\nQuantity      : " + Quantity +
       "\nMinimum Stock : " + minimumStock;

    }

    
}