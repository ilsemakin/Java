package dialogwindows;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.stage.Stage;

public class DialogWindows extends Application {

    private ArrayList<Specialization> spec;

    @Override
    public void start(Stage primaryStage) {
        spec = new ArrayList<>();
        spec.add(new Specialization("Прикладной мыслитель", "210"));
        spec.add(new Specialization("Фундаментальный лентяй", "234"));
        spec.add(new Specialization("Кабалистика и ворожба", "203"));

        Controller.init(primaryStage, spec);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
