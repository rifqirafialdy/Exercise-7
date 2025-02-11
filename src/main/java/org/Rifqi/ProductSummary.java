package org.Rifqi;

import org.Rifqi.execption.InvalidProductException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProductSummary {
    private float totalSale;
    private int totalSold;
    private Product mostBought;
    private Product leastBought;

    public ProductSummary(String filePath) throws InvalidProductException{
        List<Product> products = readCsvFile(filePath);
        this.totalSale=calculateTotalSale(products);
        this.totalSold=calculateTotalSold(products);
        this.mostBought=findMostBought(products);
        this.leastBought=findLeastBought(products);
    }

    public List<Product> readCsvFile(String filePath) throws InvalidProductException{
        List<Product> productList = new ArrayList<>();
        String[] header = null;

        try (Scanner scanner = new Scanner(new File(filePath))) {
            if (scanner.hasNextLine()) {
               String headerLine = scanner.nextLine().trim();
               header=headerLine.split(",");

            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                String[] values = line.split(",");

                if (values.length != header.length) {
                    throw new InvalidProductException("Invalid Product Format in line" + line);
                }


                try {
                    String name = values[0];

                    int quantity = Integer.parseInt(values[1]);

                    float price = Float.parseFloat(values[2]);

                    productList.add(new Product(name, quantity, price));

                } catch (NumberFormatException e) {
                    throw new InvalidProductException("Invalid format in  : " +line);
                }
            }
        } catch (FileNotFoundException e) {
            throw new InvalidProductException("file not found : "+filePath);
        }

        return productList;
    }
    public float calculateTotalSale(List<Product>productsList){
        float sum = 0;
        for (Product p :productsList){
            sum+=(p.getPrice()*p.getQuantity());
        }
        return sum;
    }
    public int calculateTotalSold(List<Product>productsList){
        int total = 0;
        for (Product p:productsList){
            total+=p.getQuantity();
        }
        return total;
    }
    public Product findMostBought(List<Product>productsList){
        Product mostBought = productsList.get(0);
        for (Product p:productsList){
            if (p.getQuantity()>mostBought.getQuantity()){
                mostBought=p;
            }
        }
        return mostBought;

    }
    public Product findLeastBought(List<Product>productList){
        Product leastBought = productList.get(0);
        for (Product p : productList){
            if (p.getQuantity()<leastBought.getQuantity()){
                leastBought=p;
            }
        }
        return leastBought;
    }
    public float getTotalSales() {
        return totalSale;
    }

    public int getTotalSold() {
        return totalSold;
    }

    public Product getMostBought() {
        return mostBought;
    }

    public Product getLeastBought() {
        return leastBought;
    }


}
