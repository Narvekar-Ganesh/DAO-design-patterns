package home.pratice.service;

import home.pratice.dao.implimentation.UserWithPostGresDAOImpl;
import home.pratice.design.pattern.dao.UserDAO;
import home.pratice.regitration.service.controller.UserRegistrationController;
import home.pratice.user.User;

public class UserRegistrationService {
    private UserDAO userDAO;
     public UserRegistrationService(){
         userDAO= new UserWithPostGresDAOImpl();
     }
     public User getUser(int userId){
         User user = userDAO.getUser(userId);
         return user;
     }


}
