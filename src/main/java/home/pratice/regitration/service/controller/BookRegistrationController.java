package home.pratice.regitration.service.controller;

import home.pratice.domain.Book;
import home.pratice.service.BookRegistrationService;

import java.util.ArrayList;
import java.util.List;

public class BookRegistrationController {
    private BookRegistrationService bookRegistrationService;

    public BookRegistrationController() {
        bookRegistrationService = new BookRegistrationService();
    }

    public Book getDetailsOfBook(Long bookId) {
        Book book = bookRegistrationService.getBook(bookId);
        return book;
    }

    public String registerBook(int bookId, String name) {
        String result = bookRegistrationService.registerBook(bookId, name);
        return result;
    }

    public static void main(String[] args) {
        BookRegistrationController controller = new BookRegistrationController();
        List<Book> books = new ArrayList<>();
        Book book = null;
        for (int i = 0; i < 10; i++) {
            book = new Book();
            book.setBookName("Book-Name-" + i + 10);
            book.setBookNumber(i + 10);
            books.add(book);
        }
        for (Book bookToBeRegistered : books) {
            String response = controller.registerBook(bookToBeRegistered.getBookNumber(), bookToBeRegistered.getBookName());
            System.out.println(response);
        }
    }
}
