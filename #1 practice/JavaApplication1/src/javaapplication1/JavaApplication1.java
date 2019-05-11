package javaapplication1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

interface Test {

    boolean test(int n);
}

public class JavaApplication1 {

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Double> linkedList = new LinkedList<>();
        HashSet<String> hashSet = new HashSet<>();

        try {
            File inFileInt = new File("inFileInt.txt");
            File inFileDouble = new File("inFileDouble.txt");
            File inFileText = new File("inFileText.txt");

            Scanner in = new Scanner(inFileInt);
            Scanner in2 = new Scanner(inFileDouble);
            Scanner in3 = new Scanner(inFileText);

            while (in.hasNextInt()) {
                arrayList.add(in.nextInt());
            }

            while (in2.hasNextDouble()) {
                linkedList.add(in2.nextDouble());
            }

            System.out.println(arrayList);
            Test negativeTest = (int n) -> n < 0;
            for (int number = 0; number < arrayList.size(); number++) {
                if (negativeTest.test(arrayList.get(number))) {
                    arrayList.remove(number--);
                }
            }
            System.out.println(arrayList);

            int max = arrayList.get(0);
            int index = 0;
            for (int number = 1; number < arrayList.size(); number++) {
                if (max < arrayList.get(number)) {
                    max = arrayList.get(number);
                    index = number;
                }
            }
            System.out.println(index);

            Collections.sort(arrayList);
            System.out.println(arrayList);

            for (Integer number : arrayList) {
                if ((isPrimeNumber(number))) {
                    System.out.println("Collection contains prime number");
                    break;
                }
            }

            int removed = 0;
            System.out.println(linkedList);

            for (double number : linkedList) {
                if (number == 0) {
                    System.out.println("Null elements");
                }
            }

            for (int number = 0; number < linkedList.size(); number++) {
                if ((number + 1) % 3 == 0) {
                    linkedList.remove(number++ - removed);
                    removed++;
                }
            }
            System.out.println(linkedList);

            double min = linkedList.get(0);
            int index2 = 0;
            for (int number = 1; number < linkedList.size(); number++) {
                if (linkedList.get(number) < min) {
                    min = linkedList.get(number);
                    index2 = number;
                }
            }

            System.out.println(min);

            linkedList.remove(index2);
            linkedList.add(min);

            System.out.println(linkedList);

            Collections.sort(linkedList);
            Collections.reverse(linkedList);
            System.out.println(linkedList);

            in.close();
            in2.close();
            in3.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static boolean isPrimeNumber(int number) {
        for (int devider = 2; devider < (number / 2) + 1; devider++) {
            if (number % devider == 0) {
                return false;
            }
        }

        return true;
    }
}
