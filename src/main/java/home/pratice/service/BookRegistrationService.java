package home.pratice.service;

import home.pratice.dao.implimentation.BookWithH2DAO;
import home.pratice.design.pattern.dao.BookDAO;
import home.pratice.domain.Book;


public class BookRegistrationService {
    private BookDAO bookDAO;

    public BookRegistrationService() {
        bookDAO = new BookWithH2DAO();
    }

    public Book getBook(Long bookId) {
        Book book = bookDAO.getBook(bookId);
        return book;
    }

    public void registerBook(int bookId, String name) {
        bookDAO.saveBook(bookId, name);
    }
}
