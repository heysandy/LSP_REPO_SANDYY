// src/test/java/org/howard/edu/lspfinal/question1/ShoppingCartTest.java
package org.howard.edu.lspfinal.question1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    @DisplayName("Test for adding valid item")
    void testAddingValidItem() {
        cart.addItem("Apple", 1.50);
        assertEquals(1, cart.getItemCount(),
            "Cart size should be 1 after adding one item");
        assertEquals(1.50, cart.getTotalCost(), 1e-4,
            "Total cost should reflect the added item price");
    }

    @Test
    @DisplayName("Test for adding item with 0 price (expect exception)")
    void testAddingZeroPriceThrows() {
        assertThrows(ShoppingCartException.class,
            () -> cart.addItem("Freebie", 0.0),
            "Adding an item priced at 0.0 should throw ShoppingCartException");
    }

    @Test
    @DisplayName("Test for adding item with negative price (expect exception)")
    void testAddingNegativePriceThrows() {
        assertThrows(ShoppingCartException.class,
            () -> cart.addItem("BadItem", -5.00),
            "Adding an item with negative price should throw ShoppingCartException");
    }

    @Test
    @DisplayName("Test for adding item with empty name (expect exception)")
    void testAddingEmptyNameThrows() {
        assertThrows(ShoppingCartException.class,
            () -> cart.addItem("", 2.00),
            "Adding an item with an empty name should throw ShoppingCartException");
    }

    @Test
    @DisplayName("Test for removing existing item")
    void testRemovingExistingItem() {
        cart.addItem("Milk", 3.00);
        assertEquals(1, cart.getItemCount(),
            "Cart size should be 1 after adding one item");
        cart.removeItem("Milk");
        assertEquals(0, cart.getItemCount(),
            "Cart should be empty after removing the item");
    }

    @Test
    @DisplayName("Test for removing non-existent item (expect exception)")
    void testRemovingNonExistentItemThrows() {
        assertThrows(ShoppingCartException.class,
            () -> cart.removeItem("NonItem"),
            "Removing an item that does not exist should throw ShoppingCartException");
    }

    @Test
    @DisplayName("Test for applying \"SAVE10\"")
    void testApplySave10() {
        cart.applyDiscountCode("SAVE10");
        assertEquals(10.0, cart.getDiscountPercentage(), 1e-4,
            "Discount percentage should be 10 after applying SAVE10");
    }

    @Test
    @DisplayName("Test for applying \"SAVE20\"")
    void testApplySave20() {
        cart.applyDiscountCode("SAVE20");
        assertEquals(20.0, cart.getDiscountPercentage(), 1e-4,
            "Discount percentage should be 20 after applying SAVE20");
    }

    @Test
    @DisplayName("Test for applying invalid code (expect exception)")
    void testApplyingInvalidCodeThrows() {
        assertThrows(ShoppingCartException.class,
            () -> cart.applyDiscountCode("SAVE50"),
            "Applying an invalid discount code should throw ShoppingCartException");
    }

    @Test
    @DisplayName("Test total cost without discount")
    void testTotalCostWithoutDiscount() {
        cart.addItem("Book", 12.99);
        cart.addItem("Pen", 2.50);
        double expected = 12.99 + 2.50;
        assertEquals(expected, cart.getTotalCost(), 1e-4,
            "Total cost without discount should be sum of prices");
    }

    @Test
    @DisplayName("Test total cost with discount")
    void testTotalCostWithDiscount() {
        cart.addItem("Shoes", 50.00);
        cart.addItem("Socks", 10.00);
        cart.applyDiscountCode("SAVE20"); // 20% off
        double subtotal = 50.00 + 10.00;
        double expected = subtotal * 0.80;
        assertEquals(expected, cart.getTotalCost(), 1e-4,
            "Total cost with 20% discount should be 80% of the subtotal");
    }

    @Test
    @DisplayName("Test total cost with empty cart")
    void testTotalCostEmptyCart() {
        assertEquals(0.0, cart.getTotalCost(), 1e-4,
            "Total cost of an empty cart should be 0.0");
    }

    @Test
    @DisplayName("Test cart size updates correctly after adding/removing")
    void testCartSizeUpdates() {
        assertEquals(0, cart.getItemCount(), "New cart should start empty");
        cart.addItem("A", 1.00);
        cart.addItem("B", 2.00);
        assertEquals(2, cart.getItemCount(), "Cart size should be 2 after two additions");
        cart.removeItem("A");
        assertEquals(1, cart.getItemCount(), "Cart size should be 1 after one removal");
    }
}
