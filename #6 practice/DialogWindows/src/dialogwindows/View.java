package dialogwindows;

import java.util.ArrayList;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View {

    public static void showMainStage(Stage primaryStage, ArrayList<Specialization> spec) {
        Label studentName = new Label();
        Label specs = new Label();

        primaryStage.setTitle("Abitur");
        VBox root = new VBox(5);

        Button btn = new Button();
        btn.setText("Редактровать данные абитурента");

        root.getChildren().add(btn);

        btn.setOnAction((ActionEvent e) -> {
            ArrayList<String> c = Controller.editAbitur(spec);
            studentName.setText(c.get(0));
            String output = "";
            for (String str : c) {
                output += str + "\n";
            }
            specs.setText(output);
        });

        Button btn2 = new Button();
        btn2.setText("Редактировать данные направлений");
        root.getChildren().add(btn2);
        btn2.setOnAction((ActionEvent e) -> {
            Controller.editSpec(spec);
        });

        root.getChildren().add(specs);

        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static Student editAbiturDialog() {
        String s_name;
        String s_matendra;
        String s_pykh;
        String s_och;

        TextInputDialog dialog = new TextInputDialog();

        dialog.setTitle("Edit abiturient");
        dialog.setHeaderText("Edit abiturient");

        GridPane pane = new GridPane();
        pane.setHgap(5);
        pane.setVgap(5);

        TextField name = new TextField();
        Label l_name = new Label("Имя");
        pane.add(l_name, 0, 0);
        pane.add(name, 1, 0);

        TextField mat = new TextField();
        Label l_mat = new Label("Матендра");
        pane.add(l_mat, 0, 1);
        pane.add(mat, 1, 1);

        TextField pykh = new TextField();
        Label l_pykh = new Label("Пыхтелка");
        pane.add(l_pykh, 0, 2);
        pane.add(pykh, 1, 2);

        TextField och = new TextField();
        Label l_och = new Label("Очумелые ручки");
        pane.add(l_och, 0, 3);
        pane.add(och, 1, 3);

        DialogPane dialogPane = dialog.getDialogPane();

        dialogPane.setContent(pane);
        Optional<String> result = dialog.showAndWait();

        return new Student(name.getText(), mat.getText(), pykh.getText(), och.getText());
    }

    public static ArrayList<String> editSpecDialog(ArrayList<Specialization> spec) {
        String score;

        TextInputDialog dialog = new TextInputDialog();

        GridPane pane = new GridPane();
        pane.setHgap(5);
        pane.setVgap(5);

        TextField name = new TextField();
        Label l_name = new Label("Прикладной мыслитель");
        pane.add(l_name, 0, 0);
        pane.add(name, 1, 0);

        TextField pykh = new TextField();
        Label l_pykh = new Label("Фундаментальный лентяй");
        pane.add(l_pykh, 0, 2);
        pane.add(pykh, 1, 2);

        TextField och = new TextField();
        Label l_och = new Label("Кабалистика и ворожба");
        pane.add(l_och, 0, 3);
        pane.add(och, 1, 3);

        DialogPane dialogPane = dialog.getDialogPane();
        dialogPane.setContent(pane);

        Optional<String> result = dialog.showAndWait();

        ArrayList<String> results = new ArrayList<>();
        results.add(name.getText());
        results.add(pykh.getText());
        results.add(och.getText());
        return results;
    }
}
