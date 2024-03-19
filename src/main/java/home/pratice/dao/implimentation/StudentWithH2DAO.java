package home.pratice.dao.implimentation;

import home.pratice.design.pattern.dao.StudentDAO;
import home.pratice.domain.Student;
import home.pratice.utillities.DatabaseHibernateUtility;
import org.hibernate.Session;

import java.io.Serializable;

public class StudentWithH2DAO implements StudentDAO {
    public Student getStudent(Long studentId) {
        Student student = new Student();
        student.setRollNumber(000);
        student.setName("H2");
        return student;
    }

    public Boolean saveStudent(Student student) {
        Session session = DatabaseHibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Serializable savedId = session.save(student);
        Long primaryKey = (Long) savedId;
        session.getTransaction().commit();
        if (primaryKey != null) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean deleteStudent(Long studentNumber){
        Session session = DatabaseHibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Student studentFromDatabase = session.byId(Student.class).load((Long) studentNumber);
        if(studentFromDatabase!=null){
            session.delete(studentFromDatabase);
            session.getTransaction().commit();
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void updateStudent(Student student) {
        Session session= DatabaseHibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(student);
        session.getTransaction().commit();

    }



    }




