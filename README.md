@"

# Inventory Management System

A Java-based Inventory Management System developed using **Core Java, JDBC, Maven, and MySQL**. The project demonstrates object-oriented programming, database connectivity, CRUD operations, product management, and inventory-related business logic.

## 🚀 Features

- Product management
- Add, view, search, update, and delete products
- Product quantity and stock management
- Minimum stock tracking
- Purchase order management
- Supplier management
- Category management
- Warehouse management
- User management
- MySQL database connectivity using JDBC
- Service and repository layer implementation
- Maven-based project structure
- Exception handling and database operations

## 🛠️ Technologies Used

- **Java**
- **JDBC**
- **MySQL**
- **Maven**
- **Object-Oriented Programming (OOP)**
- **SQL**
- **Git & GitHub**
- **VS Code**

## 📁 Project Structure

```text
inventory-management/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── inventory/
│   │               ├── database/
│   │               │   └── DBConnection.java
│   │               │
│   │               ├── main/
│   │               │   ├── Main.java
│   │               │   └── TestConnection.java
│   │               │
│   │               ├── menu/
│   │               │   └── InventoryMenu.java
│   │               │
│   │               ├── model/
│   │               │   ├── Category.java
│   │               │   ├── Product.java
│   │               │   ├── PurchaseOrder.java
│   │               │   ├── Supplier.java
│   │               │   ├── User.java
│   │               │   └── Warehouse.java
│   │               │
│   │               ├── repository/
│   │               │   └── ProductRepository.java
│   │               │
│   │               └── services/
│   │                   └── ProductService.java
│   │
│   └── test/
│       └── java/
│
├── pom.xml
├── .gitignore
└── README.md
```
