package main.java.book;

public class Ebook extends Book {

    private final String fileFormat;

    public Ebook(String title, String author, String isbn, String fileFormat) {
        super(title, author, isbn);
        this.fileFormat = fileFormat;
    }

    @Override
    public void getBookInfo() {
        super.getBookInfo();
    }

    @Override
    public String toString() {
        return super.toString() + ", Format: " + fileFormat;
    }
}
