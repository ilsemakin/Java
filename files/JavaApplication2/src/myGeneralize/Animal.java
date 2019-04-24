package myGeneralize;

                           //какие объекты будем использовать
public abstract class Animal implements Comparable <Animal>{
    String name;
    String type;
    int age;

    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }
    
    public String getName(){
        return name;
    }
    
    public int getAge(){
        return age;
    }
    
    public abstract String speak();
    
    @Override
    public String toString(){
        return type + " " + name + " " + age;
    }
    
    @Override
    public int compareTo(Animal a){
        //return name.compareTo(a.name);
        //return (type+name).compareTo(a.type+a.name);
        return (name+age).compareTo(a.name+a.age); // при совпадение имен смотрит возраст
    }
}
