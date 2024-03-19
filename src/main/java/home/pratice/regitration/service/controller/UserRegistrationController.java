package home.pratice.regitration.service.controller;

import home.pratice.domain.User;
import home.pratice.service.UserRegistrationService;

import java.util.ArrayList;
import java.util.List;

public class UserRegistrationController {
    UserRegistrationService userRegistrationService;

    public UserRegistrationController() {
        userRegistrationService = new UserRegistrationService();
    }

    public User getDetailsOfUser(int userId) {
        User user = userRegistrationService.getUser(userId);
        return user;
    }


    public String registerUser(int userId, String userName) {
        String response = userRegistrationService.registerUser(userId, userName);
        return response;
    }

    public static void deleteGivenUser() {
        UserRegistrationController controller = new UserRegistrationController();
        System.out.println(controller.userRegistrationService.deleteUser(14L));
    }

    public static void main(String[] args) {
//         deleteGivenUser();
        doRegistration();
    }

    private static void doRegistration() {
        UserRegistrationController controller = new UserRegistrationController();
        List<User> users = new ArrayList<>();

        for (int i = 0; i <= 10; i++) {
            User user = new User();
            user.setUserName("User-Name" + i + 10);
            user.setUserId(i + 10);
            users.add(user);
        }

        for (User eachUser : users) {
            String responase = controller.registerUser(eachUser.getUserId(), eachUser.getUserName());
            System.out.println(responase);
        }
    }
}
