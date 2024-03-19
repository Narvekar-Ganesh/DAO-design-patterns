package home.pratice.regitration.service.controller;

import home.pratice.domain.Student;
import home.pratice.service.BookRegistrationService;
import home.pratice.service.StudentRegistrationService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.LoggingMXBean;

public class StudentController {
    private final StudentRegistrationService studentRegistrationService;//has-a relationship

    public StudentController() {
        studentRegistrationService = new StudentRegistrationService();
    }

    public Student getDetailsOfStudent(Long studentId) {
        return studentRegistrationService.getStudent(studentId);
    }

    public void registerStudent(int rollNumber, String name) {
        studentRegistrationService.registerStudent(rollNumber, name);
    }

    public String deleteStudent(Long studentId){
        return studentRegistrationService.deleteStudent(studentId);
    }

    public static void deleteGivenStudent(Long studentId){
        StudentController controller =new StudentController();
        System.out.println(controller.deleteStudent(studentId));
    }

    public String updateStudent(Long studentId,String name){
        return  studentRegistrationService.updateStudent(studentId,name);
    }


    /**
     * This method acts as a customer / client to your vendor
     *
     * @param args
     */
    public static void main(String[] args) {
//        updateGivenBook(27L,"viraj" );
//        deleteGivenStudent(15L);
        saveMultipleStudents();


    }

    private static void updateGivenBook(Long studentId ,String studentname){
        StudentController controller = new StudentController();
        controller.updateStudent(studentId,studentname);
    }

    private static void saveMultipleStudents() {
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
