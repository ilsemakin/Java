package myCamparator;

import java.util.Comparator;
import myGeneralize.ComplexNumber;

public class OrderImComparator implements Comparator <ComplexNumber> {

    @Override
    public int compare(ComplexNumber complex1, ComplexNumber complex2) {
        
        if(complex1.getIm() < complex2.getIm())
            return 1;
        
        if(complex1.getIm() == complex2.getIm())
            return 0; 
        
        return -1;
    }
}
