package laboratory2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import myException.StringException;
import myException.TwoZerosException;
import myException.EmptyFileException;
import myGeneralize.ComplexNumber;
import java.util.Comparator;
import myCamparator.OrderImComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Laboratory2{
    public static void main(String[] args) 
            throws FileNotFoundException, IOException, StringException, TwoZerosException, EmptyFileException{
        
        ComplexNumber complex;
        
        File inFile = new File("in.txt");
        File outFile = new File("out.txt");
        
        ArrayList <ComplexNumber> arrayList = new ArrayList <>();
        
        try{
            Scanner in = new Scanner(inFile);
            FileWriter out = new FileWriter(outFile);

            String str;
            
            if(in.hasNextLine() == false)
                throw new EmptyFileException();

            out.write("Число:"+"\t\t\t"+"Модуль числа:"+"\t"+"Тригонометрическая форма числа:\n\n");
            while(in.hasNextLine()){
                str = in.nextLine();
                
                String line[] = str.split(" ");
                
                if(line.length != 2)
                    throw new StringException();                
                
                complex = new ComplexNumber(Double.parseDouble(line[0]), Double.parseDouble(line[1]));
                
                arrayList.add(complex); //добавляем элементы в коллекцию
                
                /*Выводим в файл информацию о комплексном числе ввиде таблицы*/
                out.write(complex.toString());
                out.write(String.format("\t\t%.3f", complex.abs()));
                out.write(String.format("\t\t%.3f*(cos(%.3f) + i*sin(%.3f)))\n", complex.abs(), complex.arctg(), complex.arctg()));
            }
            in.close();
            
            ComplexNumber newSum = new ComplexNumber(arrayList.get(0).getRe(), arrayList.get(0).getIm());
            ComplexNumber newMulti = new ComplexNumber(arrayList.get(0).getRe(), arrayList.get(0).getIm());
            
            for(int j = 1; j < arrayList.size(); j++){
              newSum = newSum.sumComplex(arrayList.get(j));
              newMulti = newMulti.multiComplex(arrayList.get(j));
            }
            
            out.write("\n\nСумма всех комплексных чисел: ");
            out.write(newSum.toString());
            
            out.write("\nПроизведение всех комплексных чисел: ");
            out.write(newMulti.toString());
         
            /*Сортируем нашу коллекцию компаратором cIm и выводим*/
           /*-----------------------------------*/
            out.write("\n\nСортировка по Im:\n");
            Comparator cIm = new OrderImComparator();
            
            Collections.sort(arrayList, cIm);
            
            for(Object collection : arrayList){
                out.write(collection+"\n");
            }
           /*-----------------------------------*/            
            
            out.close();
        }
        catch(NumberFormatException ex){
            System.out.println("\n\tError: In file invalid symbol!");
        }
        catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("\n\tError : Array index out of bounds!");
        }
        catch(TwoZerosException | StringException | EmptyFileException ex){
            System.out.println("\n\n" + ex.getMessage());
        }
    }
}