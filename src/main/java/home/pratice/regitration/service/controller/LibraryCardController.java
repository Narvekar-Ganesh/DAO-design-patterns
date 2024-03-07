package home.pratice.regitration.service.controller;

//import home.pratice.design.pattern.dao.LibraryCardDAO;
import home.pratice.domain.LibraryCard;
import home.pratice.service.LibraryCardRegistrationService;

public class LibraryCardController {
    private LibraryCardRegistrationService libraryCardRegistrationService;

    public LibraryCardController(){
        libraryCardRegistrationService =new LibraryCardRegistrationService();
    }

    public LibraryCard getDetailsofLibraryCard(Long cardId){
        LibraryCard libraryCard = libraryCardRegistrationService.getLibraCard(cardId);
        return libraryCard;

    }

    public void registerLibraryCard(int cardNumber,String cardName){
        libraryCardRegistrationService.registerLibraryCard(cardNumber,cardName);
    }

    public static void main(String [] args){
        LibraryCardController controller = new LibraryCardController();
//        controller.registerLibraryCard(123,"Classic");
        LibraryCard libraryCard = controller.getDetailsofLibraryCard(0L);
        System.out.println("Details of library"+libraryCard);


    }
}
