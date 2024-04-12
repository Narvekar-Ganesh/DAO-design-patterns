package home.pratice.spring.runner;

import home.pratice.domain.Book;
import home.pratice.domain.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookSpringRunner {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:book-config.xml");
        Book book = applicationContext.getBean("book", Book.class);

//        System.out.println(book.getPrices());

        Student student = applicationContext.getBean("student", Student.class);
        System.out.println(student);

    }
}
