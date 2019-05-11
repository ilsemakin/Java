package laboratory3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import myException.CostException;
import myException.StringException;
import myException.TimeException;

public class Laboratory3 {
    public static void main(String[] args) 
            throws FileNotFoundException, StringException, TimeException {
        
        File inFile = new File("input.txt");
        Train train;
        try{
            Scanner in = new Scanner(inFile);
            String str;
            
            while(in.hasNextLine()){
                
                str = in.nextLine();
                String line[] = str.split(" ");
                
                if(line.length != 6){
                    in.close();
                     throw new StringException();
                }
                
                train = new Train(line[0], line[1], line[2], line[3], line[4],
                                                   Double.parseDouble(line[5]));

                DataBase.add(train);
            }
            in.close();
            
            Menu.show();
        }
        catch(FileNotFoundException | StringException | CostException | TimeException ex){
            System.out.println(ex.getMessage());
        }
        catch(NumberFormatException ex){
            System.out.println("\t\nОшибка : Неверный формат данных -> " + ex.getMessage());
        }
    }
}