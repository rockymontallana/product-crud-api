# Product CRUD API

A simple Spring Boot 3 CRUD application to manage products, using MySQL as the database.

## Features

- Create, Read, Update, Delete (CRUD) products
- Fields: id, product_name, quantity, amount, created_at, updated_at
- RESTful API endpoints
- Uses Gradle for build management

## Prerequisites

- Java 17+
- MySQL server installed
- Gradle

## Setup Instructions

### 1. Clone the Repository

-https://github.com/rockymontallana/product-crud-api

### 2. Database Setup

- Create a database in MySQL - You can use existing db.
- Create the product table using the script below

```sql
CREATE TABLE product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    quantity INT NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
```

### 3. Configure Application Properties

Edit `src/main/resources/application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/your_mysql_db
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update
```

### 4. Build and Run

To build and start the app:

```bash
./gradlew bootRun
```

### 5. Test the API

You can use [Postman](https://www.postman.com/) or `curl`:

- **Create Product:** `POST /products`
- **Get All Products:** `GET /products`
- **Get Single Product:** `GET /products/{id}`
- **Update Product:** `PUT /products/{id}`
- **Delete Product:** `DELETE /products/{id}`

Example curl testing. Make sure application is running

```bash
#Create
curl -i -X POST http://localhost:8080/products -H 'Content-Type: application/json' -d '{"productName": "Paint","quantity": 50,"amount": 500.00}'
#Update
curl -i -X PUT http://localhost:8080/products/1 -H 'Content-Type: application/json' -d '{"productName": "Hollow Blocks","quantity": 150,"amount": 20.00}'
#Delete
curl -i -X DELETE http://localhost:8080/products/3
```
