package home.pratice.design.pattern.dao;

import home.pratice.domain.Book;

public interface BookDAO {
    Book getBook(Long bookId);

    Boolean saveBook(int bookId, String bookName, String autherName, String  isbnNumber);

    Boolean deleteBook(Long bookId);

    void updateBook(Book book);

    public void getBookByAuthorName(String authorName);


    void getBookByBookName(String bookName);
}
