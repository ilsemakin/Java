package javaapplication1;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import myException.InvalidMarkException;

public class JavaApplication3{

    public static void main(String[] args)
            throws InvalidMarkException, FileNotFoundException, IOException{
        
//        Student.setMaxSize(3);
//        Student st1 = new Student("Ivanov");
        
//        Student.setMaxSize(10);
//        Student st2 = new Student("Petrov");
   
//        System.out.println(st1 + "\n" + st2);
//        st1.toString();
        
//        st1.addMark(3);
//        System.out.println(st1);
      
        File inFile = new File("in.txt");
        File outFile = new File("out.txt");
        
        try{
            Student.setMaxSize(10);
            
            Scanner in = new Scanner(inFile);
            FileWriter out = new FileWriter(outFile);
            
            String str;
            
            while(in.hasNextLine()){
                str = in.nextLine();
                String s[] = str.split(" ");
                Student st = new Student(s[0]);
                
                for(int i = 1; i < s.length; i++){
                    int m = Integer.parseInt(s[i]);
                    st.addMark(m);
                }
                out.write(st.toString());
            } 
            in.close();
            out.close();
        }
        catch(FileNotFoundException ex){
            System.out.println("\tError: File missing!");
        }
        catch(IOException | ArrayIndexOutOfBoundsException | InvalidMarkException ex){
            System.out.println(ex.getMessage());
        }
        catch(NumberFormatException ex){
            System.out.println("\tError: Invalid symbol in file!");
        }  
    }   
} 