package Model;

import Controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;

public class JavaFXApplication4 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Controller.read();
        Controller.init(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
