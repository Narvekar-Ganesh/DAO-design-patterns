package home.pratice.design.pattern.dao;

import home.pratice.domain.User;

public interface UserDAO {
    User getUser(int userId);

    Boolean saveUser(int userId, String userName);
}
