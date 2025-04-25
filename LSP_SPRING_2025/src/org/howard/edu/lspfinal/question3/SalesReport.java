// src/main/java/org/howard/edu/lspfinal/question3/SalesReport.java
package org.howard.edu.lspfinal.question3;

/**
 * A SalesReport: loads, formats, and prints sales data.
 */
public class SalesReport extends Report {

    @Override
    protected void loadData() {
        System.out.println("Loading sales data...");
    }

    @Override
    protected void formatData() {
        System.out.println("Formatting sales data...");
    }

    @Override
    protected void printReport() {
        System.out.println("Printing sales report.");
    }
}
