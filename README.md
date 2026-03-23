# 📚 Library Management System

![Java](https://img.shields.io/badge/Java-17-orange)
![License](https://img.shields.io/badge/License-MIT-green)
![Console](https://img.shields.io/badge/Interface-Console-blue)

A **console-based Library Management System** built in Java, demonstrating **object-oriented programming**, **service-repository architecture**, and **clean code practices**. This project simulates real-world library operations such as adding books, managing members, and tracking borrow/return activities.

---

## 📌 Table of Contents

- [Features](#-features)  
- [Architecture](#-architecture)  
- [Technologies](#-technologies-used)  
- [Project Structure](#-project-structure)  
- [How to Run](#-how-to-run)  
- [Sample Output](#-sample-output)  
- [Key Learnings](#-key-learning)  
- [Future Improvements](#-future-improvements)  
- [License](#-license)  
- [Author](#-author)  

---

## 🛠 Features

- **Book Management**
  - Add, remove, and view books
  - Track available copies
- **Member Management**
  - Register and manage members
  - Maintain contact details (email, phone)
- **Borrow/Return System**
  - Borrow books with validation for availability
  - Return books and update availability automatically
  - Track borrow and return dates
- **Console Table Display**
  - Data displayed in **aligned table format**
  - Fixed-width columns for readability
  - Supports multiple entities: Books, Members, Borrows

---

## 🏗 Architecture

This project follows a **3-layer architecture**:

```
User Input (Scanner)
↓
Controller Layer (LibraryController)
↓
Service Layer (Business Logic)
↓
Repository Layer (Data Storage)
```


- **Repository Layer:** Handles CRUD operations for Books, Members, and Borrow records  
- **Service Layer:** Contains business logic and interacts with repositories  
- **Controller Layer:** Manages user input and output  

**Benefits:**  
- Separation of concerns  
- Easy to maintain and test  
- Mimics real-world backend architecture  

---

## 💻 Technologies Used

- Java 17+
- Object-Oriented Programming (OOP)  
- Jackson (for JSON serialization, if needed)
- Console-based user interface
- Java Collections Framework (Map, List)
- File I/O (for data persistence) 

---

## 📁 Project Structure
```
LibraryManagementSystem/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   └── sabbir/
│   │   │   │       └── library/
│   │   │   │           ├── app/
│   │   │   │           ├── controller/
│   │   │   │           ├── model/
│   │   │   │           ├── repository/
│   │   │   │           ├── service/
│   │   │   │           └── localdb/
|   |   |   |               └── JsonStorage.java
│   │   |   └── resources/
|   |   |       └── data/
|   |   |       └── books.json
|   |   |       └── members.json
|   |   |       └── borrow.json
|   |   |   └── test/
├── README.md
```

---

## 🚀 How to Run

1. **Clone the repository:**

```bash
git clone https://github.com/sabbir-sharif/library-management.git
cd library-management
javac -d bin src/main/java/com/sabbir/library/app/LibraryApplication.java
java -cp bin com.sabbir.library.app.LibraryApplication
```
2. **Follow the console prompts** to interact with the system (add books, register members, borrow/return books).
---
## 📊 Sample Output

---
## 📚 Key Learnings
- Implementing a layered architecture in Java
- Managing data using in-memory storage and file persistence
- Designing a console-based user interface with aligned tables
- Applying OOP principles for clean and maintainable code
- Handling user input and validation effectively
- Using Java Collections for data management
---
## 🔮 Future Improvements
- Add search functionality for books and members
- Implement user authentication and roles (admin, member)
- Integrate a database (e.g., MySQL) for persistent storage
- Add unit tests for service and repository layers

## 📄 License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
## 👤 Author
[Sabbir Sharif]
- GitHub: [https://github.com/sabbir-sharif](https://github.com/sabbir-sharif/)
