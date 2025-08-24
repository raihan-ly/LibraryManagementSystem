package model;

public class Book {
    private int id;
    private String title;
    private String author;
    private String category;
    private boolean isAvailable;

    public Book(int id, String title, String author, String category, boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", isAvailable=" + (isAvailable ? "Yes" : "No") +
                '}';
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
