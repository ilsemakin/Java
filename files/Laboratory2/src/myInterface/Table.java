package myInterface;

import myException.TwoZerosException;

public interface Table{
    double abs();
    double arctg() throws TwoZerosException;
}
