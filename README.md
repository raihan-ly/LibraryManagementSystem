# Library Management System (Flask)

A simple Library Management System built using Flask and SQLite. The system supports two types of users—admin and regular users—with the ability to add, borrow, and track books in the library.

## Features

- **Admin Role**: 
  - Add new books to the library.
  - View all borrowed books, including information on which user borrowed which book and when.
  
- **User Role**:
  - Borrow books from the library (based on availability).
  
- **Book Management**:
  - Admin can track book inventory, including title, author, genre, and quantity.
  - Users can view available books and borrow them (if quantity > 0).

- **Authentication**:
  - User registration and login system.
  - Admin and user roles with secure password management using hashing (via `werkzeug`).

## Technologies Used

- **Flask**: Micro web framework for Python to handle routing and server-side logic.
- **SQLite**: A lightweight, serverless database to store user and book data.
- **SQLAlchemy**: ORM (Object-Relational Mapping) for interacting with SQLite database.
- **Werkzeug**: Password hashing for secure authentication.
- **HTML/CSS**: For the front-end interface.

## Database Schema

The application uses three tables in the SQLite database:

1. **Book Table** (`book`)
   - `id`: Primary key (auto-incremented).
   - `title`: Title of the book.
   - `author`: Author of the book.
   - `genre`: Genre of the book.
   - `quantity`: Quantity of the book available in the library.

2. **Borrowed Book Table** (`borrowed_book`)
   - `id`: Primary key (auto-incremented).
   - `user_id`: Foreign key reference to `user` table.
   - `book_id`: Foreign key reference to `book` table.
   - `quantity`: Quantity of the book borrowed.
   - `borrow_date`: Date when the book was borrowed.

3. **User Table** (`user`)
   - `id`: Primary key (auto-incremented).
   - `username`: Username for login.
   - `password`: Hashed password for authentication.
   - `role`: Either 'admin' or 'user' to differentiate roles.

## Installation

1. Clone this repository to your local machine:

   ```bash
   git clone https://github.com/raihan-ly/LibraryManagementSystem.git
   cd library-management-system
