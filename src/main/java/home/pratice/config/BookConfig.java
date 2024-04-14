package home.pratice.config;

import home.pratice.dao.implimentation.BookWithH2DAO;
import home.pratice.domain.Book;
import home.pratice.regitration.service.controller.BookController;
import home.pratice.service.BookRegistrationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfig {

    /**
     * <bean id="book" class="home.pratice.domain.Book">
     *         <property name="bookId" value="112233"/>
     *         <property name="bookNumber" value="159"></property>
     *         <property name="bookName" value="Spring boot refernce"></property>
     *         <property name="autherName" value="Dvan Syer"></property>
     *         <property name="isbnNumber" value="765456"></property>
     * </bean >
     */
    @Bean
    public Book book(){
        Book book = new Book();
        book.setBookId(112233L);
        book.setBookNumber(159);
        book.setBookName("Spring boot refernce");
        book.setAutherName("Dvan Syer");
        book.setIsbnNumber("765456");
        return book; //TODO
    }

    /**
     * <bean id="bookDAO" class="home.pratice.dao.implimentation.BookWithH2DAO">
     *  </bean>
     */
    @Bean
    public BookWithH2DAO bookDAO(){
        BookWithH2DAO bookWithH2DAO = new BookWithH2DAO();
        return bookWithH2DAO;
    }

    /**
     *     <bean id ="bookRegistrationService" class="home.pratice.service.BookRegistrationService">
     *         <property name="bookDAO" ref="bookDAO"></property>
     *     </bean>
     */
    @Bean
    public BookRegistrationService bookRegistrationService(){
        BookRegistrationService bookRegistrationService = new BookRegistrationService();
        bookRegistrationService.setBookDAO(bookDAO());
        return  bookRegistrationService;
    }

    /**
     * <bean id="bookController" class ="home.pratice.regitration.service.controller.BookController">
     *         <property name="bookRegistrationService" ref="bookRegistrationService"></property>
     *     </bean>
     */
    @Bean
    public BookController bookController(){
        BookController bookController= new BookController();
            bookController.setBookRegistrationService(bookRegistrationService());
        return bookController;
    }
}
