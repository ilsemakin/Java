package javafxapplication4;

import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
        TextField f_password = new TextField();
        Label password = new Label("Пароль : ");
        hbox_password.getChildren().addAll(password, f_password);

        HBox hbox_btn = new HBox();
        hbox_btn.setAlignment(Pos.CENTER);
        Button btn = new Button();
        // btn.setPrefSize(200, 10);
        btn.setText("Войти");
        hbox_btn.getChildren().add(btn);

        vbox.getChildren().addAll(hbox_login, hbox_password, hbox_btn);

        btn.setOnAction((ActionEvent e) -> {
        });

        primaryStage.setTitle("Вход в аккаунт");
        Scene scene = new Scene(vbox, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
