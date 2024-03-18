package home.pratice.dao.implimentation;

import home.pratice.design.pattern.dao.UserDAO;
import home.pratice.domain.User;
import home.pratice.utillities.DatabaseHibernateUtility;
import org.hibernate.Session;

import java.io.Serializable;

public class UserWithH2DAO implements UserDAO {
    @Override
    public User getUser(int userId) {
        User user = new User();
        user.setUserId(000);
        user.setUserName("PoseGressuser");
        return user;
    }

    @Override
    public Boolean saveUser(int userId, String userName) {
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        Session session = DatabaseHibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();

        Serializable savedId =session.save(user);
        Long primaryKey = (Long)savedId;
        session.getTransaction().commit();
        if (primaryKey!=null){
            return true;
        }else{
            return false;
        }
    }
}
