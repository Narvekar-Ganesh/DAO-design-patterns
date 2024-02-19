package home.pratice.domain;

import javax.persistence.*;

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long  bookNumber;

    @Column
    private  int bookId ;

    @Column
    private String  bookName;

    public long getBookNumber() {
        return bookNumber;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setBookNumber(long bookNumber) {
        this.bookNumber = bookNumber;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookNumber=" + bookNumber +
                ", bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}
