package service.impl;

import models.User;

import java.util.List;

public   class Generickchecks {
    public static boolean checkForEmail(String email){
        return email.length() > 3;
    }
    public static boolean unicalEmail(String email, List<User> users){
        for (User user : users) {
            if (user.getLogin().equalsIgnoreCase(email)){
                return false;
            }
        }
        return true;
    }
}
