package service;

import models.User;

public interface UserService {
    User findUserByEmail(String email);
    String findUserByPost(String post);
    String registratsia(User user);
    User login(User user);
    String updateMyProfile(User user);
    String removeMyAccaunt(User user);
    void MyProfile(User user);
    void addnewPost(User user);

}
