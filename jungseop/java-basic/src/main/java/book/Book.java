package main.java.book;

public class Book {

    private final String title;
    private final String author;
    private final String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public void getBookInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Title: " + title +
                ", Author: " + author +
                ", isbn: " + isbn;
    }
}
