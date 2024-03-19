package home.pratice.regitration.service.controller;

import home.pratice.domain.LibraryCard;
import home.pratice.service.LibraryCardService;

import java.util.ArrayList;
import java.util.List;

public class LibraryCardController {
    private LibraryCardService libraryCardService;

    public LibraryCardController() {
        libraryCardService = new LibraryCardService();
    }

    public LibraryCard getDetailsofLibraryCard(Long cardId) {
        LibraryCard libraryCard = libraryCardService.getLibraCard(cardId);
        return libraryCard;
    }

    public String registerLibraryCard(int cardNumber, String cardName) {
        String result = libraryCardService.registerLibraryCard(cardNumber, cardName);
        return result;
    }

    public String deleteLibraryCard(Long libraryCardId) {
        return libraryCardService.deleteLibraryCard(libraryCardId);
    }

    public static void main(String[] args) {
        deRegistration();
    }

    public static void deleteLibraryCard() {
        LibraryCardController controller = new LibraryCardController();
        System.out.println(controller.deleteLibraryCard(44L));
    }

    private static void deRegistration() {
        LibraryCardController controller = new LibraryCardController();
        List<LibraryCard> libraryCards = new ArrayList<>();
        LibraryCard libraryCard = null;
        for (int i = 0; i < 10; i++) {
            libraryCard = new LibraryCard();
            libraryCard.setCardName("LibraryCard-Name" + i + 10);
            libraryCard.setCardNumber(i + 10);
            libraryCards.add(libraryCard);
        }
        for (LibraryCard libraryCardToBeRegister : libraryCards) {

            String response = controller.registerLibraryCard(libraryCardToBeRegister.getCardNumber(), libraryCardToBeRegister.getCardName());
            System.out.println(response);
        }
    }
}
