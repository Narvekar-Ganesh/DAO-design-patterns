package home.pratice.domain;

import javax.persistence.*;

@Entity
public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private int cardNumber;

    @Column
    private String cardName;

    public long getId() {
        return id;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "LibraryCard{" +
                "id=" + id +
                ", cardNumber=" + cardNumber +
                ", cardName='" + cardName + '\'' +
                '}';
    }
}
