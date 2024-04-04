package home.pratice.design.pattern.dao;

import home.pratice.domain.Student;

public interface StudentDAO {
    Student getStudent(Long  studentId);

    Boolean saveStudent(Student student);

    Boolean deleteStudent(Long studentId);

    void updateStudent(Student student);
}

