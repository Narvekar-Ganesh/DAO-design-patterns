package home.pratice.design.pattern.dao;

import home.pratice.domain.Student;

public interface StudentDAO {
    Student getStudent(int rollNumber);

    Boolean saveStudent(int rollNumber, String name);

    Boolean deleteStudent(Long studentId);
}

