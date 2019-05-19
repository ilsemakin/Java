package Model;

import java.util.ArrayList;

public class DataBase {

    private static ArrayList<User> users = new ArrayList<>();

    public static void addUser(User user) {
        if (checkLogin(user) && checkPassword(user)) {
            users.add(user);
        }
    }

    public static User find(String login, String password) {
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }

        return null;
    }

    public static void show() {
        users.forEach((user) -> {
            System.out.println(user);
        });
    }

    private static boolean checkLogin(User userCheck) {
        if (users.stream().noneMatch((user) -> (user.getLogin().equals(userCheck.getLogin())))) {
            return true;
        }

        return false;
    }

    private static boolean checkPassword(User userCheck) {
        if (userCheck.getPassword().matches("(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9@#$%]).{8,}")) {
            return true;
        }

        return false;
    }
}
