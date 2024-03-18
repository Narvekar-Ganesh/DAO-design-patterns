package home.pratice.regitration.service.controller;

import home.pratice.domain.Book;
import home.pratice.domain.Student;
import home.pratice.service.StudentRegistrationService;

import java.util.ArrayList;
import java.util.List;

public class
StudentRegistrationController {
    private StudentRegistrationService studentRegistrationService;//has-a relationship

    public StudentRegistrationController() {
        studentRegistrationService = new StudentRegistrationService();
    }

    public Student getDetailsOfStudent(int rollNumber) {
        Student student = studentRegistrationService.getStudent(rollNumber);
        return student;
    }

    public void registerStudent(int rollNumber, String name) {
        studentRegistrationService.registerStudent(rollNumber, name);
    }

    public static void main(String[] args) {
        StudentRegistrationController controller = new StudentRegistrationController();
        List<Student> students =new ArrayList<>();

        for (int i =0;i>=10;i++){
            Student student =new Student();
            student.setName("Book-Name-"+i+10);
            student.setRollNumber(i+10);
            students.add(student);

        }
        for(Student eachStudent:students){
            controller.registerStudent(eachStudent.getRollNumber(), eachStudent.getName());

        }


//        controller.registerStudent(456, "Bunty");
//        Student student = controller.getDetailsOfStudent(852);
//        System.out.println("details of student : " + student);
    }
}
