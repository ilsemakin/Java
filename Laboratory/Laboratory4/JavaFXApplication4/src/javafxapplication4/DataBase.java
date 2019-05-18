package javafxapplication4;

import java.util.ArrayList;

public class DataBase {

    private static ArrayList<User> users = new ArrayList<>();

    static void addUser(User user) {
        if (checkLogin(user) && checkPassword(user)) {
            users.add(user);
        }
    }

    static User find(String login, String password) {
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }

        return null;
    }

    static private boolean checkLogin(User userCheck) {
        if (users.stream().noneMatch((user) -> (user.getLogin().equals(userCheck.getLogin())))) {
            return true;
        }
        return false;
    }

    static private boolean checkPassword(User userCheck) {
        if (userCheck.getPassword().equals("(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9@#$%]).{8,}")) {
            return true;
        }
        return false;
    }
}
