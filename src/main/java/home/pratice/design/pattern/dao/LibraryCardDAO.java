package home.pratice.design.pattern.dao;

import home.pratice.domain.LibraryCard;

public interface LibraryCardDAO {
    LibraryCard getLibraryCard(int cardNumber);
    void saveLibraryCard(int cardNumber, String cardName);

}
