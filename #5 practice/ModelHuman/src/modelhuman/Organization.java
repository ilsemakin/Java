package modelhuman;

import java.util.ArrayList;
import java.util.Iterator;

public class Organization {

    private String name;
    private int age;
    private int material_state;
    private final ArrayList<Listener> listeners;

    public Organization(String name, int age) {
        this.name = name;
        this.age = age;
        material_state = 0;
        listeners = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getStatus_ms() {
        return material_state;
    }

    public void setStatus_ms(int material_state) {
        this.material_state += material_state;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String setStatusHumanAge(int age) {
        String value;
        if (age >= 0 && age <= 11) {
            value = "Детство";
        } else if (age >= 12 && age <= 19) {
            value = "Юность";
        } else if (age >= 20 && age <= 35) {
            value = "Молодость";
        } else if (age >= 36) {
            value = "Зрелость";
        } else {
            value = "Ошибка : отрицательный возраст";
        }

        return value;
    }

    /*materialState*/
    public String setStatusHumanMS(int mS) {
        String value;
        
        if (mS <= 0) {
            value = "Банкрот";
        } else if (mS > 0 && mS <= 5000) {
            value = "Бедняк";
        } else if (mS > 5000 && mS <= 10000) {
            value = "Достаток";
        } else if (mS > 10000 && mS <= 999999) {
            value = "Средний класс";
        } else if (mS > 1000000 && mS <= 10000000) {
            value = "Миллионер";
        } else if (mS > 10000000 && mS <= 999999999) {
            value = "Мультимиллионер";
        } else {
            value = "Миллиардер";
        }

        return value;
    }

    public void actionStatusHumanAge() {
        fire();
    }

    void addListener(Listener l) {
        listeners.add(l);
    }

    void deleteListener(Listener l) {
        Iterator<Listener> iter = listeners.iterator();
        while (iter.hasNext()) {
            Listener e = iter.next();
            if (e.equals(l)) {
                iter.remove();
            }
        }
    }

    void fire() {
        for (Listener l : listeners) {
            l.dataChanged();
        }
    }
}
