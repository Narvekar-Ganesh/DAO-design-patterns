package home.pratice.dao.implimentation;

import home.pratice.design.pattern.dao.BookDAO;
import home.pratice.domain.Book;
import home.pratice.utillities.DatabaseHibernateUtility;
import org.hibernate.Session;

import java.io.Serializable;

public class BookWithH2DAO implements BookDAO {
    public Book getBook(Long bookId) {
        Session session = DatabaseHibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Book book = (Book) session.byId(Book.class).load((Long) bookId);
        session.getTransaction().commit();
        return book;
    }

    @Override
    public Boolean saveBook(int bookId, String bookName) {
        Book book = new Book();
        book.setBookNumber(bookId);
        book.setBookName(bookName);
        Session session = DatabaseHibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Serializable savedId = session.save(book);
        Long primaryKey = (Long) savedId;
        session.getTransaction().commit();
        if (primaryKey != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean deleteBook(Long bookId) {
        Session session = DatabaseHibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Book bookFromDatabase = session.byId(Book.class).load((Long) bookId);
        if (bookFromDatabase != null) {
            session.delete(bookFromDatabase);
            session.getTransaction().commit();
            return true;
        } else {
            return false;
        }
    }


    @Override
    public void updateBook(Book book) {
        Session session = DatabaseHibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(book);
        session.getTransaction().commit();
    }
}
