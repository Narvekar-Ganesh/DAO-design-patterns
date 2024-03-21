package home.pratice.service;

import home.pratice.dao.implimentation.BookWithH2DAO;
import home.pratice.design.pattern.dao.BookDAO;
import home.pratice.domain.Book;

import java.util.List;


public class BookRegistrationService {
    private BookDAO bookDAO;

    public BookRegistrationService() {
        bookDAO = new BookWithH2DAO();
    }

    public Book getBook(Long bookId) {
        Book book = bookDAO.getBook(bookId);
        return book;
    }

    public String registerBook(int bookId, String name, String autherName, String isbnNumber) {
        Boolean result = bookDAO.saveBook(bookId, name, autherName,isbnNumber  );
        if (result) {
            return "Book with book name:" + name + "is registered succssefully";
        } else {
            return "Book with book name:" + name + "is not  registered succsefully";
        }
    }

    public String deleteBook(Long bookId) {
        Boolean result = bookDAO.deleteBook(bookId);
        if (result) {
            return "Requested book is deleted successfully";
        } else {
            return "Requested book is not deleted";
        }
    }

    public String updateBook(Long bookId, String nameToBeUpdated) {
        Book bookToBeUpdated = bookDAO.getBook(bookId);
        if (bookToBeUpdated != null) {
            bookToBeUpdated.setBookName(nameToBeUpdated);
//            bookDAO.updateBook(bookToBeUpdated);
            return "book is updated successfully";

        } else {
            return "book is not updated ";
        }

//        bookToBeUpdated.setBookName(nameToBeUpdated);
//        bookDAO.updateBook(bookToBeUpdated);
//
//        return "book is updated successfully";
    }

    public List<Book> getBooksByAuthorName(String authorName){
       return bookDAO.getBookByAuthorName(authorName);
    }

    public List<Book> getBookByBookName(String bookName){
       return bookDAO.getBookByBookName(bookName);
    }
}
