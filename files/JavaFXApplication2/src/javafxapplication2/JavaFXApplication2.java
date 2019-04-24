package javafxapplication2;

import java.util.HashMap;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JavaFXApplication2 extends Application {
    Group root;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Drawling");

        Group root = new Group();

        Canvas canvas = new Canvas(500, 300);
        
        ToggleButton btn = new ToggleButton();
        
        btn.setLayoutX(20);
        btn.setLayoutY(350);
        btn.setText("Push!");
        
        GraphicsContext gc = canvas.getGraphicsContext2D();
        btn.setOnAction((ActionEvent event) -> {
            if (btn.isSelected()) {
                drawSun(gc);
            } else {
                drawCloud(gc);
            }
        });
        root.getChildren().add(btn);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public void drawSun(GraphicsContext gc){
        gc.clearRect(0, 0, 500, 500);
        gc.setFill(Color.YELLOW);
        gc.setStroke(Color.YELLOW);
        gc.setLineWidth(3);
        
        gc.strokeLine(40,40,68,68);
        gc.strokeLine(128,38,108,66);
        
        gc.strokeLine(30,87,60,87);
        gc.strokeLine(120,87,150,87);
        
        gc.strokeLine(68,110,40,136);
        gc.strokeLine(138,133,110,113);
        
        gc.strokeOval(60,60,60,60);
        gc.fillOval(60,60,60,60);
    }
    
    public void drawCloud(GraphicsContext gc){
        gc.clearRect(0, 0, 300, 500);
        gc.setFill(Color.GRAY);
        gc.setStroke(Color.GRAY);
        gc.setLineWidth(3);
        
        
        gc.strokeOval(180,50,180,100);
        gc.fillOval(180,50,180,100);

        gc.setFill(Color.BLUE);
        gc.setStroke(Color.BLUE);

        for(int i=0; i<180; i+=10){
            int t =(int) (Math.random() * 10);
        gc.strokeLine(180 + i,180+t,170 + i,210+t);
        }
    }
    
    
}
