package View;

import javafx.stage.Stage;
import javafx.scene.Scene;
import Controller.Controller;
import Model.User;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Modality;

public class View {

    public static void showMainStage(Stage primaryStage) {
        VBox vboxMain = new VBox();
        vboxMain.setSpacing(170);

        /*---------------------------Меню-------------------------------------*/
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Меню");
        MenuItem exit = new MenuItem("Выход");

        menu.getItems().add(exit);
        menuBar.getMenus().add(menu);

        exit.setOnAction((e) -> {
            Controller.closeStage(primaryStage);
        });
        /*--------------------------------------------------------------------*/

        VBox vbox = new VBox();
        vbox.setSpacing(10);
        
        /*-------------------------Логин и пароль-----------------------------*/
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
        /*--------------------------------------------------------------------*/

        vbox.getChildren().addAll(hboxLogin, hboxPassword);

        /*---------------------------Кнопки-----------------------------------*/
        HBox hboxButtons = new HBox();
        hboxButtons.setAlignment(Pos.CENTER);
        hboxButtons.setSpacing(28);

        Button signIn = new Button();
        signIn.setPrefSize(90, 10);
        signIn.setText("Войти");

        Button signUp = new Button();
        signUp.setPrefSize(90, 10);
        signUp.setText("Регистрация");

        hboxButtons.getChildren().addAll(signIn, signUp);
        /*--------------------------------------------------------------------*/

        vbox.getChildren().add(hboxButtons);

        /*--------------------Действие по нажитию кнопки----------------------*/
        signIn.setOnAction((ActionEvent e) -> {
            Controller.checkUser(fieldLogin.getText(), fieldPassword.getText(), primaryStage);
        });

        signUp.setOnAction((ActionEvent e) -> {
            Controller.registration(primaryStage);
        });
        /*--------------------------------------------------------------------*/

        vboxMain.getChildren().addAll(menuBar, vbox);

        primaryStage.setTitle("Вход в аккаунт");
        Scene scene = new Scene(vboxMain, 500, 500);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void showUserStage(Stage primaryStage, User user) {
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);

        /*----------------------Редактирование имени--------------------------*/
        HBox formName = new HBox();
        formName.setAlignment(Pos.CENTER);
        formName.setSpacing(35);

        HBox hboxName = new HBox();
        hboxName.setAlignment(Pos.CENTER);
        hboxName.setSpacing(60);

        TextField fieldName = new TextField();
        fieldName.setEditable(false);
        fieldName.setText(user.getName());

        Label labelName = new Label("Имя : ");

        ToggleButton editName = new ToggleButton();
        editName.setText("Редактировать");

        hboxName.getChildren().addAll(labelName, fieldName);

        editName.setOnAction((ActionEvent e) -> {
            if (editName.isSelected()) {
                fieldName.setEditable(true);
            } else {
                if (Controller.checkName(fieldName.getText())) {
                    Controller.setName(user, fieldName.getText());
                }
                fieldName.setEditable(false);
            }
        });

        formName.getChildren().addAll(hboxName, editName);
        /*--------------------------------------------------------------------*/

        vbox.getChildren().add(formName);

        /*---------------------Редактирование фамилии-------------------------*/
        HBox formSurname = new HBox();
        formSurname.setAlignment(Pos.CENTER);
        formSurname.setSpacing(35);

        HBox hboxSurname = new HBox();
        hboxSurname.setAlignment(Pos.CENTER);
        hboxSurname.setSpacing(35);

        TextField fieldSurname = new TextField();
        fieldSurname.setEditable(false);
        fieldSurname.setText(user.getSurname());

        Label labelSurname = new Label("Фамилия : ");

        hboxSurname.getChildren().addAll(labelSurname, fieldSurname);

        ToggleButton editSurname = new ToggleButton();
        editSurname.setText("Редактировать");

        editSurname.setOnAction((ActionEvent e) -> {
            if (editSurname.isSelected()) {
                fieldSurname.setEditable(true);
            } else {
                if (Controller.checkSurname(fieldSurname.getText())) {
                    Controller.setSurname(user, fieldSurname.getText());
                }
                fieldSurname.setEditable(false);
            }
        });

        formSurname.getChildren().addAll(hboxSurname, editSurname);
        /*--------------------------------------------------------------------*/

        vbox.getChildren().add(formSurname);

        /*------------------Редактирование электронной почты------------------*/
        HBox formEmail = new HBox();
        formEmail.setAlignment(Pos.CENTER);
        formEmail.setSpacing(35);

        HBox hboxEmail = new HBox();
        hboxEmail.setAlignment(Pos.CENTER);
        hboxEmail.setSpacing(49);

        TextField fieldEmail = new TextField();
        fieldEmail.setEditable(false);
        fieldEmail.setText(user.getEmail());

        Label labelEmail = new Label("Почта : ");
        hboxEmail.getChildren().addAll(labelEmail, fieldEmail);

        ToggleButton editEmail = new ToggleButton();
        editEmail.setText("Редактировать");

        editEmail.setOnAction((ActionEvent e) -> {
            if (editEmail.isSelected()) {
                fieldEmail.setEditable(true);
            } else {
                if (Controller.checkEmail(fieldEmail.getText())) {
                    Controller.setEmail(user, fieldEmail.getText());
                }
                fieldEmail.setEditable(false);
            }
        });

        formEmail.getChildren().addAll(hboxEmail, editEmail);
        /*--------------------------------------------------------------------*/

        vbox.getChildren().add(formEmail);

        /*---------------------------Кнопки-----------------------------------*/
        HBox hboxButtons = new HBox();
        hboxButtons.setAlignment(Pos.CENTER);
        hboxButtons.setSpacing(28);

        Button logout = new Button();
        logout.setPrefSize(175, 10);
        logout.setText("Выйти из личного кабинета");

        Button exit = new Button();
        exit.setPrefSize(175, 10);
        exit.setText("Выход");

        hboxButtons.getChildren().addAll(logout, exit);
        /*--------------------------------------------------------------------*/

        vbox.getChildren().addAll(hboxButtons);

        /*--------------------Действие по нажитию кнопки----------------------*/
        logout.setOnAction((ActionEvent e) -> {
            Controller.init(primaryStage);
        });

        exit.setOnAction((ActionEvent e) -> {
            Controller.closeStage(primaryStage);
        });
        /*--------------------------------------------------------------------*/

        primaryStage.setTitle("Личный кабинет");
        primaryStage.setResizable(false);
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
        HBox hboxButton = new HBox();
        hboxButton.setAlignment(Pos.CENTER);
        hboxButton.setSpacing(28);
        Button createAccount = new Button();
        createAccount.setPrefSize(130, 10);
        createAccount.setText("Зарегистрироваться");
        hboxButton.getChildren().addAll(createAccount);
        /*--------------------------------------------------------------------*/

        vbox.getChildren().add(hboxButton);

        /*--------------------Действие по нажитию кнопки----------------------*/
        createAccount.setOnAction((ActionEvent e) -> {
            if (Controller.checkName(fieldName.getText())) {
                if (Controller.checkSurname(fieldSurname.getText())) {
                    if (Controller.checkEmail(fieldEmail.getText())) {
                        if (Controller.checkLogin(fieldLogin.getText(), (Stage) createAccount.getScene().getWindow())) {
                            if (Controller.checkPassword(fieldPasswordOne.getText(), (Stage) createAccount.getScene().getWindow())) {
                                if (Controller.checkPasswords(fieldPasswordOne.getText(), fieldPasswordTwo.getText())) {
                                    Controller.addUser(fieldName.getText(), fieldSurname.getText(), fieldEmail.getText(),
                                            fieldLogin.getText(), fieldPasswordTwo.getText());

                                    Stage stage = (Stage) createAccount.getScene().getWindow();
                                    stage.close();
                                }
                            }
                        }
                    }
                }
            }
        });
        /*--------------------------------------------------------------------*/

        Scene scene = new Scene(vbox, 500, 500);

        Stage secondaryStage = new Stage();
        secondaryStage.setTitle("Регистрация нового пользователя");
        secondaryStage.setScene(scene);
        secondaryStage.setResizable(false);
        secondaryStage.initModality(Modality.WINDOW_MODAL);
        secondaryStage.initOwner(primaryStage);

        secondaryStage.show();
    }
}
