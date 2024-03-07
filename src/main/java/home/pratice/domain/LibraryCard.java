package home.pratice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LibraryCard {
    @Id
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
