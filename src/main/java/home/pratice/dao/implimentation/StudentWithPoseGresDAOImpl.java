package home.pratice.dao.implimentation;

import home.pratice.design.pattern.dao.StudentDAO;
import home.pratice.domain.Student;
import home.pratice.utillities.DatabaseHibernateUtility;
import org.hibernate.Session;

public class StudentWithPoseGresDAOImpl implements StudentDAO {
    public Student getStudent(int rollNumber) {
        Student student = new Student();
        student.setRollNumber(000);
        student.setName("poseGresstudent");
        return student;

    }
    public void saveStudent(int rollNumber, String name) {
        Student student= new Student();
        student.setRollNumber(rollNumber);
        student.setName(name);
        Session session = DatabaseHibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        System.out.println("student is persisted successfully");

    }


}
