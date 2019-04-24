package myGeneralize;

import myInterface.Hobby;

public class Dog extends Animal implements Hobby{
    String breed;
    
    public Dog(String name, int age, String breed){
        super(name,age);
        this.breed = breed;
        type = "dog";
    }
    
    //реализуем toString, потому что новое поле
    @Override
    public String toString(){
        return super.toString() + " " + breed;
    }
    
    //чтобы не перегрузить speak
    @Override
    public String speak(){
        return "......гав-гав-гав.....";
    }
    
    @Override
    public void play(){
        System.out.println("мячик");
    }
}
