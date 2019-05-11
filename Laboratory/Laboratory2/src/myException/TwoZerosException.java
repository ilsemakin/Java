package myException;

public class TwoZerosException extends Exception{

    String output = "\n\tError: Found two zeros in the string!";

    @Override
    public String toString(){
        return output;
    }

    @Override
    public String getMessage(){
        return this.toString();
    }
}