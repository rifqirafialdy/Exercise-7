package org.Rifqi;

import org.Rifqi.execption.InvalidProductException;

import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    AverageCalculator calculator= new AverageCalculator();
        List<Integer> numbers = calculator.readNumber();
        System.out.println(calculator.calculateAverage(numbers));
        try {

        ProductSummary summary = new ProductSummary("src/main/resources/product_sales_data.csv");
        System.out.println(summary.getMostBought().getName());
        System.out.printf("Rp %,.2f",summary.getTotalSales());
        }catch (InvalidProductException e){
            System.out.println("Error: "+e.getMessage());
        }
}}