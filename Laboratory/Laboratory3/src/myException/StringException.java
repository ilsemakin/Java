package myException;

public class StringException extends Exception{
    String output = "\n\tОшибка: В файле неверное количество полей для создания объекта.";
    
    @Override
    public String toString(){
        return output;
    }
    
    @Override
    public String getMessage(){
        return this.toString();
    }
}