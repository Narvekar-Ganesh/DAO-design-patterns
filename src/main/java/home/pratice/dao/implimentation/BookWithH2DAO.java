package home.pratice.dao.implimentation;

import home.pratice.design.pattern.dao.BookDAO;
import home.pratice.domain.Book;
import home.pratice.utillities.DatabaseHibernateUtility;
import org.hibernate.Session;

import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public class BookWithH2DAO implements BookDAO {
    public Book getBook(Long bookId) {
        Session session = DatabaseHibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Book book = (Book) session.byId(Book.class).load((Long) bookId);
        session.getTransaction().commit();
        return book;
    }

    @Override
    public Boolean saveBook(int bookId, String bookName, String autherName, String isbnNumber) {
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
//        session.update(book);
        session.getTransaction().commit();
    }

    public void getBookByBookName(String bookName) {
        Session session = DatabaseHibernateUtility.getSessionFactory().openSession();
        Query query = session.createNamedQuery("getBooksByBookName", Book.class);
        query.setParameter("bookName", bookName);
        List resultList = query.getResultList();
        List<Book> books = (List<Book>) resultList;
        System.out.println("books from database using named query : " + books);
    }

    public void getBookByAuthorName(String authorName) {
        Session session = DatabaseHibernateUtility.getSessionFactory().openSession();
        Query query = session.createNamedQuery("getBooksByAuthorName", Book.class);
        query.setParameter("autherName", authorName);
        List resultList = query.getResultList();
        List<Book> books = (List<Book>) resultList;
        System.out.println("books from database using named query : " + books);
    }
}
