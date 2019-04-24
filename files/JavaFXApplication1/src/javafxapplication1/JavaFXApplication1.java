package javafxapplication1;

import java.util.HashMap;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JavaFXApplication1 extends Application {
    
    GridPane root; //сетка
    Text actiontarget;
    TextField nameTextField; // место для вход текста
    Button btn;
    
    HashMap<String, Integer> cal = new HashMap<>();
    
    public void initRootLayout(){
        cal.put("Индейка", 198); cal.put("Омлет", 209); cal.put("Вафли", 543);
        cal.put("Вишня", 52); cal.put("Огурцы", 13); cal.put("Колбаса", 301);
        
        root = new GridPane();
        root.setAlignment(Pos.CENTER); // выравнивание
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25, 25, 25, 25));
                                  //низ лево верх право
        
        Text scenetitle = new Text("Рассчёт калорийности продукта");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        root.add(scenetitle, 0, 0, 2, 1);
        
        Label userCal = new Label("Введите количество граммов");
        root.add(userCal, 0, 1);
        
        nameTextField = new TextField();
        root.add(nameTextField, 1, 1);
        
        Label userProduct = new Label("Выберите продукт");
        root.add(userProduct, 0, 2);
        
        Label label = new Label();
        
        ComboBox comboBox = new ComboBox();
        comboBox.getItems().addAll(cal.keySet());
        comboBox.setValue("Колбаса");
        
        Text output = new Text();
        
        btn = new Button();
        btn.setText("Рассчитать");
        try{
            btn.setOnAction((ActionEvent event) -> {
            int result = 0;
            
            int calories = cal.get(comboBox.getValue());
            int grams = Integer.parseInt(nameTextField.getText());
            result = grams * calories / 100;
            
            output.setText("" + result);
            root.add(output, 1, 6);
        });
        }catch (IllegalArgumentException ex){
                System.out.println(ex);
        }
        
        root.add(btn, 1, 4);
        root.add(comboBox, 1, 2);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Рассчёт калорийности продукта");
        
        initRootLayout();
        Scene scene = new Scene(root, 400, 350);
        primaryStage.setScene(scene);
        primaryStage.show();        
    }

    public static void main(String[] args) {
        launch(args);
    }
}
