package dao.impl;

import dao.UserDao;
import db.DataBase;
import models.User;

import java.util.Date;
import java.util.List;

public class UserDaoImpl implements UserDao {
    final DataBase dataBase;

    public UserDaoImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String add(User user){
        dataBase.save(user);
        return "Success";
    }

    @Override
    public List<User> update(User user) {
        return dataBase.getAll();

    }

    @Override
    public List<User> getAll() {
        return dataBase.getAll();
    }

    @Override
    public String remove(User user) {
        dataBase.remove(user);
        return "Success";
    }

    @Override
    public List<User> findUserByEmail(String email) {
        return  dataBase.getAll();
    }
}
