package home.pratice.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookNumber == book.bookNumber && Objects.equals(bookName, book.bookName) && Objects.equals(autherName, book.autherName) && Objects.equals(isbnNumber, book.isbnNumber) && Objects.equals(price, book.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookNumber, bookName, autherName, isbnNumber, price);
    }
}
