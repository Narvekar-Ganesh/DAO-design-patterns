package home.pratice.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Data

@Entity
public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private int cardNumber;

    @Column
    private String cardName;


    @Override
    public int hashCode() {
        return Objects.hash(id, cardNumber, cardName);
    }
}

