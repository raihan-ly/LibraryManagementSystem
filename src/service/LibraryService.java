package service;

import model.Book;

import java.util.HashMap;

public class LibraryService {

    private HashMap<Integer, Book> books = new HashMap<>();
    private int nextId = 1;

    public void addBook(String title, String author, String category) {
        Book addedBook = new Book(nextId, title, author, category, true);
        books.put(nextId, addedBook);
        System.out.println("Book added: " + addedBook);
        nextId++;
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("Library is empty");
            return;
        }
        System.out.println("Library Books:");
        for (Book book: books.values()) {
            System.out.println(book);
        }
    }

    public void borrowBook(int id) {
        Book book = books.get(id);
        if (book == null) {
            System.out.println("Book not found having id " + id);
            return;
        }
        if(book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("Borrowed Book: " + book.getTitle());
        } else {
            System.out.println("Book is already borrowed");
        }
    }

    public void returnBook(int id) {
        Book book = books.get(id);
        if (book == null) {
            System.out.println("Book not found having id " + id);
            return;
        }
        if (!book.isAvailable()) {
            book.setAvailable(true);
            System.out.println("Book returned: " + book.getTitle());
        } else {
            System.out.println("Book is already available: " + book.getTitle());
        }
    }

    public void searchBook(String keyword) {
        boolean found = false;
        String lowerKeyword = keyword.toLowerCase();
        for (Book book: books.values()) {
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


