package laboratory3;

import java.util.ArrayList;
import java.util.Scanner;
import myException.CostException;
import myException.TimeException;

public class Menu{
    public static void show() throws CostException, TimeException{
        
        String command;
        Train train;
        Scanner in = new Scanner(System.in);
        
        while(true){

            System.out.print("\nВведите команду > ");
            command = in.nextLine();

            switch(command){
                case "show":
                    if(!DataBase.checkCollection())
                        DataBase.show();
                    break;
                
                case "add":
                    train = train();
                    if(train != null)
                        DataBase.add(train);
                    break;
                
                case "delete":
                   if(!DataBase.checkCollection())
                        DataBase.remove(input("Введите номер поезда: "));
                    break;
                
                case "point_point":
                    if(!DataBase.checkCollection())
                        DataBase.pointDeparture_pointDestination
                                (input("Введите пункт отправления: "),
                                        input("Введите пункт назначения: "));
                    break;
                
                case "point_time":
                    if(!DataBase.checkCollection())
                        DataBase.pointDeparture_timeDestination
                                (input("Введите пункт отправления: "),
                                        input("Введите время прибытия: "));
                    break;
                case "route":
                    ArrayList<Train> tmp = new ArrayList<>();
                    DataBase.route(tmp, input("Введите пункт отправления: "),
                                        input("Введите время прибытия: "));
                    break;
                case "help":
                    System.out.println(help());
                    break;
                
                case "exit":
                    return;
                
                default:
                    System.out.println("Неверная команда! Повторите!\n");
                    break;
            }
        }   
    }
    
    private static String input(String message){
        System.out.print(message);
        return new Scanner(System.in).nextLine();
    }
    
    private static Train train() throws CostException, TimeException{
        try{
        String num = input("Введите номер поезда: ");
        String pointDeparture = input("Введите пункт отправления: ");
        String pointDestination = input("Введите пункт назначения: ");
        String timeDeparture = input("Введите время отправления: ");
        String timeDestination = input("Введите время прибытия: ");
        double cost = Double.parseDouble(input("Введите стоимость билета: "));
        
        return new Train(num, pointDeparture, pointDestination,
                        timeDeparture, timeDestination, cost);
        
        }catch(CostException | TimeException ex){
            System.out.println(ex);
        }
        catch(NumberFormatException ex){
            System.out.println("\t\nОшибка : Неверный формат данных -> " + ex.getMessage());
        }
        return null;
    }
    
    private static String help(){
        return "" +
                "\tshow : показать список поездов в базе\n" +
                "\tadd : добавить поезд в базу\n" +
                "\tdelete : удалить поезд из базы\n" +
                "\tpoint_point : поиск поездов пункт отправления - пункт назначения\n" +
                "\tpoint_time : поиск поездов пункт отправления - время прибытия\n" +
                "\texit : выход из программы";
    }
}