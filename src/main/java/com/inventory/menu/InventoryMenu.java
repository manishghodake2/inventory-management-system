package com.inventory.menu;
import java.util.*;
import com.inventory.services.ProductService;
import com.inventory.model.Product;
public class InventoryMenu 
{
  
  private ProductService service;
  private Scanner scanner;

  public InventoryMenu(ProductService service)
  {
    this.service = service;
    this.scanner = new Scanner(System.in);
  }  
  public void startMenu()
  {
    boolean running = true;
    while(running)
      {
        System.out.println("========================================");
        System.out.println("\n");
        System.out.println("Inventory Management System");
        System.out.println("\n");
        System.out.println("========================================");
        System.out.println("1. Add Product");
        System.out.println("2. Display Products");
        System.out.println("3. Update Products");
        System.out.println("4. Delete Products");
        System.out.println("5. Search Product");
        System.out.println("6. Purchase Stock");
        System.out.println("7: Exit");

        int choice  = scanner.nextInt();

        switch(choice)
        {
          case 1:
          
          System.out.println("Add Product");

          System.out.print("Enter Product Id: ");
          int productId = scanner.nextInt();
          scanner.nextLine();

          System.out.print("Enter Product Name: ");
          String productName = scanner.nextLine();

          System.out.print("Enter Category: ");
          String category = scanner.nextLine();

          System.out.print("Enter Brand: ");
          String brand = scanner.nextLine();

          System.out.println("Enter Purchasing Price: ");
          int purchasingPrice = scanner.nextInt();

          System.out.println("Enter Selling Price: ");
          int sellingPrice = scanner.nextInt();

          System.out.println("Enter Quantity: ");
          int quantity = scanner.nextInt();

          System.out.println("Enter Minimum Stock: ");
          int minimumStock = scanner.nextInt();


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
         
          service.addProduct(product);
          
          break;
           
          case 2:
            System.out.println("Display Products");
            service.displayProducts();
          break;

          case 3:
            System.out.println("Please Enter Product Id");
            int productIdforUpdate = scanner.nextInt();
            Product productUpdate  = service.searchProduct(productIdforUpdate);
              if(productUpdate == null)
              {
                System.out.println("Product Not Found");
              }
              else
              {
                System.out.println("DEBUG: Entered else block");
                System.out.println("======Update Product======");
                System.out.println("1. Update Quantity");
                System.out.println("2. Update Purchasing Price");
                System.out.println("3. Update Selling Price");
                System.out.println("4. Update Minimum Stock");
                System.out.println("Enter Your Choice");
                int updateChoice = scanner.nextInt();

                switch(updateChoice)
                {
                    case 1:
                    
                      System.out.println("Enter New Quantity");
                      int newQuantity = scanner.nextInt();

                    service.UpdateQuantity(productIdforUpdate, newQuantity);
                    break;

                    case 2:

                      System.out.println("Enter New Purchasing Price");
                      double newPurchasingPrice = scanner.nextDouble();

                      service.updatePurchasingPrice(productIdforUpdate, newPurchasingPrice);
                      break;
                    
                    case 3:
                        System.out.println("new Selling Price");
                        double newSellingPrice = scanner.nextDouble();
                        service.updateSellingPrice(productIdforUpdate, newSellingPrice);
                      break;
                    case 4:
                      System.out.println("New Minimum Stock is");
                      int newMinimumStock = scanner.nextInt();
                      service.updateMinimumStock(productIdforUpdate, newMinimumStock);
                      break;
                    default:
                      System.out.println("Invalid Choice");
                      break;
                }
              }

          break;

          case 4:
            System.out.println("Delete Product");
            System.out.println("Please Enter Product Id");
            int productIdForDelete = scanner.nextInt();
            service.deleteProduct(productIdForDelete);
            break;

          case 5:
            System.out.print("Enter Product Id\n");
            int searchId = scanner.nextInt();

            Product searchproductbyId = service.searchProduct(searchId);
              if(searchproductbyId != null)
              {
                System.out.println(searchproductbyId);
                System.out.println("--------------");
              }
              else
              {
                System.out.println("Product not found");
              }
            break;
          case 6:
            System.out.println("Please Enter Product Id");
            int productIdForPurchase = scanner.nextInt();
            
            System.out.println("Please Enter Amount of Stock Purchased");
            int purchasedStock = scanner.nextInt();
            
            service.PurchaseStock(productIdForPurchase, purchasedStock);
              break;
          case 7:
            System.out.println("Thank You for Using Inventory System.");
            running = false;
            break;

          default:
            System.out.println("Invalid Choice");
        }

      }
    
  }
}
