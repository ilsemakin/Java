package modelhuman;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ModelHuman extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simple Model Human ");
        
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        
        Organization org = new Organization("Ilya", 19);
        View viewOrg = new View(org);
        root.getChildren().add(viewOrg);
        
        Button btn = new Button();
        btn.setText("Show status");
        btn.setOnAction((ActionEvent exent) -> {
            try{
            viewOrg.edit();
            org.fire();
            }catch(NumberFormatException ex){
                System.out.println(ex.getMessage());
            }
        });
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 800, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
