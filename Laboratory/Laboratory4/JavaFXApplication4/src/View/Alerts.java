package View;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import Controller.Controller;

public class Alerts {

    public static void fileRead(String message, String errorUsers) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");

        alert.setHeaderText("Чтение из базы данных завершилось с ошибками!");

        if (errorUsers.isEmpty()) {
            alert.setContentText(message);
        } else {
            alert.setContentText(message + "\n\t" + errorUsers);
        }

        alert.showAndWait();
    }

    public static void fileWrite(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");

        alert.setHeaderText("Запись в базу данных завершилось с ошибками!");
        alert.setContentText(message);

        alert.showAndWait();
    }

    public static void fields() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Информация");

        alert.setHeaderText(null);
        alert.setContentText("Все поля должны быть заполнены.");

        alert.showAndWait();
    }

    public static void User() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");

        alert.setHeaderText(null);
        alert.setContentText("Пользователь с таким данными не зарегистрирован в системе!");

        alert.showAndWait();
    }

    public static void Email() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Предупреждение");

        alert.setHeaderText(null);
        alert.setContentText("Введённый адрес электронной почты не соответствует формату!");

        alert.showAndWait();
    }

    public static void Login(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Информация");

        alert.setHeaderText(null);
        alert.setContentText("Логин уже используется. Попробуйте ввести другой.");

        Optional<ButtonType> option = alert.showAndWait();

        if (option.get() == ButtonType.CANCEL) {
            Controller.closeStage(stage);
        }
    }

    public static void Password(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Предупреждение");

        String message = "Для ввода пароля введите не менее 8 символов.\n"
                + "Используйте как минимум одну строчную букву, одну заглавную букву, одну цифру и один специальный символ.";

        alert.setHeaderText("Пароль недостаточно надёжный!");
        alert.setContentText(message);

        Optional<ButtonType> option = alert.showAndWait();

        if (option.get() == ButtonType.CANCEL) {
            Controller.closeStage(stage);
        }
    }

    public static void Passwords() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Предупреждение");

        alert.setHeaderText(null);
        alert.setContentText("Пароли не совпадают! Повторите ввод.");

        alert.showAndWait();
    }
}
