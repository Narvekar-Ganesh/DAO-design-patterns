package home.pratice.dao.implimentation;

import home.pratice.design.pattern.dao.BookDAO;
import home.pratice.domain.Book;
import home.pratice.utillities.DatabaseHibernateUtility;
import org.hibernate.Session;

public class BookWithH2 implements BookDAO {
    public Book getBook(Long bookId){
        Session session = DatabaseHibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Book book = (Book)session.byId(Book.class).load((Long)bookId);;
        session.getTransaction().commit();;
         return book;

    }
    @Override
    public void saveBook(int bookId ,String bookName){
        Book book = new Book();
        book.setBookNumber(bookId);
        book.setBookName(bookName);
        Session session = DatabaseHibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();;
        System.out.println("Book persisted succssefully");
    }

}
