package home.pratice.service;

import home.pratice.dao.implimentation.BookWithH2DAO;
import home.pratice.design.pattern.dao.BookDAO;
import home.pratice.domain.Book;


public class BookRegistrationService {
    private BookDAO bookDAO;

    public BookRegistrationService() {
        bookDAO = new BookWithH2DAO();
    }

    public Book getBook(Long bookId) {
        Book book = bookDAO.getBook(bookId);
        return book;
    }

    public String registerBook(int bookId, String name) {
        Boolean result = bookDAO.saveBook(bookId, name);
        if (result) {
            return "Book with book name:" + name + "is registered succssefully";
        } else {
            return "Book with book name:" + name + "is not  registered succsefully";
        }
    }

    public String deleteBook(Long bookId){
       Boolean result= bookDAO.deleteBook(bookId);
       if(result){
           return "Requested book is deleted sucssefully";
       }else{
           return "Requested book is not deleted ";
       }

    }
}
