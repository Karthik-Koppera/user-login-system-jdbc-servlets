# 🔐 User Login System (JDBC + Servlets)

This is a simple Java web application built using Servlets and JDBC.
It allows users to register and log in using a MySQL database, demonstrating basic web application flow using Java EE.

## 🚀 Features

User registration form (insert data into MySQL)
User login authentication (validate user details)
Database connection using JDBC
HTML + CSS frontend interface
Servlet-based backend logic

---

## 📂 Project Structure
```
user-login-system-jdbc-servlets/
│── RegisterServlet.java
│──LoginServlet.java
│ ├── login.html
│ ├── register.html
│
│── WEB-INF/
│ └── web.xml
│└── classes
│└──lib/
│ └── mysql-connector-j-9.3.0.jar
│└── ojdbc17.jar
│── README.md
```
---

## 🛠️ Technologies Used

- Core Java
- Servlets
- JDBC
- MySQL Database
- HTML, CSS
- Apache Tomcat Server

## ⚙️ Setup Instructions
```
1. Clone this repository
   git clone https://github.com/karthik-koppera.github.io/user-login-system-jdbc-servlets.git

2. CREATE DATABASE userdb;
   USE userdb;

CREATE TABLE users (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100) NOT NULL,
email VARCHAR(100) UNIQUE NOT NULL,
password VARCHAR(100) NOT NULL
);

3. Update Database Connection
   In both RegisterServlet.java and LoginServlet.java
   Connection con = DriverManager.getConnection(
   "jdbc:mysql://localhost:3306/mydb", "root", "root");

4. Deploy and Run
   Import the project in Eclipse / IntelliJ
   Add to Apache Tomcat Server
   Open in browser
   http://localhost:8080/user-login-system-jdbc-servlets/login.html
```

## 🧠 Learning Outcome

- Understood how Servlets handle HTTP requests/responses
- Connected Java web app to MySQL using JDBC
- Implemented user registration and login
- Built a complete mini web project with frontend + backend

## License

This project is open-source and available under the [MIT License](LICENSE).
