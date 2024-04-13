package home.pratice.spring.runner;

import home.pratice.domain.Book;
import home.pratice.domain.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookSpringRunner {
    public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:book-config.xml");
//        Book book = applicationContext.getBean("book", Book.class);//1st call to spring bean - book
//        book.setBookNumber(124563); // changed the attributes
//        book.setAutherName("Siddhu");
//        book.setBookId(85969L);
//        System.out.println(book.toString());
//        System.out.println(book.getBookId());
//        System.out.println(book.getAutherName());

//        Book book1 = applicationContext.getBean("book",Book.class);//2nd call to the same spring bean - book
//        book.setBookNumber(88888); // changed the attributes
//        book.setAutherName("Sahahshsshs");
//        book.setBookId(88888L);
//        System.out.println(book1.toString());
//        System.out.println(book1.getBookId());
//        System.out.println(book1.getAutherName());
////        System.out.println(book.getPrices());
//
//        Student student = applicationContext.getBean("student", Student.class);
//        System.out.println(student);


        /****
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("student-config.xml");
        Book book = applicationContext.getBean("book", Book.class);
        book.setBookNumber(4444);
        System.out.println(book.hashCode());
        System.out.println(book.getBookNumber());



        ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("book-config.xml");
        Book book1  = applicationContext1.getBean("book",Book.class);
        System.out.println(book1.hashCode());
        System.out.println(book1.getBookNumber());
***/


        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("book-config.xml");
        Book book =  applicationContext.getBean("book",Book.class);
        System.out.println(book.hashCode());




        ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("book-config.xml");
        Book book1 = applicationContext1.getBean("book",Book.class);
        System.out.println(book1.hashCode());
    }
}

//ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:book-config.xml");
//Book book = applicationContext.getBean("book", Book.class);
