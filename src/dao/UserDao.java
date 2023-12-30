package dao;

import models.User;

import java.util.List;

public interface UserDao {

    String add(User user);

    String update(User user);

    List<User> getAll();

    String remove(User user);

    User findUserByEmail(String email);
}
