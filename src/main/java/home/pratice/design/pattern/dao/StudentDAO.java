package home.pratice.design.pattern.dao;

import home.pratice.domain.Student;

public interface StudentDAO {
    Student getStudent(int rollNumber);
    void  saveStudent(int rollNumber , String name);
}

