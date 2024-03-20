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

    public Student getDetailsOfStudent(Long studentId) {
        return studentRegistrationService.getStudent(studentId);
    }

    public void registerStudent(int rollNumber, String name,String gender,String addresLine1,String addresLine2) {
        studentRegistrationService.registerStudent(rollNumber, name,gender,addresLine1,addresLine2);
    }

    public String deleteStudent(Long studentId) {
        return studentRegistrationService.deleteStudent(studentId);
    }

    public static void deleteGivenStudent(Long studentId) {
        StudentController controller = new StudentController();
        System.out.println(controller.deleteStudent(studentId));
    }

    public String updateStudent(Long studentId, String name) {
        return studentRegistrationService.updateStudent(studentId, name);
    }


    /**
     * This method acts as a customer / client to your vendor
     *
     * @param args
     */
    public static void main(String[] args) {
//        updateGivenBook(27L,"viraj" );
//        deleteGivenStudent(87L);
        saveMultipleStudents();
//        saveSingleStudent(45,"Shourya","Mail","flat no H-405","Balaji Symphony");
    }

    private static void updateGivenBook(Long studentId, String name) {
        StudentController controller = new StudentController();
        controller.updateStudent(studentId, name);
    }

    public static void saveSingleStudent(int number ,String name,String gender,String addresLine1,String addresLine2){
        StudentController controller = new StudentController();
        controller.registerStudent(number,name,gender,addresLine1,addresLine2);
    }

    private static void saveMultipleStudents() {
        StudentController controller = new StudentController();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i <= 1; i++) {
            Student student = new Student();
            student.setName("Student-name-with-Library-card-" + i + 10);
            student.setRollNumber(i + 10);
            student.setGender("Male");
            student.setAddresLine1("harmonic");
            student.setAddresLine2("Room no - 405");
            students.add(student);
        }

        for (Student eachStudent : students) {
            controller.registerStudent(eachStudent.getRollNumber(), eachStudent.getName(),eachStudent.getGender(),eachStudent.getAddresLine1(),eachStudent.getAddresLine2());

        }
    }

}
