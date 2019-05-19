package View;

import javafx.stage.Stage;
import javafx.scene.Scene;
import Controller.Controller;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Modality;

public class View {

    public static void showMainStage(Stage primaryStage) {

        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);

        HBox hboxLogin = new HBox();
        hboxLogin.setAlignment(Pos.CENTER);
        hboxLogin.setSpacing(13);
        TextField fieldLogin = new TextField();
        Label labelLogin = new Label("Логин : ");
        hboxLogin.getChildren().addAll(labelLogin, fieldLogin);

        HBox hboxPassword = new HBox();
        hboxPassword.setAlignment(Pos.CENTER);
        hboxPassword.setSpacing(5);
        PasswordField fieldPassword = new PasswordField();
        Label password = new Label("Пароль : ");
        hboxPassword.getChildren().addAll(password, fieldPassword);

        /*---------------------------Кнопки-----------------------------------*/
        HBox loginAndRegistration = new HBox();
        loginAndRegistration.setAlignment(Pos.CENTER);
        loginAndRegistration.setSpacing(28);

        Button buttonAccount = new Button();
        buttonAccount.setPrefSize(90, 10);
        buttonAccount.setText("Войти");

        Button buttonRegistration = new Button();
        buttonRegistration.setPrefSize(90, 10);
        buttonRegistration.setText("Регистрация");

        loginAndRegistration.getChildren().addAll(buttonAccount, buttonRegistration);
        /*--------------------------------------------------------------------*/

        vbox.getChildren().addAll(hboxLogin, hboxPassword, loginAndRegistration);

        /*--------------------Действие по нажитию кнопки----------------------*/
        buttonAccount.setOnAction((ActionEvent e) -> {
            Controller.checkUser(fieldLogin.getText(), fieldPassword.getText());
        });

        buttonRegistration.setOnAction((ActionEvent e) -> {
            Controller.registration(primaryStage);
        });
        /*--------------------------------------------------------------------*/

        primaryStage.setTitle("Вход в аккаунт");
        Scene scene = new Scene(vbox, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void registration(Stage primaryStage) {
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);

        /*----------------------Ввод личных данных----------------------------*/
        HBox hboxName = new HBox();
        hboxName.setAlignment(Pos.CENTER);
        hboxName.setSpacing(82);
        TextField fieldName = new TextField();
        Label labelName = new Label("Имя : ");
        hboxName.getChildren().addAll(labelName, fieldName);

        HBox hboxSurname = new HBox();
        hboxSurname.setAlignment(Pos.CENTER);
        hboxSurname.setSpacing(58);
        TextField fieldSurname = new TextField();
        Label labelSurname = new Label("Фамилия : ");
        hboxSurname.getChildren().addAll(labelSurname, fieldSurname);

        HBox hboxEmail = new HBox();
        hboxEmail.setAlignment(Pos.CENTER);
        hboxEmail.setSpacing(73);
        TextField fieldEmail = new TextField();
        Label labelEmail = new Label("Почта : ");
        hboxEmail.getChildren().addAll(labelEmail, fieldEmail);
        /*--------------------------------------------------------------------*/

        vbox.getChildren().addAll(hboxName, hboxSurname, hboxEmail);

        /*-------------------------Логин и пароль-----------------------------*/
        HBox hboxLogin = new HBox();
        hboxLogin.setAlignment(Pos.CENTER);
        hboxLogin.setSpacing(73);
        TextField fieldLogin = new TextField();
        Label labelLogin = new Label("Логин : ");
        hboxLogin.getChildren().addAll(labelLogin, fieldLogin);

        HBox hboxPasswordOne = new HBox();
        hboxPasswordOne.setAlignment(Pos.CENTER);
        hboxPasswordOne.setSpacing(65);
        PasswordField fieldPasswordOne = new PasswordField();
        Label labelPasswordOne = new Label("Пароль : ");
        hboxPasswordOne.getChildren().addAll(labelPasswordOne, fieldPasswordOne);

        HBox hboxPasswordTwo = new HBox();
        hboxPasswordTwo.setAlignment(Pos.CENTER);
        hboxPasswordTwo.setSpacing(5);
        PasswordField fieldPasswordTwo = new PasswordField();
        Label labelPasswordTwo = new Label("Повторите пароль : ");
        hboxPasswordTwo.getChildren().addAll(labelPasswordTwo, fieldPasswordTwo);
        /*--------------------------------------------------------------------*/

        vbox.getChildren().addAll(hboxLogin, hboxPasswordOne, hboxPasswordTwo);

        /*---------------------------Кнопка-----------------------------------*/
        HBox loginAndRegistration = new HBox();
        loginAndRegistration.setAlignment(Pos.CENTER);
        loginAndRegistration.setSpacing(28);
        Button buttonAccount = new Button();
        buttonAccount.setPrefSize(130, 10);
        buttonAccount.setText("Зарегистрироваться");
        loginAndRegistration.getChildren().addAll(buttonAccount);

        vbox.getChildren().add(loginAndRegistration);
        /*--------------------------------------------------------------------*/

        buttonAccount.setOnAction((ActionEvent e) -> {
            if (Controller.checkEmail(fieldEmail.getText())) {
                if (Controller.checkLogin(fieldLogin.getText(), (Stage) buttonAccount.getScene().getWindow())) {
                    if (Controller.checkPassword(fieldPasswordOne.getText(), (Stage) buttonAccount.getScene().getWindow())) {
                        if (Controller.checkPasswords(fieldPasswordOne.getText(), fieldPasswordTwo.getText())) {
                            Controller.addUser(fieldName.getText(), fieldSurname.getText(), fieldEmail.getText(),
                                    fieldLogin.getText(), fieldPasswordTwo.getText());

                            Stage stage = (Stage) buttonAccount.getScene().getWindow();
                            stage.close();
                        }
                    }
                }
            }
        });

        Scene scene = new Scene(vbox, 500, 500);

        Stage secondaryStage = new Stage();
        secondaryStage.setTitle("Регистрация нового пользователя");
        secondaryStage.setScene(scene);
        secondaryStage.initModality(Modality.WINDOW_MODAL);
        secondaryStage.initOwner(primaryStage);

        secondaryStage.show();
    }
}
