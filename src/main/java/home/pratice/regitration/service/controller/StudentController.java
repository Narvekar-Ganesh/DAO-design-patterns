package home.pratice.regitration.service.controller;

import home.pratice.domain.Student;
import home.pratice.service.StudentRegistrationService;

import java.util.ArrayList;
import java.util.List;

public class StudentController {
    private final StudentRegistrationService studentRegistrationService;//has-a relationship

    public StudentController() {
        studentRegistrationService = new StudentRegistrationService();
    }

    public Student getDetailsOfStudent(int rollNumber) {
        return studentRegistrationService.getStudent(rollNumber);
    }

    public void registerStudent(int rollNumber, String name) {
        studentRegistrationService.registerStudent(rollNumber, name);
    }
    public static void deleteGivenStudent(){
        StudentController controller =new StudentController();
        System.out.println(controller.studentRegistrationService.deleteStudent(11L));
    }

    public static void main(String[] args) {
        deleteGivenStudent();

        StudentController controller = new StudentController();
        List<Student> students =new ArrayList<>();

        for (int i =0;i<=10;i++){
            Student student =new Student();
            student.setName("Book-Name-"+i+10);
            student.setRollNumber(i+10);
            students.add(student);
        }

        for(Student eachStudent:students){
            controller.registerStudent(eachStudent.getRollNumber(), eachStudent.getName());

        }

    }

}