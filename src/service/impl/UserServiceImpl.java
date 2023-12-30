package service.impl;

import dao.impl.UserDaoImpl;
import models.User;
import MyExceptions.Notfoud;
import service.UserService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserServiceImpl implements UserService {
    private static Long id = 0L;
    private final UserDaoImpl userDao;

    public UserServiceImpl(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findUserByEmail(String email) {
        return userDao.getAll().stream()
                .filter(user -> user.getLogin().equalsIgnoreCase(email))
                .findFirst()
                .orElseThrow(() -> new Notfoud("Not found"));
    }

    @Override
    public String findUserByPost(String posttt) {
        return userDao.getAll().stream()
                .flatMap(user -> user.getPosts().stream()
                        .filter(post -> post.equalsIgnoreCase(posttt)))
                .findFirst()
                .orElseThrow(() -> new Notfoud("Not found"));

    }

    @Override
    public String registratsia(User user) {
        while (true) {
            System.out.println("Write email:");
            String email = new Scanner(System.in).nextLine();
            if (Generickchecks.checkForEmail(email) && Generickchecks.unicalEmail(email, userDao.getAll())) {
                user.setLogin(email);
                user.setId(++UserServiceImpl.id);
                break;
            }
        }
        while (true) {
            System.out.println("Write password");
            String password = new Scanner(System.in).nextLine();
            if (password.length() > 3) {
                user.setPassword(password);
                break;
            }
        }
        return userDao.add(user);
    }

    @Override
    public User login(User user) {
        System.out.println("Write email: ");
        String email = new Scanner(System.in).nextLine();
        System.out.println("Write password: ");
        String password = new Scanner(System.in).nextLine();
        return userDao.getAll().stream()
                .filter(user1 -> user1.getLogin().equalsIgnoreCase(email) && user1.getPassword().equalsIgnoreCase(password))
                .findFirst().orElseThrow(() -> new Notfoud("Write correct please"));
    }

    @Override
    public String updateMyProfile(User user) {
        System.out.println("""
                Choose command for update:
                1.email
                2.password
                               
                """);
        try {
            int action = new Scanner(System.in).nextInt();
            switch (action) {
                case 1 -> {
                    while (true) {
                        System.out.println("Write new email: ");
                        String newEmail = new Scanner(System.in).nextLine();
                        if (Generickchecks.checkForEmail(newEmail) && Generickchecks.unicalEmail(newEmail, userDao.getAll())) {
                            user.setLogin(newEmail);
                            break;
                        }
                    }
                }
                case 2 -> {
                    while (true) {
                        System.out.println("Write new password: ");
                        String newPassword = new Scanner(System.in).nextLine();
                        if (newPassword.length() > 3) {
                            user.setPassword(newPassword);
                            break;
                        }
                    }
                }
            }
        } catch (InputMismatchException e) {
            return "Write number please";
        }
        return "Write number";
    }



        @Override
        public String removeMyAccaunt (User user){
            userDao.remove(user);
            return "Success";
        }

        @Override
        public void MyProfile (User user){
            System.out.println(user);
        }

    @Override
    public void addnewPost(User user) {
        System.out.println("Write post: ");
        List<String> posts = new ArrayList<>();
        posts.add(new Scanner(System.in).nextLine());
        user.setPosts(posts);
    }
}
