package home.pratice.regitration.service.controller;

import home.pratice.domain.Student;
import home.pratice.service.StudentRegistrationService;

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
        controller.registerStudent(456, "Bunty");
        Student student = controller.getDetailsOfStudent(852);
        System.out.println("details of student : " + student);
    }
}
