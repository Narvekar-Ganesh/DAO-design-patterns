package home.pratice.service;

import home.pratice.dao.implimentation.StudentWithH2DAO;
import home.pratice.design.pattern.dao.StudentDAO;
import home.pratice.domain.LibraryCard;
import home.pratice.domain.Student;

public class StudentRegistrationService {
    private StudentDAO studentDAO; //has-a relationship

    public StudentRegistrationService() {
        studentDAO = new StudentWithH2DAO(); //is-a relationship - Dependency-injection
    }

    public Student getStudent(Long studentId) {
        Student student = studentDAO.getStudent(studentId);
        return student;
    }

    public String registerStudent(int rollNumber, String name) {
        Student student = prepareStudent(rollNumber, name);
        LibraryCard libraryCard = prepareLibraryCard(name);
        student.setLibraryCard(libraryCard);

        Boolean result = studentDAO.saveStudent(student);
        if (result) {
            return "Student with student name:" + name + "is registered succssefully";
        } else {
            return "Student with student name:" + name + "is not registered";
        }
    }

    public String deleteStudent(Long studentId) {
        Boolean result = studentDAO.deleteStudent(studentId);
        if (result) {
            return "Requested student is deleted sucssefully";
        } else {
            return "Requested student is not deleted ";
        }
    }

    private Student prepareStudent(int rollNumber, String name) {
        Student student = new Student();
        student.setRollNumber(rollNumber);
        student.setName(name);
        return student;
    }

    private LibraryCard prepareLibraryCard(String studentName) {
        LibraryCard libraryCard = new LibraryCard();
        libraryCard.setCardNumber(9999);
        libraryCard.setCardName(studentName);
        return  libraryCard;
    }

    public String updateStudent(Long id, String nameToBeUpdate) {
        Student studentToBeUpdate = studentDAO.getStudent(id);
        if (studentToBeUpdate != null) {
            studentToBeUpdate.setName(nameToBeUpdate);
            studentDAO.updateStudent(studentToBeUpdate);
            return "Student id updated successfully";
        } else {
            return "Student is not updated";
        }
    }
}


