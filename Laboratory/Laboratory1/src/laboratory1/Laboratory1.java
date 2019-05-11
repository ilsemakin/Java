package laboratory1;

import java.util.Scanner;
import java.util.InputMismatchException;
import myException.InvalidSizeException;

public class Laboratory1{
    public static void main(String[] args){
        
        int amountOfElements;
        int inputNumber;
        
        Array a;
        
        Scanner in = new Scanner(System.in);
            
        try{
            System.out.print("Input amount of elemets: ");
            amountOfElements = in.nextInt();
            
            a = new Array(amountOfElements);
                    
            System.out.print("Input numbers: ");
            for(int i = 0; i < a.getAmountOfElements(); i++){
                inputNumber = in.nextInt();
                a.setArray(inputNumber, i);
            }
            
            a.sortNegativeNumbersOfArray();
            a.sortZerosOfArray();
            System.out.println(a);
        }
        catch(InputMismatchException ex){
            System.out.println("\n\tError: Invalid symbol!");
        }
        catch(InvalidSizeException ex){
            System.out.println(ex);
        }
    } 
}
