package home.pratice.service;

import home.pratice.dao.implimentation.LibraryCardWithH2;
import home.pratice.design.pattern.dao.LibraryCardDAO;
import home.pratice.domain.LibraryCard;

public class LibraryCardRegistrationService {
    private LibraryCardDAO libraryCardDAO;

    public LibraryCardRegistrationService(){
        libraryCardDAO = new LibraryCardWithH2();

    }
    public LibraryCard getLibraCard(Long cardId){
        LibraryCard libraryCard =libraryCardDAO.getLibraryCard(cardId);
        return libraryCard;
    }

    public void registerLibraryCard(int cardNumber,String cardName){
        libraryCardDAO.saveLibraryCard(cardNumber,cardName);
    }

}

