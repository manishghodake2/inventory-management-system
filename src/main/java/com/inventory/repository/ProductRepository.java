package com.inventory.repository;
import java.sql.Connection;
import com.inventory.model.Product;
import com.inventory.database.DBConnection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ProductRepository {
  private ArrayList<Product> products;

public ProductRepository()
{
    products = new ArrayList<>();
}
//Search Product By Id
public Product searchProductById(int productId)
{
  String sql = "SELECT * from products WHERE product_id=?";
  try
  (
    Connection con = DBConnection.getConnection();
    
    PreparedStatement ps = con.prepareStatement(sql);
    
  )
  {
    ps.setInt(1, productId);
    ResultSet rs = ps.executeQuery();

    if(rs.next())
    {
      int productId1 = rs.getInt("product_id");
      String productName = rs.getString("product_name");
      String category = rs.getString("category");
      String brand = rs.getString("brand");
      double purchasingPrice = rs.getDouble("purchasing_price");
      double sellingPrice = rs.getDouble("selling_price");
      int quantity = rs.getInt("quantity");
      int minimumStock = rs.getInt("minimum_stock");

      Product product = new Product(
        productId1,
        productName,
        category,
        brand,
        purchasingPrice,
        sellingPrice,
        quantity,
        minimumStock
      );
      return product;
    }
    return null;
  }
  catch(SQLException e)
  {
    e.printStackTrace();
    return null;
  }
  
}
//Display All Products

public ArrayList<Product> getAllProducts()
{
    ArrayList<Product> products = new ArrayList<>();
    String sql = "SELECT * FROM products";

  try(
    Connection con = DBConnection.getConnection();
    PreparedStatement ps = con.prepareStatement(sql)
    )
    {
    ResultSet rs = ps.executeQuery();
    while(rs.next())
    {
      int productId = rs.getInt("product_id");
      String productName = rs.getString("product_name");
      String category = rs.getString("category");
      String brand = rs.getString("brand");
      double purchasingPrice = rs.getDouble("purchasing_Price");
      double sellingPrice = rs.getDouble("selling_Price");
      int quantity = rs.getInt("quantity");
      int minimumStock = rs.getInt("minimum_Stock");

      Product product = new Product(
        productId,
        productName,
        category,
        brand,
        purchasingPrice,
        sellingPrice,
        quantity,
        minimumStock
      );
      products.add(product);
    }
  }
    catch(SQLException e)
    {
      e.printStackTrace();
    }
    return products;   
}

//Delete Product

public void deleteProduct(Product product)
{
    products.remove(product);
}

// Add Prdouct

  public boolean addProduct(Product product)
  {
    String sql = "INSERT INTO products(product_id,product_name,category,brand,purchasing_price,selling_price,quantity,minimum_stock) VALUES (?,?,?,?,?,?,?,?)";
    try
    (
    Connection con = DBConnection.getConnection();
    PreparedStatement ps = con.prepareStatement(sql)
    )
    { 
    ps.setInt(1,product.getProductId());
    ps.setString(2,product.getProductName());
    ps.setString(3,product.getCategory());
    ps.setString(4,product.getBrand());
    ps.setDouble(5,product.getPurchasingPrice());
    ps.setDouble(6,product.getSellingPrice());
    ps.setInt(7,product.getQuantity());
    ps.setInt(8,product.getMinimumStock());

    int rows = ps.executeUpdate();
    return rows > 0;
    }

    catch(SQLException e)
    {
      e.printStackTrace();
      return false;
    }
  }  

  //Update Product by Quantity

    public boolean updateProductQuantity(int productId, int quantity)
    {
      String sql = "UPDATE products SET quantity = ? WHERE product_id = ?";

      try(
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)
      )
      {
        ps.setInt(1,quantity);
        ps.setInt(2,productId);

        int rows = ps.executeUpdate();

        return rows > 0;
      }
      catch(SQLException e)
      {
        e.printStackTrace();
        return false;

      }
    }
    // Update product by PurchasingPrice
    public boolean updateProductPurchasing(int productId , double PurchasingPrice)
    {
      String sql = "UPDATE products SET purchasing_price = ? WHERE product_id = ?";

      try(
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)
      )
      {
        ps.setDouble(1,PurchasingPrice);
        ps.setInt(2,productId);

        int rows = ps.executeUpdate();

        return rows > 0;
      }
      catch(SQLException e)
      {
       e.printStackTrace();
       return false; 
      }
    }
    // Update product by Selling Price
    public boolean updateProductSelling(int productId , double SellingPrice)
    {
      String sql = "UPDATE products SET selling_price = ? WHERE product_id = ?";

      try(
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)
      )
      {
        ps.setDouble(1,SellingPrice);
        ps.setInt(2,productId);

        int rows = ps.executeUpdate();

        return rows > 0;
      }
      catch(SQLException e)
      {
       e.printStackTrace();
       return false; 
      }
    }
    //Update Minimum Stock

    public boolean updateminimumStock(int productID, int minimumStock)
    {
      String sql = "UPDATE product SET minimum_stock = ? WHERE product_id = ?";
      try(
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)
      )
        {
          ps.setInt(1,minimumStock);
          ps.setInt(2,productID);

          int rows = ps.executeUpdate();
          return rows > 0;
        }
        catch(SQLException e)
        {
          e.getStackTrace();
        return false;
        }
      
    }

    public boolean DeleteProduct(int productId)
    {
      String sql = "DELETE FROM products WHERE product_id = ?";

      try(
        Connection con = DBConnection.getConnection();
        PreparedStatement ps= con.prepareStatement(sql)
      )
        {
          ps.setInt(1,productId);

          int rows = ps.executeUpdate();
          return rows > 0;
        }
        catch(SQLException e)
        {
          e.getStackTrace();
          return false;
        }
    }

    }
