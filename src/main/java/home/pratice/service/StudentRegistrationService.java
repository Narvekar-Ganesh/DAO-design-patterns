package home.pratice.service;

import home.pratice.dao.implimentation.StudentWithH2DAO;
import home.pratice.design.pattern.dao.StudentDAO;
import home.pratice.domain.Student;

public class StudentRegistrationService {
    private StudentDAO studentDAO; //has-a relationship

    public StudentRegistrationService(){
        studentDAO = new StudentWithH2DAO(); //is-a relationship - Dependency-injection
    }

    public Student getStudent(int rollNumber){
        Student student = studentDAO.getStudent(rollNumber);
        return student;
    }
    public String  registerStudent(int rollNumber , String name){
       Boolean result=  studentDAO.saveStudent(rollNumber,name) ;
        if(result){
            return"Student with student name:" + name + "is registered succssefully";
        }else {
            return"Student with student name:" + name + "is not registered";
        }
    }
    public String deleteStudent(Long studentId){
        Boolean result= studentDAO.deleteStudent(studentId);
            if (result){
                 return "Requested student is deleted sucssefully";
            }else{
                return "Requested student is not deleted ";
            }

    }

}


