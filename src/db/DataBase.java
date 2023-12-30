package db;

import models.User;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

    private List<User> users = new ArrayList<>();

    public Boolean save(User user){
        return users.add(user);
    }

    public List<User> getAll(){
        return users;
    }

    public Boolean remove(User user){
        return users.remove(user);
    }
}
