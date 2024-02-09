package home.pratice.regitration.service.controller;

import home.pratice.service.StudentRegistrationService;
import home.pratice.user.Student;

public class StudentRegistrationController {
    private StudentRegistrationService studentRegistrationService;//has-a relationship

    public StudentRegistrationController(){
        studentRegistrationService = new StudentRegistrationService();
    }

    public Student getDetailsOfStudent(int rollNumber) {
        Student student = studentRegistrationService.getStudent(rollNumber);
        return student;
    }

    public static void main(String[] args) {
        StudentRegistrationController controller = new StudentRegistrationController();

        Student student = controller.getDetailsOfStudent(852);
        System.out.println("details of student : " + student);

    }
}
