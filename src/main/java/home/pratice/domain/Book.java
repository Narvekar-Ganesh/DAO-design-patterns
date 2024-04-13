package home.pratice.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//@NoArgsConstructor
@ToString
@Getter
@Setter
@Data
@Entity
@NamedQueries({
        @NamedQuery(name = "getBooksByAuthorName",
                query = "FROM Book book " +
                        "WHERE book.autherName = :autherName"),
        @NamedQuery(name = "getBooksByBookName",
                query = "FROM Book book " +
                        "WHERE book.bookName = :bookName"),
        @NamedQuery(name = "getAllBooks",
                query = "From Book book"),
        @NamedQuery(name= "updateGivenBookWithDefaultPrice",
                query = "update Book book " +
                        "set book.price=0.0 " +
                        "Where book.bookId = :bookId"),
        @NamedQuery(name ="updateBookAutherNameWithBookName",
                     query = "update Book book " +
                             "set book.autherName=Krishna " +
                             "Where book.bookName=:bookName"
                            )
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

    public Book(){
        System.out.println("I am in default constructor of Book");
    }

//    private List<Integer>prices = new ArrayList<>();

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Book book = (Book) o;
//        return bookNumber == book.bookNumber && Objects.equals(bookName, book.bookName) && Objects.equals(autherName, book.autherName) && Objects.equals(isbnNumber, book.isbnNumber) && Objects.equals(price, book.price);
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(bookNumber, bookName, autherName, isbnNumber, price);
//    }
}

