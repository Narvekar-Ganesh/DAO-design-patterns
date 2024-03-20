package home.pratice.regitration.service.controller;

import home.pratice.domain.Book;
import home.pratice.service.BookRegistrationService;

import java.util.ArrayList;
import java.util.List;

public class BookController {
    private BookRegistrationService bookRegistrationService;

    public BookController() {
        bookRegistrationService = new BookRegistrationService();
    }

    public Book getDetailsOfBook(Long bookId) {
        Book book = bookRegistrationService.getBook(bookId);
        return book;
    }

    public String registerBook(int bookId, String name,String autherName, String  isbnNumber) {
        String result = bookRegistrationService.registerBook(bookId, name, autherName,isbnNumber);
        return result;
    }

    public String deleteBook(Long bookId) {
        return bookRegistrationService.deleteBook(bookId);
    }

    public String updateBook(Long bookId, String name) {
        return bookRegistrationService.updateBook(bookId, name);
    }

    public static void main(String[] args) {
        doBookRegistration();
//        deleteGivenBook();
//        updateGivenBook(54L, "Sahil");
    }

    private static void updateGivenBook(Long bookId, String bookName) {
        BookController controller = new BookController();
        controller.updateBook(bookId, bookName);
    }

    private static void deleteGivenBook() {
        BookController controller = new BookController();
        System.out.println(controller.deleteBook(114L));
    }

    private static void doBookRegistration() {
        BookController controller = new BookController();
        List<Book> books = new ArrayList<>();
        Book book = null;
        for (int i = 0; i < 10; i++) {
            book = new Book();
            book.setBookName("Book-Name-" + i + 10);
            book.setBookNumber(i + 10);
            book.setAutherName("Auther_name-"+i+10);
            book.getIsbnNumber();
            books.add(book);
        }
        for (Book bookToBeRegistered : books) {
            String response = controller.registerBook(bookToBeRegistered.getBookNumber(), bookToBeRegistered.getBookName(),bookToBeRegistered.getAutherName(),bookToBeRegistered.getIsbnNumber());
            System.out.println(response);
        }
    }
}
