package laboratory3;

import java.util.ArrayList;

public class DataBase{
    
    private static ArrayList<Train> arrayList = new ArrayList<>();

    private interface Action<T, R> {

        R action(T text);
    }
        
    private static Action<String, Train> gcd = (String text) ->{
        for(Train value: arrayList){
            if(value.getNum().equals(text))
              return value;
        }
        return null;
    };
    
    public static void add(Train train){
        arrayList.add(train);
    }
        
    public static void remove(String text){
        Train train = gcd.action(text);
        
        if(train != null){
            arrayList.remove(train);
            System.out.println("\tПоезд удалён.");
        }else{
            System.out.println("\n\tПоезд не найден!");
        }
    }
    
    public static void pointDeparture_timeDestination(String point, String time){
        arrayList.stream()
                .filter(s -> s.getTimeDestination().equals(time))
                .filter(s -> s.getPointDeparture().equals(point))
                .forEach(System.out::println);
    }
    
    public static void pointDeparture_pointDestination(String pointDep, String pointDest){
        arrayList.stream()
                .filter(s -> s.getPointDeparture().equals(pointDep))
                .filter(s -> s.getPointDestination().equals(pointDest))
                .forEach(System.out::println);
    }
    
    public static ArrayList<Train> route(ArrayList<Train> buf, String pointDep, String pointDest){
        for(Train cur : arrayList){
            if(cur.getPointDeparture().equals(pointDep)){
                buf.add(cur);
                
            }
        }
        
        for(Train cur2 : buf){
            for(Train cur1 : arrayList){
                if(cur2.getPointDestination().equals(cur1.getPointDeparture()))
                    buf.add(cur2);
            }
        }
        
        return buf;
    }
    
    public static void show(){
        System.out.println(arrayList);
    }
    
    public static boolean checkCollection(){
        if(arrayList.isEmpty()){
            System.out.println("\n\tПоезда отсутствуют!");
            return true;
        }
        
        return false;
    }
}