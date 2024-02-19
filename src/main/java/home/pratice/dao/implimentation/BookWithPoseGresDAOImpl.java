package home.pratice.dao.implimentation;

import home.pratice.design.pattern.dao.BookDAO;
import home.pratice.domain.Book;
import home.pratice.utillities.DatabaseHibernateUtility;
import org.hibernate.Session;

public class BookWithPoseGresDAOImpl implements BookDAO {
    public Book getBook(int bookId){
        Book book =new Book();
        book.setBookNumber(789);
        book.setBookName("PoseGressBook");
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
        System.out.println("Student persisted succssefully");
    }

}
