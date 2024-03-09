package home.pratice.regitration.service.controller;

import home.pratice.domain.User;
import home.pratice.service.UserRegistrationService;

public class UserRegistrationController {
    UserRegistrationService userRegistrationService;

    public UserRegistrationController() {
        userRegistrationService = new UserRegistrationService();
    }

    public User getDetailsOfUser(int userId) {
        User user = userRegistrationService.getUser(userId);
        return user;
    }

    public void registerUser(int userId, String userName) {
        userRegistrationService.registerUser(userId, userName);
    }

    public static void main(String[] args) {
        UserRegistrationController controller = new UserRegistrationController();
        controller.registerUser(686, "Sonal");
        User user = controller.getDetailsOfUser(686);
        System.out.println("Details of Student" + user);
    }
}
