package Controller;

import Exception.FileReadException;
import java.io.FileNotFoundException;
import javafx.stage.Stage;
import java.util.Scanner;
import Model.DataBase;
import java.io.File;
import Model.User;
import View.Alerts;
import View.View;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Platform;

public class Controller {

    public static void closeStage(Stage stage) {
        stage.close();
    }

    public static void read() {
        File input = new File("Accounts.txt");
        ArrayList<User> list = new ArrayList<>();
        String errorUsers = "";
        User user;

        try (Scanner in = new Scanner(input)) {
            String str;

            while (in.hasNextLine()) {
                str = in.nextLine();

                String line[] = str.split(" ");
                if (line.length != 5) {
                    errorUsers = str;
                    throw new FileReadException();
                }

                user = new User(line[0], line[1], line[2], line[3], line[4]);
                if (DataBase.checkLogin(user.getLogin()) && checkPassword(user.getPassword())) {
                    list.add(user);
                }
            }
            in.close();

            list.forEach((newUser) -> {
                DataBase.addUser(newUser);
            });

        } catch (FileNotFoundException ex) {
            Alerts.fileRead("Файл отсутствует!\n База данных будет пустой!", errorUsers);
        } catch (FileReadException ex) {
            Alerts.fileRead(ex.getMessage(), errorUsers);
            Platform.exit();
        }
    }

    public static void write() {
        ArrayList<User> list = DataBase.getList();

        if (!list.isEmpty()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("Accounts.txt"))) {

                for (User user : list) {
                    bw.write(user.getName() + " " + user.getSurname() + " " + user.getEmail()
                            + " " + user.getLogin() + " " + user.getPassword() + "\n");
                }

                bw.close();
            } catch (IOException ex) {
                Alerts.fileWrite(ex.getMessage());
            }
        }
    }

    public static void init(Stage primaryStage) {
        View.showMainStage(primaryStage);
    }

    public static void checkUser(String login, String password, Stage primaryStage) {
        User user = DataBase.search(login, password);

        if (user == null) {
            Alerts.User();
        } else {
            UserStage(primaryStage, user);
        }
    }

    private static void UserStage(Stage primaryStage, User user) {
        View.showUserStage(primaryStage, user);
    }

    public static void addUser(String name, String surname, String email, String login, String password) {
        DataBase.addUser(new User(name, surname, email, login, password));
    }

    public static void registration(Stage primaryStage) {
        View.registration(primaryStage);
    }

    public static boolean checkName(String name) {
        if (name.isEmpty()) {
            Alerts.Name();
            return false;
        }

        return true;
    }
    
    public static void setName(User user, String name) {
        user.setName(name);
    }

    public static boolean checkSurname(String surname) {
        if (surname.isEmpty()) {
            Alerts.Surname();
            return false;
        }

        return true;
    }
    
    public static void setSurname(User user, String surname) {
        user.setSurname(surname);
    }

    public static boolean checkEmail(String email) {
        if (email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {

            return true;
        }

        Alerts.Email();
        return false;
    }
    
    public static void setEmail(User user, String email) {
        user.setEmail(email);
    }

    public static boolean checkLogin(String login, Stage stage) {
        if (DataBase.checkLogin(login) && !login.isEmpty()) {
            return true;
        }

        Alerts.Login(stage, login);
        return false;
    }

    public static boolean checkPassword(String password, Stage stage) {
        if (password.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9@#$%]).{8,}")) {
            return true;
        }

        Alerts.Password(stage);
        return false;
    }

    public static boolean checkPasswords(String passwordOne, String passwordTwo) {
        if (passwordOne.equals(passwordTwo)) {
            return true;
        }

        Alerts.Passwords();
        return false;
    }

    private static boolean checkPassword(String password) {
        if (password.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9@#$%]).{8,}")) {
            return true;
        }

        return false;
    }
}
