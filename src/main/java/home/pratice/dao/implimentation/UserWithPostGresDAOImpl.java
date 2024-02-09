package home.pratice.dao.implimentation;

import home.pratice.design.pattern.dao.UserDAO;
import home.pratice.user.User;

public class UserWithPostGresDAOImpl implements UserDAO {
    @Override
    public User getUser(int userId) {
        User user =new User();
        user.setUserId(6869);
        user.setUserName("Swapnil");
        return user;
    }
}
