package myException;

public class StringException extends Exception{
    
    String output = "\n\tError: The string must have 2 elements!";

    @Override
    public String toString(){
        return output;
    }

    @Override
    public String getMessage(){
        return this.toString();
    }
}
