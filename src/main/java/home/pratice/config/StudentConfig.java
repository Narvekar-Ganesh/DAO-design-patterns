package home.pratice.config;

import home.pratice.dao.implimentation.BookWithH2DAO;
import home.pratice.dao.implimentation.StudentWithH2DAO;
import home.pratice.domain.Student;
import home.pratice.regitration.service.controller.StudentController;
import home.pratice.service.StudentRegistrationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {


    /***
     * <bean id="student" class="home.pratice.domain.Student">
     *         <property name="rollNumber" value="21"></property>
     *         <property name="name" value="Krish"></property>
     *         <property name="gender" value="Male"></property>
     *         <property name="addresLine1" value="Mathura Anath Ashram"></property>
     *         <property name="addresLine2" value="Mathura"></property>
     *     </bean>
     */
    @Bean
    public Student student(){
        Student student = new Student();
        student.setRollNumber(21);
        student.setName("Krishana");
        student.setGender("male");
        student.setAddresLine1("Mathura anath ashram");
        student.setAddresLine2("MAthura");
        return student;



    }
    /**
     * <bean id="studentDAO" class="home.pratice.dao.implimentation.StudentWithH2DAO">
     */
    @Bean
    public StudentWithH2DAO studentDAO(){
        StudentWithH2DAO studentWithH2DAO = new StudentWithH2DAO();
        return null;
    }

    /**
     * <bean id="studentRegistrationService" class="home.pratice.service.StudentRegistrationService">
     *         <property name="studentDAO" ref="studentDAO"/>
     *     </bean>
     */
    @Bean
    public StudentRegistrationService studentRegistrationService(){
        StudentRegistrationService studentRegistrationService= new StudentRegistrationService();
        studentRegistrationService.setStudentDAO(studentDAO());

        return  studentRegistrationService;
    }

    /**
     *  </bean >
     *     <bean id="studentController" class="home.pratice.regitration.service.controller.StudentController">
     *         <property name="studentRegistrationService" ref="studentRegistrationService"/>
     *     </bean>
     ***/

    @Bean
    public StudentController studentController(){
        StudentController studentController= new StudentController();
        studentController.setStudentRegistrationService(studentRegistrationService());
        return studentController;

    }

}
