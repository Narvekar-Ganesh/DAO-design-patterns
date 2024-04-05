package home.pratice.domain;

import lombok.*;

import javax.persistence.*;

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
}
