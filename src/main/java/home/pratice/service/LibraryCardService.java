package home.pratice.service;

import home.pratice.dao.implimentation.LibraryCardWithH2;
import home.pratice.design.pattern.dao.LibraryCardDAO;
import home.pratice.domain.LibraryCard;

public class LibraryCardService {
    private LibraryCardDAO libraryCardDAO;

    public LibraryCardService() {
        libraryCardDAO = new LibraryCardWithH2();
    }

    public LibraryCard getLibraCard(Long cardId) {
        LibraryCard libraryCard = libraryCardDAO.getLibraryCard(cardId);
        return libraryCard;
    }

    public String registerLibraryCard(int cardNumber, String cardName) {
       Boolean result = libraryCardDAO.saveLibraryCard(cardNumber, cardName);
       if(result==true){
           return "Library card  with card number : "+cardNumber+" is registered succsesfully";
       }else{
           return "Library card  with card number : "+cardNumber+" is not  registered succsesfully";
       }
    }
}

