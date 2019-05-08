package javafxapplication3;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Semakin
 */
public class Organization {
    private SimpleStringProperty nickname;
    private SimpleStringProperty name;
    private SimpleIntegerProperty age;

    public Organization(String nickname, String name, int age) {
        this.nickname = new SimpleStringProperty(nickname);
        this.name = new SimpleStringProperty(name);
        this.age = new SimpleIntegerProperty(age);
    }

    public String getNickname() {
        return nickname.get();
    }

    public String getName() {
        return name.get();
    }

    public int getAge() {
        return age.get();
    }

    public void setNickname(String nickname) {
        this.nickname.set(nickname);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    @Override
    public String toString() {
        return nickname.get() + "," + name.get() + "," + age.get();
    }
    
}
