package service;

import model.Book;

public class LibraryService {

    private Book[] books = new Book[100];
    private int bookCount = 0;
    private int nextId = 1;

    public void addBook(String title, String author, String category) {
        if (bookCount >= books.length) {
            System.out.println("Library is full! Can't add more books.");
            return;
        }
        Book addedBook = new Book(nextId++, title, author, category, true);
        books[bookCount++] = addedBook;
        System.out.println("Book added: " + addedBook);
    }

    public void listBooks() {
        if (bookCount == 0) {
            System.out.println("No books available in the Library.");
            return;
        }
        System.out.println("Library Books: ");
        for(int i = 0; i <=books.length; i++) {
            if(books[i] == null) {
                break;
            }
            System.out.println(books[i]);
        }
    }

    public void borrowBook(int id) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getId() == id) {
                if (books[i].isAvailable()) {
                    books[i].setAvailable(false);
                    System.out.println("Borrowed Book: " + books[i].getTitle());
                }
                else {
                    System.out.println("Book is already borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found having id " + id);
    }

    public void returnBook(int id) {
        for(int i = 0; i < bookCount; i++) {
            if(books[i].getId() == id) {
                if (!books[i].isAvailable()) {
                    books[i].setAvailable(true);
                    System.out.println("Book returned: " + books[i].getTitle());
                }
                else {
                    System.out.println("Book is available and hasn't been borrowed");
                }
                return;
            }
        }
        System.out.println("Book not found with id: " + id);
    }

    public void searchBook(String keyword) {
        boolean found = false;
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().toLowerCase().contains(keyword.toLowerCase())){
                System.out.println("Book found: " + books[i].getTitle());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No match found for " + keyword);
        }
    }
}

