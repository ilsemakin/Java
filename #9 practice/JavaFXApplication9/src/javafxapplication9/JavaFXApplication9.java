package javafxapplication9;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JavaFXApplication9 extends Application {

    private Scene createScene() {
        Group root = new Group();
        root.getChildren().add(createLabel("A", 50, 50, 50, 100));
        root.getChildren().add(createLabel("B", 50, 50, 200, 100));
        root.getChildren().add(createLabel("C", 50, 50, 350, 100));
        root.getChildren().add(createLabel("D", 50, 50, 500, 100));
        root.getChildren().add(createLabel("E", 50, 50, 650, 100));

//        Text text = new Text("");
//        text.prefWidth(200);
//        text.prefWidth(50);
//        text.setFocusTraversable(true);
//        text.setOnKeyPressed((KeyEvent ke) -> {
//            System.out.println("Label Key Pressed: " + ke.getText());
//        });
//
        Scene scene = new Scene(root, 800, 600);
        return scene;

    }

    private Label createLabel(String text, int height, int width, int x, int y) {
        Label label = new Label(text);
        label.setStyle("-fx-text-fill: AQUA");
        label.setPrefWidth(height);
        label.setPrefHeight(width);
        label.setAlignment(Pos.CENTER);
        label.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
        label.setLayoutX(x);
        label.setLayoutY(y);
        addTranslateListener(label);

        return label;
    }

    private void addTranslateListener(final Node node) {
        Label label = (Label) node;

        node.setOnMouseMoved((mouse) -> {
            node.setScaleX(2);
            node.setScaleY(2);
        });

        node.setOnMouseExited((mouse) -> {
            node.setScaleX(1);
            node.setScaleY(1);

            label.setTextFill(Color.AQUA);

        });

        node.setOnMousePressed((mouse) -> {
            if (mouse.getButton() == MouseButton.PRIMARY) {
                label.setTextFill(Color.RED);
            }
            if (mouse.getButton() == MouseButton.SECONDARY) {
                label.setTextFill(Color.BLACK);
            }
        });

        node.setOnMouseClicked((mouse) -> {
            if (mouse.getClickCount() == 2) {
                label.setTextFill(Color.DARKCYAN);
            }
        });

//        node.setOnKeyPressed((KeyEvent ke) -> {
//            if (label.getText().equals(ke.getText())) {
//                label.setBackground(new Background(new BackgroundFill(Color.GREENYELLOW, null, null)));
//            }
//        });
//
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Words");
        primaryStage.setScene(createScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
