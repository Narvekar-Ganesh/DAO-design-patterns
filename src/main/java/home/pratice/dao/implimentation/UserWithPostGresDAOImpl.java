package home.pratice.dao.implimentation;

import home.pratice.design.pattern.dao.UserDAO;
import home.pratice.domain.Book;
import home.pratice.domain.Student;
import home.pratice.domain.User;
import home.pratice.utillities.DatabaseHibernateUtility;
import org.hibernate.Session;

public class UserWithPostGresDAOImpl implements UserDAO {
    @Override
    public User getUser(int  userId) {
        User user = new User();
        user.setUserId(000);
        user.setUserName("PoseGressuser");
        return user;
    }

    @Override
    public void saveUser(int userId, String userName) {
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);

        Session session = DatabaseHibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        System.out.println("User is persisted successfully");

    }
}
