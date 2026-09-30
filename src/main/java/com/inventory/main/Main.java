package com.inventory.main;

import com.inventory.menu.InventoryMenu;
import com.inventory.repository.ProductRepository;
import com.inventory.services.ProductService;

public class Main
{ 
  public static void main(String A[])
  {
    
    ProductRepository repository = new ProductRepository();
    ProductService service = new ProductService(repository);
    InventoryMenu menu = new InventoryMenu(service);

    menu.startMenu();
  }
}