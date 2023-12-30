package dao;

import models.User;

import java.util.List;

public interface UserDao {

    String add(User user);

    List<User> update(User user);

    List<User> getAll();

    String remove(User user);

    List<User> findUserByEmail(String email);
}
