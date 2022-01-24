package com.softserveinc.task03;

import java.util.HashSet;
import java.util.Set;

public class UserManager {
    private final Set<User> users;

    public UserManager() {
      users = new HashSet<>();
    }

    public void register(String login, String password) {
        User newUser = new User(login, password);
        users.add(newUser);
        System.out.println(users);
    }

    public User findUserByLogin(String login) {
        User userFound = null;
        for (User user : this.users) {
            if (user.getLogin().equals(login)) {
                System.out.println("User found");
                userFound = user;
                break;
            }
        }
        return userFound;
    }

    public void delete(String loginFound) {
        User user = findUserByLogin(loginFound);
        this.users.remove(user);
        System.out.println("All users: " + users);
    }

    public boolean exists(String login, String password) {
        boolean userFound = false;
        for (User user : this.users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                System.out.println("User found");
                userFound = true;
                break;
            }
        }
        return userFound;
    }

    public boolean changePassword(String login, String oldPassword, String newPassword) {
        User user = findUserByLogin(login);
        if (user!= null) {
            String currentPassword = user.getPassword();
            if (currentPassword.equals(oldPassword)){
                user.setPassword(newPassword);
                return true;
            } else{
                System.out.println("incorrect data");
                return false;
            }
        } return false;
    }
}
