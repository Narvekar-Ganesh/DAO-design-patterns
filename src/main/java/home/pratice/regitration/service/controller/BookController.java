package home.pratice.regitration.service.controller;

import home.pratice.domain.Book;
import home.pratice.service.BookRegistrationService;
import home.pratice.comparator.BookNumberComparator;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@NoArgsConstructor
@Setter
@Getter
@Data
public class BookController {
    private BookRegistrationService     bookRegistrationService;


    public Book getDetailsOfBook(Long bookId) {
        Book book = bookRegistrationService.getBook(bookId);
        return book;
    }

    public String registerBook(int bookId, String name, String autherName, String isbnNumber) {
        String result = bookRegistrationService.registerBook(bookId, name, autherName, isbnNumber);
        return result;
    }

    public String deleteBook(Long bookId) {
        return bookRegistrationService.deleteBook(bookId);
    }

    public String updateBook(Long bookId, String name) {
        return bookRegistrationService.updateBook(bookId, name);
    }

    public List<Book> getBookByAuthorName(String authorName) {
        return bookRegistrationService.getBooksByAuthorName(authorName);
    }

    public List<Book> getBooksByBookName(String bookName) {
        return bookRegistrationService.getBookByBookName(bookName);

    }

    public List<Book> getAllBook() {
        return bookRegistrationService.getAllBooks();
    }

    public void updateAllBooksWithDefaultPriceAsZero(){
        bookRegistrationService.updateAllBooksWithDefaultPrice();
    }

    public void  updateBookAutherNameWithBookName(String bookName,String autherName){
        bookRegistrationService.updateAllBooksWithDefaultPrice();
    }

//    public void updateAllBooksWithDefoultPrice(){
////        return boo;
//    }

    public static void main(String[] args) {
//        doBookRegistration();
//        deleteGivenBook();
//        updateGivenBook(54L, "Sahil");
//        getBookByAuthorName();
//        getAllBooks();
//        sortBookByBookNumberInAscendingOrder();
        updateAllBooksWithDefaultPrice();
    }

    private static void getBookByAuthorName() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:book-config.xml");
        BookController bookController = applicationContext.getBean("bookController", BookController.class);
        String bookName = "ABC";
        bookController.getBookByAuthorName("bookName");
        List<Book> books = bookController.getBookByAuthorName(bookName);
        for (Book book : books) {
            System.out.println("Each Auther's details are" + book);
        }
        if (books.isEmpty()) {
            System.out.println("Auther not found in database");
        } else {
            System.out.println(books.size() + " Auther found in database for Book" + bookName);
        }

    }

    private static void getBooksByBookName() {
        String author = "Siddhu";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:book-config.xml");
        BookController bookController = applicationContext.getBean("bookController", BookController.class);
        List<Book> books = bookController.getBooksByBookName(author);

        for (Book book : books) {
            System.out.println(" Each book's details are :  " + book);
        }
        if (books.isEmpty()) {
            System.out.println("books not found in database");
        } else {
            System.out.println(books.size() + "  books found in database for author :  " + author);
        }
    }

    private static void getAllBooks() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:book-config.xml");
        BookController bookController = applicationContext.getBean("bookController", BookController.class);
        List<Book> books = bookController.getAllBook();

        for (Book book : books) {
            System.out.println("Each Book - " + book);
        }
    }

    private static void updateAllBooksWithDefaultPrice(){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:book-config.xml");
        BookController bookController = applicationContext.getBean("bookController", BookController.class);
        bookController.updateAllBooksWithDefaultPriceAsZero();
    }


    private static void updateGivenBook(Long bookId, String bookName) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:book-config.xml");
        BookController bookController = applicationContext.getBean("bookController", BookController.class);
        bookController.updateBook(bookId, bookName);
    }

    private static void updateBookAutherNameWithBookName(){
        String bookName = "Book-Name-310";
        String autherName ="Krishna";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:book-config.xml");
        BookController bookController = applicationContext.getBean("bookController", BookController.class);
        bookController.updateBookAutherNameWithBookName(bookName,autherName);
    }

    private static void deleteGivenBook() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:book-config.xml");
        BookController bookController = applicationContext.getBean("bookController", BookController.class);
        System.out.println(bookController.deleteBook(114L));
    }

    private static void doBookRegistration() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:book-config.xml");
        BookController bookController = applicationContext.getBean("bookController", BookController.class);
        List<Book> books = new ArrayList<>();
        Book book = null;
        for (int i = 0; i < 10; i++) {
            book = new Book();
            book.setBookName("Book-Name-" + i + 10);
            book.setBookNumber(i + 10);
            book.setAutherName("Auther_name-" + i + 10);
            book.getIsbnNumber();
            books.add(book);
        }
        for (Book bookToBeRegistered : books) {
            String response = bookController.registerBook(bookToBeRegistered.getBookNumber(), bookToBeRegistered.getBookName(), bookToBeRegistered.getAutherName(), bookToBeRegistered.getIsbnNumber());
            System.out.println(response);
        }
    }

    private static void removeDuplicateBooksByAuthorName() {
        String author = "ABC";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:book-config.xml");
        BookController bookController = applicationContext.getBean("bookController", BookController.class);
        List<Book> books = bookController.getBookByAuthorName(author);

        Set<Book> bookHashSet = new HashSet<>();
        for (Book book : books) {
            boolean result = bookHashSet.add(book);
            System.out.println(result);
            if (result == false) {
                String duplicateElement = bookController.deleteBook(book.getBookId());
                System.out.println("Duplicate Elements are :" + duplicateElement);
            }
        }
    }

    private static void sortBookByBookNumberInAscendingOrder() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:book-config.xml");
        BookController bookController = applicationContext.getBean("bookController", BookController.class);
        List<Book> books = bookController.getBookByAuthorName("ABC");
        BookNumberComparator bookNumberComarator = new BookNumberComparator();
        books.sort(bookNumberComarator);

        System.out.println("Sort Books By book name" + books);

    }
}
