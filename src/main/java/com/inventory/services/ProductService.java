package com.inventory.services;
import java.util.ArrayList;

import com.inventory.model.Product;
import com.inventory.repository.ProductRepository;


public class ProductService {

  private ProductRepository repository;
  
  public ProductService(ProductRepository repository)
  {
    this.repository = repository;
  }

  public boolean isProductIdExist(int productId)
  {
    for(Product product : repository.getAllProducts())
    {
      if(product.getProductId() == productId) //Validate Product Id is Exist or Not
      {
        return true;
      }
    }
    return false;
  }

  // Add Product


  public void addProduct(Product product)
  {
    if(isProductIdExist(product.getProductId()))
    {
      System.out.println("Product Id is Already Exist");
    }
    else
    {
      boolean isAdded = repository.addProduct(product);
      if(isAdded)
      {
        System.out.println("Product Added Successfully");
      }else
      {
        System.out.println("Failed to Add Product");
      }
    }
    }

  

// Display All Products  
  public void displayProducts()
  {
    ArrayList<Product> products = repository.getAllProducts();
      if(products.isEmpty())
      { 
        System.out.println("No Products Found");
        return;
      }
      for(Product product: products)
    {
      System.out.println(product);
      System.out.println("--------------------------------");        
    }
    System.out.println("Total Products: " + products.size());
  }

//Search product by ID

  public Product searchProduct(int productId)
  {
    Product product = repository.searchProductById(productId);

    if(product.getProductId() == productId)
    {
      return product;
    }   
    else
    {
     System.out.println("Product not Found");
     return null;
    }
  }


  //Update Product Quantity

  public void UpdateQuantity(int productId, int Quantity)
  {
    Product product = searchProduct(productId);
      if(product == null)
      {
        System.out.println("Product Not Found");
        return;
      }

      if(Quantity < 0)
      { 
        System.out.println("Quantity cannot be negative");
        return;
      }

      boolean result = repository.updateProductQuantity(productId, Quantity);
      if(result)
      {
        System.out.println("Product Quantity Updated Successfully");
      }else
      {
        System.out.println("Failed to Update Product Quantity");
      }
  }
  // Update Product Purchasing Price
  public void updatePurchasingPrice(int productId,double PurchasingPrice)
  {
    Product product = searchProduct(productId);
    if(product == null)
      {
        System.out.println("Product Not Found");
        return;
      }
      if(PurchasingPrice < 0)
      {
        System.out.println("Purcahsing Price Cnnot be Negative");
      }else if(PurchasingPrice >= product.getSellingPrice())
      {
        System.out.println("Purchasing Price Should be Less than Selling Price");
      }else
      {
        boolean result = repository.updateProductPurchasing(productId, PurchasingPrice);

        if(result)
        {
        System.out.println("Purchasing Price Updated Successfully");
        }
        else
        {
          System.out.println("Purchaing Price Update Failed");
        }
      }   
  }

  //Update Product Selling Price

  public void updateSellingPrice(int productId,double SellingPrice)
  {
    Product product = searchProduct(productId);
    if(product == null)
    {
      System.out.println("Product Not Found");
      return;
    }
    if(SellingPrice < 0)
    {
      System.out.println("Selling Price Cannot be Negative");
    }else if(SellingPrice <= product.getPurchasingPrice())
    {
      System.out.println("Selling Price should be Greater than Purchasing Price");
    }else
    {
      boolean result = repository.updateProductSelling(productId, SellingPrice);

        if(result)
        {
        System.out.println("Selling Price Updated Successfully");
        }
        else
        {
          System.out.println("Selling Price Update Failed");
        }
    }

  }
  //Update Product Minimum Stock

  public void updateMinimumStock(int productId,int minimumStock)
  {
    Product product = searchProduct(productId);
    if(product == null)
    {
      System.out.println("Product Not Found");
      return;
    }
    if(minimumStock < 0)
    {
      System.out.println("Minimum Stock Cannot be Negative");
      return;
    }
    boolean result = repository.updateminimumStock(productId, minimumStock);
    if(result)
    {
      System.out.println("Minimum Stock Updated Successfully");
    }
    else
    {
      System.out.println("Failed to Update Minimum Stock");
    }
  }


  //Delete Product

  public boolean deleteProduct(int productId)
  {
    Product product = searchProduct(productId);
    if(product == null)
    {
      System.out.println("Product not found");
      return false;
    }

     boolean result = repository.DeleteProduct(productId);

     if(result)
     {
      System.out.println("Product Deleted Successfully");
      return true;
     } 
     else
     {
      System.out.println("Failed to Delete Product");
      return false;
     }    
    
  }

  //Purchase Stock

  public void PurchaseStock(int productId,int productQuantity)
  {
  Product product = searchProduct(productId);
    if(product == null)
    {
      System.out.println("Product Not Found");
      return;
    }
    if(productQuantity <= 0)
    {
      System.out.println("Product Quantity should be Greater than 0");
      return;
    }
    
    product.setQuantity(product.getQuantity()+productQuantity);
    System.out.println("Stock Purchased Successfully ");
    System.out.println("Current Stock is : "+ product.getQuantity());

  }

}
