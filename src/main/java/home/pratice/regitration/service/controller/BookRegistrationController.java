package home.pratice.regitration.service.controller;

import home.pratice.domain.Book;
import home.pratice.service.BookRegistrationService;

public class BookRegistrationController {
    private BookRegistrationService bookRegistrationService;

    public BookRegistrationController() {
        bookRegistrationService = new BookRegistrationService();
    }

    public Book getDetailsOfBook(Long bookId) {
        Book book = bookRegistrationService.getBook(bookId);
        return book;
    }

    public void registerBook(int bookId, String name) {
        bookRegistrationService.registerBook(bookId, name);

    }

    public static void main(String[] args) {
        BookRegistrationController controller = new BookRegistrationController();
        controller.registerBook(789, "Geeta");
        Book book = controller.getDetailsOfBook(1L);
        System.out.println("Details of Book" + book);
    }
}
