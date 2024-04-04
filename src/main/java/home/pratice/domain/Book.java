package home.pratice.domain;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "getBooksByAuthorName",
                    query = "FROM Book book " +
                            "WHERE book.autherName = :autherName"),
        @NamedQuery(name="getBooksByBookName",
                    query = "FROM Book book " +
                "WHERE book.bookName = :bookName")

})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;

    @Column
    private int bookNumber;

    @Column
    private String bookName;
    @Column
    private String autherName;
    @Column
    private String isbnNumber;
    @Column
    private Integer price;


    public String getAutherName() {
        return autherName;
    }

    public void setAutherName(String autherName) {
        this.autherName = autherName;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookNumber=" + bookNumber +
                ", bookName='" + bookName + '\'' +
                ", autherName='" + autherName + '\'' +
                ", isbnNumber=" + isbnNumber +
                ", price=" + price +
                '}';
    }
}
