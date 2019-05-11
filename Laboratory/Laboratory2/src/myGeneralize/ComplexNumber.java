package myGeneralize;

import myException.TwoZerosException;
import myInterface.Table;

public class ComplexNumber implements Table, Comparable <ComplexNumber>{
    
    private final double Pi = 3.1415926535;
    private final double Re, Im;
    
    public ComplexNumber(double Re, double Im){
        this.Re = Re;
        this.Im = Im;
    }
    
    public double getRe(){
        return Re;
    }
    
    public double getIm(){
        return Im;
    }
    
    public ComplexNumber sumComplex(ComplexNumber C){
        return new ComplexNumber(Re + C.getRe(), Im + C.getIm());
    }
    
    public ComplexNumber multiComplex(ComplexNumber C){
       return new ComplexNumber(Re*C.getRe() + (-Im*C.getIm()), Im*C.getRe() + Re*C.getIm());
    }
    
    @Override
    public double abs(){
        return Math.sqrt(Re*Re + Im*Im);
    }
    
    @Override
    public double arctg() 
            throws TwoZerosException{
        
        if(Re == 0 && Im == 0)
            throw new TwoZerosException();

        return Math.atan(Im/Re)*180/Pi;
    }
    
    @Override
    public int compareTo(ComplexNumber complex){
        if(this.Re < complex.getIm())
            return 1;
        
        if(this.Re == complex.getIm())
            return 0;
        
        return -1;
    }
    
    @Override
    public String toString(){
        String str = String.format("%.3f + i*(%.3f)", Re, Im);
        
        return str; 
    }
    
    @Override
    public int hashCode(){
        return (int) ((Re*Im) + (Re+Im));
    }

    @Override
    public boolean equals(Object obj){
        
        if(this == obj) return true;
        
        if(obj == null) return false;
        
        if(!(obj instanceof ComplexNumber)) return false;
        
        ComplexNumber other = (ComplexNumber)obj;
        if(Re != other.Re && Im != other.Im) return false;
        
        return true;
    }
}
