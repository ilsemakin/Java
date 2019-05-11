package laboratory1;

import myException.InvalidSizeException;

public class Array{
    
    private int[] array;
    private int amountOfElements;
    
    Array(int amountOfElements) throws InvalidSizeException{
        
        if(amountOfElements <= 0)
            throw new InvalidSizeException();
        
        this.amountOfElements = amountOfElements;
        
        array = new int[amountOfElements];
    }
   
    public int getAmountOfElements(){
        return amountOfElements;
    }
   
    public void setArray(int inputNumber, int i){
        array[i] = inputNumber;
    }
   
    public void sortNegativeNumbersOfArray(){
        int counterOfPositiveNumbers = 0;
        int tmp;

        for(int i = 0; i < array.length; i++){
            if(array[i] > 0)
                counterOfPositiveNumbers++;

            // offset of negative elements of the array to the left //
            if((array[i] <= 0) && (i != 0) && (counterOfPositiveNumbers != 0)){
                for(int g = 0; g < counterOfPositiveNumbers; g++){
                    tmp = array[i  -  g];
                    array[i - g] = array[i - 1 - g];
                    array[i - 1 - g] = tmp;    
                }

                counterOfPositiveNumbers = 0;
                i = 0;              
            }
        }
    }
    
    public void sortZerosOfArray(){
    
        for(int i = 0; i < array.length; i++)
            if(array[i] > 0){
                sortZerosOfArrrayToTheRight();
                return;
            }
        sortZerosOfArrrayToTheLeft();
    }
                
    private void sortZerosOfArrrayToTheRight(){
        int tmp, shift = 0;

        // offset of zeros to the right //
        for(int j = 0; j < array.length; j++){
            for(int i = 0; i < array.length; i++){
                if((array[i] == 0) && (i != (array.length - 1))){

                    // check the zero goes beyond the array //
                    while((array[i + 1 + shift] <= 0) && ((i + 1 + shift) < array.length - 1)){
                        tmp = array[i + shift];
                        array[i + shift] = array[i + 1 + shift];
                        array[i + 1 + shift] = tmp; 
                        shift++;
                    }
                }  
                shift = 0;
            }
        }
    }
    
    private void sortZerosOfArrrayToTheLeft(){
        int tmp, shift = 0;

        // offset of zeros to the left //
        for(int j = 0; j < array.length; j++){
            for(int i = (array.length - 1); i >= 0; i--){
                if((array[i] == 0) && (i != 0)){
                    
                    // check the zero goes beyond the array //
                    while(((i - 1 - shift) >= 0)){
                        tmp = array[i - 1 - shift];
                        array[i - 1 - shift] = array[i - shift];
                        array[i - shift] = tmp; 
                        shift++;
                    }
                }  
            shift = 0;
            }
        }
    }
   
    @Override
    public String toString(){
        System.out.print("Array output: ");
        String str = new String();
        for(int i = 0; i < array.length; i++)
                str += array[i] + " ";
        str += '\n';
        
        return str;
    }

    @Override
    public int hashCode(){
        int sum = 0;

        for(int i = 0; i < array.length; i++)
            sum += array[i];

        return sum + array.length;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(!(obj instanceof Array))
            return false;
        
        Array b = (Array)obj;
        if(amountOfElements != b.amountOfElements)
            return false;
        
        for(int i = 0; i < amountOfElements; i++){
            if(array[i] != b.array[i])
                return false;
        }
        return true;
    }  
}


