package home.pratice.design.pattern.dao;

public interface BookDAO {
    void getBook(int bookId);
    void saveBook(int bookId ,String bookName);
}
