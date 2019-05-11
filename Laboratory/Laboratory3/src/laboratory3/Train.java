package laboratory3;

import java.util.Objects;
import myException.CostException;
import myException.TimeException;

public class Train{
    
    private final String num;
    private final String pointDeparture, pointDestination;
    private final String timeDeparture, timeDestination;
    private final double cost;
    
    public Train(String num, String pointDeparture, String pointDestination,
            String timeDeparture, String timeDestination, double cost) 
            throws CostException, TimeException{
        
        if(cost < 0)
            throw new CostException(cost);
        
        if(checkTime(timeDeparture) == false) 
            throw new TimeException(timeDeparture);
        
        if(checkTime(timeDestination) == false)
            throw new TimeException(timeDestination);
        
        this.num = num;
        this.pointDeparture = pointDeparture;
        this.pointDestination = pointDestination;
        this.timeDeparture = timeDeparture;
        this.timeDestination = timeDestination;
        this.cost = cost;
    }
    
    public String getNum(){
        return num;
    }
    
    public String getPointDeparture(){
        return pointDeparture;
    }
    
    public String getPointDestination(){
        return pointDestination;
    }
    
    public String getTimeDestination(){
        return timeDestination;
    }
    
    @Override
    public String toString(){
        return "" +
                "\nНомер поезда: " + num
                + "\nПункт и время отправления: " + pointDeparture + " " + timeDeparture
                + "\nПункт и время прибытия: " + pointDestination + " " + timeDestination
                + "\nСтоимость билета: " + cost + "\n";
    }
    
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        
        if(obj == null) return false;
    
        if(!(obj instanceof Train)) return false;
        
        Train other = (Train)obj;
        
        if(!num             .equals(other.num)                ||
           !pointDeparture  .equals(other.pointDeparture)     ||
           !pointDestination.equals(other.pointDestination)   ||
           !timeDeparture   .equals(other.timeDeparture)      ||
           !timeDestination .equals(other.timeDestination)    ||
            cost             !=     other.cost                )
                
        return false;
        
        return true;
    }

    @Override
    public int hashCode() {
        //return num.hashCode();
        
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.num);
        hash = 31 * hash + Objects.hashCode(this.pointDeparture);
        hash = 31 * hash + Objects.hashCode(this.pointDestination);
        hash = 31 * hash + Objects.hashCode(this.timeDeparture);
        hash = 31 * hash + Objects.hashCode(this.timeDestination);
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.cost) ^ (Double.doubleToLongBits(this.cost) >>> 32));
        return hash;
    }
    
    private static boolean checkTime(String time){
        String line[] = time.split(":");
        
        if(line.length != 2)
            return false;
        
        int hour = Integer.parseInt(line[0]);
        int minute = Integer.parseInt(line[1]);
        
        if(hour < 0 || hour > 23 || minute < 0 || minute > 59)
            return false;
        
        return true;
    } 
}
