package org.howard.edu.lsp.assignment5;

public class Driver {
    public static void main(String[] args) {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        System.out.println("Initial Set1: " + set1.toString());
        System.out.println("Smallest in Set1: " + set1.smallest());
        System.out.println("Largest in Set1: " + set1.largest());

        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        System.out.println("Initial Set2: " + set2.toString());

        System.out.println("\nTesting Union");
        set1.union(set2);
        System.out.println("After Union, Set1: " + set1.toString());

        System.out.println("\nTesting Intersect");
        set1.intersect(set2);
        System.out.println("After Intersect, Set1: " + set1.toString());

        System.out.println("\nTesting Diff (Set1 - Set2)");
        set1.diff(set2);
        System.out.println("After Diff, Set1: " + set1.toString());

        set1.add(10);
        set1.add(11);
        System.out.println("\nTesting Complement (Set2 complement Set1)");
        set1.complement(set2);
        System.out.println("After Complement, Set1: " + set1.toString());

        System.out.println("\nTesting equals method:");
        IntegerSet set3 = new IntegerSet();
        set3.add(4);
        set3.add(5);
        System.out.println("Set1: " + set1.toString());
        System.out.println("Set3: " + set3.toString());
        System.out.println("Set1 equals Set3? " + set1.equals(set3));

        System.out.println("\nTesting clear:");
        set1.clear();
        System.out.println("Set1 after clear: " + set1.toString());
        System.out.println("Is Set1 empty? " + set1.isEmpty());
    }
}
