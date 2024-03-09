package home.pratice.service;

import home.pratice.dao.implimentation.UserWithH2DAO;
import home.pratice.design.pattern.dao.UserDAO;
import home.pratice.domain.User;

public class UserRegistrationService {
    private UserDAO userDAO;

    public UserRegistrationService() {
        userDAO = new UserWithH2DAO();
    }

    public User getUser(int userId) {
        User user = userDAO.getUser(userId);
        return user;
    }

    public void registerUser(int userId, String userName) {
        userDAO.saveUser(userId, userName);
    }
}
