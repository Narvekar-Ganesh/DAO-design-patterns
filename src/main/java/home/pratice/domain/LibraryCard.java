package home.pratice.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private int cardNumber;

    @Column
    private String cardName;

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardName() {
        return cardName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibraryCard that = (LibraryCard) o;
        return cardNumber == that.cardNumber && Objects.equals(id, that.id) && Objects.equals(cardName, that.cardName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cardNumber, cardName);
    }

    @Override
    public String toString() {
        return "LibraryCard{" +
                "id=" + id +
                ", cardNumber=" + cardNumber +
                ", cardName='" + cardName + '\'' +
                '}';
    }
}
