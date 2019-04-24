package myComparator;

import java.util.Comparator;
import myGeneralize.Animal;

public class NameComparator implements Comparator <Animal>{
    
    @Override           //любая сортировка, сравниваем поля
    public int compare(Animal a1, Animal a2){
        return a1.getName().compareTo(a2.getName());
    }
}
