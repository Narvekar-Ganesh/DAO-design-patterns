package home.pratice.design.pattern.dao;

import home.pratice.domain.LibraryCard;

public interface LibraryCardDAO {
    LibraryCard getLibraryCard(Long cardId);

    Boolean saveLibraryCard(int cardNumber, String cardName);
}
