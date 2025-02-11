package org.Rifqi;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    AverageCalculator calculator= new AverageCalculator();
        List<Integer> numbers = calculator.readNumber();
        System.out.println(calculator.calculateAverage(numbers));
    }
}