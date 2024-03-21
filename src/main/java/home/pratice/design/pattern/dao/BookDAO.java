package home.pratice.design.pattern.dao;

import home.pratice.domain.Book;

import java.util.List;

public interface BookDAO {
    Book getBook(Long bookId);

    Boolean saveBook(int bookId, String bookName, String autherName, String  isbnNumber);

    Boolean deleteBook(Long bookId);

    void updateBook(Book book);

    List<Book> getBookByAuthorName(String authorName);


     List<Book> getBookByBookName(String bookName);
}
