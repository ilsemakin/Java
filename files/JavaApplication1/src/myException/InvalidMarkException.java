package myException;

public class InvalidMarkException extends Exception {
    public int invalidMark;
    public String s = "\tError: Invalid Mark -> ";

    
    public InvalidMarkException(int badMark){
        this.invalidMark = badMark;
    }
    
    @Override
    public String toString(){
       return s + invalidMark;
    }
    
    @Override
    public String getMessage(){
        return this.toString();
    }
}