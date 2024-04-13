package home.pratice.regitration.service.controller;

import home.pratice.domain.Student;
import home.pratice.service.StudentRegistrationService;
import lombok.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
@Data
@NoArgsConstructor


public class StudentController {
    private  StudentRegistrationService studentRegistrationService;//has-a relationship

    public Student getDetailsOfStudent(Long studentId) {
        return studentRegistrationService.getStudent(studentId);
    }

    public void registerStudent(int rollNumber, String name, String gender, String addresLine1, String addresLine2 , String mobileNumber1, String mobileNumber2) {
        studentRegistrationService.registerStudent(rollNumber, name, gender, addresLine1, addresLine2, mobileNumber1,mobileNumber2);
    }

    public String deleteStudent(Long studentId) {
        return studentRegistrationService.deleteStudent(studentId);
    }

    public static void deleteGivenStudent(Long studentId) {
//        StudentController controller = new StudentController();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:student-config.xml");
        StudentController studentController = applicationContext.getBean("studentController", StudentController.class);
        System.out.println(studentController.deleteStudent(studentId));
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
        updateGivenStudent(52L,"viraj" );
//        deleteGivenStudent(87L);
//        saveMultipleStudents();
//        saveSingleStudent(999, "ASDFGH", "Mail", "flat no H-999", "Balaji Symphony", "111222111222", "3334443334443");
        getStudentById(130L);
    }

    private static void getStudentById(Long id){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:student-config.xml");
        StudentController studentController = applicationContext.getBean("studentController", StudentController.class);
        System.out.println("getStudentById-controller:hashcode"+studentController.hashCode());
        System.out.println("getStudentById-sevice:hashcode"+ studentController.getStudentRegistrationService().hashCode());
        Student student = studentController.getDetailsOfStudent(id);
        System.out.println("details of student are - " + student);
    }
    private static void updateGivenStudent(Long studentId, String name) {
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("classpath:student-config.xml");
        StudentController  studentController = applicationContext.getBean("studentController",StudentController.class);
        System.out.println("updateGivenStudent-controller:hashcode"+studentController.hashCode());
        System.out.println("updateGivenStudent-sevice:hashcode"+ studentController.getStudentRegistrationService().hashCode());
        ;

        studentController.updateStudent(studentId, name);
    }

    public static void saveSingleStudent(int number, String name, String gender, String addresLine1, String addresLine2, String mobileNumber1, String mobileNumber2) {
//        StudentController controller = new StudentController();//
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:student-config.xml");
        StudentController studentController = applicationContext.getBean("studentController",StudentController.class);
        studentController.registerStudent(number, name, gender, addresLine1, addresLine2, mobileNumber1, mobileNumber2);
    }

    private static void saveMultipleStudents() {
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("classpath:student-config.xml");
        StudentController studentController = applicationContext.getBean("studentController",StudentController.class);
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
            System.out.println("Each student is : " + eachStudent);
        }

        /*for (Student eachStudent : students) {
            controller.registerStudent(eachStudent.getRollNumber(), eachStudent.getName(), eachStudent.getGender(), eachStudent.getAddresLine1(), eachStudent.getAddresLine2(),null,null);

        }*/
    }

}
