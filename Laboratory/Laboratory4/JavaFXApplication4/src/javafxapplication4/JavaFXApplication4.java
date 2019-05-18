package javafxapplication4;

import javafx.application.Application;
import javafx.stage.Stage;

public class JavaFXApplication4 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Controller.init(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
