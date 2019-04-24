package myGeneralize;

import myInterface.Hobby;

public class Cat extends Animal implements Hobby{
    
    public Cat(String name, int age){
        super(name,age);
        type = "cat";
    }
    
    //чтобы не перегрузить speak
    @Override
    public String speak(){
        return "......мяу.....";
    }
    
    @Override
    public void play(){
        System.out.println("кошки-мышки");
    }
}
