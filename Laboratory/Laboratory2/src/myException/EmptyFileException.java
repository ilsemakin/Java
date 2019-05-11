package myException;

public class EmptyFileException extends Exception{

    String output = "\n\tError: Fail is empty!";

    @Override
    public String toString(){
        return output;
    }

    @Override
    public String getMessage(){
        return this.toString();
    }
}