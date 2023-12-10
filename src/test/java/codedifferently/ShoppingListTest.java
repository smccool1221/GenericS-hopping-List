package codedifferently;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

public class ShoppingListTest {

    private ShoppingList<String> shoppingList;

    @BeforeEach
    public void setUp() {
        shoppingList = new ShoppingList<>("My Shopping List");
    }

    @Test
    public void testAddItem() {
        shoppingList.addItem("Apple");
        shoppingList.addItem("Banana");

        Map<String, Integer> expectedQuantities = new HashMap<>();
        expectedQuantities.put("Apple", 1);
        expectedQuantities.put("Banana", 1);

        assertEquals(expectedQuantities, shoppingList.getItemQuantities());
    }

    @Test
    public void testAddQuantity() {
        shoppingList.addQuantity("Apple", 2);
        shoppingList.addQuantity("Banana", 3);

        Map<String, Integer> expectedQuantities = new HashMap<>();
        expectedQuantities.put("Apple", 2);
        expectedQuantities.put("Banana", 3);

        assertEquals(expectedQuantities, shoppingList.getItemQuantities());
    }

    @Test
    public void testDisplayItems() {
        shoppingList.addQuantity("Apple", 2);
        shoppingList.addQuantity("Banana", 1);

        String expectedDisplay = "My Shopping List's Shopping List:\n" +
                "- 2 Apples\n" +
                "- 1 Banana\n";

        assertEquals(expectedDisplay, shoppingList.displayItems());
    }


}