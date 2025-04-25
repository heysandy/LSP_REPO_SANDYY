// Course Material, https://www.geeksforgeeks.org/java/
package org.howard.edu.lspfinal.question3;

/**
 * An InventoryReport: loads, formats, and prints inventory data.
 */
public class InventoryReport extends Report {

    @Override
    protected void loadData() {
        System.out.println("Loading inventory data...");
    }

    @Override
    protected void formatData() {
        System.out.println("Formatting inventory data...");
    }

    @Override
    protected void printReport() {
        System.out.println("Printing inventory report.");
    }
}
