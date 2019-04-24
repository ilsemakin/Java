package javaapplication1;

import java.util.Arrays;
import myException.InvalidMarkException;

public class Student{
    private String name;
    private int[] marks;
    private int amountOfMark;
    private static int maxSize;
    
    Student(String name){
        this.name = name;
        marks = new int[maxSize];
        amountOfMark = 0;
    }
    
    public static void setMaxSize(int m){
        if (m < 1 || m < maxSize) throw
                new ArrayIndexOutOfBoundsException("\tError: Invalid array size!");
        maxSize = m;
    }

    public void addMark(int mark) throws InvalidMarkException{
        if(mark < 1 || mark > 5) throw
                new InvalidMarkException(mark);

        if(amountOfMark >= maxSize) throw
                new ArrayIndexOutOfBoundsException("\tError: Array overflow!");

        try{   
            marks[amountOfMark] = mark;
            amountOfMark++;
        }
        catch(ArrayIndexOutOfBoundsException ex){
            changeMarks(mark);
        }
    }
    
    private void changeMarks(int mark) throws InvalidMarkException{
        marks = Arrays.copyOf(marks, maxSize);
        addMark(mark);
    }
    
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder(name);
        for(int i = 0; i < amountOfMark; i++){
            str.append(" ");
            str.append(marks[i]);
        }
        str.append("\n");
        return str.toString();

        // return name + Arrays.toString(marks);
    }
}