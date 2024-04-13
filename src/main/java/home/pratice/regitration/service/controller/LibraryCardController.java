package home.pratice.regitration.service.controller;

import home.pratice.domain.LibraryCard;
import home.pratice.service.LibraryCardService;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Data

public class LibraryCardController {
    private LibraryCardService libraryCardService;

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
//        deRegistration();
        deleteLibraryCard();
    }

    public static void deleteLibraryCard() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("library-card-config.xml");
        LibraryCardController libraryCardController = applicationContext.getBean("libraryCardController",LibraryCardController.class);
        System.out.println(libraryCardController.deleteLibraryCard(44L));
    }

    private static void deRegistration() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("library-card-config.xml");
        LibraryCardController libraryCardController = applicationContext.getBean("libraryCardController",LibraryCardController.class);
        List<LibraryCard> libraryCards = new ArrayList<>();
        LibraryCard libraryCard = null;
        for (int i = 0; i < 10; i++) {
            libraryCard = new LibraryCard();
            libraryCard.setCardName("LibraryCard-Name" + i + 10);
            libraryCard.setCardNumber(i + 10);
            libraryCards.add(libraryCard);
        }
        for (LibraryCard libraryCardToBeRegister : libraryCards) {

            String response = libraryCardController.registerLibraryCard(libraryCardToBeRegister.getCardNumber(), libraryCardToBeRegister.getCardName());
            System.out.println(response);
        }
    }
}
