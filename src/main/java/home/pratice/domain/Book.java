package home.pratice.domain;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookId;

    @Column
    private int bookNumber;


    @Column
    private String bookName;

    public long getBookId() {
        return bookId;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }


    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
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
