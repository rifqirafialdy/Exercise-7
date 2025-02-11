package org.Rifqi;

import org.Rifqi.execption.InvalidNumberException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageCalculator {
    public List<Integer> readNumber(){
        List<Integer> numbers= new ArrayList<>();
        Scanner scanner= new Scanner(System.in);

        while (true){
            System.out.println("Input a Number, or press q to quit");
            String input = scanner.next();
            if (input.equalsIgnoreCase("q")){
                 break;
            }
try {
    addNumber(numbers,input);

}catch (InvalidNumberException e){
    System.out.println(e.getMessage());
}

        }
        scanner.close();
        return numbers;
    }


    public void addNumber(List<Integer>numbers,String input)throws InvalidNumberException {
        try {
            int number=Integer.parseInt(input);
            numbers.add(number);

        }catch (NumberFormatException e){
            throw new InvalidNumberException();
        }
    }
    public double calculateAverage(List<Integer>numbers){
        int sum = 0;
        for (int num:numbers){
            sum+=num;
        }
        return (double) sum/numbers.size();
    }
}

