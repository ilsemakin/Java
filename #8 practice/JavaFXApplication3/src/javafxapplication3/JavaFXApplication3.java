package javafxapplication3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

/**
 *
 * @author Semakin
 */
public class JavaFXApplication3 extends Application {

    private TableView<Organization> table = new TableView<Organization>();
    private TableColumn nicknameCol = new TableColumn("Nickname");
    private TableColumn nameCol = new TableColumn("Name");
    private TableColumn ageCol = new TableColumn("Age");

    private ObservableList<Organization> data
            = FXCollections.observableArrayList();
    VBox vb = new VBox();

    private void readFile() {
        try {
            File inFile = new File("input.txt");
            Scanner in = new Scanner(inFile);
            String str;

            while (in.hasNextLine()) {
                str = in.nextLine();
                String line[];
                line = str.split(",");
                data.add(new Organization(line[0], line[1], Integer.parseInt(line[2])));
            }
            in.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void saveFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
            for (Organization pet : data) {
                bw.write(pet.toString() + "\n");
            }
            bw.close();
        } catch (IOException ex) {}
    }

    private void createTable() {
        table.setEditable(true);

        TableColumn<Organization, Number> indexColumn = new TableColumn<Organization, Number>("#");
        indexColumn.setMinWidth(50);
        indexColumn.setSortable(false);
        indexColumn.setCellValueFactory(column -> new ReadOnlyObjectWrapper<Number>(table.getItems().indexOf(column.getValue())));

        nicknameCol.setMinWidth(100);
        nicknameCol.setCellValueFactory(
                new PropertyValueFactory<Organization, String>("Nickname"));
        nicknameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nicknameCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Organization, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Organization, String> t) {
                ((Organization) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setNickname(t.getNewValue());
            }
        }
        );

        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(
                new PropertyValueFactory<Organization, String>("Name"));
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nameCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Organization, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Organization, String> t) {
                ((Organization) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setName(t.getNewValue());
            }
        }
        );

        ageCol.setMinWidth(100);
        ageCol.setCellValueFactory(
                new PropertyValueFactory<Organization, Integer>("Age"));
        ageCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        ageCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Organization, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Organization, Integer> t) {
                ((Organization) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setAge(t.getNewValue());
            }
        }
        );

        table.setItems(data);
        table.getColumns().addAll(indexColumn, nicknameCol, nameCol, ageCol);
    }

    private void dataEditGroup() {
        TextField addNickname = new TextField();
        addNickname.setPromptText("Nickname");
        addNickname.setMaxWidth(nicknameCol.getPrefWidth());

        TextField addName = new TextField();
        addName.setMaxWidth(nameCol.getPrefWidth());
        addName.setPromptText("Name");

        TextField addAge = new TextField();
        addAge.setMaxWidth(ageCol.getPrefWidth());
        addAge.setPromptText("Age");

        TextField delete = new TextField();
        delete.setMaxWidth(ageCol.getPrefWidth());
        delete.setPromptText("#");

        final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            data.add(new Organization(
                    addNickname.getText(),
                    addName.getText(),
                    Integer.parseInt(addAge.getText())));
            addNickname.clear();
            addName.clear();
            addAge.clear();
        });

        final Button deleteButton = new Button("Delete");
        deleteButton.setOnAction((ActionEvent e) -> {
            data.remove(Integer.parseInt(delete.getText()));
            delete.clear();
        });

        HBox hb1 = new HBox();
        hb1.getChildren().addAll(addNickname, addName, addAge, addButton);

        HBox hb2 = new HBox();
        hb2.getChildren().addAll(delete, deleteButton);

        vb.getChildren().addAll(hb1, hb2);
        vb.setSpacing(5);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(450);
        stage.setHeight(550);

        createTable();
        readFile();

        Label label = new Label("Organizations List");
        label.setFont(new Font("Arial", 20));

        dataEditGroup();

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, vb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() {
        saveFile();
    }
}
