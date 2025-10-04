# Java Backend REST API with Servlets and PostgreSQL

## Overview

This project demonstrates building a Java backend using **Servlets**, **PostgreSQL**, and **JSON**. It covers the full CRUD cycle and shows how to handle JSON input/output in a RESTful style.

## Features Covered

### 1. Core Java and Object-Oriented Programming

- Defined `Book` and `Database` classes
- Used constructors, getters/setters
- Implemented encapsulation and object management
- Applied inheritance for specialized classes like `EBook` and `AudioBook`

### 2. Exception Handling

- Custom exceptions (`BookNotFoundException`)
- Proper try-catch blocks around database operations

### 3. File Handling

- Logged book data to a local file (`books.txt`)
- Read/write using `FileWriter` and `BufferedReader`

### 4. Collections

- Managed books using `ArrayList` and `HashMap`
- Implemented search by title

### 5. JDBC Database Connectivity

- Connected to PostgreSQL
- Implemented `insert`, `read`, `update`, `delete` methods
- Used `PreparedStatement` to prevent SQL injection
- Demonstrated `DriverManager` and connection management

### 6. Servlets

- Implemented `BookServlet` for REST endpoints
- Handled HTTP methods:

  - `GET` → List books in JSON
  - `POST` → Add book via JSON
  - `PUT` → Update book via JSON
  - `DELETE` → Remove book by ID

- Set `Content-Type: application/json`
- Used `org.json` library for JSON parsing and generation

### 7. Deployment Setup (Local)

- Compiled Servlets with `javac` including all required JARs:

  - `servlet-api.jar`
  - `postgresql.jar`
  - `json.jar`

- Deployed to Apache Tomcat
- Verified database connectivity
- Tested endpoints via **curl** or Postman

## Tools & Libraries

- **Java JDK 20+**
- **Apache Tomcat 10**
- **PostgreSQL 16**
- **JSON-java (org.json)**
- **JDBC PostgreSQL driver**

## Next Steps

- Implement connection pooling for production
- Add environment variable configuration for credentials
- Deploy to a cloud hosting provider (VPS or PaaS)
- Optional: Use Gson or Jackson for JSON handling
- Add proper logging and error handling
