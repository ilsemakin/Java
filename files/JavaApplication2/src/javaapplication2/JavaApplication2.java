package javaapplication2;

import java.util.ArrayList; //динамический массив
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;
import myComparator.AgeComparator;
import myComparator.NameComparator;
import myGeneralize.Animal;
import myGeneralize.Cat;
import myGeneralize.Dog;

public class JavaApplication2{
    public static void main(String[] args){
////////////////////////////////////////////////////////////////////////////////        
                    //Hobby
//        ArrayList <Animal> aL = new ArrayList<>();
//        Cat c = new Cat("Barsik",3);
//        Dog d = new Dog("Sharik",5,"dvoryanin");
//        
//        aL.add(c);
//        aL.add(d);
//        
//        for(int i = 0;i < aL.size(); i++){
//            System.out.println(aL.get(i));
//        }
////////////////////////////////////////////////////////////////////////////////       
//        Animal [] a = new Animal[4];
//        Cat c1 = new Cat("Barsik",3);
//        Cat c2 = new Cat("Pyshok",4);
//        Dog d1 = new Dog("Tyzik",7,"kolli");
//        Dog d2 = new Dog("Tyzik",3,"shpic");
//        
//        a[0] = c2;
//        a[1] = d1;
//        a[2] = c1;
//        a[3] = d2;
//        
//        System.out.println(Arrays.toString(a));
//        //Arrays.sort(a);
//        
//        Comparator cName = new NameComparator();
//        Comparator cAge = new AgeComparator();          // несколько условий
//        Comparator <Animal> cAnimal= new NameComparator().thenComparing(cAge); 
//        
//        System.out.println("\nСортировка по имени:");
//        Arrays.sort(a, cName);
//        System.out.println(Arrays.toString(a));
//        
//        System.out.println("\nСортировка по возрасту:");
//        Arrays.sort(a, cAge);
//        System.out.println(Arrays.toString(a));
//        
//        System.out.println("\nСортировка по возрасту и имени (если совпадает имя):");
//        Arrays.sort(a, cAnimal);
//        System.out.println(Arrays.toString(a));

        Cat c1 = new Cat("Barsik",3);
        Cat c2 = new Cat("Pyshok",4);
        Dog d1 = new Dog("Sharik",7,"kolli");
        Dog d2 = new Dog("Tyzik",3,"shpic");

         //<тип элементов коллекции>
        //ArrayList <Animal> aL = new ArrayList();
//        TreeSet <Animal> aL = new TreeSet();
//        
//        aL.add(d2);
//        aL.add(c1);
//        aL.add(d1);
//        aL.add(c2);
        
//        for(int i = 0; i < aL.size(); i++){
//            System.out.println(aL.get(i));
//        }
        
//        System.out.println("\n\n");
        
                //перебираем an в коллекции aL
//        for(Animal an: aL)
//            System.out.println(an);
        
        //Collections.sort(aL); //не нужно из-за TreeSet 
        
//        System.out.println("\n\n");
        
//        for(Animal an: aL)
//            System.out.println(an);
        
//        Iterator <Animal> i = aL.iterator();
//        
//        while(i.hasNext()){
//            System.out.println(i.next());
//        }
//        
//        i = aL.iterator(); // поставить начало коллекции

        //словарь
       //HashMap <String,Animal> h = new HashMap();
       HashMap <Animal,String> h = new HashMap();
       
       h.put(c2, "cat");
       h.put(c1,"cat");
       h.put(d2,"dog");
       h.put(d1,"dog");
       
       System.out.println(h);
    }
}
