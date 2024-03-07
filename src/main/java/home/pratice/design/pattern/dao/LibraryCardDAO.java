package home.pratice.design.pattern.dao;

import home.pratice.domain.LibraryCard;

public interface LibraryCardDAO {
    LibraryCard getLibraryCard(Long cardId);
    void saveLibraryCard(int cardNumber, String cardName);

}
