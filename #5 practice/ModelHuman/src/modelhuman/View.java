package modelhuman;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public final class View extends Group implements Listener {

    private Organization org;
    private GridPane grid;
    private Label name;
    private Label status_age;
    private Label status_ms;
    private Text inSum;
    private TextField sumTextField;
    private TextField ageTextField;
    private TextField nameTextField;

    public View(Organization org) {
        setOrganization(org);
        createPane();
        this.getChildren().add(grid);
    }

    public void setOrganization(Organization org) {
        this.org = org;
        this.org.addListener(this);
    }

    private void createPane() {
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text inName = new Text("Введите имя");
        inName.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        grid.add(inName, 0, 1);

        nameTextField = new TextField();
        grid.add(nameTextField, 1, 1);

        Text inAge = new Text("Введите возраст");
        inAge.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        grid.add(inAge, 0, 2);

        ageTextField = new TextField();
        grid.add(ageTextField, 1, 2);

        inSum = new Text("Введите сумму");

        inSum.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        grid.add(inSum, 0, 3);

        sumTextField = new TextField();
        grid.add(sumTextField, 1, 3);

        ////////////////////////////////////////////////////////////
        name = new Label(org.getName());
        name.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(name, 20, 1);

        status_age = new Label(org.setStatusHumanAge(org.getStatus_ms()));
        status_age.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(status_age, 20, 2);

        status_ms = new Label(org.setStatusHumanMS(org.getAge()));
        status_ms.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(status_ms, 20, 3);
    }

    public void edit() {
        org.setStatus_ms(Integer.parseInt(sumTextField.getText()));
        org.setAge(Integer.parseInt(ageTextField.getText()));
        org.setName(nameTextField.getText());
    }

    @Override
    public void dataChanged() {
        name.setText(org.getName());
        status_age.setText(org.setStatusHumanAge(org.getAge()));
        status_ms.setText(org.setStatusHumanMS(org.getStatus_ms()));
    }
}
