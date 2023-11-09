package main.java.book;

public class BookApp {

    public static void main(String[] args) {
        Ebook ebook = new Ebook("The Great Gatsby", "F. Scott Fitzgerald", "1234567890", "PDF");

        ebook.getBookInfo();
    }
}
