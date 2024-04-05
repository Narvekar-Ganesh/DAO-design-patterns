package home.pratice.domain;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@ToString
@Getter
@Setter
@Data
@EqualsAndHashCode
@Entity
public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private int cardNumber;

    @Column
    private String cardName;
}