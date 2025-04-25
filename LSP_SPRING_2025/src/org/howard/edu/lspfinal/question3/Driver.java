// src/main/java/org/howard/edu/lspfinal/question3/Driver.java
package org.howard.edu.lspfinal.question3;

/**
 * Demonstrates generating two reports via the Template Method pattern.
 */
public class Driver {
    public static void main(String[] args) {
        Report sales     = new SalesReport();
        Report inventory = new InventoryReport();

        sales.generateReport();
        System.out.println();
        inventory.generateReport();
    }
}
