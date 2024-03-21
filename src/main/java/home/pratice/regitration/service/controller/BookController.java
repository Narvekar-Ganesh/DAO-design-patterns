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

    public String registerBook(int bookId, String name, String autherName, String isbnNumber) {
        String result = bookRegistrationService.registerBook(bookId, name, autherName, isbnNumber);
        return result;
    }

    public String deleteBook(Long bookId) {
        return bookRegistrationService.deleteBook(bookId);
    }

    public String updateBook(Long bookId, String name) {
        return bookRegistrationService.updateBook(bookId, name);
    }

    public List<Book> getBookByAuthorName(String authorName) {
        return bookRegistrationService.getBooksByAuthorName(authorName);
    }

    public List<Book> getBooksByBookName(String bookName) {
        return bookRegistrationService.getBookByBookName(bookName);

    }

    public static void main(String[] args) {
//        doBookRegistration();
//        deleteGivenBook();
//        updateGivenBook(54L, "Sahil");
        getBookByAuthorName();
//        getBooksByBookName();

    }

    private static void getBookByAuthorName() {
        BookController bookController = new BookController();
        String bookName = "SHA";
        bookController.getBookByAuthorName("bookName");
        List<Book> books = bookController.getBookByAuthorName(bookName);
        for (Book book : books) {
            System.out.println("Each Auther's details are" + book);
        }
        if (books.isEmpty()) {
            System.out.println("Auther not found in databas");
        } else {
            System.out.println(books.size() + " Auther found in database for Book" + bookName);
        }
    }

    private static void getBooksByBookName() {
        String author = "Siddhu";
        BookController bookController = new BookController();
        List<Book> books = bookController.getBooksByBookName(author);

        for (Book book : books) {
            System.out.println(" Each book's details are :  " + book);
        }
        if (books.isEmpty()) {
            System.out.println("books not found in database");
        } else {
            System.out.println(books.size() + "  books found in database for author :  " + author);
        }
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
            book.setAutherName("Auther_name-" + i + 10);
            book.getIsbnNumber();
            books.add(book);
        }
        for (Book bookToBeRegistered : books) {
            String response = controller.registerBook(bookToBeRegistered.getBookNumber(), bookToBeRegistered.getBookName(), bookToBeRegistered.getAutherName(), bookToBeRegistered.getIsbnNumber());
            System.out.println(response);
        }
    }
}
