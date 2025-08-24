package service;

import model.Book;

import java.util.ArrayList;

public class LibraryService {

    private ArrayList<Book> books = new ArrayList<>();
    private int nextId = 1;

    public void addBook(String title, String author, String category) {
        Book addedBook = new Book(nextId++, title, author, category, true);
        books.add(addedBook);
        System.out.println("Book added: " + addedBook);
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("Library is empty");
            return;
        }
        System.out.println("Library Books:");
        for (Book book: books) {
            System.out.println(book);
        }
    }
    
    public void borrowBook(int id) {
        for (Book book: books) {
            if (book.getId() == id) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("Borrowed Book: " + book.getTitle());
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
        for (Book book: books) {
            if (book.getId() == id) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("Book returned: " + book.getTitle());
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
        String lowerKeyword = keyword.toLowerCase();
        for (Book book: books) {
            if (book.getTitle().toLowerCase().contains(lowerKeyword)){
                System.out.println("Book found: " + book.getTitle());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No match found for " + keyword);
        }
    }
}


