package myException;

public class TimeException extends Exception{
    private String time;
    
    public TimeException(String time){
        this.time = time;
    }
    
    @Override
    public String toString(){
        return "\n\tОшибка: Формат времени неверен -> " + time;
    }
    
    @Override
    public String getMessage(){
        return this.toString();
    }
}
