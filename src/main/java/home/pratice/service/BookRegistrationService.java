package home.pratice.service;

import home.pratice.dao.implimentation.BookWithH2;
import home.pratice.design.pattern.dao.BookDAO;
import home.pratice.domain.Book;


public class BookRegistrationService {
    private BookDAO bookDAO;

    public BookRegistrationService() {
        bookDAO = new BookWithH2();

    }

    public Book getBook(int bookId) {
         Book book =bookDAO.getBook(bookId);
        return book ;//TODO

    }

    public void registerBook(int bookId, String name) {
        bookDAO.saveBook(bookId, name);
    }
}
