// https://www.geeksforgeeks.org/java/



package org.howard.edu.lspfinal.question1;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a simple shopping cart that allows adding/removing items,
 * applying discount codes, and calculating the total cost.
 */
public class ShoppingCart {
    private final Map<String, Double> items = new HashMap<>();
    private double discountPercentage = 0.0;

    /**
     * Adds an item to the shopping cart.
     *
     * @param itemName the name of the item (must be non‐empty)
     * @param price    the price of the item (must be > 0)
     * @throws ShoppingCartException if name is empty or price ≤ 0
     */
    public void addItem(String itemName, double price) {
        if (itemName == null || itemName.trim().isEmpty()) {
            throw new ShoppingCartException("Item name cannot be empty.");
        }
        if (price <= 0) {
        	// changed this so that it satisfies the test case.
            throw new ShoppingCartException("Price must be greater than zero.");
        }
        items.put(itemName, price);
    }

    /**
     * Removes an item from the shopping cart.
     *
     * @param itemName the name of the item to remove
     * @throws ShoppingCartException if the item is not in the cart
     */
    public void removeItem(String itemName) {
        if (!items.containsKey(itemName)) {
            throw new ShoppingCartException("Item '" + itemName + "' not found in cart.");
        }
        items.remove(itemName);
    }

    /**
     * @return the number of items currently in the cart
     */
    public int getItemCount() {
        return items.size();
    }

    /**
     * Calculates and returns the total cost of the cart,
     * applying any discounts currently in effect.
     *
     * @return total cost after applying discount
     */
    public double getTotalCost() {
        double total = 0.0;
        for (double price : items.values()) {
            total += price;
        }
        return total - (total * (discountPercentage / 100.0));
    }

    /**
     * Applies a valid discount code to the shopping cart.
     * Supported codes:
     * - "SAVE10" → 10% off
     * - "SAVE20" → 20% off
     *
     * @param code the discount code
     * @throws ShoppingCartException if the code is invalid
     */
    public void applyDiscountCode(String code) {
        switch (code) {
            case "SAVE10" -> discountPercentage = 10.0;
            case "SAVE20" -> discountPercentage = 20.0;
            default        -> throw new ShoppingCartException("Invalid discount code.");
        }
    }

    /**
     * @return the current discount percentage applied to the cart
     */
    public double getDiscountPercentage() {
        return discountPercentage;
    }
}
