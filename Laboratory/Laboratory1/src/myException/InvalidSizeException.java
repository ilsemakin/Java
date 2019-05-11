package myException;

public class InvalidSizeException extends Exception{

    String output = "\n\tError: Invalid array size!";

    @Override
    public String toString(){
        return output;
    }

    @Override
    public String getMessage(){
        return this.toString();
    }
}
