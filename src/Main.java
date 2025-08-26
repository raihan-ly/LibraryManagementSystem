import exception.BookNotFoundException;
import service.LibraryService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryService library = new LibraryService();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("\n===Library Menu===\n1) Add Book\n2) List Books\n3) Borrow Book\n4) Return Book\n5) Search by Title\n6) Exit\n");
            System.out.println("Select: ");
            int input;
            try {
                input = scanner.nextInt();
            } catch (InputMismatchException e ) {
                System.out.println("Type a number: ");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine();

            switch (input) {
                case 1:
                    System.out.println("Title: ");
                    String title = scanner.nextLine();

                    System.out.println("Author: ");
                    String author = scanner.nextLine();

                    System.out.println("Category: ");
                    String category = scanner.nextLine();

                    library.addBook(title, author, category);
                    break;

                case 2:
                    library.listBooks();
                    break;

                case 3:
                    System.out.println("Enter book id: ");
                    int borrowId;
                    try {
                        borrowId= scanner.nextInt();
                        scanner.nextLine();
                        library.borrowBook(borrowId);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid ID! Please enter a number.");
                        scanner.nextLine();
                        continue;
                    }
                    catch (BookNotFoundException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    break;

                case 4:
                    System.out.println("Enter book id: ");
                    int returnId;
                    try {
                        returnId = scanner.nextInt();
                        scanner.nextLine();
                        library.returnBook(returnId);
                    } catch (InputMismatchException e ) {
                        System.out.println("Invalid ID! Please enter a number.");
                        scanner.nextLine();
                        continue;
                    }
                    catch (BookNotFoundException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    break;

                case 5:
                    System.out.println("Enter keyword to search: \n");
                    String keyword = scanner.nextLine();
                    library.searchBook(keyword);
                    break;

                case 6:
                    System.out.println("Exiting....");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid Option");
            }
        }
    }
}