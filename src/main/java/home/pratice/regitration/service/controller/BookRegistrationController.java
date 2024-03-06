package home.pratice.regitration.service.controller;

import home.pratice.design.pattern.dao.BookDAO;
import home.pratice.domain.Book;
import home.pratice.service.BookRegistrationService;

public class BookRegistrationController {
    private BookRegistrationService bookRegistrationService;

    public BookRegistrationController(){
        bookRegistrationService = new BookRegistrationService();
    }

    public Book getDetailsOfBook(int bookId) {
        Book book = bookRegistrationService.getBook(bookId);
        return book;
    }
    public void registerBook(int bookId,String name){
        bookRegistrationService.registerBook(bookId,name);


    }
    public static void main(String[] args){
        BookRegistrationController controller =new BookRegistrationController();

        Book book = controller.getDetailsOfBook(789);
        System.out.println("Details of Book"+book);

        controller.registerBook(789,"Geeta");



    }
}
