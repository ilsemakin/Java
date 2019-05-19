package Controller;

import java.io.FileNotFoundException;
import javafx.stage.Stage;
import java.util.Scanner;
import Model.DataBase;
import java.io.File;
import Model.User;
import View.View;

public class Controller {

    public static void read() {
        File input = new File("Accounts.txt");
        User user;
        try {
            Scanner in = new Scanner(input);
            String str;

            while (in.hasNextLine()) {
                str = in.nextLine();

                String line[] = str.split(" ");
                if (line.length != 5) {
                    in.close();
                }

                user = new User(line[0], line[1], line[2], line[3], line[4]);
                DataBase.addUser(user);
            }
            in.close();
            DataBase.show();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void checkUser(String login, String password) {
        if (DataBase.find(login, password) == null) {
            View.message();
        }
    }

    public static void init(Stage primaryStage) {
        View.showMainStage(primaryStage);
    }
}
