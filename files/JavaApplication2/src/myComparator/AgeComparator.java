package myComparator;


import java.util.Comparator;
import myGeneralize.Animal;

public class AgeComparator implements Comparator <Animal>{
    @Override
    public int compare(Animal a1, Animal a2){
        return a1.getAge()-a2.getAge();
    }
}
