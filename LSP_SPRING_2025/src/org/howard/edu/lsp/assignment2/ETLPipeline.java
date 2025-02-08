package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.util.*;

//Gorakh Khatri
//003086020

public class ETLPipeline {
    public static void main(String[] args) {
        String inputFile = "data/products.csv";       // input file path
        String outputFile = "data/transformed_products.csv"; // output file path
        List<Product> products = new ArrayList<>();

        // Read and transform input
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line = br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length < 4) continue; // ignore bad lines

                int id = Integer.parseInt(tokens[0].trim());
                String name = tokens[1].trim().toUpperCase(); // uppercase name
                double price = Double.parseDouble(tokens[2].trim());
                String category = tokens[3].trim();

                // Apply 10% discount for Electronics
                if (category.equalsIgnoreCase("Electronics")) {
                    price = Math.round(price * 0.9 * 100.0) / 100.0; // discount & round
                    if (price > 500) { // adjust category if price > 500
                        category = "Premium Electronics";
                    }
                }

                // Determine price range
                String priceRange;
                if (price >= 0 && price <= 10) {
                    priceRange = "Low";
                } else if (price > 10 && price <= 100) {
                    priceRange = "Medium";
                } else if (price > 100 && price <= 500) {
                    priceRange = "High";
                } else {
                    priceRange = "Premium";
                }

                products.add(new Product(id, name, price, category, priceRange));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Input file not found: " + inputFile);
            return;
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        // Write transformed data
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("ProductID,Name,Price,Category,PriceRange");
            bw.newLine();
            for (Product p : products) {
                bw.write(p.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

    // Simple product class
    static class Product {
        int id;
        String name;
        double price;
        String category;
        String priceRange;

        Product(int id, String name, double price, String category, String priceRange) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.category = category;
            this.priceRange = priceRange;
        }

        // Format product as CSV line
        String toCSV() {
            return id + "," + name + "," + String.format("%.2f", price) + "," + category + "," + priceRange;
        }
    }
}
