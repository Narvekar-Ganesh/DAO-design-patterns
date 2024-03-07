package home.pratice.design.pattern.dao;

import home.pratice.domain.Book;

public interface BookDAO {
    Book getBook(Long bookId);
    void saveBook(int bookId ,String bookName);
}
