package Model;

import java.util.ArrayList;

public class DataBase {

    private static final ArrayList<User> users = new ArrayList<>();

    public static void addUser(User user) {
        users.add(user);
    }

    public static User search(String login, String password) {
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }

        return null;
    }

    public static ArrayList<User> getList() {
        ArrayList<User> list = new ArrayList<>();

        users.forEach((user) -> {
            list.add(user);
        });

        return list;
    }

    public static boolean checkLogin(String login) {
        if (users.stream().noneMatch((user) -> (user.getLogin().equals(login)))) {
            return true;
        }

        return false;
    }
}
