package codedifferently;

import java.util.HashMap;
import java.util.Map;
//class with generic type T with string for title and integer to add item quantities
public class ShoppingList<T> {
    private String title;
    private final Map<T, Integer> itemQuantities;

    //constructor its taking in a string for the title
    public ShoppingList(String title) {
        this.title = title;
        itemQuantities = new HashMap<>();
    }
    //getter method
    public String getTitle() {
        return title;
    }
    //setter method return the title of the string
    public void setTitle(String title) {
        this.title = title;
    }
    //method that returns the quantities of each item added
    public Map<T, Integer> getItemQuantities() {
        return itemQuantities;
    }
    //adds up the quantity of each item
    public void addQuantity(T item, int quantity) {
        itemQuantities.put(item, itemQuantities.getOrDefault(item, 0) + quantity);
    }
    //adds an item to the list
    public void addItem(T item) {
        addQuantity(item, 1);
    }
    //if statement to display items for multiple quantities if there is more than one item it adds a plural s
    public String displayItems() {
        StringBuilder result = new StringBuilder(title + "'s Shopping List:\n");
//        for each loop that iterates over them item quantities
        for (Map.Entry<T, Integer> entry : itemQuantities.entrySet()) {
//            used to retrieve the key of current map entry
            T item = entry.getKey();
//            used to retrieve the value associated with the current map entry
            int quantity = entry.getValue();
//            appends a formatted string to the StringBuilder named result
            result.append("- ").append(quantity).append(" ").append(item.toString());
//conditional statement checks if the quantity is greater than 1 and if the
// string representation of the item (in lowercase) does not already end with "s."
// If both conditions are true, it appends an "s" to make the output grammatically
// correct (pluralizing the item)
            if (quantity > 1 && !item.toString().toLowerCase().endsWith("s")) {
//                newline character is appended to the StringBuilder
//                to start a new line for the next entry.
                result.append("s");
            }
            result.append("\n");
        }
//        method returns the string representation of the shopping list
        return result.toString();
    }
}