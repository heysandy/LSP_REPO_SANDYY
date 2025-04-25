package org.howard.edu.lspfinal.question3;

/**
 * Abstract base class defining the template for report generation.
 * Subclasses supply the specific steps.
 */
public abstract class Report {

    /**
     * The template method: defines the sequence of steps.
     * It is final so subclasses can’t change the workflow order.
     */
    public final void generateReport() {
        loadData();
        formatData();
        printReport();
    }

    /** Load the data needed for this report. */
    protected abstract void loadData();

    /** Format the loaded data for output. */
    protected abstract void formatData();

    /** Print the final, formatted report. */
    protected abstract void printReport();
}
