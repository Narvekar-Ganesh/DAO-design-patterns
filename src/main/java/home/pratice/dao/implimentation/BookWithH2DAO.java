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

    public List<Book> getBookByBookName(String bookName) {
        Session session = DatabaseHibernateUtility.getSessionFactory().openSession();
        Query query = session.createNamedQuery("getBooksByBookName", Book.class);
        query.setParameter("bookName", bookName);
        List resultList = query.getResultList();
        List<Book> books = (List<Book>) resultList;
        return books;
    }

    public List<Book> getBookByAuthorName(String authorName) {
        Session session = DatabaseHibernateUtility.getSessionFactory().openSession();
        Query query = session.createNamedQuery("getBooksByAuthorName", Book.class);
        query.setParameter("autherName", authorName);
        List resultList = query.getResultList();
        List<Book> books = (List<Book>) resultList;
        System.out.println("books from database using named query : " + books);
        return books;
    }

    public List<Book> getAllBooks() {
        Session session = DatabaseHibernateUtility.getSessionFactory().openSession();
        Query query = session.createNamedQuery("getAllBooks", Book.class);
        List resultList = query.getResultList();
        List<Book> books = (List<Book>) resultList;
        return books;
    }

    public void updateEachBookWithPrice(Book book) {
        Session session = DatabaseHibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
//        Query query = session.createName9+dQuery("updateGivenBookWithDefaultPrice", Book.class);
        Query query = session.createQuery("update Book book " +
                "set book.price=0.  0 " +
                "Where book.bookId = :bookId");
        query.setParameter("bookId", book.getBookId());
        query.executeUpdate();

        session.getTransaction().commit();
    }

    @Override
    public Book  updateBookAutherNameWithBookName(String bookName, String AutherName) {
        String message = null;
        Session session=DatabaseHibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createNamedQuery("update Book book"+
                "set book.autherName=Krishna" +
                "Where book.bookName=:bookName");
        int result =query.executeUpdate();
        if (result>0){
            message =  result + " books are updated";
        } else {
            message= "Books are not updated";
        }
        session.getTransaction().commit();
        return null;//TODO
    }
}


