package home.pratice.regitration.service.controller;

import home.pratice.domain.LibraryCard;
import home.pratice.service.LibraryCardService;

public class LibraryCardController {
    private LibraryCardService libraryCardService;

    public LibraryCardController() {
        libraryCardService = new LibraryCardService();
    }

    public LibraryCard getDetailsofLibraryCard(Long cardId) {
        LibraryCard libraryCard = libraryCardService.getLibraCard(cardId);
        return libraryCard;

    }

    public void registerLibraryCard(int cardNumber, String cardName) {
       String result= libraryCardService.registerLibraryCard(cardNumber, cardName);
        System.out.println(result);
    }

    public static void main(String[] args) {
        LibraryCardController controller = new LibraryCardController();
        controller.registerLibraryCard(123, "Classic");
        LibraryCard libraryCard = controller.getDetailsofLibraryCard(0L);
        System.out.println("Details of library" + libraryCard);
    }
}
