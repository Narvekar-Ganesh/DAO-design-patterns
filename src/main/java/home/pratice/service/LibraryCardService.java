package home.pratice.service;

import home.pratice.dao.implimentation.LibraryCardWithH2DAO;
import home.pratice.design.pattern.dao.LibraryCardDAO;
import home.pratice.domain.LibraryCard;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Data
@Setter
@Getter
public class LibraryCardService {
    private LibraryCardDAO libraryCardDAO;


    public LibraryCard getLibraCard(Long cardId) {
        LibraryCard libraryCard = libraryCardDAO.getLibraryCard(cardId);
        return libraryCard;
    }

    public String registerLibraryCard(int cardNumber, String cardName) {
        Boolean result = libraryCardDAO.saveLibraryCard(cardNumber, cardName);
        if (result == true) {
            return "Library card  with card number : " + cardNumber + " is registered succsesfully";
        } else {
            return "Library card  with card number : " + cardNumber + " is not  registered succsesfully";
        }
    }


    public String deleteLibraryCard(Long libraryCardId) {
        Boolean result = libraryCardDAO.deleteLibraryCard(libraryCardId);
        if (result) {
            return "Request user is deleted ";
        } else {
            return "Requested book is not deleted";
        }
    }
}

