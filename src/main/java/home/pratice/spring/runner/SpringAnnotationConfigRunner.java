package home.pratice.spring.runner;

import home.pratice.config.BookConfig;
import home.pratice.config.StudentConfig;
import home.pratice.domain.Book;
import home.pratice.regitration.service.controller.BookController;
import home.pratice.regitration.service.controller.StudentController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAnnotationConfigRunner {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BookConfig.class);
//        Book book = applicationContext.getBean("book", Book.class);
//        System.out.println(book);
        BookController bookController = applicationContext.getBean("bookController" , BookController.class);
        System.out.println(bookController.getAllBook());


        ApplicationContext applicationContext1= new AnnotationConfigApplicationContext(StudentConfig.class);
        StudentController studentController = applicationContext1.getBean("studentController",StudentController.class);
//        System.out.println(studentController.);
    }
}
