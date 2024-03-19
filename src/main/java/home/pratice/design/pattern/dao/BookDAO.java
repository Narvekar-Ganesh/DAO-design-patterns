package home.pratice.design.pattern.dao;

import home.pratice.domain.Book;

public interface BookDAO {
    Book getBook(Long bookId);

    Boolean saveBook(int bookId, String bookName);

    Boolean deleteBook(Long bookId);

    void updateBook(Book book);
}
