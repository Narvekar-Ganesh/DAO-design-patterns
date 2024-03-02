package home.pratice.design.pattern.dao;

import home.pratice.domain.Book;

public interface BookDAO {
    Book getBook(int bookId);
    void saveBook(int bookId ,String bookName);
}
