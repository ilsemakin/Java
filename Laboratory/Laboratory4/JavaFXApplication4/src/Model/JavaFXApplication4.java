package Model;

import Controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;

public class JavaFXApplication4 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Controller.read();
        Controller.init(primaryStage);
    }

    @Override
    public void stop() {
        Controller.write();
    }
}
