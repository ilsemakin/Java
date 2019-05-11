package myExceptions;

public class ZeroException extends Exception{
    private final int age;
    
    public ZeroException(int age){
        this.age = age;
    }
    
    @Override
    public String toString(){
        return "Отрицательный возрасть -> " + age;
    }
    
    @Override
    public String getMessage(){
        return this.toString();
    }
}
