package home.pratice.service;

import home.pratice.dao.implimentation.StudentWithPoseGresDAOImpl;
import home.pratice.design.pattern.dao.StudentDAO;
import home.pratice.domain.Student;

public class StudentRegistrationService {
    private StudentDAO studentDAO; //has-a relationship

    public StudentRegistrationService(){
        studentDAO = new StudentWithPoseGresDAOImpl(); //is-a relationship - Dependency-injection
    }

    public Student getStudent(int rollNumber){
        Student student = studentDAO.getStudent(rollNumber);
        return student;
    }
    public void registerStudent(int rollNumber , String name){
        studentDAO.saveStudent(rollNumber,name) ;

    }
}
