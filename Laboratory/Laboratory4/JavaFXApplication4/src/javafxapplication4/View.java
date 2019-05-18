package javafxapplication4;

import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View {

    public static void showMainStage(Stage primaryStage) {

        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);

        HBox hbox_login = new HBox();
        hbox_login.setAlignment(Pos.CENTER);
        hbox_login.setSpacing(13);
        TextField f_login = new TextField();
        Label login = new Label("Логин : ");
        hbox_login.getChildren().addAll(login, f_login);

        HBox hbox_password = new HBox();
        hbox_password.setAlignment(Pos.CENTER);
        hbox_password.setSpacing(5);
        PasswordField f_password = new PasswordField();
        Label password = new Label("Пароль : ");
        hbox_password.getChildren().addAll(password, f_password);

        HBox account_registration = new HBox();
        account_registration.setAlignment(Pos.CENTER);
        account_registration.setSpacing(28);
        Button b_account = new Button();
        b_account.setPrefSize(90, 10);
        b_account.setText("Войти");
        Button b_registration = new Button();
        b_registration.setPrefSize(90, 10);
        b_registration.setText("Регистрация");
        account_registration.getChildren().addAll(b_account, b_registration);

        vbox.getChildren().addAll(hbox_login, hbox_password, account_registration);

        b_account.setOnAction((ActionEvent e) -> {
            Controller.checkUser(f_login.getText(), f_password.getText());
        });

        b_registration.setOnAction((ActionEvent e) -> {
        });

        primaryStage.setTitle("Вход в аккаунт");
        Scene scene = new Scene(vbox, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void message(){
        System.out.println("Логин или пароль введён неверно");
    }
}
