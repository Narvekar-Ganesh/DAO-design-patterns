package home.pratice.dao.implimentation;

import home.pratice.design.pattern.dao.StudentDAO;
import home.pratice.domain.Student;

public class StudentWithDefaulValuesDAOImpl implements StudentDAO {
    public Student getStudent(int rollNumber) {
        Student student = new Student();
        student.setRollNumber(000);
        student.setName("default-student");
        return student;

    }
}
