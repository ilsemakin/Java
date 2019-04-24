package myException;

public class CostException extends Exception{
    private final double cost;
    
    public CostException(double cost){
        this.cost = cost;
    }
    
    @Override
    public String toString(){
        return "\n\tОшибка: Неверная стоимость билета -> " + cost;
    }
    
    @Override
    public String getMessage(){
        return this.toString();
    }
    
}
