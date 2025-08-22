# 🛒 BuyHive – Marketplace Backend

BuyHive is a **Spring Boot-based backend system** for a marketplace application where:
- Users can register/login.
- Sellers can list products for sale.
- Buyers can purchase products if they have enough balance.
- Purchases update buyer inventory, seller balance, and buyer balance.

---

## ⚙️ Tech Stack
- **Java 21**
- **Spring Boot 3**
- **Spring Data JPA **
- **Spring Security**
- **MySQL** (Database)
- **Maven** (Build tool)

---

## 📂 Project Structure

```
com.buyHive.BuyHive
│
├── Data
│   ├── UserDetails.java       # Entity for users
│   ├── Product.java           # Entity for products
│   ├── UserInventory.java     # Entity for buyer inventory
│
├── Repository
│   ├── UserDetailsRepository.java
│   ├── ProductRepository.java
│   └── UserInventoryRepository.java
│
├── Service
│   └── MarketplaceService.java  # Handles purchase logic
│
└── Security
    └── AuthSecurityConfiguration.java
```

---

## 🗄️ Database Schema

### **UserDetails (user_details)**
| Column   | Type    | Description              |
|----------|---------|--------------------------|
| id       | INT PK  | Unique user ID           |
| name     | VARCHAR | User name                |
| mail     | VARCHAR | Email (login)            |
| password | VARCHAR | Encrypted password       |
| balance  | DOUBLE  | User’s wallet balance    |
| role     | ENUM    | BUYER / SELLER / ADMIN   |

---

### **Product (product)**
| Column   | Type    | Description              |
|----------|---------|--------------------------|
| id       | INT PK  | Unique product ID        |
| name     | VARCHAR | Product name             |
| price    | DOUBLE  | Product price            |
| user_id  | FK      | Seller (maps to User)    |

---

### **UserInventory (user_inventory)**
| Column     | Type    | Description              |
|------------|---------|--------------------------|
| id         | INT PK  | Unique inventory ID      |
| user_id    | FK      | Buyer (maps to User)     |
| product_id | FK      | Product purchased        |
| quantity   | INT     | Quantity owned           |

---

## 🔑 Core Features

1. **User Authentication** – Secure login and registration with Spring Security.
2. **Product Management** – Sellers can list and manage products.
3. **Purchase Flow** –
    - Deducts balance from buyer.
    - Adds funds to seller.
    - Updates buyer’s inventory.
4. **Role-Based Access Control** – BUYER, SELLER, ADMIN roles.

---

## 🚀 Setup Instructions

### 1️⃣ Clone the Repository
```sh
git clone https://github.com/yourusername/buyhive.git
cd buyhive
```

### 2️⃣ Configure Database (MySQL)
Create a database:
```sql
CREATE DATABASE buyHive;
```

Update `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/buyHive
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

### 3️⃣ Build and Run
```sh
./mvnw clean install
./mvnw spring-boot:run
```

### 4️⃣ Test API Endpoints
Use **Postman** or **cURL** to test APIs. Example purchase endpoint:

```http
POST /api/purchase/{productId}
Authorization: Bearer <token>
```

---

## ✅ Roadmap / TODO

- [ ] Inventory Management RestAPI's
- [ ] Downloadable Invoice Of Purchases
- [ ] Add role-based API access (SELLER vs BUYER)
- [ ] Write Unit & Integration Tests

---

## 👨‍💻 Contributors
- **Sahil Bhure** – Developer & Maintainer

---

## 📜 License
This project is licensed under the **MIT License**.  
