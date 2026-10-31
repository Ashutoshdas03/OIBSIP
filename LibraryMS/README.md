# 📚 Digital Library Management System

A Java-based application to manage a library's books, members, and borrowing activity digitally. It replaces manual registers with a searchable catalogue, issue/return tracking, and automatic fine calculation.

## ✨ Features

**Admin / Librarian**
- Add, update, delete, and search books
- Manage member records
- Issue and return books with due-date tracking
- Automatic fine calculation for overdue books
- View issued books and overdue reports

**Member**
- Search books by title, author, or category
- Check book availability
- View borrowing history and pending fines

**General**
- Login with role-based access (Admin, Librarian, Member)
- Data stored in a database using JDBC

## 🛠 Tech Stack

| Component  | Technology                        |
|------------|-----------------------------------|
| Language   | Java 25            |
| GUI        | Java Swing / JavaFX               |
| Database   | MySQL                             |
| Connectivity | JDBC (MySQL Connector/J)        |
| IDE        | Eclipse IDE                       |
| Version Control | Git, GitHub                  |

## 📁 Project Structure

```
DigitalLibraryManagementSystem/
├── src/
│   ├── model/        # Book, Member, Issue classes
│   ├── dao/          # Database access classes
│   ├── ui/           # Swing/JavaFX screens
│   ├── util/         # DBConnection and helpers
│   └── Main.java
├── lib/
│   └── mysql-connector-j.jar
├── database/
│   └── library_db.sql
└── README.md
```

## 🚀 Getting Started

### Prerequisites
- JDK 17 or later
- Eclipse IDE
- MySQL Server 8 or later
- MySQL Connector/J (JDBC driver)

### Setup in Eclipse

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/digital-library-management-system.git
   ```

2. **Import into Eclipse**
   - Open Eclipse → `File` → `Import` → `General` → `Existing Projects into Workspace`
   - Select the cloned folder and click `Finish`

3. **Set up the database**
   - Open MySQL and run the script:
   ```sql
   source database/library_db.sql;
   ```

4. **Add the JDBC driver**
   - Right-click the project → `Build Path` → `Configure Build Path`
   - `Libraries` → `Add External JARs` → select `mysql-connector-j.jar`

5. **Configure the database connection**

   Open `src/util/DBConnection.java` and update your details:
   ```java
   private static final String URL = "jdbc:mysql://localhost:3306/library_db";
   private static final String USER = "root";
   private static final String PASSWORD = "your_password";
   ```

6. **Run the project**
   - Right-click `Main.java` → `Run As` → `Java Application`

## 🗄 Database Tables

| Table      | Description                                  |
|------------|----------------------------------------------|
| users      | Login details and roles                      |
| books      | Title, author, ISBN, category, quantity      |
| members    | Member details                               |
| issues     | Issue date, due date, return date, status    |
| fines      | Fine amount and payment status               |

## 💡 Usage

1. Log in using your admin credentials.
2. Add books and register members.
3. Issue a book to a member and set the due date.
4. Process the return; any fine is calculated automatically.

## 🗺 Future Improvements

- Email/SMS reminders for due dates
- Barcode scanning for books
- Online reservation system
- Reports export to PDF/Excel
